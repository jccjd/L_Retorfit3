package com.example.lenovo.l_retorfit3;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.lenovo.l_retorfit3.R.id.btn_get;
import static com.example.lenovo.l_retorfit3.R.id.btn_post;
import static com.example.lenovo.l_retorfit3.R.id.tv_show_msg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

private Button mButtonGet,mButtonPost;
private TextView mViewShowMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        init();
    }

    private void init() {
        mButtonGet.setOnClickListener(this);
        mButtonPost.setOnClickListener(this);
    }

    private void initView() {
        mButtonGet = (Button) findViewById(btn_get);
        mButtonPost = (Button) findViewById(btn_post);
        mViewShowMsg = (TextView) findViewById(tv_show_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btn_get:
                getData();
                break;
            case btn_post:
                PostData();
                break;
        }
    }

    private void PostData() {
        RetorfitUtil.requestPost(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mViewShowMsg.setText("Get方法获取数据 ---> "+ response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mViewShowMsg.setText(t.getMessage());
            }
        });
    }

    public void getData() {

        RetorfitUtil.resquestGet(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mViewShowMsg.setText("Post方法获取数据 ---> "+ response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mViewShowMsg.setText(t.getMessage());
            }
        });
    }
}
