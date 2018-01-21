package org.firstinspires.ftc.teamcode.autonomous.blue.stone1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/21/2018.
 */
@Autonomous(name = "Blue Stone 1 - Park", group = "Blue Stone 1")
public class BlueStoneOnePark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.parkBlueStoneOne();
        robot.setDownGlyph();
    }
}
