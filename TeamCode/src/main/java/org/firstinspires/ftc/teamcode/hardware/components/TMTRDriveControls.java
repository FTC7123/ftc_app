package org.firstinspires.ftc.teamcode.hardware.components;



import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.hardware.configurations.TwoMotorTankRobot;


/**
 * Created by andre on 7/23/2017.
 */

public class TMTRDriveControls extends TwoMotorTankRobot {

    TwoMotorTankRobot robot;

    public void drive (double distance){
        distance =  distance * 4.1772973503558 * 1120;

        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMotor.setTargetPosition((int)distance);
        leftMotor.setTargetPosition((int)distance);

        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightMotor.setPower(0.75);
        leftMotor.setPower(0.75);

        while (rightMotor.isBusy() && leftMotor.isBusy() && opMode.opModeIsActive()){}

        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
//    public void drive(double distance, double power) {
//
//        double targetTics;
//        targetTics = (distance / 10.16) * 1120;
//
//        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        rightMotor.setTargetPosition((int) targetTics);
//        leftMotor.setTargetPosition((int) targetTics);
//
//        while (robot.rightMotor.getCurrentPosition() < robot.rightMotor.getTargetPosition()){
//            robot.rightMotor.setPower(power);
//            robot.leftMotor.setPower(power);
//        }
//
//        robot.rightMotor.setPower(power);
//        robot.leftMotor.setPower(power);
//
//    }
}
