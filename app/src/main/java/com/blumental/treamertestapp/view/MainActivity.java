package com.blumental.treamertestapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blumental.treamertestapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToUserListFragment();
    }

    private void switchToUserListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, new UserListFragment())
                .commit();
    }
}
