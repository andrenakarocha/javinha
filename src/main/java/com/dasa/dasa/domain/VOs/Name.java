package com.dasa.dasa.domain.VOs;

import java.util.Objects;
import com.dasa.dasa.utils.StringParser;

public final class Name {

    private final String value;

    public Name(String value) {
        this.validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    private void validate(String value){
        if(StringParser.isEmptyOrNull(value)) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}