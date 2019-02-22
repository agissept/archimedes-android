package com.app.myapplication.detail;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.myapplication.R;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView title, date;
    WebView body;
    String strBody;
    SwipeRefreshLayout swipe;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Detail News");
        title = findViewById(R.id.title);
        swipe = findViewById(R.id.swipe);
        body = findViewById(R.id.body);
        imageView = findViewById(R.id.image);
        date = findViewById(R.id.date);
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
        }

        if (getIntent().getStringExtra("image") != null){
            System.out.println("https://acrhimedes.000webhostapp.com/storage/" + getIntent().getStringExtra("image") + " this image");
            Glide.with(this)
                    .load("https://acrhimedes.000webhostapp.com/storage/" + getIntent().getStringExtra("image"))
                    .into(imageView);
        }else {
            imageView.setVisibility(View.GONE);
        }

        title.setText(getIntent().getStringExtra("title"));
        date.setText(getIntent().getStringExtra("date"));
        body.loadData(strBody,"text/html", null);
        swipe.setRefreshing(false);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
