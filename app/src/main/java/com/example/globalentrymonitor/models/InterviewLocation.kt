package com.example.globalentrymonitor.models

import com.google.gson.annotations.SerializedName

data class InterviewLocation(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("shortName") val shortName: String,
    @SerializedName("locationType") val locationType: String,
    @SerializedName("locationCode") val locationCode: String,
    @SerializedName("address") val address: String,
    @SerializedName("addressAdditional") val addressAdditional: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("postalCode") val postalCode: String,
    @SerializedName("countryCode") val countryCode: String,
    @SerializedName("tzData") val tzData: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("phoneAreaCode") val phoneAreaCode: String,
    @SerializedName("phoneCountryCode") val phoneCountryCode: String,
    @SerializedName("phoneExtension") val phoneExtension: String,
    @SerializedName("phoneAltNumber") val phoneAltNumber: String,
    @SerializedName("phoneAltAreaCode") val phoneAltAreaCode: String,
    @SerializedName("phoneAltCountryCode") val phoneAltCountryCode: String,
    @SerializedName("phoneAltExtension") val phoneAltExtension: String,
    @SerializedName("faxNumber") val faxNumber: String,
    @SerializedName("faxAreaCode") val faxAreaCode: String,
    @SerializedName("faxCountryCode") val faxCountryCode: String,
    @SerializedName("faxExtension") val faxExtension: String,
    @SerializedName("effectiveDate") val effectiveDate: String,
    @SerializedName("temporary") val temporary: Boolean,
    @SerializedName("inviteOnly") val inviteOnly: Boolean,
    @SerializedName("operational") val operational: Boolean,
    @SerializedName("directions") val directions: String,
    @SerializedName("notes") val notes: String,
    @SerializedName("mapFileName") val mapFileName: String,
    @SerializedName("accessCode") val accessCode: String,
    @SerializedName("lastUpdatedBy") val lastUpdatedBy: String,
    @SerializedName("lastUpdatedDate") val lastUpdatedDate: String,
    @SerializedName("createdDate") val createdDate: String,
    @SerializedName("services") val services: List<InterviewLocationService>
)