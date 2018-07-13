package com.example.servicelearn;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ServiceDemo serviceDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ServiceDemo.BinderDemo binderDemo = (ServiceDemo.BinderDemo)iBinder;
                serviceDemo = binderDemo.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        Intent intent1 = new Intent(MainActivity.this,ServiceDemo.class);
        bindService(intent1,serviceConnection,BIND_AUTO_CREATE);

    }
}
