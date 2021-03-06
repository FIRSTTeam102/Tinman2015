package org.usfirst.frc.team102.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team102.robot.commands.Autonomous;
import org.usfirst.frc.team102.robot.commands.DriveStraight;
import org.usfirst.frc.team102.robot.subsystems.Arm;
import org.usfirst.frc.team102.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain tinManDriveTrain;
	public static Arm tinManArm;
	public static Joystick driverJoystick;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		try {
			oi = new OI();
			tinManDriveTrain = new DriveTrain(0.4, 0.0, 0.0);
			tinManArm = new Arm();//.005?
			// instantiate the command used for the autonomous period
			//autonomousCommand = new ExampleCommand();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		try{
			
			autonomousCommand = new Autonomous();
		if (autonomousCommand != null)
			autonomousCommand.start();
	
	}catch (Exception ex1) {
		ex1.printStackTrace();
		DriverStation.reportError(ex1.getMessage(), true);
	
	}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		try{
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		}catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		
		}
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		try {
			Scheduler.getInstance().run();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
