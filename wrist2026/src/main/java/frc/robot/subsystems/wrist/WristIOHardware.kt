package frc.robot.subsystems.wrist

open class WristIOHardware() : WristIO {

    override var currentAngle: Double
        get() = TODO("Not yet implemented")
        set(value) {}

    override var targetAngle: Double
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun setAngle(angle: Double) {
        targetAngle = angle
    }

    override fun runCommandOne(angle: Double) {
        setAngle(angle)
    }

    override fun runCommandTwo(angleOne: Double, angleTwo: Double) {
        setAngle(angleOne)
        // wait one second
        setAngle(angleTwo)
    }
}
