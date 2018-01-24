package org.firstinspires.ftc.teamcode.hardware.configurations;


import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
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
            setRightPower(0.5);
            setLeftPower(-0.5);
        } else if (ultrasonicArray.ultrasonicDifference <= -2) {
            setRightPower(-0.5);
            setLeftPower(0.5);
        } else if (ultrasonicArray.ultrasonicDifference < 2 || ultrasonicArray.ultrasonicDifference > -2) {
            setRightPower(0);
            setLeftPower(0);
        }
    }

    public void parkRedStoneOne() {
        drive(-0.90, 0.2);
    }

    public void parkBlueStoneOne() {
        drive(0.90, 0.15);
    }

    public void parkBlueStoneTwo() {
        drive(0.70, 0.15);
        turnRight(90, 0.2);
        drive(0.30, 0.2);
    }

    public void scoreGlyph(double meters, double speed) {
        drive(meters, speed);
        setDownGlyph();
        harvester.openHarvester();
    }

    public void pickUpGlyph() {
        harvester.closeHarvester();
        opMode.sleep(100);
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

        opMode.telemetry.addData("Red Value", jewelArm.colorSensor.red());
        opMode.telemetry.addData("Blue Value", jewelArm.colorSensor.blue());
        opMode.telemetry.update();


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

    public void scoreJewelBlue() {
        jewelArm.setJewelArmDown();

        opMode.sleep(500);

        jewelArm.testColor();

        opMode.telemetry.addData("Red Value", jewelArm.colorSensor.red());
        opMode.telemetry.addData("Blue Value", jewelArm.colorSensor.blue());
        opMode.telemetry.update();


        if (jewelArm.colorRecorded == jewelArm.COLOR_RED) {
            turnLeft(10, 0.1);
            jewelArm.setJewelArmUp();
            turnRight(10, 0.1);
        } else if (jewelArm.colorRecorded == jewelArm.COLOR_BLUE) {
            turnRight(10, 0.1);
            jewelArm.setJewelArmUp();
            turnLeft(10, 0.1);
        } else {
        }
    }

    public void findTarget() {
        VuforiaTrackables relicTrackables = this.fellowshipVuforia.vuforia.loadTrackablesFromAsset("RelicVuMark");

        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();
        Log.d("INFO", "Trackables Activated");
        opMode.sleep(3000);
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        if (vuMark == RelicRecoveryVuMark.LEFT) {
            fellowshipVuforia.targetNumber = 1;
            opMode.telemetry.addData("Target Number ", fellowshipVuforia.targetNumber);
            opMode.telemetry.update();
        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            fellowshipVuforia.targetNumber = 2;
            opMode.telemetry.addData("Target Number ", fellowshipVuforia.targetNumber);
            opMode.telemetry.update();
        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            fellowshipVuforia.targetNumber = 3;
            opMode.telemetry.addData("Target Number ", fellowshipVuforia.targetNumber);
            opMode.telemetry.update();
        } else {
            fellowshipVuforia.targetNumber = 0;
            opMode.telemetry.addData("Target Number ", fellowshipVuforia.targetNumber);
            opMode.telemetry.update();
        }

    }
}
