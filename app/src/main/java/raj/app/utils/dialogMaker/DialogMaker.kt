package raj.app.utils.dialogMaker

import android.support.v7.app.AppCompatActivity
import raj.app.R
import raj.app.utils.dialogMaker.util.AlertDialogSingleton
import raj.app.utils.dialogMaker.util.DialogMakerCallback

object DialogMaker {

    enum class Type {
        GOOD, BAD, WARN, INFO
    }

    private fun getIcon(type: Type): Int {
        return when (type) {
            Type.GOOD -> R.drawable.ic_correct
            Type.BAD -> R.drawable.ic_cancel
            Type.WARN -> R.drawable.ic_warning
            else -> R.drawable.ic_info
        }
    }

    private fun getIconColor(type: Type): Int {
        return when (type) {
            Type.GOOD -> R.color.green
            Type.BAD -> R.color.red
            Type.WARN -> R.color.yellow
            else -> R.color.colorPrimary
        }
    }

    fun show(activity: AppCompatActivity, title: String, message: String) {
        show(activity, title, message, false, Type.INFO, null)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, cancelable: Boolean) {
        show(activity, title, message, cancelable, Type.INFO, null)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, type: Type) {
        show(activity, title, message, false, type, null)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, cancelable: Boolean, type: Type) {
        show(activity, title, message, cancelable, type, null)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, callback: DialogMakerCallback) {
        show(activity, title, message, false, Type.INFO, callback)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, cancelable: Boolean, callback: DialogMakerCallback) {
        show(activity, title, message, cancelable, Type.INFO, callback)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, type: Type, callback: DialogMakerCallback?) {
        show(activity, title, message, false, type, callback)
    }

    fun show(activity: AppCompatActivity, title: String, message: String, cancelable: Boolean, type: Type, callback: DialogMakerCallback?) {
        val dialog = AlertDialogSingleton.getInstance(activity, callback, getIcon(type), getIconColor(type), title, message, cancelable)
        if (dialog.isShowing)
            dialog.dismiss()
        dialog.show()
    }

}
