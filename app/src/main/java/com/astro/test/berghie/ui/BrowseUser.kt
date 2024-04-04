package com.astro.test.berghie.ui

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
import androidx.compose.ui.tooling.preview.Preview
import com.astro.test.berghie.data.defaultUsers


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseUser(user : String){
    Log.d("usergit","user to find $user")
    var input by remember{
        mutableStateOf("")
    }
    Column {
        TextField(
            value = input,
            onValueChange ={ value -> input = value} ,
            placeholder = {
                Text(text = user)
            })
        UserList(users = defaultUsers)
    }

}

@Preview
@Composable
fun BrowseUserPreview(){
    BrowseUser(user = "Jake")
}