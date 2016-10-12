package com.blumental.treamertestapp.di;

import com.blumental.treamertestapp.presenter.UserListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    UserListPresenterImpl getUserListPresenter() {
        return new UserListPresenterImpl();
    }
}
