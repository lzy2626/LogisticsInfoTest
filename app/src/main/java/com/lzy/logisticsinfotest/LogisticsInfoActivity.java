package com.lzy.logisticsinfotest;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者：lzy on 2018/4/2 16:54
 * 查看物流信息
 */
public class LogisticsInfoActivity extends AppCompatActivity {
    ListView listView;
    TextView txt_no_data;

    private List<MessContent> allContent;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_info);

        txt_no_data = findViewById(R.id.txt_no_data);
        listView = findViewById(R.id.list_view);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        new Thread(new Runnable() {
            @Override
            public void run() {

                KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
                try {
                    String result = api.getOrderTracesByJson("JD", id);
                    Message msg = new Message();
                    Bundle data = new Bundle();
                    data.putString("value", result);
                    msg.setData(data);
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    Handler handler = new Handler() {

        private List<MessContent.TracesBean> list = new ArrayList<>();

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            list.clear();
            Bundle data = msg.getData();
            String val = data.getString("value").replace(" ", "");
            try {
                JSONObject jsonObject = new JSONObject(val);
                JSONArray Traces = (JSONArray) jsonObject.get("Traces");
                for (int i = 0; i < Traces.length(); i++) {
                    MessContent.TracesBean bean = new MessContent.TracesBean();
                    JSONObject o = (JSONObject) Traces.get(i);
                    bean.setAcceptStation((String) o.get("AcceptStation"));
                    bean.setAcceptTime((String) o.get("AcceptTime"));
                    list.add(bean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            if (list.size() > 0) {
                Collections.reverse(list);//反转一下顺序
                MessListAdapter adapter = new MessListAdapter(LogisticsInfoActivity.this, list);
                listView.setAdapter(adapter);
                txt_no_data.setVisibility(View.GONE);
            } else {
                txt_no_data.setVisibility(View.VISIBLE);
            }


        }
    };
}
