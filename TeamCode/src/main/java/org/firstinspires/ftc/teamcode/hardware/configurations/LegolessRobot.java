package org.firstinspires.ftc.teamcode.hardware.configurations;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.components.FellowshipVuforia;
import org.firstinspires.ftc.teamcode.hardware.components.Harvester;
import org.firstinspires.ftc.teamcode.hardware.components.JewelArm;
import org.firstinspires.ftc.teamcode.hardware.components.RelicArm;
import org.firstinspires.ftc.teamcode.hardware.components.SixWheelDriveTrain;

/**
 * Created by andre on 9/24/2017.
 *
 * Hardware and methods specifically for Legoless
 */

public class LegolessRobot extends SixWheelDriveTrain {

    public Harvester harvester;
    public JewelArm jewelArm;
    public RelicArm relicArm;
    public FellowshipVuforia fellowshipVuforia;

    public LegolessRobot(HardwareMap hardwareMap, LinearOpMode opMode) {
        super(hardwareMap, opMode);

        harvester = new Harvester(hardwareMap, this);
        jewelArm = new JewelArm(hardwareMap, this);
        relicArm = new RelicArm(hardwareMap, this);
        fellowshipVuforia = new FellowshipVuforia(hardwareMap, this);
    }
}