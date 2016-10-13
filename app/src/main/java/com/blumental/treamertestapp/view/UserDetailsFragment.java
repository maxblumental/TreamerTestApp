package com.blumental.treamertestapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blumental.treamertestapp.R;
import com.blumental.treamertestapp.model.Address;
import com.blumental.treamertestapp.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsFragment extends Fragment {

    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.phone)
    TextView phone;

    @BindView(R.id.website)
    TextView website;

    @BindView(R.id.street)
    TextView street;

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.zipcode)
    TextView zipcode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);
        ButterKnife.bind(this, view);
        initializeFields();
        return view;
    }

    private void initializeFields() {
        Bundle arguments = getArguments();
        User user = arguments.getParcelable("user");

        username.setText(user.getUsername());
        name.setText(user.getName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        website.setText(user.getWebsite());

        Address address = user.getAddress();

        street.setText(address.getStreet());
        city.setText(address.getCity());
        zipcode.setText(address.getZipcode());
    }
}
