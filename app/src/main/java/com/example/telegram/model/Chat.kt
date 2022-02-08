package com.example.telegram.model

data class Chat(var profile:Int, var fullname: String? = null, var message:String? = null, var first: Boolean=false){
}