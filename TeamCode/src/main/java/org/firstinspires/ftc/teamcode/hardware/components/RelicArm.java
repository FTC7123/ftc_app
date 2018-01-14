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

    public static final double RELIC_CLAW_OPEN = 0.85;
    public static final double RELIC_CLAW_CLOSED = 0.38;

    public DcMotor relicWinch;
    public Servo relicArmServo;
    public Servo relicClawServo;


    public static final double POSITION_STOW = 0;
    public static final double POSITION_UP = 0.04;
    public static final double POSITION_DOWN = 0.11;

    public boolean relicClawPosition = POSITION_OPEN;

    public RelicArm(HardwareMap hardwareMap, LegolessRobot opMode){
        relicWinch = hardwareMap.dcMotor.get("relicWinch");
        relicArmServo = hardwareMap.servo.get("relicArmServo");
        relicClawServo = hardwareMap.servo.get("relicClawServo");

        setRelicArm(POSITION_STOW);
        setRelicClaw(POSITION_OPEN);
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
}
