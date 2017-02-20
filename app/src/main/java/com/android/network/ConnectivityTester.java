package com.android.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by isurangaperera on 2/20/17.
 */
public class ConnectivityTester implements NetworkManager {
    private Context context;

    public ConnectivityTester(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnectedToInternet() {
        ConnectivityManager connectivity =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if(info != null)
                for(int i = 0; i < info.length; i++) {
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
        }
        return false;
    }
}
