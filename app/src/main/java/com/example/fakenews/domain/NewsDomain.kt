package com.example.fakenews.domain

data class NewsDomain(
    val title: String,
    val image: Int,
    val author: String,
    val date: String,
    val topic: String,
    val text: String
)
