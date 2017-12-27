package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

        double driveFactor = 0.7;

        /** Will wuz here */
        // Create two lists of size 100 with all elements set to 0
        List<Double> yStickReadings = new ArrayList<>(Collections.nCopies(100, 0.0));
        List<Double> xStickReadings = new ArrayList<>(Collections.nCopies(100, 0.0));
        /** END Will wuz here */

        telemetry.addData("Drive Mode: Sport", driveFactor);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            //Drive speed controls
            if (gamepad1.x){
                driveFactor = 0.4;
                telemetry.addData("Drive Mode: Normal ", driveFactor);
                telemetry.update();
            }
            if (gamepad1.y){
                driveFactor = 0.7;
                telemetry.addData("Drive Mode: Sport ", driveFactor);
                telemetry.update();
            }
            if (gamepad1.b){
                driveFactor = 1;
                telemetry.addData("Drive Mode: Sport Plus ", driveFactor);
                telemetry.update();
            }

            //Nudge controls
            if (gamepad1.dpad_up){
                driveTrain.rightFrontMotor.setPower(0.25);
                driveTrain.rightBackMotor.setPower(0.25);
                driveTrain.leftFrontMotor.setPower(0.25);
                driveTrain.leftBackMotor.setPower(0.25);
            } else if (gamepad1.dpad_down){
                driveTrain.rightFrontMotor.setPower(-0.25);
                driveTrain.rightBackMotor.setPower(-0.25);
                driveTrain.leftFrontMotor.setPower(-0.25);
                driveTrain.leftBackMotor.setPower(-0.25);
            } else if (gamepad1.dpad_left){
                driveTrain.rightFrontMotor.setPower(0.25);
                driveTrain.rightBackMotor.setPower(0.25);
                driveTrain.leftFrontMotor.setPower(-0.25);
                driveTrain.leftBackMotor.setPower(-0.25);
            } else if (gamepad1.dpad_right){
                driveTrain.rightFrontMotor.setPower(-0.25);
                driveTrain.rightBackMotor.setPower(-0.25);
                driveTrain.leftFrontMotor.setPower(0.25);
                driveTrain.leftBackMotor.setPower(0.25);
            } else {
                //Drive Controls
                driveTrain.rightFrontMotor.setPower(gamepad1.right_stick_y * driveFactor);
                driveTrain.rightBackMotor.setPower(gamepad1.right_stick_y * driveFactor);

                driveTrain.leftFrontMotor.setPower(gamepad1.left_stick_y * driveFactor);
                driveTrain.leftBackMotor.setPower(gamepad1.left_stick_y * driveFactor);
            }
            //End Nudge/Drive Controls


            //Harvester Controls
            harvesterWinch.setPower(gamepad2.left_stick_y);

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
            //End Harvester Controls

            //Jewel Servo Controls
            if (gamepad1.left_bumper){
                if (!jewelServoDebounce){
                    jewelServoPosition = !jewelServoPosition;
                    jewelServoDebounce = true;
                }
            } else {
                jewelServoDebounce = false;
            }

            if (jewelServoPosition = POSITION_UP){
                jewelServo.setPosition(0);
            }

            if (jewelServoPosition = POSITION_DOWN){
                jewelServo.setPosition(1);
            }
            //End Jewel Servo Controls

            //Relic Controls
            relicWinch.setPower(gamepad2.right_stick_y);

            //End Relic Controls
        }
    }
}