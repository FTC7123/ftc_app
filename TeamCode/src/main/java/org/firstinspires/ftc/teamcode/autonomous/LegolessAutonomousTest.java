package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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

        fellowshipVuforia = new FellowshipVuforia(hardwareMap, this);
        waitForStart();

        sleep(1000);

        fellowshipVuforia.findTarget();

        sleep(1000);

        if (fellowshipVuforia.targetNumber == 1) {
            telemetry.addData("Target Number: ", fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (fellowshipVuforia.targetNumber == 2) {
            telemetry.addData("Target Number: ", fellowshipVuforia.targetNumber);
            telemetry.update();
        } else if (fellowshipVuforia.targetNumber == 3) {
            telemetry.addData("Target Number: ", fellowshipVuforia.targetNumber);
            telemetry.update();
        } else {
            telemetry.addData("NO TARGET VISIBLE ", null);
            telemetry.update();
        }
    }
}
