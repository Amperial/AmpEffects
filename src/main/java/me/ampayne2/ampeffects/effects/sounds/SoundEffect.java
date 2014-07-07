package me.ampayne2.ampeffects.effects.sounds;

import me.ampayne2.ampeffects.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Holds the information needed to play a sound to simplify playing it.
 */
public class SoundEffect implements Effect {
    private Sound sound;
    private float volume;
    private float pitch;

    /**
     * Creates a new SoundEffect.
     *
     * @param sound  The sound.
     * @param volume The volume of the sound.
     * @param pitch  The pitch of the sound.
     */
    public SoundEffect(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    /**
     * Gets the SoundEffect's sound.
     *
     * @return The sound.
     */
    public Sound getSound() {
        return sound;
    }

    /**
     * Sets the SoundEffect's sound.
     *
     * @param sound The sound.
     * @return The SoundEffect
     */
    public SoundEffect setSound(Sound sound) {
        this.sound = sound;
        return this;
    }

    /**
     * Gets the SoundEffect's volume.
     *
     * @return The volume.
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Sets the SoundEffect's volume.
     *
     * @param volume The volume.
     * @return The SoundEffect.
     */
    public SoundEffect setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Gets the SoundEffect's pitch.
     *
     * @return The pitch.
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * Sets the SoundEffect's pitch.
     *
     * @param pitch The pitch.
     * @return The SoundEffect.
     */
    public SoundEffect setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    @Override
    public Effect play(Location location) {
        location.getWorld().playSound(location, sound, volume, pitch);
        return this;
    }

    @Override
    public Effect play(Location location, Player... players) {
        for (Player player : players) {
            player.playSound(location, sound, volume, pitch);
        }
        return this;
    }
}
