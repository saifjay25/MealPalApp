package com.mycode.mealplanapp.ui

class Resource<T>(status: Status, data: T?, message: String) {

    val status: Status

    val data: T?

    val message: String?

    init {
        this.status = status
        this.data = data
        this.message = message
    }

    companion object {
        fun <T> success(data: T, message: String): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(data: T?, msg: String): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null!!)
        }
    }

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    override fun equals(obj: Any?): Boolean {
        if (obj!!.javaClass != javaClass || obj.javaClass != Resource::class.java) {
            return false
        }

        val resource = obj as Resource<T>?

        if (resource!!.status != this.status) {
            return false
        }

        if (this.data != null) {
            if (resource.data !== this.data) {
                return false
            }
        }

        if (resource.message != null) {
            if (this.message == null) {
                return false
            }
            if (resource.message != this.message) {
                return false
            }
        }

        return true
    }
}