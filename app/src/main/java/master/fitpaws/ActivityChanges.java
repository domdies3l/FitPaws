package master.fitpaws;

import android.content.Context;
import android.content.Intent;

public class ActivityChanges {
    public static void startActivity(Context context, Class activityToStart){
        Intent intent = new Intent(context, activityToStart);
        context.startActivity(intent);
    }
}
