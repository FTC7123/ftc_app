package org.firstinspires.ftc.teamcode.autonomous;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.internal.stellaris.FlashLoaderDatagram;
import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */
@Autonomous(name = "Legoless Autonomous Test")
public class LegolessAutonomousTest extends LinearOpMode {

    public VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {

        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);
//        try {
//            Log.d("Status", "Initialized");
//
//            waitForStart();
//
//            Log.d("Status", "Started");
//
//            robot.drive(1,0.2);
//
//            Log.d("Status", "Drive");
//        } catch (NullPointerException e){
//            telemetry.addData("Null Pointer Exception", null);
//        }

        robot.turnLeft(90, 0.2);
        sleep(2000);
        robot.turnRight(90, 0.2);

    }
}