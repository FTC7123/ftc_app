package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by fello on 9/12/2017.
 */
@TeleOp(name="6WheelTest")
public class evalynOliverTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor rightMotor1 = hardwareMap.dcMotor.get("rightMotor1");
        DcMotor rightMotor2 = hardwareMap.dcMotor.get("rightMotor2");
        DcMotor leftMotor1 = hardwareMap.dcMotor.get("leftMotor1");
        DcMotor leftMotor2 = hardwareMap.dcMotor.get("leftMotor2");

        rightMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor2.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        while(opModeIsActive()){
            rightMotor1.setPower(gamepad1.right_stick_y);
            rightMotor2.setPower(gamepad1.right_stick_y);
            leftMotor1.setPower(gamepad1.left_stick_y);
            leftMotor2.setPower(gamepad1.right_stick_y);
            
        }
    }


}