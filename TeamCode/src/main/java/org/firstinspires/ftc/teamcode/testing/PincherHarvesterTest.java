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

        Servo rightServo;
        Servo leftServo;

        winch = hardwareMap.dcMotor.get("winch");

        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");

        rightServo.setPosition(0);
        leftServo.setPosition(0);

        waitForStart();

        while (opModeIsActive()){
            winch.setPower(gamepad1.left_stick_y);

            while(gamepad1.a){
                rightServo.setPosition(0.5);
                leftServo.setPosition(0.5);
            }
        }
    }
}
