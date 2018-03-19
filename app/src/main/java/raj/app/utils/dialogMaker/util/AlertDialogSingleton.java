package raj.app.utils.dialogMaker.util;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import raj.app.R;

public class AlertDialogSingleton {

    //single instance of alert dialog in whole app
    private static DialogBuilder instance;

    private AlertDialogSingleton() {
    }

    public synchronized static AlertDialog getInstance(AppCompatActivity activity, DialogMakerCallback callback, int icon, int iconColor, String title, String message, boolean cancelable) {
        if (instance == null) {
            instance = new DialogBuilder(activity, R.style.MyAlertDialogStyle);
        }
        instance.build(callback, icon, iconColor, title, message, cancelable);
        return instance.getAlertDialog();
    }

    //close ; if needed
    public static void close() {
        instance.close();
    }

}
