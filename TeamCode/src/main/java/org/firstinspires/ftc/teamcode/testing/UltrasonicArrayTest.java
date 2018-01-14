package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/13/2018.
 */
@Autonomous(name = "Ultrasonic Test")
public class UltrasonicArrayTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        robot.jewelArm.setJewelArmUp();

        waitForStart();


        for (int i = 0; i < 500; i++) {

            robot.ultrasonicArray.getFrontUltrasonicDistance();
            robot.ultrasonicArray.getBackUltrasonicDistance();
            robot.ultrasonicArray.getUltrasonicDifference();

            robot.equalizeDiffernce();

            sleep(1);
        }

    }
}
