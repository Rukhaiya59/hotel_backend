package org.example.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object MongoFactory {

    private val client = MongoClient.create(
        "mongodb+srv://hotel_user:1234@cluster0.abcd.mongodb.net/hotel_db?retryWrites=true&w=majority"
    )

    val database: MongoDatabase =
        client.getDatabase("hotel_db")
}