package com.blumental.treamertestapp.di;

import com.blumental.treamertestapp.repository.TreamerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {

    @Provides
    TreamerService getTreamerService() {

        return new Retrofit.Builder()
                .baseUrl(TreamerService.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TreamerService.class);
    }
}
