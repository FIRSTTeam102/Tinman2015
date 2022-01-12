package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

    public DriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tinManDriveTrain);
    	this.setTimeout(60.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.tinManDriveTrain.theGyro.reset();			
		Robot.tinManDriveTrain.DriveStraight(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tinManDriveTrain.StopDriveStraight();
    	if (this.isTimedOut()){
    		DriverStation.reportError("Timed Out.\n", false);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
