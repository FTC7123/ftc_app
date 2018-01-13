package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by thomaslauer on 12/28/17.
 */
@Autonomous(name = "WinchTest")
@Disabled
public class WinchServoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Servo s = hardwareMap.servo.get("relicArmServo");
        waitForStart();
        while(opModeIsActive()) {
            s.setPosition(0.1);
            sleep(5000);
            s.setPosition(0.2);
            sleep(5000);
            s.setPosition(0.3);
            sleep(5000);
            s.setPosition(0.4);
            sleep(5000);
            s.setPosition(0.5);
            sleep(5000);
            s.setPosition(0.6);
            sleep(5000);
            s.setPosition(0.7);
            sleep(5000);
            s.setPosition(0.8);
            sleep(5000);
            s.setPosition(0.9);
            sleep(5000);
        }
    }
}
