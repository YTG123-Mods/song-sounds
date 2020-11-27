package io.github.ytg1234.songsounds.base.song;

public abstract class Notes {
    // region Named (Solfége)
    // region Octave 0
    public static final float SOL_0 = calcNote(-23);
    public static final float SOL_D_0 = calcNote(-22);
    public static final float LA_0 = calcNote(-21);
    public static final float SI_B_0 = calcNote(-20);
    public static final float SI_0 = calcNote(-19);
    public static final float DO_0 = calcNote(-18);
    public static final float DO_D_0 = calcNote(-17);
    public static final float RE_0 = calcNote(-16);
    public static final float MI_B_0 = calcNote(-15);
    public static final float MI_0 = calcNote(-14);
    public static final float FA_0 = calcNote(-13);
    public static final float FA_D_0 = calcNote(-12);
    // endregion
    // region Octave 1
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
    // region Octave 2
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
    // region Octave 3
    public static final float SOL_3 = calcNote(13);
    public static final float SOL_D_3 = calcNote(14);
    public static final float LA_3 = calcNote(15);
    public static final float SI_B_3 = calcNote(16);
    public static final float SI_3 = calcNote(17);
    public static final float DO_3 = calcNote(18);
    public static final float DO_D_3 = calcNote(19);
    public static final float RE_3 = calcNote(20);
    public static final float MI_B_3 = calcNote(21);
    public static final float MI_3 = calcNote(22);
    public static final float FA_3 = calcNote(23);
    public static final float FA_D_3 = calcNote(24);
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

    public static final float LA_B_0 = SOL_D_0;
    public static final float LA_D_0 = SI_B_0;
    public static final float RE_B_0 = DO_D_0;
    public static final float RE_D_0 = MI_B_0;

    public static final float F_0 = FA_0;
    public static final float C_0 = DO_0;
    public static final float D_0 = RE_0;
    public static final float E_0 = MI_0;
    public static final float G_F_0 = F_S_0;
    public static final float G_0 = SOL_0;
    public static final float G_S_0 = SOL_D_0;
    public static final float A_F_0 = G_S_0;
    public static final float A_0 = LA_0;
    public static final float B_F_0 = SI_B_0;
    public static final float A_S_0 = B_F_0;
    public static final float B_0 = SI_0;
    public static final float C_S_0 = DO_D_0;
    public static final float D_F_0 = C_S_0;
    public static final float E_F_0 = MI_B_0;
    public static final float D_S_0 = E_F_0;

    public static final float SOL_B_4 = FA_D_3;
    public static final float G_F_4 = FA_D_3;
    public static final float LA_B_3 = SOL_D_3;
    public static final float LA_D_3 = SI_B_3;
    public static final float RE_B_3 = DO_D_3;
    public static final float RE_D_3 = MI_B_3;

    public static final float F_3 = FA_3;
    public static final float C_3 = DO_3;
    public static final float D_3 = RE_3;
    public static final float E_3 = MI_3;
    public static final float G_3 = SOL_3;
    public static final float G_S_3 = SOL_D_3;
    public static final float A_F_3 = G_S_3;
    public static final float A_3 = LA_3;
    public static final float B_F_3 = SI_B_3;
    public static final float A_S_3 = B_F_3;
    public static final float B_3 = SI_3;
    public static final float C_S_3 = DO_D_3;
    public static final float D_F_3 = C_S_3;
    public static final float E_F_3 = MI_B_3;
    public static final float D_S_3 = E_F_3;
    public static final float F_S_3 = FA_D_3;


    // Generic alias code
    //
    // public static final float SOL_B_2 = FA_D_1;
    // public static final float G_F_2 = FA_D_1;
    // public static final float LA_B_1 = SOL_D_1;
    // public static final float LA_D_1 = SI_B_1;
    // public static final float RE_B_1 = DO_D_1;
    // public static final float RE_D_1 = MI_B_1;
    //
    // public static final float F_1 = FA_1;
    // public static final float C_1 = DO_1;
    // public static final float D_1 = RE_1;
    // public static final float E_1 = MI_1;
    // public static final float G_1 = SOL_1;
    // public static final float G_S_1 = SOL_D_1;
    // public static final float A_F_1 = G_S_1;
    // public static final float A_1 = LA_1;
    // public static final float B_F_1 = SI_B_1;
    // public static final float A_S_1 = B_F_1;
    // public static final float B_1 = SI_1;
    // public static final float C_S_1 = DO_D_1;
    // public static final float D_F_1 = C_S_1;
    // public static final float E_F_1 = MI_B_1;
    // public static final float D_S_1 = E_F_1;
    // public static final float F_S_1 = FA_D_1;
    // endregion

    private static float calcNote(int poww) {
        return (float) Math.pow(2.0, poww / 12.0);
    }
}
