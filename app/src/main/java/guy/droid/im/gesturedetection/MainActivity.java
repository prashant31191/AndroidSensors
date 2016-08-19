package guy.droid.im.gesturedetection;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    GestureDetector myG;
    private SensorManager mSensorManager;
    TextView textView;
    Sensor prox,light;
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        textView = (TextView)findViewById(R.id.val);
        light = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); // REPLACE WITH LIGHT SENSOR,proximity , ACCELO
        mSensorManager.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL);

    //    myG = new GestureDetector(this,new Gesture());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Toast.makeText(getApplicationContext(),"SENSOR CHANGED"+event,Toast.LENGTH_SHORT).show();
        // COMMON PROCESURE FOR ALL SENSORS TO GET VALUE + NAME CAN BE GET
        i++;
        textView.setText(event.sensor.getName()+"");
        for(int j =0;j<event.values.length;j++)
        {
        textView.append("\n "+""+j+"  = "+event.values[j]);
        }
      //  textView.setText(i+"EVENT ::"+event.accuracy+"\n HAS"+event.hashCode()+"\n VALUES"+event.values.);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Toast.makeText(getApplicationContext(),"ACCURACY CHANGED",Toast.LENGTH_SHORT).show();
    }


    class Gesture extends GestureDetector.SimpleOnGestureListener{
        public boolean onSingleTapUp(MotionEvent ev) {
            Toast.makeText(getApplicationContext(),"SINGLE TAP",Toast.LENGTH_LONG).show();
            return true;
        }
        public void onLongPress(MotionEvent ev) {
            Toast.makeText(getApplicationContext(),"LONG PRESS",Toast.LENGTH_LONG).show();
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {
            Toast.makeText(getApplicationContext(),"MOTION",Toast.LENGTH_LONG).show();
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            Toast.makeText(getApplicationContext(),"FLING",Toast.LENGTH_LONG).show();
            return true;
        }

    }
}
