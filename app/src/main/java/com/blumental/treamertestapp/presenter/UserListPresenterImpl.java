package com.blumental.treamertestapp.presenter;

import com.blumental.treamertestapp.interactor.GetUserListInteractor;
import com.blumental.treamertestapp.model.User;
import com.blumental.treamertestapp.view.UserListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

public class UserListPresenterImpl implements UserListPresenter {

    private UserListView view;

    private GetUserListInteractor interactor;

    private Subscription interactorSubscription;

    @Inject
    public UserListPresenterImpl(GetUserListInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attach(UserListView view) {
        this.view = view;
    }

    @Override
    public void onResume() {
        view.showProgress();
        interactorSubscription = interactor.getUserList()
                .subscribe(new Action1<List<User>>() {
                    @Override
                    public void call(List<User> users) {
                        view.showUsers(users);
                        view.hideProgess();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.showError(throwable.getMessage());
                        view.hideProgess();
                    }
                });
    }

    @Override
    public void onPause() {
        interactorSubscription.unsubscribe();
    }

    @Override
    public void detach() {
        view = null;
    }
}
