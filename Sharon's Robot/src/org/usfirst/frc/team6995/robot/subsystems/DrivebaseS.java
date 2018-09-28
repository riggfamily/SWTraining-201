package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.commands.DriveArcadeC;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DrivebaseS extends Subsystem {

	private WPI_TalonSRX driveLeft = null;
	private WPI_TalonSRX driveRight = null;
	private DifferentialDrive differentialDrive = null;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.	
	
	public DrivebaseS() {
	
		driveLeft = new WPI_TalonSRX(RobotMap.DRIVEBASE_LEFT_TALON_CAN_ID);
		driveRight = new WPI_TalonSRX(RobotMap.DRIVEBASE_RIGHT_TALON_CAN_ID);
		differentialDrive = new DifferentialDrive(driveLeft, driveRight);
		
		driveLeft.setNeutralMode(NeutralMode.Brake);
		driveRight.setNeutralMode(NeutralMode.Brake);
		
		driveLeft.setSafetyEnabled(false);
		driveRight.setSafetyEnabled(false);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveArcadeC());
    	
    }
    
    public void arcadeDrive(double moveSpeed,double rotateSpeed) {
    	differentialDrive.arcadeDrive((moveSpeed*Robot.throttle), (rotateSpeed*Robot.throttle));
    }
    
    public void resetEncoder() {
    	driveLeft.getSensorCollection().setQuadraturePosition(0, 500);
    }
    
    public double getEncoderCount() {
    	return driveLeft.getSensorCollection().getQuadraturePosition();
    }
    
    public double getDistanceTraveled(double counts) {
    	double distance = counts /(4096/(6*Math.PI));
    	return distance;
    }
}