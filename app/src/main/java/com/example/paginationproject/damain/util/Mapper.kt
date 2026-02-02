package com.example.paginationproject.damain.util

interface Mapper <M,D> {
    fun modelToDomain(domain: D): M
    fun domainToModel(model: M): D
}