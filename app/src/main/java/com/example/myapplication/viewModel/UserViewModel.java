package com.example.myapplication.viewModel;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.User;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> username2 = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private User user;
    private Context context;

    public UserViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public void onLoginClick() {
        user.setUsername(username2.getValue());
        user.setPassword(password.getValue());

        if (!user.isValidUsername()){
            Toast.makeText(context, "Invalid Username", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidPassword()) {
            Toast.makeText(context, "Password Should be Minimum 6 Characters", Toast.LENGTH_SHORT).show();
        } else if (user.isValidCredential()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();

                }
            }, 350);
        } else {
            Toast.makeText(context, "Invalid Credential", Toast.LENGTH_SHORT).show();
        }
    }
}
