package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.components.TMTRDriveControls;
import org.firstinspires.ftc.teamcode.hardware.configurations.TwoMotorTankRobot;

/**
 * Created by andre on 7/23/2017.
 */
@Autonomous (name = "Two Motor Tank Auto Test")
public class TMTRAutoTest extends LinearOpMode {
    @Override

    public void runOpMode() throws InterruptedException{
        TMTRDriveControls robot = new TMTRDriveControls();
        robot.initialize(hardwareMap, this);

        robot.drive(2);
    }
}
