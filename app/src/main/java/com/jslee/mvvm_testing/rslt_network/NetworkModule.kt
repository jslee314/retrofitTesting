package com.jslee.mvvm_testing.rslt_network
import androidx.lifecycle.ViewModel
import com.jslee.mvvm_testing.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NetworkModule {
    @Binds
    @IntoMap
    @ViewModelKey(NetworkViewModel::class)
    abstract fun bindViewModel(viewmodel: NetworkViewModel): ViewModel
}
