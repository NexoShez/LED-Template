// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {

  private LEDs leds = new LEDs(new AddressableLED(0));
  private CommandXboxController controller = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  public LEDs getLEDs() {
    return leds;
  }

  private void configureBindings() {
    controller.rightBumper().onTrue(Commands.runOnce(() -> leds.changeSet(false), leds));
    controller.leftBumper().onTrue(Commands.runOnce(() -> leds.changeSet(true), leds));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
