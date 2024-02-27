package com.groupb.cuiz.web.quiz;

public class JumsuUpdateDTO {
    private Integer oldJumsu;
    private Integer upJumsu;

    public Integer getOldJumsu() {
        return oldJumsu;
    }

    public void setOldJumsu(Integer oldJumsu) {
        this.oldJumsu = oldJumsu;
    }

    public Integer getUpJumsu() {
        return upJumsu;
    }

    public void setUpJumsu(Integer upJumsu) {
        this.upJumsu = upJumsu;
    }

    @Override
    public String toString() {
        return "JumsuUpdateDTO{" +
                "oldJumsu=" + oldJumsu +
                ", upJumsu=" + upJumsu +
                '}';
    }
}
