package com.example.nextapp.model

data class vehicalModel(
    val ErrorException: Any,
    val IsSuccess: Boolean,
    val Message: String,
    val ResponseCode: Int,
    val ResponseDetail: List<ResponseDetail>
)