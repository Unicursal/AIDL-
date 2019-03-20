package com.sdmc.aidldemo.clientaidl;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.sdmc.aidldemo.asworkspace.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    IMyAidlInterface aidl;
    public static final String TAG="MainActivity";
    ServiceConnection sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sc=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(TAG,"onServiceConnected__success");
                aidl = IMyAidlInterface.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                aidl = null;
                Log.d(TAG,"onServiceDisconnected__fail");
            }
        };
        bindSe();

     findViewById(R.id.btn_startaidl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(aidl!=null) {
                        int value = aidl.getValue(100, 100);
                        Toast.makeText(MainActivity.this, "VALUE" + value, Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "VALUE=" + value);
                    }
                } catch (RemoteException e) {
                    Log.d(TAG,"VALUE="+e);
                    e.printStackTrace();
                }
            }
        });
    }
public void bindSe(){

        Intent intent=new Intent();
    ComponentName component=new ComponentName("com.sdmc.aidldemo.asworkspace","com.sdmc.aidldemo.asworkspace.AidlService");
//    intent.setComponent(component);
    intent.setPackage("com.sdmc.aidldemo.asworkspace");
    intent.setAction("com.dbc.aidl.server.remoteservice");
     
    bindService(intent,sc,Context.BIND_AUTO_CREATE);
    Log.d(TAG, "bindSe: ");
}


}
