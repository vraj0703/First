package raj.app.utils.toastMaker

import android.content.Context
import android.view.View
import android.widget.Toast
import raj.app.utils.toastMaker.util.ToastSingleton


object Toaster {
    private var durationDefault = Toast.LENGTH_SHORT

    fun toast(context: Context, message: String?, view: View?, duration: Int) {
        val toast = ToastSingleton.getInstance(context)
        toast.cancel()
        toast.duration = duration
        if (message != null) toast.setText(message)
        if (view != null) toast.view = view
        toast.show()
    }

    // Toast layout overloads
    @JvmOverloads
    fun toast(context: Context, view: View, duration: Int = durationDefault) {
        toast(context, null, view, duration)
    }

    // Toast plain message overloads
    @JvmOverloads
    fun toast(context: Context, message: String, duration: Int = durationDefault) {
        toast(context, message, null, duration)
    }

    fun toast(context: Context, messageResourceId: Int, duration: Int) {
        toast(context, context.getString(messageResourceId), duration)
    }

    fun toast(context: Context, messageResourceId: Int) {
        toast(context, context.getString(messageResourceId))
    }

}
