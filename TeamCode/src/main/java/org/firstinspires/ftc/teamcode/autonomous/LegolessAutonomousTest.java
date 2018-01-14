package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */
@Autonomous(name = "Legoless Autonomous Test")
public class LegolessAutonomousTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.jewelArm.setJewelArmUp();

        sleep(2000);

        robot.jewelArm.setJewelArmDown();

        sleep(2000);

    }
}