package luyao.wanandroid.model.repository

import luyao.mvvm.core.Result
import luyao.wanandroid.model.api.BaseRepository
import luyao.wanandroid.model.api.TestRetrofitClient
import luyao.wanandroid.model.bean.VersionBean

/**
 * Created by luyao
 * on 2019/10/15 16:31
 */
class TestRetorfitRepository : BaseRepository() {


    suspend fun shareArticle(title: Int, url: String): Result<VersionBean> {
        return safeApiCall(call = { requestShareArticle(title) }, errorMessage = "分享失败")
    }


    private suspend fun requestShareArticle(title: Int): Result<VersionBean> =
        executeResponse2(TestRetrofitClient.service.requestGetNewVersion(title))
}