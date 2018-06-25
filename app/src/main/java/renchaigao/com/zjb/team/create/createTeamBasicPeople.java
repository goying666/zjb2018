package renchaigao.com.zjb.team.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import renchaigao.com.zjb.R;
import renchaigao.com.zjb.team.create.pojo.date_week_select;
import renchaigao.com.zjb.util.CalendarUtil;
import renchaigao.com.zjb.util.create_team_func;

/**
 * Created by Administrator on 2018/6/26/026.
 */

public class createTeamBasicPeople extends AppCompatActivity {

    private PopupWindow popupWindow;
    private ImageView id_activity_create_team_datetime_image_more, id_activity_create_team_time_image_more;
    private TextView textview_creat_team_date, id_activity_create_team_time_value;
    private LinearLayout id_activity_create_team_datetime, id_activity_create_team_datetime_selectinfo, id_activity_create_team_time_selectinfo;
    private ConstraintLayout
            id_activity_create_team_basic_information,
            id_activity_create_team_place,
            id_activity_create_team_people_number,
            id_activity_create_team_game,
            id_activity_create_team_pwd,
            id_activity_create_team_join,
            id_activity_create_team_spend_style,
            id_activity_create_team_other_information,
            id_activity_create_team_datetime_con,
            id_activity_create_team_time_con,
            id_activity_create_team_time_selectinfo_morning,
            id_activity_create_team_time_selectinfo_afternoon,
            id_activity_create_team_time_selectinfo_evening,
            id_activity_create_team_time_selectinfo_night;
    private date_week_select
            today_date_week_select,
            tomorrow_date_week_select,
            aftertom_date_week_select,
            friday_date_week_select,
            saturday_date_week_select,
            sunday_date_week_select;

    private void initTime() {
        id_activity_create_team_time_con = findViewById(R.id.id_activity_create_team_time_con);
        id_activity_create_team_time_selectinfo_morning = findViewById(R.id.id_activity_create_team_time_selectinfo_morning);
        id_activity_create_team_time_selectinfo_afternoon = findViewById(R.id.id_activity_create_team_time_selectinfo_afternoon);
        id_activity_create_team_time_selectinfo_evening = findViewById(R.id.id_activity_create_team_time_selectinfo_evening);
        id_activity_create_team_time_selectinfo_night = findViewById(R.id.id_activity_create_team_time_selectinfo_night);
        id_activity_create_team_time_selectinfo = findViewById(R.id.id_activity_create_team_time_selectinfo);
        id_activity_create_team_time_image_more = findViewById(R.id.id_activity_create_team_time_image_more);
        id_activity_create_team_time_value = findViewById(R.id.id_activity_create_team_time_value);
        id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
        id_activity_create_team_time_value.setText("点击选择");
        id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
    }

    private void setAllClickListener() {
//        设置date选项区域折叠部分
        id_activity_create_team_datetime_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_id_activity_create_team_datetime_image_more) {
                    id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_up);
                    id_activity_create_team_datetime_selectinfo.setVisibility(View.VISIBLE);
                } else {
                    id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                    id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                }
                click_id_activity_create_team_datetime_image_more = !click_id_activity_create_team_datetime_image_more;
            }
        });

        id_activity_create_team_time_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_id_activity_create_team_time_image_more) {
                    id_activity_create_team_time_image_more.setImageResource(R.drawable.more_up);
                    id_activity_create_team_time_selectinfo.setVisibility(View.VISIBLE);
                    Log.i(TAG,"click_id_activity_create_team_time_image_more  is true");
                } else {
                    id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
                    id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
                    Log.i(TAG,"click_id_activity_create_team_time_image_more  is false");
                }
                click_id_activity_create_team_time_image_more = !click_id_activity_create_team_time_image_more;
            }
        });
        id_activity_create_team_time_selectinfo_morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_activity_create_team_time_value.setText(R.string.create_team_time_morning);
                id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_time_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "时间设置成功：" + R.string.create_team_time_morning, Toast.LENGTH_SHORT).show();
            }
        });
        id_activity_create_team_time_selectinfo_afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_activity_create_team_time_value.setText(R.string.create_team_time_afternoon);
                id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_time_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "时间设置成功：" + R.string.create_team_time_afternoon, Toast.LENGTH_SHORT).show();
            }
        });
        id_activity_create_team_time_selectinfo_evening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_activity_create_team_time_value.setText(R.string.create_team_time_evening);
                id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_time_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "时间设置成功：" + R.string.create_team_time_evening, Toast.LENGTH_SHORT).show();
            }
        });
        id_activity_create_team_time_selectinfo_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_activity_create_team_time_value.setText(R.string.create_team_time_night);
                id_activity_create_team_time_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_time_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_time_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "时间设置成功：" + R.string.create_team_time_night, Toast.LENGTH_SHORT).show();
            }
        });

