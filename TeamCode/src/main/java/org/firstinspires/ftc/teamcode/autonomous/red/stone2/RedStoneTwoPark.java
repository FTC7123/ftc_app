package org.firstinspires.ftc.teamcode.autonomous.red.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/13/2018.
 */
@Autonomous(name = "Red Stone 2 - Park")
public class RedStoneTwoPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();

        sleep(1000);

        robot.drive(-0.70, 0.1);

        sleep(1000);

        robot.turnLeft(90, 0.2);

        sleep(1000);

        robot.drive(-0.30, 0.2);

        sleep(1000);

        robot.turnRight(135, 0.2);

        sleep(1000);

        robot.setDownGlyph();
    }
}
