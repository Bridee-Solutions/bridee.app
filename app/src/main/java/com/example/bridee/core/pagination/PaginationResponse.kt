package com.example.bridee.core.pagination

data class PaginationResponse<T>(
    val content: MutableList<T>,
    val totalElements: Int,
    val totalPages: Int,
    val size: Int,
    val number: Int
)