package life.vishalsingh.ModuleB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import life.vishalsingh.R;

public class TopicB_2 extends AppCompatActivity {

    private TextView tvDisplaySenderMessage;
    private EditText etMessageToSender;
    private Button btnSendToSender;
    public static final String sREPLY = "This is reply send back";
    private static final String LOG_TAG = TopicB_2.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_b_2);

        tvDisplaySenderMessage = findViewById(R.id.tv_receiver_message);
        etMessageToSender = findViewById(R.id.et_receiver_message);
        btnSendToSender = findViewById(R.id.btn_receiver);

        Intent incomingMessage = getIntent();
        String message = incomingMessage.getStringExtra(TopicB_1.sMESSAGE);
        tvDisplaySenderMessage.setText(message);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
    }

    public void GoBackToFirstActivity(View view) {
        Intent replyBack = new Intent();
        replyBack.putExtra(sREPLY, etMessageToSender.getText().toString());
        setResult(RESULT_OK, replyBack);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
