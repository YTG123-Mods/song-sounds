package io.github.ytg1234.songsounds.base.song

import io.github.ytg1234.songsounds.util.NO_SUCH_NOTE
import java.util.Locale
import kotlin.math.pow
import kotlin.reflect.full.staticProperties

object Notes {
    // region Named (Solfége)
    // region Octave 0
    @JvmField val SOL_0 = calcNote(-23)
    @JvmField val SOL_D_0 = calcNote(-22)
    @JvmField val LA_0 = calcNote(-21)
    @JvmField val SI_B_0 = calcNote(-20)
    @JvmField val SI_0 = calcNote(-19)
    @JvmField val DO_0 = calcNote(-18)
    @JvmField val DO_D_0 = calcNote(-17)
    @JvmField val RE_0 = calcNote(-16)
    @JvmField val MI_B_0 = calcNote(-15)
    @JvmField val MI_0 = calcNote(-14)
    @JvmField val FA_0 = calcNote(-13)
    @JvmField val FA_D_0 = calcNote(-12)

    // endregion
    // region Octave 1
    @JvmField val SOL_1 = calcNote(-11)
    @JvmField val SOL_D_1 = calcNote(-10)
    @JvmField val LA_1 = calcNote(-9)
    @JvmField val SI_B_1 = calcNote(-8)
    @JvmField val SI_1 = calcNote(-7)
    @JvmField val DO_1 = calcNote(-6)
    @JvmField val DO_D_1 = calcNote(-5)
    @JvmField val RE_1 = calcNote(-4)
    @JvmField val MI_B_1 = calcNote(-3)
    @JvmField val MI_1 = calcNote(-2)
    @JvmField val FA_1 = calcNote(-1)
    @JvmField val FA_D_1 = calcNote(0)

    // endregion
    // region Octave 2
    @JvmField val SOL_2 = calcNote(1)
    @JvmField val LA_B_2 = calcNote(2)
    @JvmField val LA_2 = calcNote(3)
    @JvmField val SI_B_2 = calcNote(4)
    @JvmField val SI_2 = calcNote(5)
    @JvmField val DO_2 = calcNote(6)
    @JvmField val DO_D_2 = calcNote(7)
    @JvmField val RE_2 = calcNote(8)
    @JvmField val MI_B_2 = calcNote(9)
    @JvmField val MI_2 = calcNote(10)
    @JvmField val FA_2 = calcNote(11)
    @JvmField val FA_D_2 = calcNote(12)

    // endregion
    // region Octave 3
    @JvmField val SOL_3 = calcNote(13)
    @JvmField val SOL_D_3 = calcNote(14)
    @JvmField val LA_3 = calcNote(15)
    @JvmField val SI_B_3 = calcNote(16)
    @JvmField val SI_3 = calcNote(17)
    @JvmField val DO_3 = calcNote(18)
    @JvmField val DO_D_3 = calcNote(19)
    @JvmField val RE_3 = calcNote(20)
    @JvmField val MI_B_3 = calcNote(21)
    @JvmField val MI_3 = calcNote(22)
    @JvmField val FA_3 = calcNote(23)
    @JvmField val FA_D_3 = calcNote(24)
    // endregion
    // endregion


    // region aliases
    @JvmField val LA_D_2 = SI_B_2
    @JvmField val SOL_B_1 = FA_D_0
    @JvmField val LA_B_1 = SOL_D_1
    @JvmField val LA_D_1 = SI_B_1
    @JvmField val RE_B_1 = DO_D_1
    @JvmField val RE_D_1 = MI_B_1
    @JvmField val SOL_B_2 = FA_D_1
    @JvmField val SOL_D_2 = LA_B_2
    @JvmField val RE_B_2 = DO_D_2
    @JvmField val RE_D_2 = MI_B_2

    @JvmField val SOL_B_3 = FA_D_2

