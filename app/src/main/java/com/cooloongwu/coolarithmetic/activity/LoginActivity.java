package com.cooloongwu.coolarithmetic.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cooloongwu.coolarithmetic.R;
import com.cooloongwu.coolarithmetic.base.AppConfig;
import com.cooloongwu.coolarithmetic.base.BaseActivity;
import com.cooloongwu.coolarithmetic.utils.MD5Utils;
import com.cooloongwu.coolarithmetic.utils.StartActivityUtils;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView img_clear_phone;
    private ImageView img_clear_password;

    private EditText edit_phone;
    private EditText edit_password;

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    @Override
    protected void initViews() {
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_password = (EditText) findViewById(R.id.edit_password);

        img_clear_phone = (ImageView) findViewById(R.id.img_clear_phone);
        img_clear_password = (ImageView) findViewById(R.id.img_clear_password);
        ImageView img_eye_password = (ImageView) findViewById(R.id.img_eye_password);

        btn_login = (Button) findViewById(R.id.btn_login);

        TextView text_forget_password = (TextView) findViewById(R.id.text_forget_password);
        TextView text_register = (TextView) findViewById(R.id.text_register);

        edit_phone.addTextChangedListener(new PhoneTextWatcher());
        edit_password.addTextChangedListener(new PasswordTextWatcher());

        btn_login.setOnClickListener(this);
        text_forget_password.setOnClickListener(this);
        text_register.setOnClickListener(this);
        img_eye_password.setOnClickListener(this);
        img_clear_phone.setOnClickListener(this);
        img_clear_password.setOnClickListener(this);
    }

    private class PhoneTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            img_clear_phone.setVisibility(s.length() > 0 ? View.VISIBLE : View.INVISIBLE);

            if (s.length() > 0 && edit_password.getText().toString().trim().length() > 0) {
                btn_login.setEnabled(true);
            }
        }
    }

    private class PasswordTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            img_clear_password.setVisibility(s.length() > 0 ? View.VISIBLE : View.INVISIBLE);
            if (s.length() > 0 && edit_phone.getText().toString().trim().length() > 0) {
                btn_login.setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Log.e("登录按钮", "点击事件");
                login();

                break;
            case R.id.img_clear_phone:
                edit_phone.setText("");
                break;
            case R.id.img_clear_password:
                edit_password.setText("");
                break;
            case R.id.text_register:
                StartActivityUtils.startRegisterActivity(LoginActivity.this);
                break;
            default:
                break;
        }
    }

    private void login() {
        String accid = edit_phone.getText().toString().trim();
        final String password = edit_password.getText().toString().trim();
        LoginInfo info = new LoginInfo(accid, MD5Utils.getMD5(password));
        NIMClient.getService(AuthService.class).login(info).setCallback(new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {
                        Log.e("登录", "成功");
                        AppConfig.setUserToken(LoginActivity.this, MD5Utils.getMD5(password));
                        StartActivityUtils.startMainActivity(LoginActivity.this);
                        finish();
                    }

                    @Override
                    public void onFailed(int code) {
                        Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                        Log.e("登录", "失败" + code);
                    }

                    @Override
                    public void onException(Throwable exception) {
                        Log.e("登录", "出错" + exception.toString());
                    }
                    // 可以在此保存LoginInfo到本地，下次启动APP做自动登录用
        });


    }
}