//        date
        today_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(today_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + today_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
        tomorrow_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(tomorrow_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + tomorrow_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
        aftertom_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(aftertom_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + aftertom_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
        friday_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(friday_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + friday_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
        saturday_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(saturday_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + saturday_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
        sunday_date_week_select.getConstraint().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_creat_team_date.setText(sunday_date_week_select.getDate_textView().getText());
                id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                click_id_activity_create_team_datetime_image_more = true;
                Toast.makeText(createTeamBasicPeople.this, "日期设置成功：" + sunday_date_week_select.getDate_textView().getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

//        设置各区域的layout绑定
        setAllConstraintLayout();

//        date选项部分，点击后是否打开
        click_id_activity_create_team_datetime_image_more = true;
//        time选项部分，点击后是否打开
        click_id_activity_create_team_time_image_more = true;

        initDate();
        initTime();

//      设置按键响应
        setAllClickListener();


//        设置 日期 选择部分；
//        Spinner spinner_start_date = findViewById(R.id.creat_team_text_start_date);
//        ArrayAdapter arrayAdapter_spinner_start_date = ArrayAdapter.createFromResource(this,
//                R.array.create_team_start_date, android.R.layout.simple_spinner_item);
//        arrayAdapter_spinner_start_date.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_start_date.setAdapter(arrayAdapter_spinner_start_date);


        Intent intent = getIntent();
        Spinner ct_spend = (Spinner) findViewById(R.id.spinner_ct_spend);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ct_spend.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar_creat);
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

    //    根据当天日期将日期选项内的数据处理
//    private ConstraintLayout today_constraint, tomorrow_constraint, aftertom_constraint, friday_constraint, saturday_constraint, sunday_constraint;
//    private TextView today_textView, tomorrow_textView, aftertom_textView, friday_textView, saturday_textView, sunday_textView;
//    private TextView today_textView_week, tomorrow_textView_week, aftertom_textView_week, friday_textView_week, saturday_textView_week, sunday_textView_week;

    //      初始化日期相关默认选项
    private void initDate() {

        id_activity_create_team_datetime_con = findViewById(R.id.id_activity_create_team_datetime_con);
        id_activity_create_team_datetime_image_more = findViewById(R.id.id_activity_create_team_datetime_image_more);
        id_activity_create_team_datetime_selectinfo = findViewById(R.id.id_activity_create_team_datetime_selectinfo);

        id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
//      默认设置今日日期
        textview_creat_team_date = findViewById(R.id.textview_creat_team_date);
        textview_creat_team_date.setText(CalendarUtil.getCurrentDate());

//        实例化各选项
        today_date_week_select = new date_week_select();
        tomorrow_date_week_select = new date_week_select();
        aftertom_date_week_select = new date_week_select();
        friday_date_week_select = new date_week_select();
        saturday_date_week_select = new date_week_select();
        sunday_date_week_select = new date_week_select();
//        将后三天的总布局定位
        today_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_today));
        tomorrow_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_tomorrow));
        aftertom_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_aftowmor));
        friday_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_friday));
        saturday_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_saturday));
        sunday_date_week_select.setConstraint((ConstraintLayout) findViewById(R.id.id_activity_create_team_date_selectinfo_sunday));
//        锁定各选项的date信息
        today_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_today_date));
        tomorrow_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_tomorrow_date));
        aftertom_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_aftowmor_date));
        friday_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_friday_date));
        saturday_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_saturday_date));
        sunday_date_week_select.setDate_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_sunday_date));
