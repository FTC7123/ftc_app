package org.firstinspires.ftc.teamcode.hardware.configurations;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
/**
 * Created by fello on 7/23/2017.
 */

public class TwoMotorTankRobot{

    public DcMotor rightMotor;
    public DcMotor leftMotor;

    public LinearOpMode opMode;

    public void initialize(HardwareMap hardwareMap, LinearOpMode opMode){
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor = hardwareMap.dcMotor.get("leftMotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
