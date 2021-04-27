package com;

import java.awt.Point;

/**
 * @Author: HGF
 * @Date: 4/21/21
 */
public class CalculateTrace {
    public CalculateTrace(){
    }

    public Double CalculateDistance(Float w, Float c, Memory memory, int index) {
        Float section = w/8;
        Point controllerPoint = new Point(0, (int)(section*(index*2+1)));
        Point memoryCenter = new Point(c.intValue(), memory.y.intValue());
        return controllerPoint.distance(memoryCenter);
    }



}
