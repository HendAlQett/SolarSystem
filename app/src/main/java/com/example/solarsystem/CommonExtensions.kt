package com.example.solarsystem

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by hend on 6/12/18.
 */

/**
 * Creating new file "Cmd + N"
 */
fun View.showSnackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
}
