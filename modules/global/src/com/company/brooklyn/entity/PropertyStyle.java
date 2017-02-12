package com.company.brooklyn.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PropertyStyle implements EnumClass<String> {

    THREE_STORY("3 story - RH"),
    TWO_STORY("2 story - RH"),
    VACANT_LOT("Vacant Lot");

    private String id;

    PropertyStyle(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PropertyStyle fromId(String id) {
        for (PropertyStyle at : PropertyStyle.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}