package org.firstinspires.ftc.teamcode.autonomous.blue.stone2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/23/2018.
 */
@Autonomous(name = "Blue Stone Two - Park", group = "Blue Stone Two")
public class BlueStoneTwoPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.parkBlueStoneTwo();
        robot.setDownGlyph();
    }
}
