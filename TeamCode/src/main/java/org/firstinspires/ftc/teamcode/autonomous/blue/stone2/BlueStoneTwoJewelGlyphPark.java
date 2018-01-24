package org.firstinspires.ftc.teamcode.autonomous.blue.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/23/2018.
 */
@Autonomous(name = "Blue Stone Two - Jewel, Basic Glyph, Park", group = "Blue Stone Two")
public class BlueStoneTwoJewelGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        robot.pickUpGlyph();
        robot.scoreJewelBlue();
        robot.parkBlueStoneTwo();

        robot.drive(0.25, 0.2);
        robot.turnLeft(105, 0.2);
        robot.scoreGlyph(0.15, 0.2);
    }
}
