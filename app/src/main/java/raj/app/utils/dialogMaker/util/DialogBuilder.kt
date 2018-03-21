package raj.app.utils.dialogMaker.util

import android.content.Context
import android.content.DialogInterface
import android.graphics.PorterDuff
import android.support.annotation.ColorRes
import android.support.annotation.StyleRes
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.ImageView
import raj.app.R


@Suppress("NAME_SHADOWING")
class DialogBuilder(private val context: Context, @StyleRes myAlertDialogStyle: Int) {

    private val dialog: AlertDialog = AlertDialog.Builder(context, myAlertDialogStyle).create()

    fun getAlertDialog(): AlertDialog {
        return dialog
    }

    fun build(callback: DialogMakerCallback?, icon: Int, iconColor: Int, title: String, message: String, cancalable: Boolean) {
        dialog.setIcon(icon)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setCancelable(cancalable)
        var buttonText: CharSequence = context.resources.getText(R.string.okay)
        if (callback != null) {
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, buttonText) { _, _ -> callback.dialogButtonClicked() }
            buttonText = context.resources.getText(R.string.cancel)
        }
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, buttonText) { _, _ ->
            close()
        }
        dialog.setOnShowListener {
            setIconColor(dialog, iconColor)
        }
    }

    fun close() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    private fun setIconColor(dialog: AlertDialog, @ColorRes color: Int) {
        try {
            try {
                var c: Class<*> = dialog.javaClass
                val mAlert = c.getDeclaredField("mAlert")
                mAlert.isAccessible = true
                val alertController = mAlert.get(dialog)
                c = alertController.javaClass
                val mImageView = c.getDeclaredField("mIconView")
                mImageView.isAccessible = true
                val icon = mImageView.get(alertController)
                val iconView = icon as ImageView
                val color = context.resources.getColor(color)
                iconView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
