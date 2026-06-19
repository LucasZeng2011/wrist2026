package frc.robot.subsystems.wrist

import edu.wpi.first.wpilibj.smartdashboard.Field2d
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.AutoLog
import org.littletonrobotics.junction.AutoLogOutput
import edu.wpi.first.wpilibj.Alert
import org.littletonrobotics.junction.Logger
import kotlin.math.abs

class WristSubsystem (
    private val io: WristIO
) : SubsystemBase() {
    //private val inputs: WristIO.WristIOInputs() ???

    @AutoLogOutput(key = "Wrist/WristAngle")
    var wristPitch: Double = 0.0
        private set

    @AutoLogOutput(key = "Wrist/RadiansPerSec")
    var wristAngularVelocity: Double = 0.0
        private set

    @AutoLogOutput(key = "Wrist/TargetAngle")
    var wristTargetAngle: Double = 0.0

    private val wristDisconnectedAlert =
        Alert("Wrist Disconnected (ID ${WristConstants.WRIST_MOTOR_ID}).", Alert.AlertType.kError)

    override fun periodic() {
        //io.updateInputs(inputs)
        //Logger.processInputs("Wrist", inputs)

        //wristDisconnectedAlert.set(!inputs.wristConnected)
    }

    @AutoLogOutput(key = "Wrist/WristAtTolerance")
    fun isWristAngleAtTolerance(): Boolean {
        var error = 0.0 //abs(inputs.wristPitch - wristTargetAngle)

        return error < WristConstants.WRIST_ANGLE_ERROR_TOLERANCE
    }
}
