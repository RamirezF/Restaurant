package com.ramirezf.restaurant.clases;

public class ExtrasM {
    public String nameP;
    //ublic String sizeP;
    public int imgP;
    public String description;
    public double precio;

    public ExtrasM() {
    }

    public ExtrasM(String nameP, String description, double precio, int imgP) {
        this.nameP = nameP;
        this.description = description;
        this.imgP = imgP;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
