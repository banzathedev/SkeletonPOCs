package com.grpitsolutions.skeletonpoc.di

import com.grpitsolutions.skeletonpoc.initial.InitialViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::InitialViewModel)

}