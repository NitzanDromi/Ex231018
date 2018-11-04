package com.example.user.ex231018;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout bg;
    AlertDialog.Builder adb;
    CharSequence[] clr={"Red","Green","Blue"};
    int[] color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg=(LinearLayout)findViewById(R.id.llbg);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.menucreds){
            Intent t=new Intent(this, CredsActivity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }

    public void aldi(View view) {
        adb=new AlertDialog.Builder(this);
        color= new int[]{0,0,0};
       //LayoutInflater dialogInterface=this.getLayoutInflater();
        adb.setTitle("Changing background - multi choice");
        adb.setMultiChoiceItems(clr, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b)
                    if(color[i] == 0){
                        color[i]=255;
                    }
                    else if(color[i] == 255) {
                        color[i] = 0;
                    }
            }
        });
        adb.setNeutralButton("cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                bg.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    public void reset(View view) {
        bg.setBackgroundColor(Color.WHITE);
    }

    public void basicaldi(View view) {
        adb=new AlertDialog.Builder(this);
        LayoutInflater dialogInterface=this.getLayoutInflater();
        adb.setTitle("Changing background - one choice");
        adb.setItems(clr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0)
                    bg.setBackgroundColor(Color.RED);
                if (i==2)
                    bg.setBackgroundColor(Color.BLUE);
                if (i==1)
                    bg.setBackgroundColor(Color.GREEN);
            }
        });
        adb.setNeutralButton("cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setPositiveButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                bg.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }
}
