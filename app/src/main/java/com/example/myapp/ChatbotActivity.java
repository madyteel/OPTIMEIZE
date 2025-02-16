package com.example.myapp;

import android.content.Intent; // ✅ Missing import added
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ChatbotActivity extends AppCompatActivity {
    private TextView chatText;
    private EditText inputField;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make this activity full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_chatbot);

        chatText = findViewById(R.id.chat_text);
        inputField = findViewById(R.id.chat_input);
        sendButton = findViewById(R.id.send_button);

        chatText.setText("Why are you unlocking your phone?");

        sendButton.setOnClickListener(v -> {
            String userInput = inputField.getText().toString();
            handleUserInput(userInput);
        });
    }

    private void handleUserInput(String input) {
        if (input.contains("Instagram") || input.contains("TikTok")) {
            openApp(input);
        } else {
            chatText.setText("I don't recognize that. Try again.");
        }
    }

    private void openApp(String appName) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getAppPackageName(appName));
        if (launchIntent != null) {
            launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // ✅ Required for launching activities from some contexts
            startActivity(launchIntent);
        } else {
            chatText.setText("I couldn't find that app!");
        }
    }

    private String getAppPackageName(String appName) {
        if (appName.equalsIgnoreCase("Instagram")) return "com.instagram.android";
        if (appName.equalsIgnoreCase("TikTok")) return "com.zhiliaoapp.musically";
        return "";
    }
}
