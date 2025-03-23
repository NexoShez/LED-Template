// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Percent;
import static edu.wpi.first.units.Units.Second;
import static edu.wpi.first.units.Units.Seconds;

import java.util.Map;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.LEDPattern.GradientType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDs extends SubsystemBase {
  

  private final AddressableLED led; // = new AddressableLED(0);
  private int length = 60;
  AddressableLEDBuffer buffer = new AddressableLEDBuffer(length);

  Map<Number, Color> maskSteps = Map.of(0, Color.kWhite, 0.5, Color.kBlack);
  LEDPattern abase = LEDPattern.gradient(GradientType.kContinuous, Color.kForestGreen, Color.kDarkGreen);
  LEDPattern amask =
   LEDPattern.steps(maskSteps).scrollAtRelativeSpeed(Percent.per(Second).of(75));

  private LEDPattern auto = abase.mask(amask);
  private LEDPattern disab = LEDPattern.gradient(GradientType.kContinuous, Color.kDarkRed, Color.kDarkBlue);
  private LEDPattern pattern = LEDPattern.gradient(GradientType.kContinuous, Color.kBlueViolet, Color.kRed);
  private LEDPattern enabled = pattern.breathe(Seconds.of(.75));
  private LEDPattern disabled = disab.breathe(Seconds.of(3));
  private LEDPattern progress;
  private LEDPattern progressMask;

  /**
   * LED TeleOp Visuals
   * 
   * 
   * @apiNote 0 = Default
   * @apiNote 1 = Progress Mask
   */
  int set = 0;
  final int setMax = 1;
  final int setMin = 0;

  private LEDPattern changablePattern;

  private XboxController controller = new XboxController(0);

  /** Creates a new LEDs. */
  public LEDs(AddressableLED l) {
    led = l;
    led.setLength(length);
    disabled.applyTo(buffer);
    led.start();
    
    progress = LEDPattern.progressMaskLayer(() -> controller.getLeftY()/ -1);
    progressMask = progress.mask(LEDPattern.solid(Color.kAntiqueWhite));
  }

  /**
   * Sets the LEDs color for the Autonomous Period
   */
  public void setAuto() {
    // led.close();
    auto.applyTo(buffer);
    // led.start();

  }

  /**
   * Sets the LEDs color for when the robot is disabled. LEDS are still programmable when the robot is disabled c:
   */
  public void setDisabled() {
    // led.close();
    disabled.applyTo(buffer);
    // led.start();
  } 

  /**
   * Sets the LEDs color for the Tele-Operated period.
   */
  public void setTeleOp(boolean unset) {
    // led.close();
    if (set==0) {
    enabled.applyTo(buffer);
    }
    // led.start();
  }

  /**
   * Sets the LEDs color for the Progress Mask. Generally used for elevator/lift height visuals.
   */
  public void setProgressMask() {
    // led.close();
    if (set==1) {      
    progressMask.applyTo(buffer);
    }
    // led.start();
  }

  public void changeSet(boolean backwards) {
    if (backwards==true) {
      set=0;
      // if (set==setMin) {
      //   set=setMax;
      // } else {
      //   set= set - 1;
      // }
    } else {
      set=1;
      // if (set==setMax) {
      //   set=setMin;
      // } else {
      //   set= set + 1;
      // }
    }
  }

  public void resetSet() {
set=0;
  }

  /**
   * Sets a custom pattern.
   * 
   * @param pat Pattern to set the LEDS to
   */
  public void setPattern(LEDPattern pat) {
    changablePattern=pat;
    changablePattern.applyTo(buffer);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    led.setData(buffer);

    SmartDashboard.putNumber("TELEOP SET", set);
  }
}
