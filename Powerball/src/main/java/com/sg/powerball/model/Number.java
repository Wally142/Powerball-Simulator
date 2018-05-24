
package com.sg.powerball.model;

import java.time.LocalDate;
import java.util.Objects;


public class Number {
    
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private LocalDate date;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum5() {
        return num5;
    }

    public void setNum5(int num5) {
        this.num5 = num5;
    }

    public int getNum6() {
        return num6;
    }

    public void setNum6(int num6) {
        this.num6 = num6;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.num1;
        hash = 61 * hash + this.num2;
        hash = 61 * hash + this.num3;
        hash = 61 * hash + this.num4;
        hash = 61 * hash + this.num5;
        hash = 61 * hash + this.num6;
        hash = 61 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Number other = (Number) obj;
        if (this.num1 != other.num1) {
            return false;
        }
        if (this.num2 != other.num2) {
            return false;
        }
        if (this.num3 != other.num3) {
            return false;
        }
        if (this.num4 != other.num4) {
            return false;
        }
        if (this.num5 != other.num5) {
            return false;
        }
        if (this.num6 != other.num6) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

}
