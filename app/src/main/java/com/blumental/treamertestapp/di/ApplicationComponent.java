package com.blumental.treamertestapp.di;

import com.blumental.treamertestapp.presenter.UserListPresenterImpl;

import dagger.Component;

@Component(modules = {PresenterModule.class})
public interface ApplicationComponent {
    UserListPresenterImpl userListPresenter();
}
