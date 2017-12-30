package org.firstinspires.ftc.teamcode.hardware.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by thomaslauer on 12/30/17.
 */

public class Harvester {

    public static final boolean POSITION_OPEN = false;
    public static final boolean POSITION_CLOSED = true;

    public static final double RIGHT_ARM_CLOSED = 0.9;
    public static final double RIGHT_ARM_OPENED = 0.5;

    public static final double LEFT_ARM_CLOSED = 0.1;
    public static final double LEFT_ARM_OPENED = 0.5;

    public DcMotor harvesterWinch;
    private Servo rightServo;
    private Servo leftServo;

    public boolean rightServoPosition = POSITION_OPEN;
    public boolean leftServoPosition = POSITION_OPEN;

    public Harvester(HardwareMap hardwareMap, LinearOpMode opMode) {
        harvesterWinch = hardwareMap.dcMotor.get("harvesterWinch");
        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");

        rightServo.setPosition(RIGHT_ARM_OPENED);
        leftServo.setPosition(LEFT_ARM_OPENED);
    }

    public void openHarvester() {
        setRight(POSITION_OPEN);
        setLeft(POSITION_OPEN);
    }

    public void closeHarvester() {
        setRight(POSITION_CLOSED);
        setLeft(POSITION_CLOSED);
    }

    public void toggleRight() {
        setRight(!rightServoPosition);
    }

    public void toggleLeft() {
        setLeft(!leftServoPosition);
    }

    public void setRight(boolean position) {
        rightServoPosition = position;
        if (position == POSITION_CLOSED){
            rightServo.setPosition(RIGHT_ARM_CLOSED);
        } else {
            rightServo.setPosition(RIGHT_ARM_OPENED);
        }
    }

    public void setLeft(boolean position) {
        leftServoPosition = position;
        if (position == POSITION_CLOSED){
            rightServo.setPosition(LEFT_ARM_CLOSED);
        } else {
            rightServo.setPosition(LEFT_ARM_OPENED);
        }
    }
}
