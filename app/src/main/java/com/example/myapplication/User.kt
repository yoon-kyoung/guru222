package com.example.myapplication

data class User(
    var email: String,
    var uID: String
){
    constructor(): this("", "")
}
