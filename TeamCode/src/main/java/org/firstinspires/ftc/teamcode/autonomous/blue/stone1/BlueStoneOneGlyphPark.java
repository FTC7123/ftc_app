package org.firstinspires.ftc.teamcode.autonomous.blue.stone1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/23/2018.
 */
@Autonomous(name = "Blue Stone One - Glyph, Park", group = "Blue Stone One")
public class BlueStoneOneGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.parkBlueStoneOne();
        robot.turnLeft(135, 0.15);
        robot.scoreGlyph(0.17, 0.2);
        robot.drive(-0.10, 0.2);
    }
}