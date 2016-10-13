package com.blumental.treamertestapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.blumental.treamertestapp.R;
import com.blumental.treamertestapp.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToUserListFragment();
    }

    private void switchToUserListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String tag = UserListFragment.class.getSimpleName();

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, new UserListFragment(), tag)
                .commit();
    }

    public void switchToUserDetails(User user) {
        UserDetailsFragment fragment = new UserDetailsFragment();

        Bundle args = new Bundle();
        args.putParcelable("user", user);
        fragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