//        锁定各选项的week信息
        today_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_today_week));
        tomorrow_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_tomorrow_week));
        aftertom_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_aftowmor_week));
        friday_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_friday_week));
        saturday_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_saturday_week));
        sunday_date_week_select.setWeek_textView((TextView) findViewById(R.id.id_activity_create_team_date_selectinfo_sunday_week));

        switch ("周六") {
//            switch (CalendarUtil.getWeekOfDate(new Date())){
            case "周一":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周一");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周二");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周三");
                friday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 4));
                friday_date_week_select.getWeek_textView().setText("周五");
                saturday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 5));
                saturday_date_week_select.getWeek_textView().setText("周六");
                sunday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 6));
                sunday_date_week_select.getWeek_textView().setText("周日");
                break;
            case "周二":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周二");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周三");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周四");
                friday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 3));
                friday_date_week_select.getWeek_textView().setText("周五");
                saturday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 4));
                saturday_date_week_select.getWeek_textView().setText("周六");
                sunday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 5));
                sunday_date_week_select.getWeek_textView().setText("周日");

                break;
            case "周三":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周三");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周四");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周五");
                friday_date_week_select.getConstraint().setVisibility(View.GONE);
                saturday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 3));
                saturday_date_week_select.getWeek_textView().setText("周六");
                sunday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 4));
                sunday_date_week_select.getWeek_textView().setText("周日");
                break;
            case "周四":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周四");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周五");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周六");
                friday_date_week_select.getConstraint().setVisibility(View.GONE);
                saturday_date_week_select.getConstraint().setVisibility(View.GONE);
                sunday_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 3));
                sunday_date_week_select.getWeek_textView().setText("周日");
                break;
            case "周五":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周五");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周六");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周日");
                friday_date_week_select.getConstraint().setVisibility(View.GONE);
                saturday_date_week_select.getConstraint().setVisibility(View.GONE);
                sunday_date_week_select.getConstraint().setVisibility(View.GONE);
                break;
            case "周六":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周六");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周日");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周一");
                friday_date_week_select.getConstraint().setVisibility(View.GONE);
                saturday_date_week_select.getConstraint().setVisibility(View.GONE);
                sunday_date_week_select.getConstraint().setVisibility(View.GONE);
                break;
            case "周日":
                today_date_week_select.getDate_textView().setText(CalendarUtil.getCurrentDate());
                today_date_week_select.getWeek_textView().setText("周日");
                tomorrow_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 1));
                tomorrow_date_week_select.getWeek_textView().setText("周一");
                aftertom_date_week_select.getDate_textView().setText(CalendarUtil.getStringDateAfter(new Date(), 2));
                aftertom_date_week_select.getWeek_textView().setText("周二");
                friday_date_week_select.getConstraint().setVisibility(View.GONE);
                saturday_date_week_select.getConstraint().setVisibility(View.GONE);
                sunday_date_week_select.getConstraint().setVisibility(View.GONE);
                break;
        }
    }


    private boolean click_id_activity_create_team_datetime_image_more,click_id_activity_create_team_time_image_more;
    private String TAG = "createTeam";


    private void selectOneConstraintLayoutVisible(Integer selectOne) {
        id_activity_create_team_datetime.setVisibility(create_team_func.retViewVisible(selectOne, 1));
        id_activity_create_team_place.setVisibility(create_team_func.retViewVisible(selectOne, 2));
        id_activity_create_team_people_number.setVisibility(create_team_func.retViewVisible(selectOne, 3));
        id_activity_create_team_game.setVisibility(create_team_func.retViewVisible(selectOne, 4));
        id_activity_create_team_pwd.setVisibility(create_team_func.retViewVisible(selectOne, 5));
        id_activity_create_team_join.setVisibility(create_team_func.retViewVisible(selectOne, 6));
        id_activity_create_team_spend_style.setVisibility(create_team_func.retViewVisible(selectOne, 7));
    }

    private void setAllConstraintLayout() {
        id_activity_create_team_basic_information = findViewById(R.id.id_activity_create_team_basic_information);
        id_activity_create_team_datetime = findViewById(R.id.id_activity_create_team_datetime);
        id_activity_create_team_place = findViewById(R.id.id_activity_create_team_place);
        id_activity_create_team_people_number = findViewById(R.id.id_activity_create_team_people_number);
        id_activity_create_team_game = findViewById(R.id.id_activity_create_team_game);
        id_activity_create_team_pwd = findViewById(R.id.id_activity_create_team_pwd);
        id_activity_create_team_join = findViewById(R.id.id_activity_create_team_join);
        id_activity_create_team_spend_style = findViewById(R.id.id_activity_create_team_spend_style);
        id_activity_create_team_other_information = findViewById(R.id.id_activity_create_team_other_information);
        id_activity_create_team_basic_information.setVisibility(View.VISIBLE);
        id_activity_create_team_other_information.setVisibility(View.GONE);
        selectOneConstraintLayoutVisible(1);
    }

}
