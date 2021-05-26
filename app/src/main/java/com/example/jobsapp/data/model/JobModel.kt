package com.example.jobsapp.data.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "job_table")
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

	@PrimaryKey
	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable
