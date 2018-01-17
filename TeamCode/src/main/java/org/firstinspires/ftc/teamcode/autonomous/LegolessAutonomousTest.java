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

        robot.turnLeft(90, 0.2);

        for (int i = 0; i < 5000; i++) {

            robot.ultrasonicArray.getFrontUltrasonicDistance();
            robot.ultrasonicArray.getBackUltrasonicDistance();
            robot.ultrasonicArray.getUltrasonicDifference();

            telemetry.addData("Difference: ", robot.ultrasonicArray.ultrasonicDifference);
            telemetry.addData("Right Power: ", robot.rightFrontMotor.getPower());
            telemetry.addData("Left Power: ", robot.leftFrontMotor.getPower());
            telemetry.update();

            robot.equalizeDiffernce();

            sleep(1);
        }

        robot.drive(-0.5, 0.2);

    }
}