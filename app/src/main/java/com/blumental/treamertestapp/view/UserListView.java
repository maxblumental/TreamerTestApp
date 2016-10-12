package com.blumental.treamertestapp.view;

import com.blumental.treamertestapp.model.User;

import java.util.List;

public interface UserListView {
    void showUsers(List<User> users);

    void showError(String errorMessage);
}
