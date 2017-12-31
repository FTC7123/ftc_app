package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by FTC 7123 on 12/31/2017.
 */
@Autonomous(name = "Relic Arm Servo Test")
public class RelicArmServoTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        LegolessRobot robot = new LegolessRobot(hardwareMap, this);

        robot.relicArm.relicArmServo.setPosition(1);
        sleep(2000);
        robot.relicArm.relicArmServo.setPosition(0);
        sleep(2000);
        robot.relicArm.relicArmServo.setPosition(1);
        sleep(2000);
        robot.relicArm.relicArmServo.setPosition(0);
        sleep(2000);
    }
}
