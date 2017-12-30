package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.components.Harvester;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.util.MovingAverage;

/**
 * Created by andre on 10/15/2017.
 */
@TeleOp (name = "Legoless Teleop")
public class LegolessTeleOp extends LinearOpMode {
    LinearOpMode opMode;

    @Override
    public void runOpMode() {
        LegolessRobot robot = new LegolessRobot(hardwareMap, this);

        double driveFactor = 0.7;

        MovingAverage rightStickAverage = new MovingAverage(20);
        MovingAverage leftStickAverage = new MovingAverage(20);

        telemetry.addData("Drive Mode: Sport", driveFactor);
        telemetry.update();

        waitForStart();

        boolean rightButtonDebouce = false;
        boolean leftButtonDebouce = false;

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

            rightStickAverage.addValue(gamepad1.right_stick_y);
            leftStickAverage.addValue(gamepad1.left_stick_y);

            //Nudge controls
            if (gamepad1.dpad_up){
                robot.rightFrontMotor.setPower(0.25);
                robot.rightBackMotor.setPower(0.25);
                robot.leftFrontMotor.setPower(0.25);
                robot.leftBackMotor.setPower(0.25);
            } else if (gamepad1.dpad_down){
                robot.rightFrontMotor.setPower(-0.25);
                robot.rightBackMotor.setPower(-0.25);
                robot.leftFrontMotor.setPower(-0.25);
                robot.leftBackMotor.setPower(-0.25);
            } else if (gamepad1.dpad_left){
                robot.rightFrontMotor.setPower(0.25);
                robot.rightBackMotor.setPower(0.25);
                robot.leftFrontMotor.setPower(-0.25);
                robot.leftBackMotor.setPower(-0.25);
            } else if (gamepad1.dpad_right){
                robot.rightFrontMotor.setPower(-0.25);
                robot.rightBackMotor.setPower(-0.25);
                robot.leftFrontMotor.setPower(0.25);
                robot.leftBackMotor.setPower(0.25);
            } else {
                //Drive Controls
                robot.rightFrontMotor.setPower(rightStickAverage.getAverage() * driveFactor);
                robot.rightBackMotor.setPower(rightStickAverage.getAverage() * driveFactor);

                robot.leftFrontMotor.setPower(leftStickAverage.getAverage() * driveFactor);
                robot.leftBackMotor.setPower(leftStickAverage.getAverage() * driveFactor);
            }
            //End Nudge/Drive Controls


            //Harvester Controls
            robot.harvester.harvesterWinch.setPower(gamepad2.left_stick_y);

            if (gamepad2.a){
                robot.harvester.closeHarvester();
            }

            if (gamepad2.b){
                robot.harvester.openHarvester();
            }

            if (gamepad2.right_bumper){
                if (!rightButtonDebouce){
                    robot.harvester.toggleRight();
                    rightButtonDebouce = true;
                }
            } else {
                rightButtonDebouce = false;
            }

            if (gamepad2.left_bumper){
                if (!leftButtonDebouce){
                    robot.harvester.toggleLeft();
                    leftButtonDebouce = true;
                }
            } else {
                leftButtonDebouce = false;
            }


            //End Harvester Controls
            /*
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

            if (gamepad2.dpad_right) {
                relicArmServo.setPosition(relicArmBack);
            }

            if (gamepad2.dpad_up) {
                relicArmServo.setPosition(relicArmUp);
            }

            if (gamepad2.dpad_left) {
                relicArmServo.setPosition(relicArmDown);
            }

            if (gamepad2.x) {
                relicClawServo.setPosition(0.75);
            }

            if (gamepad2.y) {
                relicClawServo.setPosition(0.38);
            }

            //End Relic Controls

            */
            sleep(1 / 2);
        }
    }
}