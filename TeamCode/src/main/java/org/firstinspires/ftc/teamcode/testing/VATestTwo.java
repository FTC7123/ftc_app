package org.firstinspires.ftc.teamcode.testing;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;

import java.util.jar.Attributes;

/**
 * Created by FTC 7123 on 1/15/2018.
 */
@Autonomous(name = "VATestTwo")
public class VATestTwo extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer vuforia;

        AutonomousLegolessRobot robot = new AutonomousLegolessRobot(hardwareMap, this);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZrVU7T/////AAAAGVo9hsImhE6RojK+5tOA/zEuh6SPnDmpFUC14U9v2xbapUtN8fWjT8/cjuJjqybmMknEdiy5uP153iKIS5Bh8NmtymZrpVxH92vqmR7tvtEV/i2VcZBI6rwd181sRIdgphcr/vm4Ow5MoxqhSsBqXYXdElfMiINTfv2riOQsnnTqtMzDo3ZRczpK4rOtqHuSJ4zqrQcP5wJiJXGYGEMzfyryC1i3bMQuwZ7EFIVpCRFilct/s+N27b+gjSMwmvaIXGfU/Mmv4XCGuUZPLEi3pbXKix98RGNfgD4+L9m8qejf3bc7fqq4k3EDunBxAJp7oGq3mzuOTnaEu2L65QujzAlqTNPyTNDZynZshmcyLFlj";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();
        Log.d("INFO", "Trackables Activated");
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        waitForStart();
/*
        while (opModeIsActive()) {
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                robot.fellowshipVuforia.targetNumber = 1;
                telemetry.addData("Left ", robot.fellowshipVuforia.targetNumber);
                telemetry.update();
                Log.d("Vision", "Left Visible");
            }
            if (vuMark == RelicRecoveryVuMark.CENTER) {
                robot.fellowshipVuforia.targetNumber = 2;
                telemetry.addData("Center ", robot.fellowshipVuforia.targetNumber);
                telemetry.update();
                Log.d("Vision", "Center Visible");
            }
            if (vuMark == RelicRecoveryVuMark.RIGHT) {
                robot.fellowshipVuforia.targetNumber = 3;
                telemetry.addData("Right ", robot.fellowshipVuforia.targetNumber);
                telemetry.update();
                Log.d("Vision", "Right Visible");
            }
            if (vuMark == RelicRecoveryVuMark.UNKNOWN) {
                robot.fellowshipVuforia.targetNumber = 0;
                Log.d("Vision", "Unknown");
            }

        }
    */
    }

}
