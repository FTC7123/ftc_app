package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.components.FellowshipVuforia;
import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;

/**
 * Created by andre on 1/2/2018.
 */
@Autonomous(name = "Legoless Autonomous Test")
public class LegolessAutonomousTest extends LinearOpMode {

    public FellowshipVuforia fellowshipVuforia;

    @Override
    public void runOpMode() throws InterruptedException {
        LegolessRobot robot = new LegolessRobot(hardwareMap, this);
        robot.drive(-1, 0.2);

        //robot.turnLeft(90, 0.2);
    }
}
