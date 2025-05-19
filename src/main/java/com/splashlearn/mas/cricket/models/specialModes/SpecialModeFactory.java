package com.splashlearn.mas.cricket.models.specialModes;

import com.splashlearn.mas.cricket.enums.SpecialModeEnum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SpecialModeFactory {
    private static final Map<Integer, SpecialMode> specialModeMap = new HashMap<>();

    static {
        // Initialize all special modes
        specialModeMap.put(SpecialModeEnum.FREE_HIT.getId(), new FreeHitMode());
        specialModeMap.put(SpecialModeEnum.POWER_PLAY.getId(), new PowerPlayMode(new HashSet<>()));
        specialModeMap.put(SpecialModeEnum.WORLD_CUP.getId(), new WorldCupMode());
        specialModeMap.put(SpecialModeEnum.SUPER.getId(), new SuperMode());
    }

    /**
     * Gets a special mode by its ID
     * @param id The ID of the special mode
     * @return The corresponding SpecialMode instance
     */
    public static SpecialMode getSpecialMode(int id) {
        return specialModeMap.get(id);
    }

    /**
     * Gets a special mode by its type
     * @param type The SpecialModeType
     * @return The corresponding SpecialMode instance
     */
    public static SpecialMode getSpecialMode(SpecialModeEnum type) {
        return specialModeMap.get(type.getId());
    }

    /**
     * Gets the map of all special modes
     * @return Map of special modes with their IDs as keys
     */
    public static Map<Integer, SpecialMode> getAllSpecialModes() {
        return new HashMap<>(specialModeMap);
    }
}
