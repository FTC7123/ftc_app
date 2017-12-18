package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by andre on 12/3/2017.
 */
@TeleOp (name = "Pincher Harvester Test")
public class PincherHarvesterTest extends LinearOpMode{
    public static final boolean POSITION_OPEN = false;
    public static final boolean POSITION_CLOSED = true;

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor winch;

        DcMotor rightDrive;
        DcMotor leftDrive;

        Servo rightServo;
        Servo leftServo;

        boolean rightServoPosition = POSITION_OPEN;
        boolean leftServoPosition = POSITION_OPEN;

        boolean rightButtonDebouce = false;
        boolean leftButtonDebouce = false;

        winch = hardwareMap.dcMotor.get("winch");

        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftDrive = hardwareMap.dcMotor.get("leftDrive");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");

        rightServo.setPosition(0.5);
        leftServo.setPosition(0.5);

        waitForStart();

        while (opModeIsActive()){

            rightDrive.setPower(gamepad1.right_stick_y);
            leftDrive.setPower(gamepad1.left_stick_y);

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
