package com.pookraidee.panupongthongsri.pookraidee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.time.Instant;


public class money extends AppCompatActivity implements View.OnClickListener{



    private ImageView avatar,logout;
    private TextView name;
    private String uu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        avatar = findViewById(R.id.avatar_home);
        name = findViewById(R.id.name_home);
        logout = findViewById(R.id.logout);

        Bundle bundle = getIntent().getExtras();
        uu= bundle.getString("username");



        final coin cc = new coin();

        Bundle b4 = new Bundle();
        b4.putString("myOusername",uu);
        cc.setArguments(b4);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,cc).commit();

        Bundle bd = getIntent().getExtras();
        if(bd != null){
            Glide.with(getApplicationContext()).load(bd.getString("img")).apply( RequestOptions.circleCropTransform()).into(avatar);
            name.setText(bd.getString("name"));
        }


        logout.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View v){
        Intent i;

        switch (v.getId()) {


            case R.id.logout:
                i = new Intent ( this , Login.class );
                startActivity ( i );
                break;


        }
    }
}