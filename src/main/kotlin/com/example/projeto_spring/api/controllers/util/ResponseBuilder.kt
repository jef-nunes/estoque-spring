package com.example.projeto_spring.api.controllers.util

import com.example.projeto_spring.models.ResponseModel
import java.time.LocalDateTime


object ResponseBuilder {

    fun <T> buildSuccessResponse(data: MutableList<T> = mutableListOf()): ResponseModel<T> {
        return ResponseModel(ResponseModelStatus.SUCCESS, data, LocalDateTime.now(), mutableListOf())
    }

    fun buildFailureResponse(errors: MutableList<String?>?): ResponseModel<Any> {
        return ResponseModel(ResponseModelStatus.FAILURE, mutableListOf(), LocalDateTime.now(), errors)
    }

    private object ResponseModelStatus {
        const val SUCCESS: String = "success"
        const val FAILURE: String = "failure"
    }

}