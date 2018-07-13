package com.example.servicelearn;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MessengerServiceDemo extends Service {
    static final int MSG_SAY_HELLO = 1;
    class SendHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
    final Messenger messenger = new Messenger(new SendHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"binding",Toast.LENGTH_SHORT).show();
        return messenger.getBinder();
    }
}
