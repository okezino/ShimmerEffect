package com.example.shimmereffect.model

data class Resources<out  T>(val status : Status, val message : String?, val data : T? ){

    companion object{
        fun <T>loading(message: String?):Resources<T> {
            return Resources(Status.LOADING, message, null)
        }
        fun <T>success(data : T?): Resources<T>{
            return Resources(Status.SUCCESS, Status.SUCCESS.name , data)
        }

        fun <T>failure(message : String, data : T?) : Resources<T>{
            return Resources(Status.FAILURE, message, null)
        }
    }
}

enum class Status{
    LOADING,
    SUCCESS,
    FAILURE
}