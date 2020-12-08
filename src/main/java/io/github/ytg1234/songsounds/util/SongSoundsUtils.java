package io.github.ytg1234.songsounds.util;

import io.github.ytg1234.songsounds.base.song.Song;
import net.minecraft.world.World;

public final class SongSoundsUtils {
    public static boolean isEnabled;
    public static Song currentSong;

    public static int index;
    public static int section;

    public static final float NoSuchNote = 12234647.364f;

    static {
        index = 0;
        section = 0;
        isEnabled = true;
        currentSong = null;
    }

    /**
     * Gets the next note and increases index.
     * @return The next note.
     */
    public static float getNextNote() {
        // idk what this code does, I wrote this months ago
        if (index >= currentSong.sections[section].notes.length) {
            index = 0;
            section++;
            if (section >= currentSong.sections.length) {
                section = 0;
            }
        }
        if (currentSong.sections[section].notes[index] == NoSuchNote) {
            index++;
            if (index >= currentSong.sections[section].notes.length) {
                index = 0;
                section++;
                if (section >= currentSong.sections.length) {
                    section = 0;
                }
            }
        }
        int prevIndex = index;
        index++;
        return currentSong.sections[section].notes[prevIndex];
    }
}
