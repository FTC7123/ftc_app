package org.firstinspires.ftc.teamcode.hardware.configurations;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.components.sensors.FellowshipUltrasonicArray;
import org.firstinspires.ftc.teamcode.hardware.components.sensors.FellowshipVuforia;

/**
 * Created by FTC 7123 on 1/7/2018.
 */

public class AutonomousLegolessRobot extends LegolessRobot {

    public FellowshipUltrasonicArray ultrasonicArray;
    public FellowshipVuforia fellowshipVuforia;

    public AutonomousLegolessRobot(HardwareMap hardwareMap, LinearOpMode opMode) {
        super(hardwareMap, opMode);
        ultrasonicArray = new FellowshipUltrasonicArray(hardwareMap, this);
        fellowshipVuforia = new FellowshipVuforia(hardwareMap, this);
    }

    public void equalizeDiffernce() {
        if (ultrasonicArray.ultrasonicDifference >= 2) {
            setRightPower(0.2);
            setLeftPower(-0.2);
        } else if (ultrasonicArray.ultrasonicDifference <= -2) {
            setRightPower(-0.2);
            setLeftPower(0.2);
        } else if (ultrasonicArray.ultrasonicDifference < 2 || ultrasonicArray.ultrasonicDifference > -2) {
            setRightPower(0);
            setLeftPower(0);
        }
    }

    public void parkRedStoneOne() {
        drive(-0.72, 0.2);
    }

    public void scoreGlyph(double meters, double speed) {
        drive(meters, speed);
        setDownGlyph();
        harvester.openHarvester();
    }

    public void pickUpGlyph() {
        harvester.closeHarvester();
        harvester.harvesterWinch.setPower(0.5);
        opMode.sleep(1000);
        harvester.harvesterWinch.setPower(0);
        opMode.sleep(250);
    }

    public void setDownGlyph() {
        harvester.closeHarvester();
        harvester.harvesterWinch.setPower(-0.5);
        opMode.sleep(500);
        harvester.harvesterWinch.setPower(0);
        opMode.sleep(500);
    }

    public void scoreJewelRed() {
        jewelArm.setJewelArmDown();

        opMode.sleep(500);

        jewelArm.testColor();

        if (jewelArm.colorRecorded == jewelArm.COLOR_RED) {
            turnRight(10, 0.1);
            jewelArm.setJewelArmUp();
            turnLeft(10, 0.1);
        } else if (jewelArm.colorRecorded == jewelArm.COLOR_BLUE) {
            turnLeft(10, 0.1);
            jewelArm.setJewelArmUp();
            turnRight(10, 0.1);
        } else {
        }
    }
}
