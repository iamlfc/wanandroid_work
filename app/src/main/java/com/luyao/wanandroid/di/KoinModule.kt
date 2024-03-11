package com.luyao.wanandroid.di

import com.luyao.wanandroid.CoroutinesDispatcherProvider
import com.luyao.wanandroid.model.api.WanRetrofitClient
import com.luyao.wanandroid.model.api.WanService
import com.luyao.wanandroid.model.repository.*
import com.luyao.wanandroid.ui.login.LoginViewModel
import com.luyao.wanandroid.ui.navigation.NavigationViewModel
import com.luyao.wanandroid.ui.project.ProjectViewModel
import com.luyao.wanandroid.ui.search.SearchViewModel
import com.luyao.wanandroid.ui.share.ShareViewModel
import com.luyao.wanandroid.ui.square.ArticleViewModel
import com.luyao.wanandroid.ui.system.SystemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by luyao
 * on 2019/11/15 15:44
 */

val viewModelModule = module {
    viewModel { LoginViewModel(get(),get()) }
    viewModel { ArticleViewModel(get(), get(), get(), get(), get()) }
    viewModel { SystemViewModel(get(), get()) }
    viewModel { NavigationViewModel(get()) }
    viewModel { ProjectViewModel(get()) }
    viewModel { SearchViewModel(get(), get()) }
    viewModel { ShareViewModel(get()) }
}

val repositoryModule = module {
    single { WanRetrofitClient.getService(WanService::class.java, WanService.BASE_URL) }
    single { com.luyao.wanandroid.CoroutinesDispatcherProvider() }
    single { LoginRepository(get()) }
    single { SquareRepository() }
    single { HomeRepository() }
    single { ProjectRepository() }
    single { CollectRepository() }
    single { SystemRepository() }
    single { NavigationRepository() }
    single { SearchRepository() }
    single { ShareRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)