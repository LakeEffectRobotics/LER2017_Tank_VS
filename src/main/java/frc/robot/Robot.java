/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  TalonSRX left1,left2,left3;
  TalonSRX right1,right2,right3;

  @Override
  public void robotInit() {
    // Left drive motors:  lead 3, followers 4,11
    // Right drive motors: lead 5, followers 2,8
    left1 = new TalonSRX(3);
    right1 = new TalonSRX(5);
    left2 = new TalonSRX(4);
    right2 = new TalonSRX(2);
    left3 = new TalonSRX(11);
    right3 = new TalonSRX(8);

    left2.set(ControlMode.Follower,3);
    left3.set(ControlMode.Follower,3);
    right2.set(ControlMode.Follower,5);
    right3.set(ControlMode.Follower,5);


    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    left1.set(ControlMode.PercentOutput, -m_leftStick.getY());
    right1.set(ControlMode.PercentOutput, m_rightStick.getY());
  }
}
