package org.firstinspires.ftc.teamcode.hardware.configurations;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.firstinspires.ftc.teamcode.testing.VuforiaTest;


/**
 * Created by andre on 9/20/2017.
 */

public class SixWheelDriveTrain extends VuforiaTest{

    public DcMotor rightFrontMotor;
    public DcMotor rightBackMotor;

    public DcMotor leftFrontMotor;
    public DcMotor leftBackMotor;

    public OpMode opMode;

    public void initialize (HardwareMap hardwareMap, LinearOpMode opMode){
        rightFrontMotor = hardwareMap.dcMotor.get("rightFrontMotor");
        rightBackMotor = hardwareMap.dcMotor.get("rightBackMotor");

        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        leftBackMotor = hardwareMap.dcMotor.get("leftBackMotor");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
