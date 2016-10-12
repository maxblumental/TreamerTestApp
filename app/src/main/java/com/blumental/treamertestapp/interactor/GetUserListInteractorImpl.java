package com.blumental.treamertestapp.interactor;

import com.blumental.treamertestapp.model.User;
import com.blumental.treamertestapp.repository.TreamerService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
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
                .observeOn(Schedulers.computation())
                .flatMap(new Func1<List<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(List<User> users) {
                        return Observable.from(users);
                    }
                })
                .toSortedList(new Func2<User, User, Integer>() {
                    @Override
                    public Integer call(User user, User user2) {
                        String name1 = user.getName();
                        String name2 = user2.getName();
                        return name1.compareTo(name2);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
