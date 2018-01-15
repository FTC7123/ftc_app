package org.firstinspires.ftc.teamcode.hardware.components.sensors;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.autonomous.LegolessAutonomousTest;
import org.firstinspires.ftc.teamcode.hardware.configurations.AutonomousLegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 12/30/2017.
 */

public class FellowshipVuforia {

    VuforiaLocalizer vuforia;

    AutonomousLegolessRobot alrOpMode;

    LinearOpMode opMode;

    public int targetNumber = 0;

    private HardwareMap hardwareMap;

    //private VuforiaTrackables relicTrackables = null;


    public FellowshipVuforia(HardwareMap _hardwareMap, LinearOpMode _opMode) {

        hardwareMap = _hardwareMap;
        opMode = _opMode;
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
//
//        parameters.vuforiaLicenseKey = "AZrVU7T/////AAAAGVo9hsImhE6RojK+5tOA/zEuh6SPnDmpFUC14U9v2xbapUtN8fWjT8/cjuJjqybmMknEdiy5uP153iKIS5Bh8NmtymZrpVxH92vqmR7tvtEV/i2VcZBI6rwd181sRIdgphcr/vm4Ow5MoxqhSsBqXYXdElfMiINTfv2riOQsnnTqtMzDo3ZRczpK4rOtqHuSJ4zqrQcP5wJiJXGYGEMzfyryC1i3bMQuwZ7EFIVpCRFilct/s+N27b+gjSMwmvaIXGfU/Mmv4XCGuUZPLEi3pbXKix98RGNfgD4+L9m8qejf3bc7fqq4k3EDunBxAJp7oGq3mzuOTnaEu2L65QujzAlqTNPyTNDZynZshmcyLFlj";
//
//        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
//        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        //VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
    }

    public void findTarget() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZrVU7T/////AAAAGVo9hsImhE6RojK+5tOA/zEuh6SPnDmpFUC14U9v2xbapUtN8fWjT8/cjuJjqybmMknEdiy5uP153iKIS5Bh8NmtymZrpVxH92vqmR7tvtEV/i2VcZBI6rwd181sRIdgphcr/vm4Ow5MoxqhSsBqXYXdElfMiINTfv2riOQsnnTqtMzDo3ZRczpK4rOtqHuSJ4zqrQcP5wJiJXGYGEMzfyryC1i3bMQuwZ7EFIVpCRFilct/s+N27b+gjSMwmvaIXGfU/Mmv4XCGuUZPLEi3pbXKix98RGNfgD4+L9m8qejf3bc7fqq4k3EDunBxAJp7oGq3mzuOTnaEu2L65QujzAlqTNPyTNDZynZshmcyLFlj";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();
        Log.d("INFO", "Trackables Activated");
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
            opMode.telemetry.addData("Vumark", "%s visible", vuMark);
            opMode.telemetry.update();

        }
        while (opMode.opModeIsActive() && vuMark != RelicRecoveryVuMark.UNKNOWN) {
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                targetNumber = 1;
                opMode.telemetry.addData("Left ", targetNumber);
                opMode.telemetry.update();
                Log.d("Vision", "Left Visible");
            }
            if (vuMark == RelicRecoveryVuMark.CENTER) {
                targetNumber = 2;
                opMode.telemetry.addData("Center ", targetNumber);
                opMode.telemetry.update();
                Log.d("Vision", "Center Visible");
            }
            if (vuMark == RelicRecoveryVuMark.RIGHT) {
                targetNumber = 3;
                opMode.telemetry.addData("Right ", targetNumber);
                opMode.telemetry.update();
                Log.d("Vision", "Right Visible");
            }
            if (vuMark == RelicRecoveryVuMark.UNKNOWN) {
                targetNumber = 0;
                Log.d("Vision", "Unknown");
            }
        }
    }
}
