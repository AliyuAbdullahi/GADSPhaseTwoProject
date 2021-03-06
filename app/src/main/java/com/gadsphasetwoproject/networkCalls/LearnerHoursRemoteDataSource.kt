package com.gadsphasetwoproject.networkCalls

import javax.inject.Inject

class LearnerHoursRemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) :
    BaseDataSource() {
    suspend fun getLearnersHours() = getResult {
        apiInterface.getLearnerHours()
    }

}