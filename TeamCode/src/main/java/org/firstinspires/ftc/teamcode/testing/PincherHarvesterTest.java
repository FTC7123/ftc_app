package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by andre on 12/3/2017.
 */
@TeleOp (name = "Pincher Harvester Test")
public class PincherHarvesterTest extends LinearOpMode{
    @Override

    public void runOpMode() throws InterruptedException {

        DcMotor winch;

        DcMotor rightDrive;
        DcMotor leftDrive;

        Servo rightServo;
        Servo leftServo;

        winch = hardwareMap.dcMotor.get("winch");

        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftDrive = hardwareMap.dcMotor.get("leftDrive");

        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");

        rightServo.setPosition(0);
        leftServo.setPosition(0);

        waitForStart();

        while (opModeIsActive()){

            rightDrive.setPower(gamepad1.right_stick_y);
            leftDrive.setPower(gamepad1.left_stick_y);

            winch.setPower(gamepad2.left_stick_y);

            if (gamepad2.a){
                rightServo.setPosition(1);
                leftServo.setPosition(0.4);
            } else {
                rightServo.setPosition(0.6);
                leftServo.setPosition(0);
            }
        }
    }
}
