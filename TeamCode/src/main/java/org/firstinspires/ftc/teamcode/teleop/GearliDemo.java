package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.components.SixWheelDriveTrain;
import org.firstinspires.ftc.teamcode.hardware.configurations.TwoMotorTankRobot;

/**
 * Created by fello on 9/12/2017.
 */
@TeleOp(name = "Gearli Demo w/ Arm")
public class GearliDemo extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        TwoMotorTankRobot robot = new TwoMotorTankRobot(hardwareMap, this);

        Servo handServo;
        handServo = hardwareMap.servo.get("handServo");
        handServo.setPosition(0.5);

        waitForStart();

        while (opModeIsActive()) {
            robot.rightMotor.setPower(gamepad1.right_stick_y);
            robot.leftMotor.setPower(gamepad1.left_stick_y);

            if (gamepad2.a) {
                handServo.setPosition(0.25);
                sleep(300);
                handServo.setPosition(0.75);
                sleep(300);
                handServo.setPosition(0.5);
            }
        }
    }
}