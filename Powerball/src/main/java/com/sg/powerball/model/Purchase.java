package com.sg.powerball.model;

import java.util.Objects;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Purchase {

    private int id;

    @NotNull
    @Size(min = 1, message = "First Name is required.")
    @Size(max = 100, message = "Name is too long (100 characters max).")
    private String firstname;

    @NotNull
    @Size(min = 1, message = "Last Name is required.")
    @Size(max = 100, message = "Name is too long (100 characters max).")
    private String lastname;

    @NotNull
    @Size(min = 1, message = "Email is required.")
    @Size(max = 100, message = "Email is too long (100 characters max).")
    private String email;

    @NotNull
    @Size(min = 1, message = "State is required.")
    @Size(max = 100, message = "State is too long (100 characters max).")

    @NotNull
    private String state;

    private boolean quickpick;
    
    private boolean ticketstatus;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(69)
    private int num1;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(69)
    private int num2;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(69)
    private int num3;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(69)
    private int num4;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(69)
    private int num5;

    @Digits(integer = 2, fraction = 0)
    @Min(1)
    @Max(26)
    private int num6;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isQuickpick() {
        return quickpick;
    }

    public void setQuickpick(boolean quickpick) {
        this.quickpick = quickpick;
    }

    public boolean isTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(boolean ticketstatus) {
        this.ticketstatus = ticketstatus;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.firstname);
        hash = 17 * hash + Objects.hashCode(this.lastname);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.state);
        hash = 17 * hash + (this.quickpick ? 1 : 0);
        hash = 17 * hash + (this.ticketstatus ? 1 : 0);
        hash = 17 * hash + this.num1;
        hash = 17 * hash + this.num2;
        hash = 17 * hash + this.num3;
        hash = 17 * hash + this.num4;
        hash = 17 * hash + this.num5;
        hash = 17 * hash + this.num6;
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
        final Purchase other = (Purchase) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quickpick != other.quickpick) {
            return false;
        }
        if (this.ticketstatus != other.ticketstatus) {
            return false;
        }
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
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    
}
