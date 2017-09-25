package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.VuMarkTarget;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.components.SixWheelDriveControls;

/**
 * Created by andre on 9/18/2017.
 */
@Autonomous (name = "Autonomous Test 2")
public class AutonomousTest2 extends VuforiaTest {

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() {

        waitForStart();


        while (opModeIsActive()){

            if (targetNumber == 1){
                targetNumber = 1;
                telemetry.addData("target number == ",  targetNumber);
                telemetry.update();
            } else if (targetNumber == 2) {
                targetNumber = 2;
                telemetry.addData("target number == ", targetNumber);
                telemetry.update();
            } else if (targetNumber == 3) {
                targetNumber = 3;
                telemetry.addData("target number == ", targetNumber);
                telemetry.update();
            }
        }
    }
}