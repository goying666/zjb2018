package renchaigao.com.zjb.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import renchaigao.com.zjb.R;
import renchaigao.com.zjb.team.join.joinTeam;
import renchaigao.com.zjb.team.team;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button user_login = (Button) findViewById(R.id.button_login_user);
        user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,team.class);
                startActivity(intent);
            }
        });


    }
}
