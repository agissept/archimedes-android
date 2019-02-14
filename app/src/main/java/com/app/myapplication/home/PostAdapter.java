package com.app.myapplication.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.app.myapplication.R;
import com.app.myapplication.detail.DetailActivity;
import com.app.myapplication.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> listPost;

    public PostAdapter(List listPost) {
        this.listPost = listPost;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder viewHolder, int i) {
        final Post p = listPost.get(i);
      //  viewHolder.number.setText(String.valueOf(i+1));
        viewHolder.title.setText(p.getTitle());
        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                i.putExtra("title", p.getTitle());
                i.putExtra("body", p.getBody());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    public Post getPost(int position){
        return listPost.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, title;
        CardView card_view;
        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            card_view = view.findViewById(R.id.card_view);
        }
    }
}
