# Song Sounds
Song Sounds aims to be a fun way to play songs.

## Caveats
Any note block contraptions you had before will turn into a mess, unless you toggle off the mod by using `/songsounds`

## How to install
Just follow the instructions on [FabricMC's website](https://fabricmc.net/use), install [Fabric API](https://curseforge.com/minecraft/mc-mods/fabric-api), and install this mod.

## Usage and Features
There aren't a lot of built-in songs in this mod, but there are some.

### How to play a song
* Just play any note on a noteblock, it works even with redstone!
* When you play a note, the mod forces the noteblock to play the next note in the current song!
* Once the song is over, it will just start again.

Note: The mod will completely ignore unknown notes (aside from a little warning in the game console). Useful for when you want to mark where specific lines are in songs. Look at [src/main/resources/data/songsounds/songs/rickroll.json](https://github.com/YTG1234/song-sounds/blob/master/src/main/resources/data/songsounds/songs/rickroll.json) for an example.

### How to switch songs
This mod adds a command, `/setsong <song>`, which allows you to switch to another song!
You need to have at least permission level 2 (The same permission level as command blocks).

Note: You can't switch to the `songsounds:empty` song, it is used internally. <br />
Note 2: Each time you `/reload`, the song is changed to `songsounds:rickroll` and the note and section are turned into `0`.

### How to switch to a specific note
This mod adds a command, `/note <section> <note>`, which allows you to switch to a note (specified by `<note>`), in a section speficied by `<section>`.

That means, the first note of the song will be: `/note 0 0`. This will start the song.
Useful when you're making a data pack and want to continue from where you left off.

### The built-in songs bore me, I want more!
You can do two things.
1. Make a custom Data Pack
1. Download the Song Extension Packs (WIP). Install them like any other mod.

## The Data Pack Structure
Song files (which are `.json` files), are located at `data/<namespace>/songs/` in a data pack, where `<namespace>` is **whatever custom namespace the datapack author chose**.
Song files can have any name, but they have to be `json` files.

### Song file Structure
`name` is The name of the Song. <br />
`sections` is a json array of Sections. <br />

Sections are json object that represent sections inside a song. <br />
Section file structure: <br />
`name` is the name of the Section. <br />
`notes` is a json array of Notes. <br />

Notes are string that represent Minecraft Note Block Notes. <br />
There are two ways to define a note: the named way and the letter way. <br />
Named notes are things like:
* DO_1
* RE_1
* MI_1
* FA_2
* FA_D_1
* FA_B_1

D = #, sharp <br />
B = b, flat <br />

Letter notes are things like:
* C_1
* D_1
* E_1
* F_2
* F_SHARP_1
* F_FLAT_1

An example C Major scale can be:
```json
{
    "name": "C Major scale",
    "sections": [
        {
            "name": "1",
            "notes": [
                "C_1",
                "D_1",
                "E_1",
                "F_1",
                "G_2",
                "A_2",
                "B_2",
                "C_2"
            ]
        }
    ]
}
```

or
```json
{
    "name": "C Major scale",
    "sections": [
        {
            "name": "1",
            "notes": [
                "DO_1",
                "RE_1",
                "MI_1",
                "FA_1",
                "SOL_2",
                "LA_2",
                "SI_2",
                "DO_2"
            ]
        }
    ]
}
```
You can also put named notes and letter notes in the same song, but why would you?
