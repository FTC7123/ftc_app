package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.components.TwoMotorTankRobotMovements;
import org.firstinspires.ftc.teamcode.hardware.configurations.TwoMotorTankRobot;

/**
 * Created by andre on 7/23/2017.
 */
@Autonomous (name = "Autonomous Testing")
public class AutonomousTest extends LinearOpMode {

    public void runOpMode() throws InterruptedException{
        TwoMotorTankRobotMovements robot = new TwoMotorTankRobotMovements();
        robot.initialize(hardwareMap, this);

        robot.drive(1 , 1);
    }

}
