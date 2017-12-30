package org.firstinspires.ftc.teamcode.hardware.configurations;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.components.Harvester;
import org.firstinspires.ftc.teamcode.hardware.components.SixWheelDriveTrain;

/**
 * Created by andre on 9/24/2017.
 *
 * Hardware and methods specifically for Legoless
 */

public class LegolessRobot extends SixWheelDriveTrain {

    public Harvester harvester;


    public VuforiaLocalizer vuforia;

    public int targetNumber = 0;





    public boolean rightButtonDebouce = false;
    public boolean leftButtonDebouce = false;

    public DcMotor relicWinch;
    public Servo relicArmServo;
    public Servo relicClawServo;

    public double relicArmBack = 0.015;
    public double relicArmUp = 0.05;
    public double relicArmDown = 0.13;

    public Servo jewelServo;

    public static final boolean POSITION_UP = false;
    public static final boolean POSITION_DOWN = true;

    public boolean jewelServoPosition = POSITION_UP;

    public boolean jewelServoDebounce = false;



    public LegolessRobot(HardwareMap hardwareMap, LinearOpMode opMode) {
        super(hardwareMap, opMode);


        /*
         * Hardware map initialization section
         * This is only for LegolessRobot specific hardware
         */


        harvester = new Harvester(hardwareMap, opMode);


        relicWinch = hardwareMap.dcMotor.get("relicWinch");
        relicArmServo = hardwareMap.servo.get("relicArmServo");
        relicClawServo = hardwareMap.servo.get("relicClawServo");


        relicArmServo.setPosition(0);

        jewelServo = hardwareMap.servo.get("jewelServo");

    }

    /*
    * PUT LegolessRobot METHODS HERE
    */

    //Vuforia Code
//    public void activateVuforia(HardwareMap hardwareMap) {
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
//
//        parameters.vuforiaLicenseKey = "AZrVU7T/////AAAAGVo9hsImhE6RojK+5tOA/zEuh6SPnDmpFUC14U9v2xbapUtN8fWjT8/cjuJjqybmMknEdiy5uP153iKIS5Bh8NmtymZrpVxH92vqmR7tvtEV/i2VcZBI6rwd181sRIdgphcr/vm4Ow5MoxqhSsBqXYXdElfMiINTfv2riOQsnnTqtMzDo3ZRczpK4rOtqHuSJ4zqrQcP5wJiJXGYGEMzfyryC1i3bMQuwZ7EFIVpCRFilct/s+N27b+gjSMwmvaIXGfU/Mmv4XCGuUZPLEi3pbXKix98RGNfgD4+L9m8qejf3bc7fqq4k3EDunBxAJp7oGq3mzuOTnaEu2L65QujzAlqTNPyTNDZynZshmcyLFlj";
//
//        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
//        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
//
//        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
//        VuforiaTrackable relicTemplate = relicTrackables.get(0);
//        relicTemplate.setName("relicVuMarkTemplate");
//
//        //waitForStart();
//
//        relicTrackables.activate();
//
//        while (opModeIsActive()) {
//            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
//            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
//                telemetry.addData("Vumark", "%s visible", vuMark);
//                telemetry.update();
//
//                        /*
//                         * Sets the targetNumber depending on which target is visible.
//                         */
//
//                if (vuMark == RelicRecoveryVuMark.LEFT) {
//                    targetNumber = 1;
//                } else if (vuMark == RelicRecoveryVuMark.CENTER) {
//                    targetNumber = 2;
//                } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
//                    targetNumber = 3;
//                }
//                break;
//            }
//        }
//    }
}