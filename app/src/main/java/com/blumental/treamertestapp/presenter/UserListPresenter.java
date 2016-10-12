package com.blumental.treamertestapp.presenter;

import com.blumental.treamertestapp.view.UserListView;

public interface UserListPresenter {

    void attach(UserListView view);

    void onResume();

    void onPause();

    void detach();
}
