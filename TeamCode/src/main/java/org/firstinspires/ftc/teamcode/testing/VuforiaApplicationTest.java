package org.firstinspires.ftc.teamcode.testing;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

/**
 * Created by FTC 7123 on 1/11/2018.
 */

@Autonomous(name = "Vuforia Application Test")

public class VuforiaApplicationTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        waitForStart();

        //robot.fellowshipVuforia.findTarget();

        Log.d("Vision", "Finished");

//        if (robot.fellowshipVuforia.targetNumber == 1) {
//            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
//            telemetry.update();
//        } else if (robot.fellowshipVuforia.targetNumber == 2) {
//            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
//            telemetry.update();
//        } else if (robot.fellowshipVuforia.targetNumber == 3) {
//            telemetry.addData("target ", robot.fellowshipVuforia.targetNumber);
//            telemetry.update();
//        } else {
//            telemetry.addData("no target visible ", robot.fellowshipVuforia.targetNumber);
//            telemetry.update();
//        }
        sleep(10000);
    }
}
