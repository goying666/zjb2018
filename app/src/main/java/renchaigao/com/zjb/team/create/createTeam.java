package renchaigao.com.zjb.team.create;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import renchaigao.com.zjb.R;

public class createTeam extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popupWindow;
    private ImageView tag_line;
    private TextView txt;
    private boolean isShow;
    private int index;
    private int oldIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

//        设置 日期 选择部分；
        Spinner spinner_start_date = findViewById(R.id.creat_team_text_start_date);
        ArrayAdapter arrayAdapter_spinner_start_date = ArrayAdapter.createFromResource( this,
                R.array.create_team_start_date, android.R.layout.simple_spinner_item);
        arrayAdapter_spinner_start_date.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start_date.setAdapter(arrayAdapter_spinner_start_date);


        Intent intent=getIntent();
        Spinner ct_spend = (Spinner)findViewById(R.id.spinner_ct_spend);
        ArrayAdapter adapter = ArrayAdapter.createFromResource( this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ct_spend.setAdapter(adapter);

        Toolbar toolbar= findViewById(R.id.toolbar_creat);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_create);
        ImageView create_title_image = findViewById(R.id.imageview_create_toolbar_top);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


//        collapsingToolbar.setTitle("创建队伍");
//        textView_create_information.setText(generateFruitContent("创建队伍"));
//        Glide.with(this).load(R.id.imageview_create_toolbar_top).into(create_title_image);

    }
    /**
     * 设置
     */
    private void setMenu(String mesg) {
        if (null == popupWindow){
            View view = getLayoutInflater().inflate(R.layout.create_team_popwindow, null);
            txt = view.findViewById(R.id.pop_text1);
            //创建弹窗
            popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);
//            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);//设置动画效果
            popupWindow.setOutsideTouchable(false);//设置点击弹窗外部不关闭弹窗
            popupWindow.setFocusable(false);//设置不获取焦点
        }
        if (isShow){
            if (index == oldIndex){
                popupWindow.dismiss();//关闭弹窗
                isShow = false;
                return;
            }
        }
        txt.setText(mesg);
        popupWindow.showAsDropDown(tag_line);//设置显示弹窗
        isShow = true;
        oldIndex = index;
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.creat_team_text_start_date:
                this.setMenu("date");
                break;
            case R.id.part1:
                this.setMenu("date");
                break;
            default:
                break;
        }
    }

    private String generateFruitContent(String fruitName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

}
