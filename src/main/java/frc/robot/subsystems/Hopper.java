/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */
  final double HopperSpeedShooting = 0.65; //changed from negative because motor was flipped physically
  final double HopperSpeedIntake = 0.4; //changed from negative because motor was flipped physically

  public CANSparkMax hopperMotor = new CANSparkMax(RobotMap.HOPPER_CAN_ID, MotorType.kBrushless);
  
  public Hopper() {
    configureMotors();
  }

  public void turnOnForShooting() {
    hopperMotor.set(HopperSpeedShooting);
  }

  
    public void turnOnForIntake() {
        hopperMotor.set(HopperSpeedIntake);
  }

  public void turnOff() {
    hopperMotor.set(0);
  }
  public void reverseForIntake() {
    hopperMotor.set(-HopperSpeedIntake);
  }

/*  public void testAgitator(){
    agitatorMotor.set(RobotContainer.oi.getOperatorLeftTrigger());  
    SmartDashboard.putNumber("Agitator Speed Position: ", RobotContainer.oi.getOperatorLeftTrigger());
  }
*/


  private void configureMotors() {
    double rampRate = 0.2;
    int currentLimit = 10; 
 
    hopperMotor.setOpenLoopRampRate(rampRate);
    hopperMotor.setSmartCurrentLimit(currentLimit);
    

    hopperMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);

  }
  /*
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
 */ 
}
