package com.gainstar.api.util;

import com.gainstar.api.entity.action.PowerGroup;

import java.util.Arrays;

public class EnumValidator {
    public static boolean isValidPowerGroup(String value) {
        return Arrays.stream(PowerGroup.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(value));
    }

}
