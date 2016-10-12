package com.blumental.treamertestapp.interactor;

import com.blumental.treamertestapp.model.User;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

public class GetUserListInteractorImpl implements GetUserListInteractor {

    @Inject
    public GetUserListInteractorImpl() {
    }

    @Override
    public Observable<List<User>> getUserList() {
        return Observable.create(new Observable.OnSubscribe<List<User>>() {
            @Override
            public void call(Subscriber<? super List<User>> subscriber) {
                subscriber.onCompleted();
            }
        });
    }
}
