package org.example.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object MongoFactory {

    private val client = MongoClient.create("mongodb://localhost:27017")

    val database: MongoDatabase =
        client.getDatabase("hotel_db")
}