package com.ytg123.songsounds.util;

import com.ytg123.songsounds.SongSounds;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;

public abstract class Note {
    public static final float FA_1 = 0.943874f;
    public static final float SOL_2 = 1.059463f;
    public static final float DO_1 = 0.707107f;
    public static final float LA_2 = 1.189207f;
    public static final float DO_2 = 1.414214f;
    public static final float SI_B_2 = 1.259921f;
    public static final float LA_D_2 = SI_B_2;
    public static final float RE_1 = 0.793701f;
    public static final float MI_1 = 0.890899f;
    public static final float FA_D_0 = 0.5f;
    public static final float SOL_B_1 = FA_D_0;
    public static final float SOL_1 = 0.529732f;
    public static final float SOL_D_1 = 0.561231f;
    public static final float LA_B_1 = SOL_D_1;
    public static final float LA_1 = 0.594604f;
    public static final float SI_B_1 = 0.629961f;
    public static final float LA_D_1 = SI_B_1;
    public static final float SI_1 = 0.667420f;
    public static final float DO_D_1 = 0.749154f;
    public static final float RE_B_1 = DO_D_1;
    public static final float MI_B_1 = 0.840896f;
    public static final float RE_D_1 = MI_B_1;
    public static final float FA_D_1 = 1f;
    public static final float SOL_B_2 = FA_D_1;
    public static final float LA_B_2 = 1.122462f;
    public static final float SOL_D_2 = LA_B_2;
    public static final float SI_2 = 1.334840f;
    public static final float DO_D_2 = 1.498307f;
    public static final float RE_B_2 = DO_D_2;
    public static final float RE_2 = 1.587401f;
    public static final float MI_B_2 = 1.681793f;
    public static final float RE_D_2 = MI_B_2;
    public static final float MI_2 = 1.781797f;
    public static final float FA_2 = 1.887749f;
    public static final float FA_D_2 = 2f;

    public static final float F_1 = FA_1;
    public static final float G_2 = SOL_2;
    public static final float C_1 = DO_1;
    public static final float A_2 = LA_2;
    public static final float C_2 = DO_2;
    public static final float B_FLAT_2 = SI_B_2;
    public static final float A_SHARP_2 = B_FLAT_2;
    public static final float D_1 = RE_1;
    public static final float E_1 = MI_1;
    public static final float F_SHARP_0 = FA_D_0;
    public static final float G_FLAT_1 = F_SHARP_0;
    public static final float G_1 = SOL_1;
    public static final float G_SHARP_1 = SOL_D_1;
    public static final float A_FLAT_1 = G_SHARP_1;
    public static final float A_1 = LA_1;
    public static final float B_FLAT_1 = SI_B_1;
    public static final float LA_SHARP_1 = B_FLAT_1;
    public static final float B_1 = SI_1;
    public static final float C_SHARP_1 = DO_D_1;
    public static final float D_FLAT_1 = C_SHARP_1;
    public static final float E_FLAT_1 = MI_B_1;
    public static final float D_SHARP_1 = E_FLAT_1;
    public static final float F_SHARP_1 = FA_D_1;
    public static final float G_FLAT_2 = F_SHARP_1;
    public static final float A_FLAT_2 = LA_B_2;
    public static final float G_SHARP_2 = A_FLAT_2;
    public static final float B_2 = SI_2;
    public static final float C_SHARP_2 = DO_D_2;
    public static final float D_FLAT_2 = C_SHARP_2;
    public static final float D_2 = RE_2;
    public static final float E_FLAT_2 = MI_B_2;
    public static final float D_SHARP_2 = E_FLAT_2;
    public static final float E_2 = MI_2;
    public static final float F_2 = FA_2;
    public static final float F_SHARP_2 = FA_D_2;


    public static float fromString(String src) {
        Field field = null;
        try {
            field = Note.class.getDeclaredField(src);
        } catch (NoSuchFieldException e) {
            SongSounds.log(Level.INFO, "Note " + src + " Doesn't exist!");
        }
        field.setAccessible(true);
        try {
            return (float)field.get(null);
        } catch (IllegalAccessException e) {
            return Float.NaN;
        }
    }
}
