package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */
@Autonomous(name = "Legoless Autonomous Test")
public class LegolessAutonomousTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        sleep(2000);

        robot.jewelArm.setJewelArmDown();

        sleep(1000);

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
        sleep(10000);

    }
}