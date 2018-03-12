package com.cherkassy.heroes.user;

public enum Role {

    ADMIN(1),
    USER(2);

    private final int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}