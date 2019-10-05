package com.pookraidee.panupongthongsri.pookraidee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class edit_profile extends AppCompatActivity {

    private EditText efname,elname,etel,earea,eaddress;
    private Button savedata,can;
    private String URL_EDIT = "http://203.154.83.137/puklaidee/editprofile.php";
    private String euser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        efname = findViewById(R.id.edit_name_et);
        elname = findViewById(R.id.edit_Sname_et);
        etel = findViewById(R.id.edit_username_et);
        earea = findViewById(R.id.edit_area_et);
        eaddress = findViewById(R.id.edit_address_et);
        savedata = findViewById(R.id.save_naja);
        can = findViewById(R.id.can_naja);

        Bundle bundle = getIntent().getExtras();
        euser = bundle.getString("username");

        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editP();
                Intent ited = new Intent(edit_profile.this, user.class);
                ited.putExtra("username", euser);
                startActivity(ited);
            }
        });

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itced = new Intent(edit_profile.this, user.class);
                itced.putExtra("username", euser);
                startActivity(itced);
            }
        });


    }


    public void editP(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL_EDIT,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {

                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(Login.this, "Error:"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("fname",efname.getText().toString());
                params.put("lname",elname.getText().toString());
                params.put("tel",etel.getText().toString());
                params.put("area",earea.getText().toString());
                params.put("address",eaddress.getText().toString());
                params.put("user",euser);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
