package org.usfirst.frc.team4959.robot.commands.Drive;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.util.States;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the shifter to high/low gear
 */
public class ShifterToggle extends Command {

	private static boolean shifterToggle;
	private final String TAG = "Shifter: ";

	public ShifterToggle() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Toggles to high gear
		if (shifterToggle && States.shifterState == States.ShifterStates.low) {
			Robot.driveTrain.shifterOn();
			States.shifterState = States.ShifterStates.high;
			System.out.println("High Gear");
		}
		// Toggles to low gear
		else {
			Robot.driveTrain.shifterOff();
			States.shifterState = States.ShifterStates.low;
			System.out.println("Low Gear");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		if (shifterToggle) {
			System.out.println(TAG + "Shifter on End");
		} else {
			System.out.println(TAG + "Shifter off End");
		}

		shifterToggle = !shifterToggle;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
}
