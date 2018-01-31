package com.jvmartinez.loginfacebook;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnClose;
    private TextView lblName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnClose = findViewById(R.id.btnClose);
        this.lblName = findViewById(R.id.lblName);
        this.btnClose.setOnClickListener(this);
        if(AccessToken.getCurrentAccessToken() == null){
            goActivitys();
        }else{
            this.profile();
        }
    }
    public void goActivitys(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClose:
                LoginManager.getInstance().logOut();
                goActivitys();
                break;
        }
    }

    public void profile(){
        this.lblName.setText(Profile.getCurrentProfile().getName());
    }
}
