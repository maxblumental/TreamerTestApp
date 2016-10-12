package com.blumental.treamertestapp.di;

import com.blumental.treamertestapp.interactor.GetUserListInteractorImpl;
import com.blumental.treamertestapp.presenter.UserListPresenter;
import com.blumental.treamertestapp.presenter.UserListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    UserListPresenter getUserListPresenter(GetUserListInteractorImpl interactor) {
        return new UserListPresenterImpl(interactor);
    }
}
