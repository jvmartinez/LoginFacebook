package com.jvmartinez.loginfacebook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.Profile;
import com.jvmartinez.loginfacebook.Fragment.ProfileFragment;
import com.jvmartinez.loginfacebook.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProfileFragment profileFragment = ProfileFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.includeFramentProfile, profileFragment).commit();
    }


}
