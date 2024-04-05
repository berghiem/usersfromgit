package com.astro.test.berghie

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import com.astro.test.berghie.data.Result
import com.astro.test.berghie.data.defaultUsers
import com.astro.test.berghie.ui.BrowseUser
import com.astro.test.berghie.ui.UserList
import com.astro.test.berghie.ui.theme.AstroUserGitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AstroUserGitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   UserFromGit("find a user")
                }
            }
        }
    }
}

@Composable
fun UserFromGit(user  : String) {
    BrowseUser(user = user)
}

@Preview(showBackground = true)
@Composable
fun UserFromGitPreview() {
    AstroUserGitTheme {
        UserFromGit("sa")
    }
}

