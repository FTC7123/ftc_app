package org.firstinspires.ftc.teamcode.hardware.components.legoless_components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by andre on 12/30/2017.
 */

public abstract class LegolessHardwareComponent {

    public LinearOpMode opMode;

    public void initialize(LinearOpMode opMode){
        this.opMode = opMode;
    }
}
