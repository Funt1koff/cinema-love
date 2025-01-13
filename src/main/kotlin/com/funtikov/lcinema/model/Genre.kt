package com.funtikov.lcinema.model

abstract class Genre {

    abstract var title: String
    abstract var code: Int

    abstract var metadata: Map<String, String>
}