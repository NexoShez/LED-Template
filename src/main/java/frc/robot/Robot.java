// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  private final LEDs leds = new LEDs();
  // private final LEDSubsystem simpleLEDS;

  public Robot() {
    m_robotContainer = new RobotContainer();

    // simpleLEDS = new LEDSubsystem();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    // Commands.run(() -> simpleLEDS.runPattern(LEDPattern.solid(Color.kRed)).withName("Disabled"), simpleLEDS);
  }

  @Override
  public void disabledPeriodic() {
    leds.setDisabled();
  }

  @Override
  public void disabledExit() {
  }

  @Override
  public void autonomousInit() {

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    leds.setAuto();
  }

  @Override
  public void autonomousExit() {
  }

  @Override
  public void teleopInit() {
    // simpleLEDS.runPattern(LEDPattern.solid(Color.kGreen)).withName("Enabled TeleOp");

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    leds.setTeleOp();
  }

  @Override
  public void teleopExit() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void testExit() {
  }
}
