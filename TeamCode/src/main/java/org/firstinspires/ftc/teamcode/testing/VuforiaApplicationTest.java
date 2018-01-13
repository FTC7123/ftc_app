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
@Disabled
public class VuforiaApplicationTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Log.d("*****ROBOT NOT ", "INITIALIZED*****");

        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        Log.d("*****ROBOT ", "INITIALIZED*****");

        waitForStart();

        Log.d("*****OPMODE ", "STARATED *****");
        if (robot.fellowshipVuforia.targetNumber == 1) {
            telemetry.addData("Target Visible: Left - ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        }
        if (robot.fellowshipVuforia.targetNumber == 2) {
            telemetry.addData("Target Visible: Center - ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        }
        if (robot.fellowshipVuforia.targetNumber == 3) {
            telemetry.addData("Target Visible: Right - ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        }

        sleep(5000);
    }
}
