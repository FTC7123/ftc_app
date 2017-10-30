package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.configurations.LegolessRobot;
import org.firstinspires.ftc.teamcode.hardware.configurations.SixWheelDriveTrain;

/**
 * Created by andre on 10/15/2017.
 */
@TeleOp (name = "Legoless Teleop")
public class LegolessTeleOp extends LegolessRobot{
    LinearOpMode opMode;


    @Override
    public void runOpMode() {
        super.runOpMode();
        SixWheelDriveTrain driveTrain = new SixWheelDriveTrain();
        driveTrain.initialize(hardwareMap, this);

        waitForStart();

        sleep(2000);
        try{
            if(gamepad1.a){
                relicClawServo.setPosition(0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
