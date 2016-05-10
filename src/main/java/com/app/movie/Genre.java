package com.app.movie;

public enum Genre {
    Action("Action"),
    Adventure("Adventure"),
    Comedy("Comedy"),
    Drama("Drama"),
    Horror("Horror"),
    Scifi("Scifi"),
    Fantasy("Fantasy"),
    Historical("Historical"),
    Mystery("Action"),
    Romance("Mystery"),
    Thriller("Thriller"),
    Animation("Animation");

    private final String name;

    private Genre(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
