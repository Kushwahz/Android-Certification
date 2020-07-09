package life.vishalsingh.ModuleF;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import life.vishalsingh.R;

public class CustomReceiver extends BroadcastReceiver {
    private BroadcastActions broadcastActions;
    public CustomReceiver(BroadcastActions actions){
        broadcastActions = actions;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Log.d("INTENT_ACTION", intentAction);
        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case BroadcastReceiverMain.ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
            broadcastActions.updateStatus(toastMessage);
        }
    }
}
