package ru.shvedov;

public class RecipeData {
    private final String shotDiscription;
    private final String fullDiscription;
    private final String ingridients;

    public RecipeData(String shotDiscrip, String fullDiscrip, String ingrid){
        this.shotDiscription = shotDiscrip;
        this.fullDiscription = fullDiscrip;
        this.ingridients = ingrid;
    }

    public String getFullDiscription() {
        return fullDiscription;
    }

    public String getIngridients() {
        return ingridients;
    }

    public String getShotDiscription() {
        return shotDiscription;
    }
}
