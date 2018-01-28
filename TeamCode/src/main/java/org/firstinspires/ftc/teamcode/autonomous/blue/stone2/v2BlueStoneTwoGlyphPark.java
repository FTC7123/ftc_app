package org.firstinspires.ftc.teamcode.autonomous.blue.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/27/2018.
 */
@Autonomous(name = "v2 Blue Stone Two - Jewel, Basic Glyph, Park", group = "Blue Stone Two")
public class v2BlueStoneTwoGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.scoreJewelBlue();
        robot.drive(0.77, 0.15);
        robot.turnRight(45, 0.2);
        robot.scoreGlyph(0.28, 0.15);
    }
}
