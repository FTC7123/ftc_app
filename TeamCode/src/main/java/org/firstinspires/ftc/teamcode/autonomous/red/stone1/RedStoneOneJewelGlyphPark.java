package org.firstinspires.ftc.teamcode.autonomous.red.stone1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/13/2018.
 */
@Autonomous(name = "Red Stone One - Jewel, Simple Glyph, Park")
public class RedStoneOneJewelGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();

        robot.scoreJewelRed();
        robot.parkRedStoneOne();

        robot.turnLeft(90, 0.1);

        robot.scoreGlyph(0.2, 0.1);

        robot.drive(-0.03, 0.2);
    }
}
