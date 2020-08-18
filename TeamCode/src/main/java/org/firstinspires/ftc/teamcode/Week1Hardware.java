
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;



public class Week1Hardware {
    /* Public OpMode members. */
    public DcMotor  leftDrive   = null;
    public DcMotor  rightDrive  = null;
    public DistanceSensor sensorRange;
    public ColorSensor color_Sensor;
    public DistanceSensor distance_Sensor;
    public DigitalChannel digitalTouch;
    // The gyroscopre for drift correction
    public BNO055IMU imu;
    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();
    //The constructor
    public Week1Hardware(){ }
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        //still a tad bit confused on what ahwMap is
        leftDrive  = hwMap.get(DcMotor.class, "motor_l ");
        rightDrive  = hwMap.get(DcMotor.class, "motor_r");

        sensorRange = hwMap.get(DistanceSensor.class, "distance_sensor");
        color_Sensor = hwMap.get(ColorSensor.class, "color_distance_sensor");
        distance_Sensor = hwMap.get(DistanceSensor.class, "color_distance_sensor");
        //went with the combo color distance sensor over the rev sensors because it was all in one and thus easier to attach
        digitalTouch = hwMap.get(DigitalChannel.class, "touch_sensor");
        //touch sensor shows when colliding with the wall

        imu = hwMap.get(BNO055IMU.class, "imu");

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        // helps the robot to calculate how much power is needed to go a specific distance
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);


    }
}

