package com;

import java.awt.Point;

/**
 * @Author: HGF
 * @Date: 4/21/21
 */
public class CalculateTrace {
    public CalculateTrace() {
    }

    public Double CalculateDistance(Float w, Float c, Memory memory) {
        Float slope = memory.y / memory.x;
        Point memoryCenter = new Point(memory.x.intValue(), memory.y.intValue());
        Point intersection = new Point();
        if (slope*c < w) {
            intersection.setLocation(c, slope*c);
        }else {
            intersection.setLocation(w/slope, w);
        }
        return intersection.distance(memoryCenter);
    }


}
