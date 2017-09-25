package org.firstinspires.ftc.teamcode.hardware.components;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

/**
 * Created by andre on 9/20/2017.
 */

public class SixWheelDriveControls extends SixWheelDriveTrain {

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
}
