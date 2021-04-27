package com;

/**
 * @Author: HGF
 * @Date: 4/22/21
 */
public class Memory {
    Float x;
    Float y;
    int index;


    public Memory(Float x, Float y,int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
