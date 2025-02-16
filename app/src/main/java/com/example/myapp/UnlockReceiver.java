package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class UnlockReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Log.d("UnlockReceiver", "Device unlocked - launching chatbot");

            // Start ChatbotActivity in full screen
            Intent chatbotIntent = new Intent(context, ChatbotActivity.class);
            chatbotIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(chatbotIntent);
        }
    }
}
