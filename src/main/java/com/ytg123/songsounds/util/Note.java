package com.ytg123.songsounds.util;

import com.google.gson.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public abstract class Note {
    public static final float FA_1 = 0.943874f;
    public static final float SOL_2 = 1.059463f;
    public static final float DO_1 = 0.707107f;
    public static final float LA_2 = 1.189207f;
    public static final float DO_2 = 1.414214f;
    public static final float SI_B_2 = 1.259921f;
    public static final float RE_1 = 0.793701f;
    public static final float MI_1 = 0.890899f;

    public static final float F_1 = FA_1;
    public static final float G_2 = SOL_2;
    public static final float C_1 = DO_1;
    public static final float A_2 = LA_2;
    public static final float C_2 = DO_2;
    public static final float B_FLAT_2 = SI_B_2;
    public static final float D_1 = RE_1;
    public static final float E_1 = MI_1;


    public static float fromString(String src) throws NoSuchFieldException, IllegalAccessException {
        Field field = Note.class.getDeclaredField(src);
        field.setAccessible(true);
        return (float)field.get(null);
    }
}
