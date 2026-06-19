package frc.robot.subsystems.wrist

import edu.wpi.first.units.measure.Angle
import edu.wpi.first.units.measure.AngularVelocity
import org.littletonrobotics.junction.AutoLog
//Set angle to x radians
//Set angle to x radians, wait 1 second, set angle to y radians
interface WristIO {
    @AutoLog
    open class WristIOInputs {
        @JvmField var wristConnected: Boolean = false

        @JvmField var wristAppliedVolts: Double = 0.0

        @JvmField var pitchVelocityRadsPerSec: Double = 0.0

        @JvmField var wristPitch: Double = 0.0

        @JvmField var wristSupplyCurrentAmps: Double = 0.0

        @JvmField var wristStatorCurrentAmps: Double = 0.0

        @JvmField var wristTempCelsius: Double = 0.0
    }

    fun updateInputs(inputs: WristIOInputs) {}

    fun setWristVoltage(voltage: Double) {}

    fun setWristVelocity(velocity: AngularVelocity) {}

    fun setWristAngle(angle: Angle) {}
}

///     @JvmField var leftTopLeaderConnected: Boolean = false
//
//        @JvmField var leftTopLeaderAppliedVolts: Double = 0.0
//
//        @JvmField var leftTopLeaderVelocityRadsPerSec: Double = 0.0
//
//        @JvmField var leftTopLeaderSupplyCurrentAmps: Double = 0.0
//
//        @JvmField var leftTopLeaderStatorCurrentAmps: Double = 0.0
//
//        @JvmField var leftTopLeaderTempCelsius: Double = 0.0