package renchaigao.com.zjb.team.create;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import renchaigao.com.zjb.R;

public class createTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        Intent intent=getIntent();

        Toolbar toolbar= findViewById(R.id.toolbar_creat);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_create);
        ImageView create_title_image = findViewById(R.id.imageview_create_toolbar_top);
        TextView textView_create_information = findViewById(R.id.textview_create_information);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        collapsingToolbar.setTitle("创建队伍");
//        textView_create_information.setText(generateFruitContent("创建队伍"));
//        Glide.with(this).load(R.id.imageview_create_toolbar_top).into(create_title_image);

    }
    private String generateFruitContent(String fruitName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

}
