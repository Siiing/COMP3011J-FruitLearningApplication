package com.app.fruit_learning;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;
import android.content.res.Configuration;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to start the welcome_text animation
        TextView textView = findViewById(R.id.welcome);
        startAnimation(textView);

        //help button for introduction
        ImageView help_button = findViewById(R.id.help_button);
        help_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.help_title)
                        .setMessage(getString((R.string.help_messages)))
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();  //show the help information
            }
        });

        //author button for my info
        ImageView author_button = findViewById(R.id.author_button);
        author_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.author_title)
                        .setMessage(getString((R.string.author_info)))
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //setting button
        ImageView settingButton = findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettingsDialog();
            }
        });


        //turn to different page
        findViewById(R.id.fruit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });

    }


    //make a animation to zoom in and zoom out the welcome word
    private void startAnimation(TextView textView) {
        // create animation to make the welcome word more active
        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(textView, "scaleX", 1f, 1.2f);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 1.2f);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(textView, "scaleX", 1.2f, 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(textView, "scaleY", 1.2f, 1f);

        // set the continue time of the animation
        scaleUpX.setDuration(5000);
        scaleUpY.setDuration(5000);
        scaleDownX.setDuration(5000);
        scaleDownY.setDuration(5000);

        AnimatorSet scaleUp = new AnimatorSet();
        scaleUp.play(scaleUpX).with(scaleUpY);

        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        AnimatorSet scaleAnimation = new AnimatorSet();
        scaleAnimation.play(scaleUp).before(scaleDown);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        //  start the animation
        scaleAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startAnimation(textView);
            }
        });
        scaleAnimation.start();
    }

    //draw a dialog to switch language or exit the app
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.setting)
                .setItems(new String[]{getString(R.string.switch_language), getString(R.string.exit)}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            switchLanguage();  //switch button
                        } else if (which == 1) {
                            finish(); //exit button
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //close the dialog
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //set a button to switch languages by oneself rather than following the system
    private void switchLanguage() {
        Locale currentLocale = getResources().getConfiguration().locale;
        Locale newLocale;

        if (currentLocale.getLanguage().equals("zh")) {  //check th current language
            newLocale = new Locale("en"); //switch to English
        } else {
            newLocale = new Locale("zh"); //switch to Chinese
        }

        Locale.setDefault(newLocale);
        Configuration config = getResources().getConfiguration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


}