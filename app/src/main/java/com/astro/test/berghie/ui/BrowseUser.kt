package com.astro.test.berghie.ui

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
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
import com.astro.test.berghie.ResultRetriever
import com.astro.test.berghie.data.Item
import com.astro.test.berghie.data.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseUser(user : String){
    Log.d("usergit","user to find $user")
    var input by remember{
        mutableStateOf("")
    }
    val resultRetriever = ResultRetriever()
    var refresh by remember {
        mutableStateOf(false)
    }
    var gitResult by remember {
        mutableStateOf(Result(ArrayList<Item>()))
    }
    val callback = object : Callback<Result> {
        override fun onFailure(call: Call<Result>, t: Throwable) {
            Log.e("astro","problem on calling api {${t?.message}}")
        }

        override fun onResponse(call: Call<Result>,
                                response: Response<Result>
        ) {
            response?.isSuccessful.let {
                gitResult = Result(response?.body()?.items?: emptyList())
                Log.i("astro","result : {${gitResult.items.size}}")
            }
        }
    }
    var resultList by remember {
        mutableStateOf(resultRetriever.getResult(callback,input))
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
            if (input.length > 0  ){
                Text(text = "fetching result for $input")
                resultRetriever.getResult(callback,input)
                Button(
                        onClick ={
                            if (refresh) {
                                refresh = false
                            }else{
                                refresh = true
                            }
                            resultRetriever.getResult(callback,input)

                        },

                    ) {
                        Text("refresh")
                }
                UserList(users = gitResult.items)



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

private fun getresult(){

}