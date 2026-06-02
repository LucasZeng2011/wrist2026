package frc.robot.subsystems.wrist
//Set angle to x radians
//Set angle to x radians, wait 1 second, set angle to y radians
interface WristIO {

    open class WristIOInputs {
        //var currentAngle: Double
        //var targetAngle: Double
    }

    var currentAngle: Double
    var targetAngle: Double

    fun setAngle(angle: Double) {}

    fun runCommandOne(angle: Double) {}

    fun runCommandTwo(angleOne: Double, angleTwo: Double) {}
}