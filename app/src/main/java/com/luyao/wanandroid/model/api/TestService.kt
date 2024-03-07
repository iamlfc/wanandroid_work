package com.luyao.wanandroid.model.api

import luyao.wanandroid.model.bean.*
import retrofit2.http.*


/**
 * Created by luyao
 * on 2018/3/13 14:33
 */
interface TestService {

    companion object {
        const val BASE_URL =  "http://testapi.quliaoba.cn/"

    }
    //获取最新版本号信息
    @GET("Platform/GetNewVersion?api-version=${1}")
    suspend fun requestGetNewVersion(@Query("sex") sex: Int): BaseResp<VersionBean>

}