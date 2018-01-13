package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/13/2018.
 */
@Autonomous(name = "Red Stone 1 - Park, Simple Glyph")
public class RedStoneOneParkGlyph extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.parkRedStoneOne();
        robot.harvester.closeHarvester();

        sleep(500);

        robot.turnLeft(90, 0.2);

        sleep(500);

        robot.scoreGlyph(0.20, 0.1);

        robot.drive(-0.04, 0.2);

        robot.turnRight(10, 0.2);
    }
}
