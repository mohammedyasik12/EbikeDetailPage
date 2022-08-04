package com.yasikuiux.ebike_detailpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skyhope.showmoretextview.ShowMoreTextView;
import com.yasikuiux.ebike_detailpage.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity {

    //Image Slide
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.drawable.ebike_img,R.drawable.ebike_img2,R.drawable.ebike_img};
    private ArrayList<Integer> ImgArray = new ArrayList<Integer>();

    private ShowMoreTextView  txtdescription;
private ImageView image_milky,image_blue,image_pink,image_black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //REMOVE STATUSBAR

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //REMOVE TOOLBAR

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_main);
        init();

    }

    private void init (){

        //IMAGE SLIDE

        for (int i=0; i<img.length; i++)
            ImgArray.add(img[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this, ImgArray));
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == img.length){
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        //Auto start
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

//Description Text
        txtdescription=(ShowMoreTextView)findViewById(R.id.description_text);
        txtdescription.setText("The powerful Electronically controlled Samsung 72V 31AH power cells provide plenty of energy for up to 65 miles of urban riding on a single charge.The Kollter ES1-S Pro is the perfect daily commuter that is stylish to boot.");
        txtdescription.setShowingLine(4);
        txtdescription.addShowMoreText("Readmore");
        txtdescription.addShowLessText("Less");
        txtdescription.setShowMoreColor(Color.parseColor("#7B19F0")); // or other color
        txtdescription.setShowLessTextColor(Color.parseColor("#FF939393"));

        //Color Select
        image_milky=(ImageView)findViewById(R.id.image_milky);
        image_milky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image_milky.setImageResource(R.drawable.ic_greucolor_sele);
                Toast.makeText(getApplicationContext(), "Milky Color Selected", Toast.LENGTH_SHORT).show();

                image_blue.setImageResource(R.drawable.ic_blucolor);
                image_pink.setImageResource(R.drawable.ic_pinkcolor);
                image_black.setImageResource(R.drawable.ic_blackcolor);

            }
        });

        image_blue=(ImageView)findViewById(R.id.image_blue);
        image_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image_blue.setImageResource(R.drawable.ic_bluecolor_sele);
                Toast.makeText(getApplicationContext(), "Blue Color Selected", Toast.LENGTH_SHORT).show();

                image_milky.setImageResource(R.drawable.ic_greycolor);
                image_pink.setImageResource(R.drawable.ic_pinkcolor);
                image_black.setImageResource(R.drawable.ic_blackcolor);

            }
        });

        image_pink=(ImageView)findViewById(R.id.image_pink);
        image_pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image_pink.setImageResource(R.drawable.ic_pinkcolor_sele);
                Toast.makeText(getApplicationContext(), "Pink Color Selected", Toast.LENGTH_SHORT).show();

                image_milky.setImageResource(R.drawable.ic_greycolor);
                image_blue.setImageResource(R.drawable.ic_blucolor);
                image_black.setImageResource(R.drawable.ic_blackcolor);

            }
        });

        image_black=(ImageView)findViewById(R.id.image_black);
        image_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image_black.setImageResource(R.drawable.ic_blackcolor_sele);
                Toast.makeText(getApplicationContext(), "Black Color Selected", Toast.LENGTH_SHORT).show();

                image_milky.setImageResource(R.drawable.ic_greycolor);
                image_blue.setImageResource(R.drawable.ic_blucolor);
                image_pink.setImageResource(R.drawable.ic_pinkcolor);

            }
        });
    }
}