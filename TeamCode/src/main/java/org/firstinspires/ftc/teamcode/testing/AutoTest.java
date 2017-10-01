package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 9/28/2017.
 */

public class AutoTest extends LegolessRobot{

    LinearOpMode opMode;

    @Override
    public void runOpMode(){
        LegolessRobot robot = new LegolessRobot();
        robot.initialize(hardwareMap, this);

        robot.drive(3, 0.5);
    }
}
