package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.DriveWithXBox;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

	CANTalon m1;
	CANTalon m2;
	Victor m3;
	Victor m4;
	public AnalogGyro theGyro;
	private double leftJoyX;
	private double leftJoyY;
	private double rightJoyX;
	private double rightJoyY;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithXBox());
	}

	public DriveTrain(double p, double i, double d) {
		super(p, i, d);
		// TODO Auto-generated constructor stub
		m1 = new CANTalon(RobotMap.m1);
		m2 = new CANTalon(RobotMap.m2);
		m3 = new Victor(RobotMap.m3);
		m4 = new Victor(RobotMap.m4);
		theGyro = new AnalogGyro(RobotMap.gyroChannel);
	}

	public void driveWithXBox(Joystick xBox) {
		try {

			leftJoyX = xBox.getRawAxis(RobotMap.xBoxLeftXAxis);
			leftJoyY = xBox.getRawAxis(RobotMap.xBoxLeftYAxis);
			rightJoyX = xBox.getRawAxis(RobotMap.xBoxRightXAxis);
			rightJoyY = xBox.getRawAxis(RobotMap.xBoxRightYAxis);

			leftJoyX *= 1.0;
			leftJoyY *= 1.0;
			rightJoyX *= 1.0;
			rightJoyY *= 1.0;

			if (Math.abs(leftJoyX) < 0.1) {
				leftJoyX = 0.0;
			}
			if (Math.abs(leftJoyY) < 0.1) {
				leftJoyY = 0.0;
			}
			if (Math.abs(rightJoyX) < 0.1) {
				rightJoyX = 0.0;
			}
			if (Math.abs(rightJoyY) < 0.1) {
				rightJoyY = 0.0;
			}

			m1.set(leftJoyX);
			m2.set(rightJoyX);
			m3.set(leftJoyY);
			m4.set(rightJoyY);
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
	}

	public void DriveStraight(double speed) {
		theGyro.reset();
		this.enable();

		m1.set(speed);
		// m2.set(speed);
		m3.set(speed);
		// m4.set(speed);
	}

	public void StopDriveStraight() {
		this.disable();
		m1.set(0.0);
		m2.set(0.0);
		m3.set(0.0);
		m4.set(0.0);

	}

	public void Rotate() {
		theGyro.reset();
		this.enable();

	}

	public void StopRotate() {
		this.disable();

	}

	@Override
	protected double returnPIDInput() {
		return theGyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		System.out.printf("Angle: %s\nOutput: %s\n", theGyro.getAngle(), output);

		m1.set(output);
		m2.set(output);
		m3.set(output);
		m4.set(output);
	}
}
