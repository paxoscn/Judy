package cn.paxos.judy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.paxos.judy.domain.User;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if (User.loggedIn()) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        }
    }
}
