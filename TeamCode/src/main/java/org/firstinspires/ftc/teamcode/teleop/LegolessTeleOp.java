package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.components.Harvester;
import org.firstinspires.ftc.teamcode.hardware.components.RelicArm;
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

        MovingAverage rightStickAverage = new MovingAverage(3);
        MovingAverage leftStickAverage = new MovingAverage(3);

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
                robot.setRightPower(0.25);
                robot.setLeftPower(0.25);
            } else if (gamepad1.dpad_down){
                robot.setRightPower(-0.25);
                robot.setLeftPower(0.25);
            } else if (gamepad1.dpad_left){
                robot.setRightPower(0.25);
                robot.setLeftPower(-0.25);
            } else if (gamepad1.dpad_right){
                robot.setRightPower(-0.25);
                robot.setLeftPower(-0.25);
            } else {
                //Drive Controls
                robot.setRightPower(-rightStickAverage.getAverage() * driveFactor);
                robot.setLeftPower(-leftStickAverage.getAverage() * driveFactor);
            }
            //End Nudge/Drive Controls


            //Harvester Controls
            robot.harvester.harvesterWinch.setPower(gamepad2.left_stick_y);

            if (gamepad2.x) {
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

            //Relic Controls
            if (gamepad1.right_trigger > 0) {
                robot.relicArm.relicWinch.setPower(gamepad1.right_trigger);
                telemetry.addData("Right Activated, slide moving out", gamepad1.right_trigger);
                telemetry.update();
            } else if (gamepad1.left_trigger > 0) {
                robot.relicArm.relicWinch.setPower(gamepad1.left_trigger);
                telemetry.addData("Left Activated, slide moving out", gamepad1.left_trigger);
                telemetry.update();
            } else {
                telemetry.addData("Nothing Activated", null);
                telemetry.update();
            }

            if (gamepad2.dpad_up) {
                robot.relicArm.moveUp();
            }
            if (gamepad2.dpad_down) {
                robot.relicArm.moveDown();
            }


            if (gamepad2.dpad_right) {
                robot.relicArm.setRelicArm(RelicArm.POSITION_STOW);
            }

            if (gamepad2.dpad_up) {
                robot.relicArm.setRelicArm(RelicArm.POSITION_UP);
            }

            if (gamepad2.dpad_left) {
                robot.relicArm.setRelicArm(RelicArm.POSITION_DOWN);
            }

            if (gamepad2.x) {
                robot.relicArm.setRelicClaw(RelicArm.POSITION_CLOSED);
            }

            if (gamepad2.y) {
                robot.relicArm.setRelicClaw(RelicArm.POSITION_OPEN);
            }

            //End Relic Controls
        }
    }
}