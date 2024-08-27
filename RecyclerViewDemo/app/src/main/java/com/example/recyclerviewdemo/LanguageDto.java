package com.example.recyclerviewdemo;

public class LanguageDto {

    private String name;
    private Integer foundedDate;

    public LanguageDto(String name, Integer foundedDate) {
        this.name = name;
        this.foundedDate = foundedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Integer foundedDate) {
        this.foundedDate = foundedDate;
    }

}
