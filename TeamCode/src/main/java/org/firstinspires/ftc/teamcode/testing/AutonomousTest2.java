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
@Autonomous (name = "Autonomous Test 2")
public class AutonomousTest2 extends LegolessRobot {



    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() {


        LegolessRobot robot = new LegolessRobot();
        robot.initialize(hardwareMap, this);

        waitForStart();

        while (targetNumber == 1){
            telemetry.addData("This worked I think", targetNumber);
            telemetry.update();
        }

    }
}