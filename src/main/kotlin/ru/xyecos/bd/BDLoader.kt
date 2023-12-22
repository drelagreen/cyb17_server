package ru.xyecos.bd

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.xyecos.domain.*

fun main() {
    BDLoader.loadStationsData().apply {
        this.forEach {
            println(it)
            println(";")
        }
    }
}

object BDLoader {
    val client: OkHttpClient = OkHttpClient().newBuilder().apply {
        this.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.build()

    val gson = Gson()

    fun loadStationsList() : List<Station> {
        val listType = object : TypeToken<List<Station>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/stationsList")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<Station>>(response.body?.string(), listType)

        return data
    }

    fun loadStationsData(): List<StationData> {
        val listType = object : TypeToken<List<StationData>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/stationsData")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<StationData>>(response.body?.string(), listType)

        return data
    }

    fun loadWagonTypeList(): WagonTypeList {
        println("Loading WagonTypeList...")

        val listType = object : TypeToken<List<String>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/wagonTypeList")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<String>>(response.body?.string(), listType)

        return WagonTypeList(data)
    }

    fun loadOwnersList(): OwnersList {
        val listType = object : TypeToken<List<String>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/ownersList")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<String>>(response.body?.string(), listType)

        return OwnersList(data)
    }

    fun loadOperationsTypesNorms(): List<OperationsTypesNorms> {
        println("Loading OperationsTypesNorms...")

        val listType = object : TypeToken<List<OperationsTypesNorms>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/operationsTypesNorms")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<OperationsTypesNorms>>(response.body?.string(), listType)

        return data
    }

    fun loadOperationTypes(): List<OperationsTypes> {
        val listType = object : TypeToken<List<OperationsTypes>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/operationsTypes")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<OperationsTypes>>(response.body?.string(), listType)

        return data
    }

    fun loadOperationsList() : List<OperationsList> {
        val listType = object : TypeToken<List<OperationsList>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/operationsList")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<OperationsList>>(response.body?.string(), listType)

        return data
    }

    fun loadOperationReasonsList(): List<OperationReasonsList> {
        val listType = object : TypeToken<List<OperationReasonsList>>() {}.type

        val request = okhttp3.Request.Builder()
            .get()
            .addHeader("content-type", "application/json;charset=UTF-8")
            .url("http://localhost:4000/operationReasonsList")
            .build()
        val response = client.newCall(request).execute()

        val data = gson.fromJson<List<OperationReasonsList>>(response.body?.string(), listType)

        return data
    }
}