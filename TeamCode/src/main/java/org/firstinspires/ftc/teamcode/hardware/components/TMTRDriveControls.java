package org.firstinspires.ftc.teamcode.hardware.components;



import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.configurations.TwoMotorTankRobot;

/**
 * Created by andre on 7/23/2017.
 */

public class TMTRDriveControls extends TwoMotorTankRobot {

    TwoMotorTankRobot robot;

    public void drive(double distance, double power) {

        double movementTics;
        movementTics = (distance / 10.16) * 1120;

        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightMotor.setTargetPosition((int) movementTics);
        leftMotor.setTargetPosition((int) movementTics);

        rightMotor.getCurrentPosition();
        leftMotor.getCurrentPosition();

        if ((movementTics - rightMotor.getCurrentPosition()) < 0) {
            rightMotor.setPower(power);
            leftMotor.setPower(power);
        } else {
            rightMotor.setPower(0);
            leftMotor.setPower(0);
        }
    }
}
