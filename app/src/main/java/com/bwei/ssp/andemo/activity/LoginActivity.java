package com.bwei.ssp.andemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.ssp.andemo.R;
import com.bwei.ssp.andemo.avtivityutils.BaseMainActivity;
import com.bwei.ssp.andemo.bean.Login_Bean;
import com.bwei.ssp.andemo.presenter.Login_presenter;
import com.bwei.ssp.andemo.view.Login_view;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseMainActivity implements Login_view{
    @InjectView(R.id.back)
    ImageView back;
    @InjectView(R.id.zhece)
    TextView zhece;
    @InjectView(R.id.phone)
    EditText phone;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.forget_password)
    TextView forgetPassword;
    @InjectView(R.id.Tourist_login)
    TextView TouristLogin;
    private Login_presenter login_presenter;

    @Override
    protected int getRootView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
        login_presenter = new Login_presenter(this);
    }
    @OnClick({R.id.back, R.id.zhece, R.id.login, R.id.forget_password, R.id.Tourist_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.zhece:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.login:
                phone.setText("18236019866");
                password.setText("123654");
                login_presenter.getLoginJs(phone.getText().toString(),password.getText().toString());
                break;
            case R.id.forget_password:
                startActivity(new Intent(LoginActivity.this,LookforpasswordActivity.class));
                break;
            case R.id.Tourist_login:
                break;
        }
    }
    @Override
    public void getYs(Login_Bean loginBean) {
        Log.e("Login", loginBean.getMsg());
        startActivity(new Intent(LoginActivity.this,Main2Activity.class));

    }
    @Override
    public void getNo(Throwable throwable) {
        Log.e("Login", throwable.getMessage());
    }


}
