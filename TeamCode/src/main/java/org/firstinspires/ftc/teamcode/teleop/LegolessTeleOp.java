package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

/**
 * Created by andre on 10/15/2017.
 */

public class LegolessTeleOp extends LegolessRobot{
    LinearOpMode opMode;

    @Override
    public void runOpMode() {
        SixWheelDriveTrain driveTrain = new SixWheelDriveTrain();
        driveTrain.initialize(hardwareMap, this);

        waitForStart();

        if (gamepad1.a){
            leftJewelServo.setPosition(1);
        }
    }
}
