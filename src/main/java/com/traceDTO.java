package com;

/**
 * @Author: HGF
 * @Date: 4/19/21
 */

public class traceDTO {
    String id;
    Double length;

    public traceDTO(String id, Double length) {
        this.id = id;
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
