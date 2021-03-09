package com.ramirezf.restaurant.clases;

public class PastasM {
    public String nameP;
    //ublic String sizeP;
    public int imgP;
    public double precio;
    public String description;

    public PastasM() {
    }

    public PastasM(String nameP, String description, double precio, int imgP) {
        this.nameP = nameP;
        this.description = description;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
