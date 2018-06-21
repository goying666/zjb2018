package renchaigao.com.zjb.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import renchaigao.com.zjb.R;
import renchaigao.com.zjb.team.create.createTeam;
import renchaigao.com.zjb.team.join.joinTeam;
import renchaigao.com.zjb.team.my.myTeam;
import renchaigao.com.zjb.util.BottomNavigationViewHelper;

public class team extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//
//            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Button button_creatTeam = (Button) findViewById(R.id.button_creatTeam);
        Button button_joinTeam = (Button) findViewById(R.id.button_joinTeam);
        Button button_myTeam = (Button) findViewById(R.id.button_myTeam);
        button_creatTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(team.this,createTeam.class);
                startActivity(intent);
            }
        });
        button_joinTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(team.this,joinTeam.class);

                startActivity(intent);

            }
        });
        button_myTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(team.this,myTeam.class);
                startActivity(intent);
            }
        });
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

}
