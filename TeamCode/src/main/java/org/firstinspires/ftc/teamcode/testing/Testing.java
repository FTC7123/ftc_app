package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by FTC 7123 on 1/24/2018.
 */
@TeleOp(name = "Testing")
public class Testing extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.right_trigger > 0) {
                telemetry.addData("Right Activated, slide moving out", gamepad1.right_trigger);
                telemetry.update();
            } else if (gamepad1.left_trigger > 0) {
                telemetry.addData("Left Activated, slide moving out", gamepad1.left_trigger);
                telemetry.update();
            } else {
                telemetry.addData("Nothing Activated", null);
                telemetry.update();
            }
        }
    }
}
