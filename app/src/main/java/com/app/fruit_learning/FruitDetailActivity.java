package com.app.fruit_learning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class FruitDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);

        TextView fruitName = findViewById(R.id.fruit_name);
        ImageView fruitImage = findViewById(R.id.fruit_image);

        String name = getIntent().getStringExtra("FRUIT_NAME");
        fruitName.setText(name);


        int imageResId = getFruitImageResId(name);
        fruitImage.setImageResource(imageResId);

        //turn to different page
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //set the text color
        int colorResId = getFruitColor(name);
        fruitName.setTextColor(ContextCompat.getColor(this, colorResId));
    }

    //according to different images, turn to different pages
    private int getFruitImageResId(String name) {

        String currentLang = Locale.getDefault().getLanguage();
        String fruitName = name;

        if ("zh".equals(currentLang)) {
            fruitName = getFruitNameInChinese(name);
        }

        //to detect the names to get images
        switch (name) {
            case "Apple":
            case "苹果":
                return R.mipmap.apple;
            case "Cherry":
            case "樱桃":
                return R.mipmap.cherry;
            case "Strawberry":
            case "草莓":
                return R.mipmap.strawberry;
            case "Banana":
            case "香蕉":
                return R.mipmap.banana;
            case "Lemon":
            case "柠檬":
                return R.mipmap.lemon;
            case "Mango":
            case "芒果":
                return R.mipmap.mango;
            case "Avocado":
            case "牛油果":
                return R.mipmap.avocado;
            case "Grape":
            case "提子":
                return R.mipmap.grape;
            case "Watermelon":
            case "西瓜":
                return R.mipmap.watermelon;
            default:
                return 0;
        }
    }


    //set different colors
    private int getFruitColor(String name) {
        switch (name) {
            case "Apple":
            case "Cherry":
            case "Strawberry":
            case "苹果":
            case "樱桃":
            case "草莓":
                return R.color.red;

            case "Banana":
            case "Lemon":
            case "Mango":
            case "香蕉":
            case "柠檬":
            case "芒果":
                return R.color.yellow;
            case "Avocado":
            case "Grape":
            case "Watermelon":
            case "牛油果":
            case "提子":
            case "西瓜":
                return R.color.green;
            default:
                return R.color.black;
        }
    }

    //translate English name and Chinese name
    private String getFruitNameInChinese(String name) {
        switch (name) {
            case "Apple":
                return "苹果";
            case "Cherry":
                return "樱桃";
            case "Strawberry":
                return "草莓";
            case "Banana":
                return "香蕉";
            case "Lemon":
                return "柠檬";
            case "Mango":
                return "芒果";
            case "Avocado":
                return "牛油果";
            case "Grape":
                return "提子";
            case "Watermelon":
                return "西瓜";
            default:
                return "";
        }
    }
}