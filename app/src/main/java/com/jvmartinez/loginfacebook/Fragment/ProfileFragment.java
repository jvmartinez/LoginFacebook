package com.jvmartinez.loginfacebook.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.jvmartinez.loginfacebook.Activity.LoginActivity;
import com.jvmartinez.loginfacebook.Model.ModelProfileFacebook;
import com.jvmartinez.loginfacebook.R;


/*
 * @autor: Juan Martinez
 * @date : 09/02/2018
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    private Button btnClose;
    private TextView lblName;
    private OnFragmentInteractionListener mListener;
    private ModelProfileFacebook profile;
    public ProfileFragment() {
        // Required empty public constructor

    }

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_phofile, container, false);
        this.btnClose = view.findViewById(R.id.btnClose);
        this.lblName = view.findViewById(R.id.lblName);
        this.btnClose.setOnClickListener(this);

        if(AccessToken.getCurrentAccessToken() == null){
            goActivitys();
        }else{
            new getProfile().execute();
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClose:
                Log.e("Log Info"," button close");
                LoginManager.getInstance().logOut();
                goActivitys();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void goActivitys(){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }

    private class getProfile extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            return null;
        }


        @Override
        protected void onPostExecute(String valor) {
            Profile profile = Profile.getCurrentProfile();
            if(profile != null){
                lblName.setText(profile.getName());
            }
        }
    }
}
