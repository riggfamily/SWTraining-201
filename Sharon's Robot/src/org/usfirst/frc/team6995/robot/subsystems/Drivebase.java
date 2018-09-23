package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.commands.DriveArcade;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivebase extends Subsystem {

	private WPI_TalonSRX driveLeft = null;
	private WPI_TalonSRX driveRight = null;
	private DifferentialDrive differentialDrive = null;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.	
	
	public Drivebase() {
	
		driveLeft = new WPI_TalonSRX(RobotMap.DRIVEBASE_LEFT_TALON);
		driveRight = new WPI_TalonSRX(RobotMap.DRIVEBASE_RIGHT_TALON);
		differentialDrive = new DifferentialDrive(driveLeft, driveRight);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
    
    public void arcadeDrive(double moveSpeed,double rotateSpeed) {
    	differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
    }
}