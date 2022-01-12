package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon armMotor;

	public void Arm(){
		
		armMotor = new CANTalon(RobotMap.arm);
	}
    public void initDefaultCommand() {
        
    	
    }
    
    public void startArm(boolean direction){
    	if(direction = true){
        	armMotor.set(1.0);
    	}else{
        	armMotor.set(-1.0);
    	}

    }
    
    public void stopArm(){
    	
        	armMotor.set(0.0); 	

    }
}

