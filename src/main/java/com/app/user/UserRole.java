package com.app.user;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String name;

    private UserRole(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
