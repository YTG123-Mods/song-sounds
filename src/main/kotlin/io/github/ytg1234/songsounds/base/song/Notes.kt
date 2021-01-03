package io.github.ytg1234.songsounds.base.song

import io.github.ytg1234.songsounds.util.NO_SUCH_NOTE
import java.util.Locale
import kotlin.math.pow
import kotlin.reflect.full.staticProperties

object Notes {
    // region Named (Solfége)
    // region Octave 0
    val SOL_0 = calcNote(-23)
    val SOL_D_0 = calcNote(-22)
    val LA_0 = calcNote(-21)
    val SI_B_0 = calcNote(-20)
    val SI_0 = calcNote(-19)
    val DO_0 = calcNote(-18)
    val DO_D_0 = calcNote(-17)
    val RE_0 = calcNote(-16)
    val MI_B_0 = calcNote(-15)
    val MI_0 = calcNote(-14)
    val FA_0 = calcNote(-13)
    val FA_D_0 = calcNote(-12)

    // endregion
    // region Octave 1
    val SOL_1 = calcNote(-11)
    val SOL_D_1 = calcNote(-10)
    val LA_1 = calcNote(-9)
    val SI_B_1 = calcNote(-8)
    val SI_1 = calcNote(-7)
    val DO_1 = calcNote(-6)
    val DO_D_1 = calcNote(-5)
    val RE_1 = calcNote(-4)
    val MI_B_1 = calcNote(-3)
    val MI_1 = calcNote(-2)
    val FA_1 = calcNote(-1)
    val FA_D_1 = calcNote(0)

    // endregion
    // region Octave 2
    val SOL_2 = calcNote(1)
    val LA_B_2 = calcNote(2)
    val LA_2 = calcNote(3)
    val SI_B_2 = calcNote(4)
    val SI_2 = calcNote(5)
    val DO_2 = calcNote(6)
    val DO_D_2 = calcNote(7)
    val RE_2 = calcNote(8)
    val MI_B_2 = calcNote(9)
    val MI_2 = calcNote(10)
    val FA_2 = calcNote(11)
    val FA_D_2 = calcNote(12)

    // endregion
    // region Octave 3
    val SOL_3 = calcNote(13)
    val SOL_D_3 = calcNote(14)
    val LA_3 = calcNote(15)
    val SI_B_3 = calcNote(16)
    val SI_3 = calcNote(17)
    val DO_3 = calcNote(18)
    val DO_D_3 = calcNote(19)
    val RE_3 = calcNote(20)
    val MI_B_3 = calcNote(21)
    val MI_3 = calcNote(22)
    val FA_3 = calcNote(23)
    val FA_D_3 = calcNote(24)
    // endregion
    // endregion


    // region aliases
    val LA_D_2 = SI_B_2
    val SOL_B_1 = FA_D_0
    val LA_B_1 = SOL_D_1
    val LA_D_1 = SI_B_1
    val RE_B_1 = DO_D_1
    val RE_D_1 = MI_B_1
    val SOL_B_2 = FA_D_1
    val SOL_D_2 = LA_B_2
    val RE_B_2 = DO_D_2
    val RE_D_2 = MI_B_2

    val SOL_B_3 = FA_D_2

    val F_1 = FA_1
    val G_2 = SOL_2
    val C_1 = DO_1
    val A_2 = LA_2
    val C_2 = DO_2
    val B_F_2 = SI_B_2
    val A_S_2 = B_F_2
    val D_1 = RE_1
    val E_1 = MI_1
    val F_S_0 = FA_D_0
    val G_F_1 = F_S_0
    val G_1 = SOL_1
    val G_S_1 = SOL_D_1
    val A_F_1 = G_S_1
    val A_1 = LA_1
    val B_F_1 = SI_B_1
    val A_S_1 = B_F_1
    val B_1 = SI_1
    val C_S_1 = DO_D_1
    val D_F_1 = C_S_1
    val E_F_1 = MI_B_1
    val D_S_1 = E_F_1
    val F_S_1 = FA_D_1
    val G_F_2 = F_S_1
    val A_F_2 = LA_B_2
    val G_S_2 = A_F_2
    val B_2 = SI_2
    val C_S_2 = DO_D_2
    val D_F_2 = C_S_2
    val D_2 = RE_2
    val E_F_2 = MI_B_2
    val D_S_2 = E_F_2
    val E_2 = MI_2
    val F_2 = FA_2
    val F_S_2 = FA_D_2

    val LA_B_0 = SOL_D_0
    val LA_D_0 = SI_B_0
    val RE_B_0 = DO_D_0
    val RE_D_0 = MI_B_0

    val F_0 = FA_0
    val C_0 = DO_0
    val D_0 = RE_0
    val E_0 = MI_0
    val G_F_0 = F_S_0
    val G_0 = SOL_0
    val G_S_0 = SOL_D_0
    val A_F_0 = G_S_0
    val A_0 = LA_0
    val B_F_0 = SI_B_0
    val A_S_0 = B_F_0
    val B_0 = SI_0
    val C_S_0 = DO_D_0
    val D_F_0 = C_S_0
    val E_F_0 = MI_B_0
    val D_S_0 = E_F_0

    val SOL_B_4 = FA_D_3
    val G_F_4 = FA_D_3
    val LA_B_3 = SOL_D_3
    val LA_D_3 = SI_B_3
    val RE_B_3 = DO_D_3
    val RE_D_3 = MI_B_3

    val F_3 = FA_3
    val C_3 = DO_3
    val D_3 = RE_3
    val E_3 = MI_3
    val G_3 = SOL_3
    val G_S_3 = SOL_D_3
    val A_F_3 = G_S_3
    val A_3 = LA_3
    val B_F_3 = SI_B_3
    val A_S_3 = B_F_3
    val B_3 = SI_3
    val C_S_3 = DO_D_3
    val D_F_3 = C_S_3
    val E_F_3 = MI_B_3
    val D_S_3 = E_F_3
    val F_S_3 = FA_D_3

    // Generic alias code
    //
    // val SOL_B_2 = FA_D_1;
    // val G_F_2 = FA_D_1;
    // val LA_B_1 = SOL_D_1;
    // val LA_D_1 = SI_B_1;
    // val RE_B_1 = DO_D_1;
    // val RE_D_1 = MI_B_1;
    //
    // val F_1 = FA_1;
    // val C_1 = DO_1;
    // val D_1 = RE_1;
    // val E_1 = MI_1;
    // val G_1 = SOL_1;
    // val G_S_1 = SOL_D_1;
    // val A_F_1 = G_S_1;
    // val A_1 = LA_1;
    // val B_F_1 = SI_B_1;
    // val A_S_1 = B_F_1;
    // val B_1 = SI_1;
    // val C_S_1 = DO_D_1;
    // val D_F_1 = C_S_1;
    // val E_F_1 = MI_B_1;
    // val D_S_1 = E_F_1;
    // val F_S_1 = FA_D_1;
    // endregion

    operator fun get(s: String): Float {
        Notes::class.staticProperties.forEach {
            if (it.get() is Float && it.name == s.toUpperCase(Locale.ENGLISH)) {
                return it.get() as Float
            }
        }
        return NO_SUCH_NOTE
    }

    private fun calcNote(pow: Int): Float {
        return 2.0.pow(pow / 12.0).toFloat()
    }
}
