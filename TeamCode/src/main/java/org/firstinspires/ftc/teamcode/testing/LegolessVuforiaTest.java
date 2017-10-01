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
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 9/18/2017.
 */
@Autonomous (name = "Legoless Vuforia Test")
public class LegolessVuforiaTest extends LegolessRobot {

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() {

        LegolessRobot robot = new LegolessRobot();
        robot.initialize(hardwareMap, this);

        waitForStart();

        while (opModeIsActive()){
            if (targetNumber == 1){
                telemetry.addData("Left Target ", targetNumber);
                telemetry.update();
            } else if (targetNumber == 2){
                telemetry.addData("Center Target ", targetNumber);
                telemetry.update();
            } else if (targetNumber == 3) {
                telemetry.addData("Right Target ", targetNumber);
                telemetry.update();
            }
        }
    }
}