package org.usfirst.frc5124.OfficialDeepSpace.commands;

import java.util.function.Supplier;

import org.usfirst.frc5124.OfficialDeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HatchArmPosition extends Command {

  // private Supplier<Double> positionSupplier;
  private boolean killImmediately;

  public HatchArmPosition(Supplier<Double> positionSupplier, boolean killImmediately) {
    // this.positionSupplier = positionSupplier;
    this.killImmediately = killImmediately;
    if (!killImmediately) {
      requires(Robot.hatch);
    }
  }

  public HatchArmPosition(double position, boolean killImmediately) {
    this(() -> position, killImmediately);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.hatch.setArmPidEnabled(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Robot.hatch.setArmPosition(positionSupplier.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return killImmediately;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.hatch.setArmPidEnabled(false);
  }
}