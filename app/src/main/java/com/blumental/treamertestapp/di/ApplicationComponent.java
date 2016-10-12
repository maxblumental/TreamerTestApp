package com.blumental.treamertestapp.di;

import com.blumental.treamertestapp.presenter.UserListPresenter;

import dagger.Component;

@Component(modules = {PresenterModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    UserListPresenter userListPresenter();
}
