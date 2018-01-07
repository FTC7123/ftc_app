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
    public DcMotor rightBackMotor;

    public DcMotor leftFrontMotor;
    public DcMotor leftBackMotor;

    private static final double wheelCircumference = 12.566;

    /*
    public FellowshipIMU imu;

    public double currentAngle;
    public double lastAngle;

    public double targetDegrees;

    public double firstAngle;

    public static final double THRESH = 180;
*/

    public SixWheelDriveTrain (HardwareMap hardwareMap, LinearOpMode opMode){
        this.opMode = opMode;
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");

        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        imu = new FellowshipIMU();
//        imu.initialize(hardwareMap);
    }

    public void resetDriveEncoders() {
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void drive(double meters, double speed) {
        meters = meters * wheelCircumference * 530;

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

        opMode.sleep(10000);

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

    public void setRightPower(double power) {
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void setLeftPower(double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
    }

    /*
    public void turnRight(double angle, double speed) {
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        setRightPower(-speed);
        setLeftPower(speed);

        imu.resetStartPosition();

        while (Math.abs(imu.getDeltaAngle()) < angle) {
            imu.update();
            opMode.sleep(1);
        }

        setRightPower(0);
        setLeftPower(0);
    }

    public void turnLeft(double angle, double speed) {
        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        setRightPower(speed);
        setLeftPower(-speed);

        imu.resetStartPosition();

        while (Math.abs(imu.getDeltaAngle()) < angle) {
            imu.update();
            opMode.sleep(1);
        }

        setRightPower(0);
        setLeftPower(0);
    }*/
}
