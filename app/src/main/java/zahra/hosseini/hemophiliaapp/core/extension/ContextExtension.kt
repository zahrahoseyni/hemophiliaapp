package zahra.hosseini.hemophiliaapp.core.extension

import android.content.Context
import android.widget.Toast

fun Context.showMessage(message: CharSequence, isLengthLong: Boolean = true) =
    Toast.makeText(
        this, message, if (isLengthLong) {
            Toast.LENGTH_LONG
        } else {
            Toast.LENGTH_SHORT
        }
    ).show()