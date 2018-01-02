package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */

public class LegolessAutonomousTest extends LinearOpMode {
    LegolessRobot robot = new LegolessRobot(hardwareMap, this);

    @Override
    public void runOpMode() throws InterruptedException {

        robot.fellowshipVuforia.findTarget();

        if (robot.fellowshipVuforia.targetNumber == 1){
            telemetry.addData("Target Number: ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (robot.fellowshipVuforia.targetNumber == 2){
            telemetry.addData("Target Number: ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (robot.fellowshipVuforia.targetNumber == 3){
            telemetry.addData("Target Number: ", robot.fellowshipVuforia.targetNumber);
            telemetry.update();
        }
    }
}
