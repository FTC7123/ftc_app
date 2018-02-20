package org.firstinspires.ftc.teamcode.hardware.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;



/**
 * Created by thomaslauer on 12/30/17.
 */

public class JewelArm {

    public static final boolean POSITION_UP = false;
    public static final boolean POSITION_DOWN = true;

    public static final double JEWEL_ARM_UP = 1;
    public static final double JEWEL_ARM_DOWN = 0.25;

    public static final boolean COLOR_RED = true;
    public static final boolean COLOR_BLUE = false;

    public boolean colorRecorded = COLOR_RED;

    LinearOpMode opmode;

    public Servo jewelArm;

    public ColorSensor colorSensor;

    public boolean jewelArmPosition = POSITION_UP;

    public JewelArm (HardwareMap hardwareMap, LegolessRobot opMode){
        jewelArm = hardwareMap.servo.get("jewelArm");

        colorSensor = hardwareMap.colorSensor.get("colorSensor");
        colorSensor.enableLed(true);

        setJewelArmUp();
    }

    public void setJewelArmUp() {
        setJewelArm(POSITION_UP);
    }

    public void setJewelArmDown() {
        setJewelArm(POSITION_DOWN);
    }

    public void setJewelArm(boolean position){
        jewelArmPosition = position;
        if (position == POSITION_DOWN){
            jewelArm.setPosition(JEWEL_ARM_DOWN);
        } else {
            jewelArm.setPosition(JEWEL_ARM_UP);
        }
    }

    public void testColor(){
        if (colorSensor.red() > colorSensor.blue()){
            colorRecorded = COLOR_RED;

        } else if (colorSensor.red() < colorSensor.blue()) {
            colorRecorded = COLOR_BLUE;
        }
    }
}
