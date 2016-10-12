package com.blumental.treamertestapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blumental.treamertestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListFragment extends Fragment {

    @BindView(R.id.userList)
    RecyclerView userList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);

        userList.setLayoutManager(new LinearLayoutManager(getContext()));
        userList.setAdapter(new UserListAdapter());

        return view;
    }
}
