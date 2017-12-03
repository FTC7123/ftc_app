package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.VuMarkTarget;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

/**
 * Created by andre on 9/28/2017.
 */
@Autonomous (name = "Auto Test")
public class AutoTest extends LegolessRobot{

    LinearOpMode opMode;

    @Override
    public void runOpMode() {

        SixWheelDriveTrain driveTrain = new SixWheelDriveTrain();
        driveTrain.initialize(hardwareMap, this);

        telemetry.addData("target 0", targetNumber);
        telemetry.update();

        super.runOpMode();

        /*
         * Allows the VuForia code to activate before the match starts
         */

        waitForStart();

        /*
         * The different actions for the robot go in this statement depending on which target it sees.
         * targetNumber == 1, Left Target
         * targetNumber == 2, Center Target
         * targetNumber == 3, Right Target
          */


        activateVuforia();

        if (targetNumber == 1) {
            telemetry.addData("target 1", targetNumber);
            telemetry.update();
        } else if (targetNumber == 2) {
            telemetry.addData("target 2", targetNumber);
            telemetry.update();
        } else if (targetNumber == 3) {
            telemetry.addData("target 3", targetNumber);
            telemetry.update();
        }

        /*
         * Make sure the post condition for all 3 options is the same.
         * This will allow the following code to work no matter which target is visible.
         */
        sleep(1000);
    }
}
