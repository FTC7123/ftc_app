package org.firstinspires.ftc.teamcode.hardware.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 12/30/17.
 *
 *  
 */

public class Harvester {

    public static final boolean POSITION_OPEN = false;
    public static final boolean POSITION_CLOSED = true;

    public static final double RIGHT_ARM_CLOSED = 0.675;
    public static final double RIGHT_ARM_OPENED = 1;

    public static final double LEFT_ARM_CLOSED = 0.3;
    public static final double LEFT_ARM_OPENED = 0;

    public DcMotor harvesterWinch;
    private Servo rightBottomServo;
    private Servo rightTopServo;

    private Servo leftBottomServo;
    private Servo leftTopServo;

    public boolean rightServoPosition = POSITION_OPEN;
    public boolean leftServoPosition = POSITION_OPEN;

    public Harvester(HardwareMap hardwareMap, LegolessRobot opMode) {
        harvesterWinch = hardwareMap.dcMotor.get("harvesterWinch");

        rightBottomServo = hardwareMap.servo.get("rightBottomServo");
        rightTopServo = hardwareMap.servo.get("rightTopServo");
        leftBottomServo = hardwareMap.servo.get("leftBottomServo");
        leftTopServo = hardwareMap.servo.get("leftTopServo");

        openHarvester();
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
            rightBottomServo.setPosition(RIGHT_ARM_CLOSED);
            rightTopServo.setPosition(RIGHT_ARM_CLOSED);
        } else {
            rightBottomServo.setPosition(RIGHT_ARM_OPENED);
            rightTopServo.setPosition(RIGHT_ARM_CLOSED);
        }
    }

    public void setLeft(boolean position) {
        leftServoPosition = position;
        if (position == POSITION_CLOSED){
            leftBottomServo.setPosition(LEFT_ARM_CLOSED);
            leftTopServo.setPosition(LEFT_ARM_CLOSED);
        } else {
            leftBottomServo.setPosition(LEFT_ARM_OPENED);
            leftTopServo.setPosition(LEFT_ARM_CLOSED);
        }
    }
}
