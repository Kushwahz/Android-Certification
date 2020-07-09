package life.vishalsingh.ModuleB;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import life.vishalsingh.R;

public class TopicB_1 extends AppCompatActivity {

    private EditText mEtMessage;
    private Button btnImplicitIntent;
    private TextView tvShowMessage;
    public static final String sMESSAGE = "This message is from First Activity";
    public static final int sREQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_b_1);

        mEtMessage = findViewById(R.id.et_receiver_message);
        btnImplicitIntent = findViewById(R.id.btn_implicit_intent);
        tvShowMessage = findViewById(R.id.tv_message);

        Log.d("HELLO", "INSIDE onCreate before checking null");
        if(savedInstanceState != null) {
            Log.d("HELLO", "INSIDE onCreate if not null");
            if(savedInstanceState.getBoolean("isDisplay")) {
                Log.d("HELLO", "INSIDE onCreate setting values now");
                Log.d("HELLO", "INSIDE onSaveInstanceMethod");
                tvShowMessage.setVisibility(View.VISIBLE);
                tvShowMessage.setText(savedInstanceState.getString("messageDisplay"));
            }
        }
    }

    public void GoToSecondActivity(View view) {
        Intent sendMessage = new Intent(this, TopicB_2.class);
        sendMessage.putExtra(sMESSAGE, mEtMessage.getText().toString());
        startActivityForResult(sendMessage, sREQUEST_CODE);
    }

    public void GoToImplicitIntent(View view) {
        startActivity(new Intent(this, TopicB_3.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == sREQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                tvShowMessage.setText(data.getStringExtra(TopicB_2.sREPLY));
                tvShowMessage.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(tvShowMessage.getVisibility() == View.VISIBLE) {
            Log.d("HELLO", "INSIDE onSaveInstanceMethod");
            outState.putBoolean("isDisplay", true);
            outState.putString("messageDisplay", tvShowMessage.getText().toString());
        }
    }
}

