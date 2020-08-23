package com.ytg123.songsounds.util;

import com.ytg123.songsounds.song.Song;

public final class ModVars {
    public static boolean isEnabled;
    public static Song currentSong;

    public static int index;
    public static int section;

    public static final float NoSuchNote = 12234647.364f;

    static {
        isEnabled = true;
        index = 0;
        section = 0;
    }
}
