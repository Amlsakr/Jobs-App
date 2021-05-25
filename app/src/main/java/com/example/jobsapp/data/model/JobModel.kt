package com.example.jobsapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JobModel(
	@field:SerializedName("company_logo")
	val companyLogo: String? = null,

	@field:SerializedName("how_to_apply")
	val howToApply: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("company")
	val company: String? = null,

	@field:SerializedName("company_url")
	val companyUrl: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable
//{
//	constructor(parcel: Parcel) : this(
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString(),
//		parcel.readString()
//	) {
//	}
//
//	override fun describeContents(): Int {
//		TODO("Not yet implemented")
//	}
//
//	override fun writeToParcel(parcel: Parcel?, flags: Int) {
//		parcel?.writeString(companyLogo)
//		parcel?.writeString(howToApply)
//		parcel?.writeString(createdAt)
//		parcel?.writeString(description)
//		parcel?.writeString(company)
//		parcel?.writeString(companyUrl)
//		parcel?.writeString(location)
//		parcel?.writeString(id)
//		parcel?.writeString(type)
//		parcel?.writeString(title)
//		parcel?.writeString(url)
//	}
//
//	companion object CREATOR : Parcelable.Creator<JobModel> {
//		override fun createFromParcel(parcel: Parcel): JobModel {
//			return JobModel(parcel)
//		}
//
//		override fun newArray(size: Int): Array<JobModel?> {
//			return arrayOfNulls(size)
//		}
//	}
//}
