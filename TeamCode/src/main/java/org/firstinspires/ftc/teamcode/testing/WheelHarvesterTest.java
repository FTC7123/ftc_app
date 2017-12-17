package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by andre on 12/3/2017.
 */
@TeleOp (name = "Wheel Harvester Test")
public class WheelHarvesterTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        /*
        Servo Orientations
        1: Bottom
        2: Mid
        3: Top
         */
        CRServo right1;
        CRServo right2;
        CRServo right3;

        CRServo left1;
        CRServo left2;
        CRServo left3;

        right1 = hardwareMap.crservo.get("right1");
        right2 = hardwareMap.crservo.get("right2");
        right3 = hardwareMap.crservo.get("right3");

        right1.setDirection(DcMotorSimple.Direction.REVERSE);
        right2.setDirection(DcMotorSimple.Direction.REVERSE);
        right3.setDirection(DcMotorSimple.Direction.REVERSE);

        left1 = hardwareMap.crservo.get("left1");
        left2 = hardwareMap.crservo.get("left2");
        left3 = hardwareMap.crservo.get("left3");

        waitForStart();

        while (opModeIsActive()) {
            //controls the bottom servos
            right1.setPower(gamepad1.left_stick_y);
            left1.setPower(gamepad1.left_stick_y);

            //controls the lifting servos
            right2.setPower(gamepad1.right_stick_y);
            right3.setPower(gamepad1.right_stick_y);
            left2.setPower(gamepad1.right_stick_y);
            left3.setPower(gamepad1.right_stick_y);
        }
    }
}
