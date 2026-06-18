package frc.robot.subsystems.wrist

import com.ctre.phoenix6.BaseStatusSignal
import com.ctre.phoenix6.controls.PositionVoltage
import com.ctre.phoenix6.controls.VelocityVoltage
import com.ctre.phoenix6.controls.VoltageOut
import com.ctre.phoenix6.hardware.TalonFX
import edu.wpi.first.units.Units
import edu.wpi.first.units.measure.Angle
import edu.wpi.first.units.measure.AngularVelocity

open class WristIOHardware : WristIO {

    val wristMotor = TalonFX(WristConstants.WRIST_MOTOR_ID)

    private val wristVoltageRequest = VoltageOut(0.0)
    private val wristVelocityRequest = VelocityVoltage(0.0)
    private val wristAngleRequest = PositionVoltage(0.0)

    private val wristMotorVoltage = wristMotor.motorVoltage
    private val wristMotorVelocity = wristMotor.velocity
    private val wristMotorSupplyCurrent = wristMotor.supplyCurrent
    private val wristMotorStatorCurrent = wristMotor.statorCurrent
    private val wristMotorTemp = wristMotor.deviceTemp

    private val isWristMotorConnected: Boolean
        get() = BaseStatusSignal.isAllGood(
            wristMotorVoltage,
            wristMotorVelocity,
            wristMotorStatorCurrent
        )

    init {

    }

    override fun updateInputs(inputs: WristIO.WristIOInputs) {
        inputs.wristConnected = isWristMotorConnected
        inputs.wristAppliedVolts = wristMotorVoltage.value.`in`(Units.Volts)
        inputs.pitchVelocityRadsPerSec = wristMotorVelocity.value.`in`(Units.RadiansPerSecond)
        //pitch
        //inputs.wristPitch += wristMotorVelocity.value * deltaTime?????
        inputs.wristSupplyCurrentAmps = wristMotorSupplyCurrent.value.`in`(Units.Amps)
        inputs.wristStatorCurrentAmps = wristMotorStatorCurrent.value.`in`(Units.Amps)
        inputs.wristTempCelsius = wristMotorTemp.value.`in`(Units.Celsius)
    }

    override fun setWristVoltage(voltage: Double) {
        wristMotor.setControl(wristVoltageRequest.withOutput(voltage))
    }

    override fun setWristVelocity(velocity: AngularVelocity) {
        wristMotor.setControl(wristVelocityRequest.withVelocity(velocity))
    }

    override fun setWristAngle(angle: Angle) {
        wristMotor.setControl(wristAngleRequest.withPosition(angle))
    }

    override fun runCommandOne(angle: Double) {
        //setWristAngle(Angle.of(angle))
    }

    override fun runCommandTwo(angleOne: Double, angleTwo: Double) {
    }
}
