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

        int i = 0;

        while (i < 4 && opModeIsActive()) {
            robot.drive(1, 0.2);
            sleep(1000);
            robot.turnLeft(90, 0.2);
            sleep(1000);
        }

        robot.setRightPower(0);
        robot.setLeftPower(0);
    }
}