package org.firstinspires.ftc.teamcode.hardware.components.sensors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.firstinspires.ftc.teamcode.hardware.components.SixWheelDriveTrain;
import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/7/2018.
 */

public class FellowshipUltrasonicArray {
    //public UltrasonicSensor frontUltrasonicSensor;
    //public UltrasonicSensor backUltrasonicSensor;

    public double frontUltrasonicSensorValue = 0;
    public double backUltrasonicSensorValue = 0;

    public double ultrasonicDifference = 0;


    public FellowshipUltrasonicArray(HardwareMap hardwareMap, AutonomousLegolessRobot opMode) {
        //frontUltrasonicSensor = hardwareMap.ultrasonicSensor.get("frontUltrasonic");
        //backUltrasonicSensor = hardwareMap.ultrasonicSensor.get("backUltrasonic");
    }

    public void getFrontUltrasonicDistance() {
        //frontUltrasonicSensorValue = frontUltrasonicSensor.getUltrasonicLevel();
    }

    public void getBackUltrasonicDistance() {
        //backUltrasonicSensorValue = backUltrasonicSensor.getUltrasonicLevel();
    }

    public void getUltrasonicDifference() {
        //ultrasonicDifference = frontUltrasonicSensorValue - backUltrasonicSensorValue;
    }
}
