package frc.robot.subsystems.wrist

import edu.wpi.first.wpilibj.smartdashboard.Field2d
import edu.wpi.first.wpilibj2.command.SubsystemBase

class WristSubsystem (
    private val io: WristIO
) : SubsystemBase() {
    private val inputs: Double = 0.0
    private val field: Field2d = Field2d()
}
