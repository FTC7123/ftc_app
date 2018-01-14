package org.firstinspires.ftc.teamcode.autonomous.red.stone1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/13/2018.
 */
@Autonomous(name = "Red Stone 1 - Park")
public class RedStoneOnePark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();
        robot.parkRedStoneOne();
        robot.setDownGlyph();
    }
}
