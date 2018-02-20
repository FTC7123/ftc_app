package org.firstinspires.ftc.teamcode.autonomous.red.stone1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.components.JewelArm;
import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/9/2018.
 */
@Autonomous(name = "Red Stone One Jewel, Key, Glyph, Park")
@Disabled
public class RedStoneOneJewelKeyGlyphPark extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        robot.pickUpGlyph();



        sleep(1000);

//        robot.jewelArm.setJewelArmDown();
//
//        if (robot.jewelArm.colorSensor.red() > 9){
//            telemetry.addData("Color is Red ", robot.jewelArm.colorSensor.red());
//            telemetry.update();
//        } else if (robot.jewelArm.colorSensor.blue() < 4){
//            telemetry.addData("Color is Blue ", robot.jewelArm.colorSensor.blue());
//            telemetry.update();
//        } else {}

        robot.drive(-0.225, 0.1);
/*
        robot.fellowshipVuforia.findTarget();

        if (robot.fellowshipVuforia.targetNumber == 1) {
            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (robot.fellowshipVuforia.targetNumber == 2) {
            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (robot.fellowshipVuforia.targetNumber == 3) {
            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        } else {
            telemetry.addData("no target visible ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        }
        sleep(10000);
        */
    }
}
