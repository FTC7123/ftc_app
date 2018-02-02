package org.firstinspires.ftc.teamcode.hardware.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by thomaslauer on 12/30/17.
 */

public class RelicArm {

    public static final boolean POSITION_OPEN = false;
    public static final boolean POSITION_CLOSED = true;

    public static final double RELIC_CLAW_OPEN = 0.2;
    public static final double RELIC_CLAW_CLOSED = 0.85;

    private double armAccuracy = 0.02;

    public DcMotor relicWinch;
    public Servo relicArmServo;
    public Servo relicClawServo;

    private double currentPosition = 0;
    public boolean relicClawPosition = POSITION_CLOSED;

    public RelicArm(HardwareMap hardwareMap, LegolessRobot opMode){
        relicWinch = hardwareMap.dcMotor.get("relicWinch");
        relicArmServo = hardwareMap.servo.get("relicArmServo");
        relicClawServo = hardwareMap.servo.get("relicClawServo");

        setRelicArm(0.8);
        setRelicClaw(POSITION_CLOSED);
    }

    public void setRelicArm(double position) {
        relicArmServo.setPosition(position);
    }

    public void setRelicClaw(boolean position){
        relicClawPosition = position;
        if (position == POSITION_CLOSED){
            relicClawServo.setPosition(RELIC_CLAW_CLOSED);
        } else {
            relicClawServo.setPosition(RELIC_CLAW_OPEN);
        }
    }

    public void moveDown() {
        currentPosition = relicArmServo.getPosition();
        relicArmServo.setPosition(currentPosition + 0.02);
    }

    public void moveUp() {
        currentPosition = relicArmServo.getPosition();
        relicArmServo.setPosition(currentPosition - 0.02);

    }
}
