package org.firstinspires.ftc.teamcode.hardware.configurations;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.components.sensors.FellowshipUltrasonicArray;
import org.firstinspires.ftc.teamcode.hardware.components.sensors.FellowshipVuforia;

/**
 * Created by FTC 7123 on 1/7/2018.
 */

public class AutonomousLegolessRobot extends LegolessRobot {

    public FellowshipUltrasonicArray ultrasonicArray;
    public FellowshipVuforia fellowshipVuforia;


    public AutonomousLegolessRobot(HardwareMap hardwareMap, LinearOpMode opMode) {
        super(hardwareMap, opMode);
        ultrasonicArray = new FellowshipUltrasonicArray(hardwareMap, this);
        fellowshipVuforia = new FellowshipVuforia(hardwareMap, this);
    }

    public void equalizeDiffernce() {
        if (ultrasonicArray.ultrasonicDifference > 0) {
            setRightPower(0.1);
            setLeftPower(-0.1);
        } else if (ultrasonicArray.ultrasonicDifference < 0) {
            setRightPower(-0.1);
            setLeftPower(0.1);
        } else {
            setRightPower(0);
            setLeftPower(0);
        }
    }
}
