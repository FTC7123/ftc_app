package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 9/28/2017.
 */
@Autonomous (name = "Auto Test")
public class AutoTest extends LegolessRobot{

    LinearOpMode opMode;

    @Override
    public void runOpMode() {
        LegolessRobot robot = new LegolessRobot();
        robot.initialize(hardwareMap, this);

        telemetry.addData("target 0", targetNumber);
        telemetry.update();

        super.runOpMode();
        if (targetNumber == 1) {
            telemetry.addData("target 1", targetNumber);
            telemetry.update();
        }
        sleep(1000);
        telemetry.addData("target name", this);
        telemetry.update();
    }
}
