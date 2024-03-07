package com.luyao.wanandroid.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.luyao.mvvm.core.base.BaseVMActivity
import com.luyao.mvvm.core.base.BaseVMsActivity
import luyao.wanandroid.R
import luyao.wanandroid.databinding.ActivityShareBinding
import luyao.wanandroid.databinding.ActivityTestKotlinRetrofitDemoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestKotlinRetrofitDemoAct : BaseVMsActivity<ActivityTestKotlinRetrofitDemoBinding>() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test_kotlin_retrofit_demo)
//    }

    private  val  mViewModel by viewModel<TestKotlinRetrofitDemoViewModel>()
    override val bindingInflater: (LayoutInflater) -> ActivityTestKotlinRetrofitDemoBinding
        get() =  ActivityTestKotlinRetrofitDemoBinding::inflate

    override fun initView() {
        // TODO: 做一些处理事情 
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}