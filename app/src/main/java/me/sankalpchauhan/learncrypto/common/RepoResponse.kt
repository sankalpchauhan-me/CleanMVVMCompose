package me.sankalpchauhan.learncrypto.common

sealed class RepoResponse<T>(val data:T? = null, val message:String? = null) {
    class Success<T> (data:T):RepoResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : RepoResponse<T>(data,message)
    class Loading<T>(data: T? = null) : RepoResponse<T>(data)
}