    @JvmField val F_1 = FA_1
    @JvmField val G_2 = SOL_2
    @JvmField val C_1 = DO_1
    @JvmField val A_2 = LA_2
    @JvmField val C_2 = DO_2
    @JvmField val B_F_2 = SI_B_2
    @JvmField val A_S_2 = B_F_2
    @JvmField val D_1 = RE_1
    @JvmField val E_1 = MI_1
    @JvmField val F_S_0 = FA_D_0
    @JvmField val G_F_1 = F_S_0
    @JvmField val G_1 = SOL_1
    @JvmField val G_S_1 = SOL_D_1
    @JvmField val A_F_1 = G_S_1
    @JvmField val A_1 = LA_1
    @JvmField val B_F_1 = SI_B_1
    @JvmField val A_S_1 = B_F_1
    @JvmField val B_1 = SI_1
    @JvmField val C_S_1 = DO_D_1
    @JvmField val D_F_1 = C_S_1
    @JvmField val E_F_1 = MI_B_1
    @JvmField val D_S_1 = E_F_1
    @JvmField val F_S_1 = FA_D_1
    @JvmField val G_F_2 = F_S_1
    @JvmField val A_F_2 = LA_B_2
    @JvmField val G_S_2 = A_F_2
    @JvmField val B_2 = SI_2
    @JvmField val C_S_2 = DO_D_2
    @JvmField val D_F_2 = C_S_2
    @JvmField val D_2 = RE_2
    @JvmField val E_F_2 = MI_B_2
    @JvmField val D_S_2 = E_F_2
    @JvmField val E_2 = MI_2
    @JvmField val F_2 = FA_2
    @JvmField val F_S_2 = FA_D_2

    @JvmField val LA_B_0 = SOL_D_0
    @JvmField val LA_D_0 = SI_B_0
    @JvmField val RE_B_0 = DO_D_0
    @JvmField val RE_D_0 = MI_B_0

    @JvmField val F_0 = FA_0
    @JvmField val C_0 = DO_0
    @JvmField val D_0 = RE_0
    @JvmField val E_0 = MI_0
    @JvmField val G_F_0 = F_S_0
    @JvmField val G_0 = SOL_0
    @JvmField val G_S_0 = SOL_D_0
    @JvmField val A_F_0 = G_S_0
    @JvmField val A_0 = LA_0
    @JvmField val B_F_0 = SI_B_0
    @JvmField val A_S_0 = B_F_0
    @JvmField val B_0 = SI_0
    @JvmField val C_S_0 = DO_D_0
    @JvmField val D_F_0 = C_S_0
    @JvmField val E_F_0 = MI_B_0
    @JvmField val D_S_0 = E_F_0

    @JvmField val SOL_B_4 = FA_D_3
    @JvmField val G_F_4 = FA_D_3
    @JvmField val LA_B_3 = SOL_D_3
    @JvmField val LA_D_3 = SI_B_3
    @JvmField val RE_B_3 = DO_D_3
    @JvmField val RE_D_3 = MI_B_3

    @JvmField val F_3 = FA_3
    @JvmField val C_3 = DO_3
    @JvmField val D_3 = RE_3
    @JvmField val E_3 = MI_3
    @JvmField val G_3 = SOL_3
    @JvmField val G_S_3 = SOL_D_3
    @JvmField val A_F_3 = G_S_3
    @JvmField val A_3 = LA_3
    @JvmField val B_F_3 = SI_B_3
    @JvmField val A_S_3 = B_F_3
    @JvmField val B_3 = SI_3
    @JvmField val C_S_3 = DO_D_3
    @JvmField val D_F_3 = C_S_3
    @JvmField val E_F_3 = MI_B_3
    @JvmField val D_S_3 = E_F_3
    @JvmField val F_S_3 = FA_D_3

    // Generic alias code
    //
    // @JvmField val SOL_B_2 = FA_D_1;
    // @JvmField val G_F_2 = FA_D_1;
    // @JvmField val LA_B_1 = SOL_D_1;
    // @JvmField val LA_D_1 = SI_B_1;
    // @JvmField val RE_B_1 = DO_D_1;
    // @JvmField val RE_D_1 = MI_B_1;
    //
    //@JvmField  val F_1 = FA_1;
    // @JvmField val C_1 = DO_1;
    // @JvmField val D_1 = RE_1;
    // @JvmField val E_1 = MI_1;
    // @JvmField val G_1 = SOL_1;
    // @JvmField val G_S_1 = SOL_D_1;
    // @JvmField val A_F_1 = G_S_1;
    // @JvmField val A_1 = LA_1;
    // @JvmField val B_F_1 = SI_B_1;
    // @JvmField val A_S_1 = B_F_1;
    // @JvmField val B_1 = SI_1;
    // @JvmField val C_S_1 = DO_D_1;
    // @JvmField val D_F_1 = C_S_1;
    // @JvmField val E_F_1 = MI_B_1;
    // @JvmField val D_S_1 = E_F_1;
    // @JvmField val F_S_1 = FA_D_1;
    // endregion

    operator fun get(s: String): Float {
        return try {
            Notes::class.java.getDeclaredField(s.toUpperCase(Locale.ENGLISH)).get(null) as Float
        } catch (e: ClassCastException) {
            NO_SUCH_NOTE
        } catch (e: NoSuchFieldException) {
            NO_SUCH_NOTE
        }
    }

    private fun calcNote(pow: Int): Float {
        return 2.0.pow(pow / 12.0).toFloat()
    }
}
