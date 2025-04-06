package com.example.bridee.core.toast

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.example.bridee.core.toast.property.ToastProperty

class CustomToast(context: Context): Toast(context) {

    @Composable
    fun MakeToast(
        message: String,
        duration: Int = LENGTH_LONG,
        type: ToastProperty,
        padding: PaddingValues,
        contentAlignment: Alignment
    ) {
        val context = LocalContext.current
        val views = ComposeView(context)

        views.setContent {
            ToastUtils.SetView(
                text = message,
                toastType = type,
                padding = padding,
                contentAlignment = contentAlignment
            )
        }


        views.setViewTreeSavedStateRegistryOwner(LocalSavedStateRegistryOwner.current)
        views.setViewTreeLifecycleOwner(LocalLifecycleOwner.current)
        views.setViewTreeViewModelStoreOwner(LocalViewModelStoreOwner.current)



        this.duration = duration
        this.view = views
    }

}