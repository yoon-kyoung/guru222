package com.example.myapplication

data class Chat_Message(
    var message: String?,
    var sendId: String?
){
    constructor():this("","")
}