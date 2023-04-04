package com.example.realbustime.presentation.models

import com.google.gson.annotations.SerializedName

data class BusRouteAll(
    @SerializedName("comMsgHeader") val comMsgHeader: Map<String, *>?,
    @SerializedName("msgHeader") val msgHeader: Map<String, *>?,
    @SerializedName("msgBody") val msgBody: Map<String, List<BusRoute?>?>
)

data class BusRoute(
    @SerializedName("stId") val stId: String?,
    @SerializedName("stNm") val stNm: String?,
    @SerializedName("arsId") val arsId: String?,
    @SerializedName("busRouteId") val busRouteId: String?,
    @SerializedName("rtNm") val rtNm: String?,
    @SerializedName("busRouteAbrv") val busRouteAbrv: String?,
    @SerializedName("firstTm") val firstTm: String?,
    @SerializedName("lastTm") val lastTm: String?,
    @SerializedName("term") val term: String?,
    @SerializedName("routeType") val routeType: String?,
    @SerializedName("nextBus") val nextBus: String?,
    @SerializedName("staOrd") val staOrd: String?,
    @SerializedName("dir") val dir: String?,
    @SerializedName("mkTm") val mkTm: String?,
    @SerializedName("vehId1") val vehId1: String?,
    @SerializedName("plainNo1") val plainNo1: String?,
    @SerializedName("sectOrd1") val sectOrd1: String?,
    @SerializedName("stationNm1") val stationNm1: String?,
    @SerializedName("traTime1") val traTime1: String?,
    @SerializedName("traSpd1") val traSpd1: String?,
    @SerializedName("isArrive1") val isArrive1: String?,
    @SerializedName("repTm1") val repTm1: String?,
    @SerializedName("isLast1") val isLast1: String?,
    @SerializedName("busType1") val busType1: String?,
    @SerializedName("avgCf1") val avgCf1: String?,
    @SerializedName("expCf1") val expCf1: String?,
    @SerializedName("kalCf1") val kalCf1: String?,
    @SerializedName("neuCf1") val neuCf1: String?,
    @SerializedName("exps1") val exps1: String?,
    @SerializedName("kals1") val kals1: String?,
    @SerializedName("neus1") val neus1: String?,
    @SerializedName("rerdie_Div1") val rerdie_Div1: String?,
    @SerializedName("reride_Num1") val reride_Num1: String?,
    @SerializedName("brerde_Div1") val brerde_Div1: String?,
    @SerializedName("brdrde_Num1") val brdrde_Num1: String?,
    @SerializedName("full1") val full1: String?,
    @SerializedName("nstnId1") val nstnId1: String?,
    @SerializedName("nstnOrd1") val nstnOrd1: String?,
    @SerializedName("nstnSpd1") val nstnSpd1: String?,
    @SerializedName("nstnSec1") val nstnSec1: String?,
    @SerializedName("nmainStnid1") val nmainStnid1: String?,
    @SerializedName("nmainOrd1") val nmainOrd1: String?,
    @SerializedName("nmainSec1") val nmainSec1: String?,
    @SerializedName("nmain2Stnid1") val nmain2Stnid1: String?,
    @SerializedName("nmain2Ord1") val nmain2Ord1: String?,
    @SerializedName("namin2Sec1") val namin2Sec1: String?,
    @SerializedName("nmain3Stnid1") val nmain3Stnid1: String?,
    @SerializedName("nmain3Ord1") val nmain3Ord1: String?,
    @SerializedName("nmain3Sec1") val nmain3Sec1: String?,
    @SerializedName("goal1") val goal1: String?,
    @SerializedName("vehId2") val vehId2: String?,
    @SerializedName("plainNo2") val plainNo2: String?,
    @SerializedName("sectOrd2") val sectOrd2: String?,
    @SerializedName("stationNm2") val stationNm2: String?,
    @SerializedName("traTime2") val traTime2: String?,
    @SerializedName("traSpd2") val traSpd2: String?,
    @SerializedName("isArrive2") val isArrive2: String?,
    @SerializedName("repTm2") val repTm2: String?,
    @SerializedName("isLast2") val isLast2: String?,
    @SerializedName("busType2") val busType2: String?,
    @SerializedName("avgCf2") val avgCf2: String?,
    @SerializedName("expCf2") val expCf2: String?,
    @SerializedName("kalCf2") val kalCf2: String?,
    @SerializedName("neuCf2") val neuCf2: String?,
    @SerializedName("exps2") val exps2: String?,
    @SerializedName("kals2") val kals2: String?,
    @SerializedName("neus2") val neus2: String?,
    @SerializedName("rerdie_Div2") val rerdie_Div2: String?,
    @SerializedName("reride_Num2") val reride_Num2: String?,
    @SerializedName("brerde_Div2") val brerde_Div2: String?,
    @SerializedName("brdrde_Num2") val brdrde_Num2: String?,
    @SerializedName("full2") val full2: String?,
    @SerializedName("nstnId2") val nstnId2: String?,
    @SerializedName("nstnOrd2") val nstnOrd2: String?,
    @SerializedName("nstnSpd2") val nstnSpd2: String?,
    @SerializedName("nstnSec2") val nstnSec2: String?,
    @SerializedName("nmainStnid2") val nmainStnid2: String?,
    @SerializedName("nmainOrd2") val nmainOrd2: String?,
    @SerializedName("nmainSec2") val nmainSec2: String?,
    @SerializedName("nmain2Stnid2") val nmain2Stnid2: String?,
    @SerializedName("nmain2Ord2") val nmain2Ord2: String?,
    @SerializedName("namin2Sec2") val namin2Sec2: String?,
    @SerializedName("nmain3Stnid2") val nmain3Stnid2: String?,
    @SerializedName("nmain3Ord2") val nmain3Ord2: String?,
    @SerializedName("nmain3Sec2") val nmain3Sec2: String?,
    @SerializedName("goal2") val goal2: String?,
    @SerializedName("arrmsg1") val arrmsg1: String?,
    @SerializedName("arrmsg2") val arrmsg2: String?,
    @SerializedName("deTourAt") val deTourAt: String?,
)

