package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveDistanceC extends Command {

	double autospeed;
	
	public AutoDriveDistanceC() {
    	requires(Robot.drivebase);
		autospeed = Math.signum(RobotMap.AUTO_DISTANCE); // returns -1, 0, or 1 depending on sign of autodistance
	}
	
    protected void initialize() {
    	Robot.drivebase.resetEncoder();
    }

    protected void execute() {
    	//Robot.drivebase.arcadeDrive(.5, 0, 1);
    	Robot.drivebase.arcadeDrive((autospeed * 0.5), 0); // drive straight at half speed
    }

    protected boolean isFinished() {
        return (Robot.drivebase.getDistanceTraveled(Math.abs(Robot.drivebase.getEncoderCount())) 
        		>= Math.abs(RobotMap.AUTO_DISTANCE));
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
