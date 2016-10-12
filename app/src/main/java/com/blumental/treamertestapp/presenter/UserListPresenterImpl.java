package com.blumental.treamertestapp.presenter;

import com.blumental.treamertestapp.view.UserListView;

public class UserListPresenterImpl implements UserListPresenter {

    private UserListView view;

    @Override
    public void attach(UserListView view) {
        this.view = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void detach() {
        view = null;
    }
}
