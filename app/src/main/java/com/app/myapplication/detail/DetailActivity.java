package com.app.myapplication.detail;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.app.myapplication.R;


public class DetailActivity extends AppCompatActivity {
    TextView title;
    WebView body;
    String strBody;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);

        //swipe = findViewById(R.id.swipe);
        title = findViewById(R.id.title);
        //body = findViewById(R.id.body);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadPost();
            }
        });

        loadPost();
    }
    private void loadPost() {
        strBody = getIntent().getStringExtra("body");
        if (strBody.contains("img src=\"/storage/posts")){
            strBody = strBody.replaceAll("img src=\"/storage/posts", "img src=\"https://acrhimedes.000webhostapp.com/storage/posts");
            System.out.println("aaaaaaaaaaaaa");
        }
        title.setText(getIntent().getStringExtra("title"));
        body.loadData(strBody,"text/html", null);
        swipe.setRefreshing(false);
    }
}
