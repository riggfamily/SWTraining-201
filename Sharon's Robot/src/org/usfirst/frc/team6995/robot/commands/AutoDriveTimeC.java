package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveTimeC extends Command {
	double autospeed;
	double elapsedtime = 0;
	
    public AutoDriveTimeC() {
        requires(Robot.drivebase);
        autospeed = Math.signum(RobotMap.AUTO_DISTANCE); // returns -1, 0, or 1 depending on sign of autodistance
    }

    protected void initialize() {
    	setTimeout(RobotMap.AUTO_TIME);  // timeout set in preferences
    }

    protected void execute() {
    	SmartDashboard.putNumber("Speed in AutoTime", (autospeed * 0.5));
     	Robot.drivebase.arcadeDrive((autospeed * 0.5), 0); // drive straight at half speed
   
    }

    protected boolean isFinished() {
    	SmartDashboard.putNumber("TimeElapsed",timeSinceInitialized());
        return isTimedOut();
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
