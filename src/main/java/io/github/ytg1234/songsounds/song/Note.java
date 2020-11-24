package io.github.ytg1234.songsounds.song;

public abstract class Note {
    // region Named (Solfége)
    public static final float FA_D_0 = calcNote(-12);
    // region First Octave
    public static final float SOL_1 = calcNote(-11);
    public static final float SOL_D_1 = calcNote(-10);
    public static final float LA_1 = calcNote(-9);
    public static final float SI_B_1 = calcNote(-8);
    public static final float SI_1 = calcNote(-7);
    public static final float DO_1 = calcNote(-6);
    public static final float DO_D_1 = calcNote(-5);
    public static final float RE_1 = calcNote(-4);
    public static final float MI_B_1 = calcNote(-3);
    public static final float MI_1 = calcNote(-2);
    public static final float FA_1 = calcNote(-1);
    public static final float FA_D_1 = calcNote(0);
    // endregion
    // region Second Octave
    public static final float SOL_2 = calcNote(1);
    public static final float LA_B_2 = calcNote(2);
    public static final float LA_2 = calcNote(3);
    public static final float SI_B_2 = calcNote(4);
    public static final float SI_2 = calcNote(5);
    public static final float DO_2 = calcNote(6);
    public static final float DO_D_2 = calcNote(7);
    public static final float RE_2 = calcNote(8);
    public static final float MI_B_2 = calcNote(9);
    public static final float MI_2 = calcNote(10);
    public static final float FA_2 = calcNote(11);
    public static final float FA_D_2 = calcNote(12);
    // endregion
    // endregion


    // region aliases
    public static final float LA_D_2 = SI_B_2;
    public static final float SOL_B_1 = FA_D_0;
    public static final float LA_B_1 = SOL_D_1;
    public static final float LA_D_1 = SI_B_1;
    public static final float RE_B_1 = DO_D_1;
    public static final float RE_D_1 = MI_B_1;
    public static final float SOL_B_2 = FA_D_1;
    public static final float SOL_D_2 = LA_B_2;
    public static final float RE_B_2 = DO_D_2;
    public static final float RE_D_2 = MI_B_2;

    public static final float SOL_B_3 = FA_D_2;

    public static final float F_1 = FA_1;
    public static final float G_2 = SOL_2;
    public static final float C_1 = DO_1;
    public static final float A_2 = LA_2;
    public static final float C_2 = DO_2;
    public static final float B_F_2 = SI_B_2;
    public static final float A_S_2 = B_F_2;
    public static final float D_1 = RE_1;
    public static final float E_1 = MI_1;
    public static final float F_S_0 = FA_D_0;
    public static final float G_F_1 = F_S_0;
    public static final float G_1 = SOL_1;
    public static final float G_S_1 = SOL_D_1;
    public static final float A_F_1 = G_S_1;
    public static final float A_1 = LA_1;
    public static final float B_F_1 = SI_B_1;
    public static final float A_S_1 = B_F_1;
    public static final float B_1 = SI_1;
    public static final float C_S_1 = DO_D_1;
    public static final float D_F_1 = C_S_1;
    public static final float E_F_1 = MI_B_1;
    public static final float D_S_1 = E_F_1;
    public static final float F_S_1 = FA_D_1;
    public static final float G_F_2 = F_S_1;
    public static final float A_F_2 = LA_B_2;
    public static final float G_S_2 = A_F_2;
    public static final float B_2 = SI_2;
    public static final float C_S_2 = DO_D_2;
    public static final float D_F_2 = C_S_2;
    public static final float D_2 = RE_2;
    public static final float E_F_2 = MI_B_2;
    public static final float D_S_2 = E_F_2;
    public static final float E_2 = MI_2;
    public static final float F_2 = FA_2;
    public static final float F_S_2 = FA_D_2;
    // endregion

    private static float calcNote(int poww) {
        return (float) Math.pow(2.0, poww/12.0);
    }
}
