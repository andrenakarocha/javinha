package com.dasa.dasa.domain.VOs;

import java.util.Objects;

import com.dasa.dasa.utils.StringParser;

public final class Barcode {

    private final String value;

    public Barcode(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid Brazilian barcode (EAN-13)");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barcode)) return false;
        Barcode barcode = (Barcode) o;
        return Objects.equals(value, barcode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    private boolean isValid(String value) {
        if(StringParser.isEmptyOrNull(value)){
            return false;
        }

        if (!this.isValidBarCodeRegex(value)) {
            return false;
        }

        if(!checkDigitIsValid(value)) {
            return false;
        }

        return true;
    }

    private boolean isValidBarCodeRegex(String value){
        return value.matches("\\d{13}");
    }

    // Validate EAN-13 check digit
    private boolean checkDigitIsValid(String barcode) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(barcode.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit == Character.getNumericValue(barcode.charAt(12));
    }
}