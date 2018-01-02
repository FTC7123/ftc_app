package org.firstinspires.ftc.teamcode.hardware.components;

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

    public DcMotor rightFrontMotor;
    public DcMotor rightBackMotor;

    public DcMotor leftFrontMotor;
    public DcMotor leftBackMotor;

    public BNO055IMU imu;

    public double currentAngle;
    public double lastAngle;

    public double targetDegrees;

    public double firstAngle;

    public static final double THRESH = 180;

    //TODO Add IMU code here

    public SixWheelDriveTrain (HardwareMap hardwareMap, LinearOpMode opMode){
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");

        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");

        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hardwareMap.get(BNO055IMU.class, "IMU");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.temperatureUnit = BNO055IMU.TempUnit.CELSIUS;

        imu.initialize(parameters);

    }

    public void drive(double meters, double speed) {
        meters =  meters * 4.1772973503558 * 1120;

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFrontMotor.setTargetPosition((int)meters);
        rightBackMotor.setTargetPosition((int)meters);

        leftFrontMotor.setTargetPosition((int)meters);
        leftBackMotor.setTargetPosition((int)meters);

        rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightFrontMotor.setPower(speed);
        rightBackMotor.setPower(speed);

        leftFrontMotor.setPower(speed);
        leftBackMotor.setPower(speed);

        while (rightFrontMotor.isBusy() && rightBackMotor.isBusy() && leftFrontMotor.isBusy() && leftBackMotor.isBusy()){}

        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);

        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
    }

    public double getAngularOrientation(){
        return imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.XYZ).thirdAngle;
    }

    public void update(){
        lastAngle = currentAngle;
        currentAngle = getAngularOrientation();

        if(Math.abs(currentAngle - lastAngle) > THRESH && currentAngle > lastAngle){
        }
    }

    public void turn(double degrees, double speed){
        degrees = targetDegrees;
        if ((currentAngle - lastAngle) < targetDegrees){
            rightFrontMotor.setPower(speed);
            rightBackMotor.setPower(speed);
            leftFrontMotor.setPower(speed);
            leftBackMotor.setPower(speed);
        } else {
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);
            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
        }

    }
}
