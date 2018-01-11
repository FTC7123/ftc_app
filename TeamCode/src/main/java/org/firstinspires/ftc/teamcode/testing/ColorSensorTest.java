package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/9/2018.
 */

@Autonomous(name = "Color Sensor Test")
public class ColorSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.jewelArm.testColor();

        if (robot.jewelArm.colorRecorded == robot.jewelArm.COLOR_RED) {
            telemetry.addData("Red Visible ", robot.jewelArm.colorSensor.red());
            telemetry.addData("     Blue Value: ", robot.jewelArm.colorSensor.blue());
            telemetry.update();
            sleep(3000);
        } else if (robot.jewelArm.colorRecorded == robot.jewelArm.COLOR_BLUE) {
            telemetry.addData("Blue Visible ", robot.jewelArm.colorSensor.blue());
            telemetry.addData("     Red Value: ", robot.jewelArm.colorSensor.red());
            telemetry.update();
            sleep(3000);
        } else {
        }

    }
}
