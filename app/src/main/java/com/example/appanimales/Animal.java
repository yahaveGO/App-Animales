package com.example.appanimales;

public class Animal {
    private String nombre;
    private int drawableImageID;
    private String desc;

    public Animal(String nombre, int drawableImageID, String desc) {
        this.nombre = nombre;
        this.drawableImageID = drawableImageID;
        this.desc = desc;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getDrawableImageID() { return drawableImageID; }
    public void setDrawableImageID(int drawableImageID) { this.drawableImageID = drawableImageID; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

}
