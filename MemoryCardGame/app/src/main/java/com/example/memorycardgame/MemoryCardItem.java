package com.example.memorycardgame;

public class MemoryCardItem {

    private String cardContent;
    private Integer id;
    private int color;
    private boolean isSelected = false;

    public MemoryCardItem(String cardContent, Integer id, int color) {
        this.cardContent = cardContent;
        this.id = id;
        this.color = color;
    }

    public MemoryCardItem(String cardContent, Integer id) {
        this.cardContent = cardContent;
        this.id = id;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
