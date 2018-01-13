package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by FTC 7123 on 1/6/2018.
 */
@Autonomous(name = "AnotherTest")
@Disabled
public class Test extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        LegolessRobot robot = new LegolessRobot(hardwareMap, this);

        waitForStart();

        while (opModeIsActive()) {
            robot.setLeftPower(0.2);
            robot.setRightPower(0.2);
        }
    }
}
