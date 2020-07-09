package life.vishalsingh.ModuleF;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import life.vishalsingh.BuildConfig;
import life.vishalsingh.R;

public class BroadcastReceiverMain extends AppCompatActivity implements BroadcastActions {
    private CustomReceiver customReceiver = new CustomReceiver(this);
    public static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private TextView chargingStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_reciever);

        chargingStatus = findViewById(R.id.tv_charging_status);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(customReceiver, filter);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(customReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(customReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(customReceiver);
        super.onDestroy();
    }

    public void SendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    @Override
    public void updateStatus(String string) {
        chargingStatus.setText(string);
    }
}