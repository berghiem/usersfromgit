package com.astro.test.berghie.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astro.test.berghie.data.User
import com.astro.test.berghie.data.defaultUsers
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun UserCard(user : User){
    Column {
        Row{
            Image(
                painterResource(user.imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape) )
            Column {
                Text(user.userName, Modifier.padding(2.dp))
                Text(user.fullName, Modifier.padding(2.dp))
            }
        }


    }

}

@Preview
@Composable
fun UserCardPreview(){
    UserCard(user = defaultUsers[0])
}