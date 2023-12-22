package ru.xyecos.bd

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.xyecos.domain.*


object BDLoader {
    val JSON: MediaType = "application/json".toMediaType()

    val client: OkHttpClient = OkHttpClient().newBuilder().apply {
        this.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.build()

    val gson = Gson()

    fun loadStationsList() : List<Station> {
        println("Loading StationsList...")

        val listType = object : TypeToken<List<Station>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/stationsList")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<Station>>(response.body?.string(), listType)

        println("StationsList loaded")
        return data
    }

    fun loadStationsData(): List<StationData> {
        val listType = object : TypeToken<List<StationData>>() {}.type

        println("Loading StationsData...")
        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/stationsData")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<StationData>>(response.body?.string(), listType)

        println("StationsData loaded")
        return data
    }

    fun loadWagonTypeList(): WagonTypeList {
        println("Loading WagonTypeList...")

        val listType = object : TypeToken<List<String>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/wagonTypeList")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<String>>(response.body?.string(), listType)

        println("WagonTypeList loaded")
        return WagonTypeList(data)
    }

    fun loadOwnersList(): OwnersList {
        println("Loading OwnersList...")

        val listType = object : TypeToken<List<String>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/ownersList")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<String>>(response.body?.string(), listType)

        println("OwnersList loaded")
        return OwnersList(data)
    }

    fun loadOperationsTypesNorms(): List<OperationsTypesNorms> {
        println("Loading OperationsTypesNorms...")

        val listType = object : TypeToken<List<OperationsTypesNorms>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/operationsTypesNorms")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<OperationsTypesNorms>>(response.body?.string(), listType)

        println("OperationsTypesNorms loaded")
        return data
    }

    fun loadOperationTypes(): List<OperationsTypes> {
        println("Loading OperationTypes...")

        val listType = object : TypeToken<List<OperationsTypes>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/operationsTypes")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<OperationsTypes>>(response.body?.string(), listType)

        println("OperationTypes loaded")
        return data
    }

    fun loadOperationsList() : List<OperationsList> {
        println("Loading OperationsList...")

        val listType = object : TypeToken<List<OperationsList>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/operationsList")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<OperationsList>>(response.body?.string(), listType)

        println("OperationsList loaded")
        return data
    }

    fun loadOperationReasonsList(): List<OperationReasonsList> {
        println("Loading OperationReasonsList...")

        val listType = object : TypeToken<List<OperationReasonsList>>() {}.type

        val request = okhttp3.Request.Builder()
            .url("http://localhost:4000/operationReasonsList")
            .build()
        val response = client.newCall(request).execute()

        println(response.body?.string())

        val data = gson.fromJson<List<OperationReasonsList>>(response.body?.string(), listType)

        println("OperationReasonsList loaded")
        return data
    }
}