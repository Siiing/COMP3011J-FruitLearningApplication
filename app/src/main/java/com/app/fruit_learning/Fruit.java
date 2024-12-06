
package com.app.fruit_learning;

/**
 * @Author Siying.Li
 * @Date 2024/10/19 16:09
 * @Version 1.0
 */
public class Fruit {
    private String name;
    private int imageResId;
    private int color;

    //set the character of Fruit
    public Fruit(String name, int imageResId, int color) {
        this.name = name;
        this.imageResId = imageResId;
        this.color=color;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getColor() {
        return color;
    }
}

