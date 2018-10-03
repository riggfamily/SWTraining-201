/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;

import edu.wpi.first.wpilibj.Preferences;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	static Preferences prefs;
	
	// Talons
	public static int DRIVEBASE_RIGHT_TALON_CAN_ID = 2;
	public static int DRIVEBASE_LEFT_TALON_CAN_ID = 3;

	// Joysticks
	public static int OI_JOYSTICK = 0;
	public static int DRIVE_MOVE_AXIS = 0;
	public static int DRIVE_ROTATE_AXIS = 2;
	
	public static double AUTO_DISTANCE = -120; //prefs.getDouble("Auto Distance", -120); // Distance to drive in auto
	public static double AUTO_TIME = 60;  // Seconds to drive in auto
}
