package io.github.ytg1234.songsounds.util

import io.github.ytg1234.songsounds.base.song.Song

const val NO_SUCH_NOTE = 12234647.364f
var isEnabled = true
var currentSong: Song? = null
var index = 0
var section = 0

/**
 * Gets the next note and increases index.
 *
 * @return The next note.
 */
fun getNextNote(): Float {
    // idk what this code does, I wrote this months ago
    if (index >= currentSong!!.sections[section].notes.size) {
        index = 0
        section++
        if (section >= currentSong!!.sections.size) {
            section = 0
        }
    }
    if (currentSong!!.sections[section].notes[index] == NO_SUCH_NOTE) {
        index++
        if (index >= currentSong!!.sections[section].notes.size) {
            index = 0
            section++
            if (section >= currentSong!!.sections.size) {
                section = 0
            }
        }
    }
    val prevIndex = index
    index++
    return currentSong!!.sections[section].notes[prevIndex]
}
