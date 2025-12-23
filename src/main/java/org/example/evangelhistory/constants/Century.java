package org.example.evangelhistory.constants;

public enum Century {
    XVI_CENTURY(1),
    XVII_XVIII_CENTURIES(2),
    XIX_CENTURY(3),
    XX_CENTURY(4),
    XXI_CENTURY(5);

    private final int centuryValue;

    Century (int centuryValue) {
        this.centuryValue = centuryValue;
    }
    public int getCenturyValue() {
        return centuryValue;
    }
}
