package org.firstinspires.ftc.teamcode.hardware.components;

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

    public static final double JEWEL_ARM_UP = 0.8;
    public static final double JEWEL_ARM_DOWN = 0.7;

    /*
    public enum colorRecorded{
        COLOR_RED, COLOR_BLUE, COLOR_UNDETERMINED
    }

    This is testing stuff that doesn't work. Needs to be redone.

    */

    private Servo jewelArm;

    public ColorSensor colorSensor;

    public boolean jewelArmPosition = POSITION_UP;

    public JewelArm (HardwareMap hardwareMap, LegolessRobot opMode){
        jewelArm = hardwareMap.servo.get("jewelArm");

        //jewelArm.setPosition(JEWEL_ARM_UP);

        colorSensor = (ColorSensor) hardwareMap.i2cDevice.get("colorSensor");
        colorSensor.enableLed(true);
    }

    public void setJewelArmUp(){
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

        }
    }

}
