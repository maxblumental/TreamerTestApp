package com.blumental.treamertestapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blumental.treamertestapp.App;
import com.blumental.treamertestapp.R;
import com.blumental.treamertestapp.model.User;
import com.blumental.treamertestapp.presenter.UserListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListFragment extends Fragment implements UserListView {

    private UserListPresenter presenter;

    private UserListAdapter adapter;

    @BindView(R.id.userList)
    RecyclerView userList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = App.component.userListPresenter();
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);

        initializeUserList();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detach();
    }

    @Override
    public void showUsers(List<User> users) {
        adapter.setUsers(users);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    private void initializeUserList() {
        userList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UserListAdapter();
        userList.setAdapter(adapter);
    }
}
