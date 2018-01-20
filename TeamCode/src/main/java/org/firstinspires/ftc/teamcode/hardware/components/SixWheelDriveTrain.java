package org.firstinspires.ftc.teamcode.hardware.components;

import android.util.Log;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.testing.VuforiaTest;


/**
 * Created by andre on 9/20/2017.
 *
 * This contains the hardware configuration for a Six Wheel robot and basic drive
 * functions assuming we are using 4 inch wheels.
 *
 */

public class SixWheelDriveTrain {

    public LinearOpMode opMode;

    public DcMotor rightFrontMotor;
    public DcMotor rightMidMotor;
    public DcMotor rightBackMotor;

    public DcMotor leftFrontMotor;
    public DcMotor leftMidMotor;
    public DcMotor leftBackMotor;

    private static final double wheelCircumference = 31.919; //measured in cm

    private static final double tickPerDegree = 5.8395; //for Neverest Planitary 20 motors with a 12 cm wheel, 120 cm turn circumference


    public SixWheelDriveTrain (HardwareMap hardwareMap, LinearOpMode opMode){
        this.opMode = opMode;
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");
        rightMidMotor = hardwareMap.dcMotor.get("rightMidMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");

        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        leftMidMotor = hardwareMap.dcMotor.get("leftMidMotor");
        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");

        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMidMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setRightPower(double power) {
        rightFrontMotor.setPower(power);
        rightMidMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void setLeftPower(double power) {
        leftFrontMotor.setPower(power);
        leftMidMotor.setPower(power);
        leftBackMotor.setPower(power);
    }

    public void resetDriveEncoders() {
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMidMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMidMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    /*
    public void drive(double meters, double speed) {
        meters = meters * 100 / wheelCircumference * 530;

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFrontMotor.setTargetPosition((int) meters);
        rightBackMotor.setTargetPosition((int) meters);

        leftFrontMotor.setTargetPosition((int) meters);
        leftBackMotor.setTargetPosition((int) meters);

        opMode.telemetry.addData("R1 Position", rightFrontMotor.getTargetPosition());
        opMode.telemetry.addData("R2 Position", rightBackMotor.getTargetPosition());
        opMode.telemetry.addData("L1 Position", leftFrontMotor.getTargetPosition());
        opMode.telemetry.addData("L2 Position", leftBackMotor.getTargetPosition());

        opMode.telemetry.update();

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightFrontMotor.setPower(speed);
        rightBackMotor.setPower(speed);

        leftFrontMotor.setPower(speed);
        leftBackMotor.setPower(speed);

        while (rightFrontMotor.isBusy() && rightBackMotor.isBusy() && leftFrontMotor.isBusy() && leftBackMotor.isBusy() && opMode.opModeIsActive()) {
            opMode.telemetry.addData("R1", rightFrontMotor.getCurrentPosition());
            opMode.telemetry.addData("R2", rightBackMotor.getCurrentPosition());
            opMode.telemetry.addData("L1", leftFrontMotor.getCurrentPosition());
            opMode.telemetry.addData("L2", leftBackMotor.getCurrentPosition());

            opMode.telemetry.update();
        }

        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);

        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
    }
    */


    public void drive(double meters, double speed) {
        meters = meters * 100 / wheelCircumference * 530;

        resetDriveEncoders();

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightMidMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightMidMotor.setTargetPosition((int) meters);
        leftMidMotor.setTargetPosition((int) meters);

        rightMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        rightFrontMotor.setPower(speed);
        rightMidMotor.setPower(speed);
        rightBackMotor.setPower(speed);
        leftFrontMotor.setPower(speed);
        leftMidMotor.setPower(speed);
        leftBackMotor.setPower(speed);

        while (rightMidMotor.isBusy() && leftMidMotor.isBusy() && opMode.opModeIsActive()) {
            opMode.telemetry.addData("position ", rightFrontMotor.getCurrentPosition());
            opMode.telemetry.addData("position ", rightMidMotor.getCurrentPosition());
            opMode.telemetry.addData("position ", rightBackMotor.getCurrentPosition());
            opMode.telemetry.addData("position ", leftFrontMotor.getCurrentPosition());
            opMode.telemetry.addData("position ", leftMidMotor.getCurrentPosition());
            opMode.telemetry.addData("position ", leftBackMotor.getCurrentPosition());
            opMode.telemetry.update();

        }

        rightFrontMotor.setPower(0);
        rightMidMotor.setPower(0);
        rightBackMotor.setPower(0);
        leftFrontMotor.setPower(0);
        leftMidMotor.setPower(0);
        leftBackMotor.setPower(0);
    }


    /*
    public void turnRight(double degrees, double speed) {
        degrees = degrees * tickPerDegree;

        resetDriveEncoders();

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFrontMotor.setTargetPosition((int) -degrees);
        rightBackMotor.setTargetPosition((int) -degrees);
        leftFrontMotor.setTargetPosition((int) degrees);
        leftBackMotor.setTargetPosition((int) degrees);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightFrontMotor.setPower(speed);
        rightBackMotor.setPower(speed);
        leftFrontMotor.setPower(speed);
        leftBackMotor.setPower(speed);

        while (rightFrontMotor.isBusy() && rightBackMotor.isBusy() && leftFrontMotor.isBusy() && leftBackMotor.isBusy() && opMode.opModeIsActive()) {
        }

        setRightPower(0);
        setLeftPower(0);
    }
    */


    public void turnRight(double degrees, double speed){
        degrees = degrees * tickPerDegree;

        rightMidMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMidMotor.setTargetPosition((int) -degrees);
        leftMidMotor.setTargetPosition((int) degrees);

        rightMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setRightPower(speed);
        setLeftPower(speed);

        while (rightMidMotor.isBusy() && leftMidMotor.isBusy() && opMode.opModeIsActive()) {
        }

        setRightPower(0);
        setLeftPower(0);
    }


    /*
    public void turnLeft(double degrees, double speed) {
        degrees = degrees * tickPerDegree;

        resetDriveEncoders();

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFrontMotor.setTargetPosition((int) degrees);
        rightBackMotor.setTargetPosition((int) degrees);
        leftFrontMotor.setTargetPosition((int) -degrees);
        leftBackMotor.setTargetPosition((int) -degrees);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightFrontMotor.setPower(speed);
        rightBackMotor.setPower(speed);
        leftFrontMotor.setPower(speed);
        leftBackMotor.setPower(speed);

        while (rightFrontMotor.isBusy() && rightBackMotor.isBusy() && leftFrontMotor.isBusy() && leftBackMotor.isBusy() && opMode.opModeIsActive()) {
        }

        setRightPower(0);
        setLeftPower(0);
    }
    */


    public void turnLeft(double degrees, double speed) {
        degrees = degrees * tickPerDegree;

        resetDriveEncoders();

        rightMidMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMidMotor.setTargetPosition((int) degrees);
        leftMidMotor.setTargetPosition((int) -degrees);

        rightMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMidMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setRightPower(speed);
        setLeftPower(speed);

        while (rightMidMotor.isBusy() && leftMidMotor.isBusy() && opMode.opModeIsActive()) {
        }

        setRightPower(0);
        setLeftPower(0);
    }
}
