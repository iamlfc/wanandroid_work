package com.luyao.wanandroid.test

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.luyao.mvvm.core.Result
import com.luyao.mvvm.core.base.BaseViewModel
import com.luyao.wanandroid.model.repository.TestRetorfitRepository

/**
 * Created by luyao
 * on 2019/10/15 15:21
 */
class TestKotlinRetrofitDemoViewModel(private val repository: TestRetorfitRepository) : BaseViewModel() {

    val title = ObservableField<String>("")
    val url = ObservableField<String>("")

    private val _uiState = MutableLiveData<ShareUiModel>()
    val uiState: LiveData<ShareUiModel>
        get() = _uiState


    val verifyInput: (String) -> Unit = { shareDataChanged() }

    private fun shareDataChanged() {
        enableShare((title.get()?.isNotBlank() ?: false) && (url.get()?.isNotBlank() ?:false))
    }

    fun shareArticle() {
        viewModelScope.launch(Dispatchers.Default) {

            withContext(Dispatchers.Main){ emitUiState(showProgress = true)}

            val result = repository.shareArticle(1, url.get()?:"")


            withContext(Dispatchers.Main){
                if (result is Result.Success){
                    emitUiState(showProgress = false,showSuccess = result.data,enableShareButton = true)
                }else if (result is Result.Error){
                    emitUiState(showProgress = false,showError = result.exception.message,enableShareButton = true)
                }
            }
        }
    }

    private fun enableShare(enable: Boolean) {
        emitUiState(enableShareButton = enable)
    }

    private fun emitUiState(
            showProgress: Boolean = false,
            showError: String? = null,
            showSuccess: String? = null,
            enableShareButton: Boolean = false
    ) {
        val uiModel = ShareUiModel(showProgress, showSuccess, showError, enableShareButton)
        _uiState.value = uiModel
    }
}


data class ShareUiModel(
        val showProgress: Boolean,
        val showSuccess: String?,
        val showError: String?,
        val enableShareButton: Boolean
)