package com.luyao.wanandroid

import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV
import com.luyao.mvvm.core.util.Timer
import com.luyao.wanandroid.di.appModule
import com.luyao.wanandroid.model.bean.User
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 * Created by luyao
 * on 2018/3/13 13:35
 */
class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
        lateinit var CURRENT_USER: User
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Timer.start(com.luyao.wanandroid.APP_START)
    }

    override fun onCreate() {
        super.onCreate()
        com.luyao.wanandroid.App.Companion.CONTEXT = applicationContext
        MMKV.initialize(this)
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}