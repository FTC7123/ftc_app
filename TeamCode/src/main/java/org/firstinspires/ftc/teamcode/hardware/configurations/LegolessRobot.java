package org.firstinspires.ftc.teamcode.hardware.configurations;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.internal.vuforia.VuforiaLocalizerImpl;

/**
 * Created by andre on 9/24/2017.
 *
 * Hardware and methods specifically for Legoless
 */

public class LegolessRobot extends LinearOpMode {

    public static final boolean POSITION_OPEN = false;
    public static final boolean POSITION_CLOSED = true;

    VuforiaLocalizer vuforia;

    public int targetNumber = 0;

    public DcMotor winch;

    public Servo rightServo;
    public Servo leftServo;

    public boolean rightServoPosition = POSITION_OPEN;
    public boolean leftServoPosition = POSITION_OPEN;

    public boolean rightButtonDebouce = false;
    public boolean leftButtonDebouce = false;

    public void runOpMode() {

        /*
         * Hardware map initialization section
         * This is only for LegolessRobot specific hardware
         */

        winch = hardwareMap.dcMotor.get("winch");

        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");

        rightServo.setPosition(0.5);
        leftServo.setPosition(0.5);
    }

    /*
    * PUT LegolessRobot METHODS HERE
    */

    //Vuforia Code
    public void activateVuforia() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZrVU7T/////AAAAGVo9hsImhE6RojK+5tOA/zEuh6SPnDmpFUC14U9v2xbapUtN8fWjT8/cjuJjqybmMknEdiy5uP153iKIS5Bh8NmtymZrpVxH92vqmR7tvtEV/i2VcZBI6rwd181sRIdgphcr/vm4Ow5MoxqhSsBqXYXdElfMiINTfv2riOQsnnTqtMzDo3ZRczpK4rOtqHuSJ4zqrQcP5wJiJXGYGEMzfyryC1i3bMQuwZ7EFIVpCRFilct/s+N27b+gjSMwmvaIXGfU/Mmv4XCGuUZPLEi3pbXKix98RGNfgD4+L9m8qejf3bc7fqq4k3EDunBxAJp7oGq3mzuOTnaEu2L65QujzAlqTNPyTNDZynZshmcyLFlj";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
                telemetry.addData("Vumark", "%s visible", vuMark);
                telemetry.update();

                        /*
                         * Sets the targetNumber depending on which target is visible.
                         */

                if (vuMark == RelicRecoveryVuMark.LEFT) {
                    targetNumber = 1;
                } else if (vuMark == RelicRecoveryVuMark.CENTER) {
                    targetNumber = 2;
                } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                    targetNumber = 3;
                }
                break;
            }
        }
    }
}


