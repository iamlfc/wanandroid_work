package com.luyao.wanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.luyao.mvvm.core.base.BaseActivity
import com.luyao.mvvm.core.base.BaseVMsActivity
import com.luyao.wanandroid.R
import com.luyao.wanandroid.databinding.ActivityMainBinding

/**
 * Created by luyao
 * on 2019/12/26 15:24
 */
class MainActivity : BaseVMsActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    companion object {
        private const val AUDIO_RECORD_REQUEST_CODE = 1081

        const val INDEX_HOME = 0
        const val INDEX_DYNAMIC = 1
        const val INDEX_MESSAGE = 2
        const val INDEX_MINE = 3
    }
    private val fragments = mapOf<Int, Fragment>(
        INDEX_HOME to FirstFragment(),
        INDEX_DYNAMIC to DongtaiFragment(),
        INDEX_MESSAGE to MsgFragment(),
        INDEX_MINE to MeFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }
    override fun startObserve() {
    }
    override fun initView() {
    }

    override fun initData() {
    }


}