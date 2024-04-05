package com.astro.test.berghie.ui

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.astro.test.berghie.data.defaultUsers


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseUser(user : String){
    Log.d("usergit","user to find $user")
    var input by remember{
        mutableStateOf("")
    }

    val url = "https://api.github.com/search/users?q=Q"
    var context = LocalContext.current
    if(isNetworkConnected(context)){
        Column {
            TextField(
                value = input,
                onValueChange ={ value -> input = value} ,
                placeholder = {
                    Text(text = user)
                })
            if (input.length > 0){
                UserList(users = defaultUsers)
            }

        }
    }else{
        AlertDialog.Builder(context).setTitle("No internet connection")
            .setMessage("Please check your internet connection try again")
            .setPositiveButton(android.R.string.ok){ _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }


}

@Preview
@Composable
fun BrowseUserPreview(){
    BrowseUser(user = "Jake")
}

private fun isNetworkConnected(context : Context):Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

    return networkCapabilities !=null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}