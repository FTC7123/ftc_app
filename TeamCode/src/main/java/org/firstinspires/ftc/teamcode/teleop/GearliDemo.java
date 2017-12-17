package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by fello on 9/12/2017.
 */
@TeleOp(name="Gearli Demo")
public class GearliDemo extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Servo handServo;

        handServo = hardwareMap.servo.get("handServo");

        DcMotor rightMotor1 = hardwareMap.dcMotor.get("rightMotor1");
        DcMotor rightMotor2 = hardwareMap.dcMotor.get("rightMotor2");
        DcMotor leftMotor1 = hardwareMap.dcMotor.get("leftMotor1");
        DcMotor leftMotor2 = hardwareMap.dcMotor.get("leftMotor2");

        leftMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor2.setDirection(DcMotorSimple.Direction.REVERSE);

        handServo.setPosition(0.25);

        waitForStart();

        while(opModeIsActive()){
            rightMotor1.setPower(gamepad1.right_stick_y);
            rightMotor2.setPower(gamepad1.right_stick_y);
            leftMotor1.setPower(gamepad1.left_stick_y);
            leftMotor2.setPower(gamepad1.left_stick_y);

            if (gamepad1.a){
                handServo.setPosition(0);
                sleep(750);
                handServo.setPosition(0.5);
                sleep(750);
            }  else {
                handServo.setPosition(0.0);
            }
        }
    }
}