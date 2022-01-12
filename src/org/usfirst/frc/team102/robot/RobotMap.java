package org.usfirst.frc.team102.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int driverJoystickPort = 0;
	public static final int xBoxLeftXAxis = 0;
	public static final int xBoxLeftYAxis = 1;
	public static final int xBoxRightXAxis = 4;
	public static final int xBoxRightYAxis = 5;
	public static final int m1 = 0;
	public static final int m2 = 1;
	public static final int m3 = 3;
	public static final int m4 = 4;
	public static final int arm = 5;
	public static final int gyroChannel = 0;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
