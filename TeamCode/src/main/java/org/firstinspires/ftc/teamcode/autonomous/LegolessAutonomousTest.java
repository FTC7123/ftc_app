package org.firstinspires.ftc.teamcode.autonomous;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.components.FellowshipVuforia;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */
@Autonomous(name = "Legoless Autonomous Test")
public class LegolessAutonomousTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        LegolessRobot robot = new LegolessRobot(hardwareMap, this);

        Log.d("Autonomous Test", "*****ROBOT INITIALIZED*****");

        waitForStart();

        Log.d("Autonomous Test", "*****OPMODE STARTED*****");
//
//        robot.setRightPower(1);
//        robot.setLeftPower(1);
//
//        sleep(1000);
//
//        robot.setRightPower(0);
//        robot.setLeftPower(0);
//
        robot.drive(1, 0.2);
//
//        Log.d("Autonomous Test", "*****COMMAND EXCECUTED*****");

        //robot.turnLeft(90, 0.2);
    }
}
