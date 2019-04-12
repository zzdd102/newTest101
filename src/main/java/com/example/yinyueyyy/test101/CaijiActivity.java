package com.example.yinyueyyy.test101;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CaijiActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caiji);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        final Button button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected  void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected  void onStop(){
        super.onStop();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        float[] values = event.values;
        int type = event.sensor.getType();
        StringBuilder sb;
        switch(type) {
            case Sensor.TYPE_ACCELEROMETER:
                sb = new StringBuilder();
                sb.append("加速度传感器返回数据：");
                sb.append("\nX方向的加速度：");
                sb.append(values[0]);
                sb.append("\nY方向的加速度：");
                sb.append(values[1]);
                sb.append("\nZ方向的加速度：");
                sb.append(values[2]);
                textView.setText(sb.toString());
                break;
            case Sensor.TYPE_ORIENTATION:
                sb = new StringBuilder();
                sb.append("\n方向传感器返回数据：");
                sb.append("\n绕Z轴转过的角度：");
                sb.append(values[0]);
                sb.append("\n绕X轴转过的角度：");
                sb.append(values[1]);
                sb.append("\n绕Y轴转过的角度：");
                sb.append(values[2]);
                textView2.setText(sb.toString());
                break;
            case Sensor.TYPE_GYROSCOPE:
                sb = new StringBuilder();
                sb.append("\n陀螺仪传感器返回数据：");
                sb.append("\n绕X轴旋转的角速度：");
                sb.append(values[0]);
                sb.append("\n绕Y轴旋转的角速度：");
                sb.append(values[1]);
                sb.append("\n绕Z轴旋转的角速度：");
                sb.append(values[2]);
                textView3.setText(sb.toString());
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                sb = new StringBuilder();
                sb.append("\n磁场传感器返回数据：");
                sb.append("\nX轴方向上的磁场强度：");
                sb.append(values[0]);
                sb.append("\nY轴方向上的磁场强度：");
                sb.append(values[1]);
                sb.append("\nZ轴方向上的磁场强度：");
                sb.append(values[2]);
                textView4.setText(sb.toString());
                break;
            case Sensor.TYPE_PRESSURE:
                sb = new StringBuilder();
                sb.append("\n气压传感器返回数据：");
                sb.append("\n当前气压为：");
                sb.append(values[0]);
                textView5.setText(sb.toString());
                break;
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }
}
