package ru.eltex.phonebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class PhoneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
    }
}
