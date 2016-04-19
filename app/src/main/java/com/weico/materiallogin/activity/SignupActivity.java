package com.weico.materiallogin.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.weico.materiallogin.R;
import com.weico.materiallogin.model.User;

import butterknife.ButterKnife;
import butterknife.Bind;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private User mUser;

    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        Bmob.initialize(this, "5b547ae828abedb5c90ecc1063d8839b");

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        //_signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        mUser = new User();
        mUser.setEmail(email);
        mUser.setUsername(name);
        mUser.setPassword(password);

        mUser.signUp(SignupActivity.this, new SaveListener() {
            @Override
            public void onSuccess() {
                progressDialog.cancel();
                final Snackbar snackbar = Snackbar.make(_loginLink, "创建成功", Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
            }

            @Override
            public void onFailure(int i, String s) {
                progressDialog.cancel();
                final Snackbar snackbar = Snackbar.make(_loginLink, "创建失败 " + s, Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
            }
        });
    }
}