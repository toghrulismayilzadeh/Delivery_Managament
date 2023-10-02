package com.div.model.enums;

import lombok.Getter;

@Getter
public enum Type {
    ADMIN(1L),
    SELLER(2L),
    CUSTOMER(3L),
    DRIVER(4L);

    public final long id;

    Type(Long id) {
        this.id = id;
    }
}
