package com.sdmc.aidldemo.asworkspace;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AidlService extends Service {
    private String TAG="AidlService";
    public AidlService() {
        Log.d(TAG, "AidlService: @@@");
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //这里需要返回的是创建aidl对象的Ibinder
        return aidl;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "com.sdmc.aidldemo.asworkspace+onCreate: ");
    }

    public   IBinder aidl = new IMyAidlInterface.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int getValue(int num1, int num2) throws RemoteException {
            return num1*num2;
        }
    };
}
