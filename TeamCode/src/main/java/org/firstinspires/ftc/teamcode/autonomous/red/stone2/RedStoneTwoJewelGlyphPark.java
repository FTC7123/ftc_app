package org.firstinspires.ftc.teamcode.autonomous.red.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 2/1/2018.
 */
@Autonomous(name = "Red Stone Two - Jewel, Basic Glyph, Park", group = "Red Stone Two")
public class RedStoneTwoJewelGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.scoreJewelRed();
        robot.drive(-0.80, 0.15);
        robot.turnRight(155, 0.2);
        robot.scoreGlyph(0.22, 0.15);
        robot.harvester.openHarvester();
        sleep(1000);
        robot.drive(-0.03, 0.2);
    }
}
