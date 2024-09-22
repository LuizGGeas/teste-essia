package com.file.teste.essia.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    public abstract Long getId();

    public abstract void setId(Long id);
}
