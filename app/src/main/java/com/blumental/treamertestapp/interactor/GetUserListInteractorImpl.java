package com.blumental.treamertestapp.interactor;

import com.blumental.treamertestapp.model.User;
import com.blumental.treamertestapp.repository.TreamerService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetUserListInteractorImpl implements GetUserListInteractor {

    private TreamerService treamerService;

    @Inject
    public GetUserListInteractorImpl(TreamerService treamerService) {
        this.treamerService = treamerService;
    }

    @Override
    public Observable<List<User>> getUserList() {
        return treamerService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
