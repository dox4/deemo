package com.study.deemo.object;

import com.study.deemo.ast.PrimaryExpr;


public final class DmNumber extends DmAbstractObject<Double> implements PrimaryExpr {
    public final static DmNumber[] CACHED_SMALL_NUMBERS = cacheSmallNumbers();
    public static DmNumber ZERO = DmNumber.of(0);

    DmNumber(double value) {
        super(value);
    }

    public static DmNumber of(double n) {
        double floorN = Math.floor(n);
        if (floorN == n && floorN <= 128D) {
            return CACHED_SMALL_NUMBERS[(int) floorN];
        }
        return new DmNumber(n);
    }

    private static DmNumber[] cacheSmallNumbers() {
        final int maxSmallNumber = 128;
        DmNumber[] numbers = new DmNumber[maxSmallNumber];
        for (int i = 0; i < maxSmallNumber; i++) {
            numbers[i] = new DmNumber(i);
        }
        return numbers;
    }

    public DmType type() {
        return DmType.NUMBER;
    }

    @Override
    public boolean asBoolean() {
        return value != 0d;
    }

}
