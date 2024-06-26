package com.astro.test.berghie.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.astro.test.berghie.data.Item
import com.astro.test.berghie.data.Result
import com.astro.test.berghie.data.defaultUsers

@Composable
fun UserList(users : List<Item>){
    LazyColumn{
        items(users){
            UserCard(it)
        }
    }
}

@Composable
@Preview
fun UserListPreview(){
    UserList(defaultUsers)
}