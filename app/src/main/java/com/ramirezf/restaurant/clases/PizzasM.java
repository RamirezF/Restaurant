package com.ramirezf.restaurant.clases;

public class PizzasM {
    public String nameP;
    //ublic String sizeP;
    public int imgP;
    public String description;

    public PizzasM() {
    }

    public PizzasM(String nameP, String description, int imgP) {
        this.nameP = nameP;
        this.description = description;
        this.imgP = imgP;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getNameP() {
        return nameP;
    }
    public void setNameP(String nameP) {
        this.nameP = nameP;
    }
    public int getImgP() {
        return imgP;
    }
    public void setImgP(int imgP) {
        this.imgP = imgP;
    }
}
