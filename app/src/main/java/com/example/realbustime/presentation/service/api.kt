package com.example.realbustime.presentation.service

import android.content.Context
import android.util.Log
import com.example.realbustime.presentation.models.BusIdAndStationId
import com.example.realbustime.presentation.models.BusRouteAll
import com.example.realbustime.presentation.models.BusRouteStationAll
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

    const val token = "JOQhI8yYWQKLyqI/1i81zpukyU1ToDcKCCmY5jU6lUXIVZ8EN/gphrIczTj6oyBXSMLbnj/L1PeHI8/quDgK7A==";
    fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        val sslSocketFactory = sslContext.socketFactory

        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier { hostname, session -> true }

        return builder
    }
    fun getJSONBusRouteAll(cList: MutableList<BusRouteAll?>, route_id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/arrive/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPIMethod = retrofit.create(retrofitAPI::class.java)

        val call: Call<BusRouteAll> = retrofitAPIMethod.getBusRoute(serviceKey = token, busRouteId = route_id, resultType = "json")

        call.enqueue(object : Callback<BusRouteAll?> {
            override fun onResponse(call: Call<BusRouteAll?>, response: Response<BusRouteAll?>) {
                Log.d("아아","${response.code()}")
                if(response.isSuccessful) {
                    var cp: BusRouteAll? = response.body()
                    Log.d("BusRoute","${cp}\nㅁㅁㅁ")
                    if(cList.isNotEmpty()) {
                        cList.clear()
                    }
                    cList.add(cp)

                } else if(response.code() == 429){

                } else {

                }

            }

            override fun onFailure(call: Call<BusRouteAll?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    fun getJSONBusRouteStation(cList: MutableList<BusRouteStationAll?>) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/arrive/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPIMethod = retrofit.create(retrofitAPI::class.java)

        val call: Call<BusRouteStationAll> = retrofitAPIMethod.getBusRouteStation(serviceKey = token, busRouteId = "100100008", stId = "107000095", ord = "2",resultType = "json")

        call.enqueue(object : Callback<BusRouteStationAll?> {
            override fun onResponse(call: Call<BusRouteStationAll?>, response: Response<BusRouteStationAll?>) {
                Log.d("아아","${response.code()}")
                if(response.isSuccessful) {
                    var cp: BusRouteStationAll? = response.body()
                    Log.d("BusRoute","${cp}\nㅁㅁㅁ")
                    if(cList.isNotEmpty()) {
                        cList.clear()
                    }
                    cList.add(cp)

                } else if(response.code() == 429){

                } else {

                }

            }

            override fun onFailure(call: Call<BusRouteStationAll?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    fun getJSONBusIdAndStationId(cList: MutableList<BusIdAndStationId?>) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.246.158.64:5050")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPIMethod = retrofit.create(retrofitAPI::class.java)

        val call: Call<BusIdAndStationId> = retrofitAPIMethod.getBusIdAndStationId()

        call.enqueue(object : Callback<BusIdAndStationId?> {
            override fun onResponse(call: Call<BusIdAndStationId?>, response: Response<BusIdAndStationId?>) {
                Log.d("아아","${response.code()}")
                if(response.isSuccessful) {
                    var cp: BusIdAndStationId? = response.body()
                    Log.d("BusRoute","${cp}\nㅁㅁㅁ")
                    if(cList.isNotEmpty()) {
                        cList.clear()
                    }
                    cList.add(cp)

                } else if(response.code() == 429){

                } else {

                }

            }

            override fun onFailure(call: Call<BusIdAndStationId?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }