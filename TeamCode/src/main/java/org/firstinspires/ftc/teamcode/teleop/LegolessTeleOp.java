package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

/**
 * Created by andre on 10/15/2017.
 */
@TeleOp (name = "Legoless Teleop")
public class LegolessTeleOp extends LegolessRobot{
    LinearOpMode opMode;

    @Override
    public void runOpMode() {
        super.runOpMode();
        SixWheelDriveTrain driveTrain = new SixWheelDriveTrain();
        driveTrain.initialize(hardwareMap, this);

        double driveFactor = 0.75;

        telemetry.addData("Drive Mode: Sport", driveFactor);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            //Drive speed controls
            if (gamepad1.x){
                driveFactor = 0.5;
                telemetry.addData("Drive Mode: Normal ", driveFactor);
                telemetry.update();
            }
            if (gamepad1.y){
                driveFactor = 0.75;
                telemetry.addData("Drive Mode: Sport ", driveFactor);
                telemetry.update();
            }
            if (gamepad1.b){
                driveFactor = 1;
                telemetry.addData("Drive Mode: Sport Plus ", driveFactor);
            }

            //Drive controls
            driveTrain.rightFrontMotor.setPower(gamepad1.right_stick_y * driveFactor);
            driveTrain.rightBackMotor.setPower(gamepad1.right_stick_y * driveFactor);

            driveTrain.leftFrontMotor.setPower(gamepad1.left_stick_y * driveFactor);
            driveTrain.leftBackMotor.setPower(gamepad1.left_stick_y * driveFactor);

            //Nudge controls
            if (gamepad1.dpad_up){
                driveTrain.rightFrontMotor.setPower(0.25);
                driveTrain.rightBackMotor.setPower(0.25);
                driveTrain.leftFrontMotor.setPower(0.25);
                driveTrain.leftBackMotor.setPower(0.25);
            }

            if (gamepad1.dpad_down){
                driveTrain.rightFrontMotor.setPower(-0.25);
                driveTrain.rightBackMotor.setPower(-0.25);
                driveTrain.leftFrontMotor.setPower(-0.25);
                driveTrain.leftBackMotor.setPower(-0.25);
            }

            if (gamepad1.dpad_left){
                driveTrain.rightFrontMotor.setPower(0.25);
                driveTrain.rightBackMotor.setPower(0.25);
                driveTrain.leftFrontMotor.setPower(-0.25);
                driveTrain.leftBackMotor.setPower(-0.25);
            }

            if (gamepad1.dpad_right){
                driveTrain.rightFrontMotor.setPower(-0.25);
                driveTrain.rightBackMotor.setPower(-0.25);
                driveTrain.leftFrontMotor.setPower(0.25);
                driveTrain.leftBackMotor.setPower(0.25);
            }


            //Harvester Controls
            winch.setPower(gamepad2.left_stick_y);

            if (gamepad2.a){
                rightServoPosition = POSITION_CLOSED;
                leftServoPosition = POSITION_CLOSED;
            }

            if (gamepad2.b){
                rightServoPosition = POSITION_OPEN;
                leftServoPosition = POSITION_OPEN;
            }

            if (gamepad2.right_bumper){
                if (!rightButtonDebouce){
                    leftServoPosition = !leftServoPosition;
                    rightButtonDebouce = true;
                }
            } else {
                rightButtonDebouce = false;
            }

            if (gamepad2.left_bumper){
                if (!leftButtonDebouce){
                    rightServoPosition = !rightServoPosition;
                    leftButtonDebouce = true;
                }
            } else {
                rightButtonDebouce = false;
            }

            if (rightServoPosition == POSITION_CLOSED){
                rightServo.setPosition(0.9);
            } else {
                rightServo.setPosition(0.5);
            }

            if (leftServoPosition == POSITION_CLOSED){
                leftServo.setPosition(0.1);
            } else {
                leftServo.setPosition(0.5);
            }
        }
    }
}