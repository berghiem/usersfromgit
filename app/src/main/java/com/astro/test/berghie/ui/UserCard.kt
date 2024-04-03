package com.astro.test.berghie.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astro.test.berghie.data.User
import com.astro.test.berghie.data.defaultUsers

@Composable
fun UserCard(user : User){
    Column {
        Row{
            Image(
                painterResource(user.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp).width(50.dp),
            )
            Column {
                Text(user.userName)
                Text(user.fullName)
            }
        }


    }

}

@Preview
@Composable
fun UserCardPreview(){
    UserCard(user = defaultUsers[0])
}