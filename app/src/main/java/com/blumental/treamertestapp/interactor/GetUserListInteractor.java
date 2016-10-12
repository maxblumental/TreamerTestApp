package com.blumental.treamertestapp.interactor;

import com.blumental.treamertestapp.model.User;

import java.util.List;

import rx.Observable;

public interface GetUserListInteractor {
    Observable<List<User>> getUserList();
}
