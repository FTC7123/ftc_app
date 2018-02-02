package org.firstinspires.ftc.teamcode.autonomous.blue.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/23/2018.
 */
@Autonomous(name = "Blue Stone Two - Jewel, Basic Glyph, Park", group = "Blue Stone Two")
public class OldBlueStoneTwoJewelGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.scoreJewelBlue();
        robot.parkBlueStoneTwo();

        sleep(1000);

        robot.drive(0.22, 0.2);
        robot.turnLeft(120, 0.2);
        robot.scoreGlyph(0.08, 0.2);
    }
}
