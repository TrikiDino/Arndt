package com.web.arndt;

public class Katalog {
    private String imgName;
    private String katGrupText;

    public Katalog(String imgName, String katGrupText){
        this.imgName = imgName;
        this.katGrupText = katGrupText;
    }

    public String getImgName(){
        return imgName;
    }

    public String getKatGrupText(){
        return katGrupText;
    }

    public void setImgName(String imgName){
        this.imgName = imgName;
    }

    public void setKatGrupText(String katGrupText){
        this.katGrupText = katGrupText;
    }

    @Override
    public String toString() {
        return "http://www.arndt-tool.de/imgapp/menu/" + imgName;
    }
}
