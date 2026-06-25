package frc.robot

import edu.wpi.first.units.Units
import edu.wpi.first.units.measure.Angle
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.PrintCommand
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.robot.commands.Autos
import frc.robot.commands.ExampleCommand
import frc.robot.subsystems.ExampleSubsystem
import frc.robot.subsystems.wrist.WristSubsystem
import frc.robot.Constants.Mode
import frc.robot.subsystems.wrist.WristIOHardware
import frc.robot.subsystems.wrist.WristIOSim
import frc.robot.subsystems.wrist.WristIO

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 *
 * In Kotlin, it is recommended that all your Subsystems are Kotlin objects. As such, there
 * can only ever be a single instance. This eliminates the need to create reference variables
 * to the various subsystems in this container to pass into to commands. The commands can just
 * directly reference the (single instance of the) object.
 */
object RobotContainer
{
    // Replace with CommandPS4Controller or CommandJoystick if needed
    private val driverController: CommandXboxController = CommandXboxController(0)
    private val opController: CommandXboxController = CommandXboxController(1)

    val wrist: WristSubsystem = WristSubsystem(
        when (Constants.CURRENT_MODE) {
            Mode.REAL -> WristIOHardware()
            Mode.SIM -> WristIOSim()
            Mode.REPLAY -> object : WristIO {}
        }
    )

    var autonomousCommand: Command = wrist.runCommandOne(Angle.ofBaseUnits(1.0, Units.Radians))
}