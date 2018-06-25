package renchaigao.com.zjb.team.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import renchaigao.com.zjb.R;
import renchaigao.com.zjb.team.create.pojo.date_week_select;
import renchaigao.com.zjb.util.CalendarUtil;
import renchaigao.com.zjb.util.create_team_func;

public class createTeam extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popupWindow;
    private ImageView id_activity_create_team_datetime_image_more;
    //    private Button id_activity_create_team_datetime_image_more;
    private TextView textview_creat_team_date;
    private boolean isShow;
    private int index;
    private int oldIndex;
    private LinearLayout id_activity_create_team_datetime, id_activity_create_team_datetime_selectinfo;
    private ConstraintLayout
            id_activity_create_team_basic_information,
            id_activity_create_team_place,
            id_activity_create_team_people_number,
            id_activity_create_team_game,
            id_activity_create_team_pwd,
            id_activity_create_team_join,
            id_activity_create_team_spend_style,
            id_activity_create_team_other_information,
            id_activity_create_team_datetime_con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        click_id_activity_create_team_datetime_image_more = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        id_activity_create_team_datetime_con = findViewById(R.id.id_activity_create_team_datetime_con);
        id_activity_create_team_datetime_image_more = findViewById(R.id.id_activity_create_team_datetime_image_more);
        id_activity_create_team_datetime_selectinfo = findViewById(R.id.id_activity_create_team_datetime_selectinfo);
//      默认设置今日日期
        textview_creat_team_date = findViewById(R.id.textview_creat_team_date);
        textview_creat_team_date.setText(CalendarUtil.getCurrentDate());

        setAllConstraintLayout();

        id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
        initWeek();
        id_activity_create_team_datetime_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_id_activity_create_team_datetime_image_more) {
                    id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_up);
                    id_activity_create_team_datetime_selectinfo.setVisibility(View.VISIBLE);
                    Log.i(TAG, "onClick: id_activity_create_team_datetime_image_more , click_id_activity_create_team_datetime_image_more is true");
                } else {
                    id_activity_create_team_datetime_image_more.setImageResource(R.drawable.more_down);
                    id_activity_create_team_datetime_selectinfo.setVisibility(View.GONE);
                    Log.i(TAG, "onClick: id_activity_create_team_datetime_image_more , click_id_activity_create_team_datetime_image_more is false");
                }
                click_id_activity_create_team_datetime_image_more = !click_id_activity_create_team_datetime_image_more;
            }
        });

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

    private date_week_select
            today_date_week_select,
            tomorrow_date_week_select,
            aftertom_date_week_select,
            friday_date_week_select,
            saturday_date_week_select,
            sunday_date_week_select;

    private void initWeek() {
//        实例化各选项
        today_date_week_select = new date_week_select();
        tomorrow_date_week_select = new date_week_select();
        aftertom_date_week_select = new date_week_select();
        friday_date_week_select = new date_week_select();
        saturday_date_week_select = new date_week_select();
        sunday_date_week_select = new date_week_select();
//        将后三天的总布局定位
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

        CalendarUtil todayCalendarUtil = new CalendarUtil();
        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(new Date());
        Log.i(TAG, "initWeek: "+todayCalendar.get(Calendar.DAY_OF_WEEK));
        switch (CalendarUtil.getWeekOfDate(new Date())){
            case "周一":

                break;
            case "周二":
                break;
            case "周三":
                break;
            case "周四":
                break;
            case "周五":
                break;
            case "周六":
                break;
            case "周日":
                break;
        }
    }

    /**
     * 设置
     * <p>
     * private void setMenu(String mesg) {
     * if (null == popupWindow){
     * View view = getLayoutInflater().inflate(R.layout.create_team_popwindow, null);
     * txt = view.findViewById(R.id.pop_text1);
     * //创建弹窗
     * popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,
     * WindowManager.LayoutParams.MATCH_PARENT);
     * //            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);//设置动画效果
     * popupWindow.setOutsideTouchable(false);//设置点击弹窗外部不关闭弹窗
     * popupWindow.setFocusable(false);//设置不获取焦点
     * }
     * if (isShow){
     * if (index == oldIndex){
     * popupWindow.dismiss();//关闭弹窗
     * isShow = false;
     * return;
     * }
     * }
     * txt.setText(mesg);
     * popupWindow.showAsDropDown(tag_line);//设置显示弹窗
     * isShow = true;
     * oldIndex = index;
     * }
     */
    private boolean click_id_activity_create_team_datetime_image_more;
    private String TAG = "createTeam";

    @Override
    public void onClick(View v) {
        Log.i(TAG, "onClick: in there");
        switch (v.getId()) {
            case R.id.id_activity_create_team_datetime_image_more:

//                this.setMenu("date");
                break;
            default:
                break;
        }
    }

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
