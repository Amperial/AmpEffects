/*
 * This file is part of AmpEffects.
 *
 * Copyright (c) 2014 <http://github.com/ampayne2/>
 *
 * AmpEffects is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AmpEffects is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AmpEffects.  If not, see <http://www.gnu.org/licenses/>.
 */
package ninja.amp.ampeffects.effects.sounds;

import ninja.amp.ampeffects.Effect;
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
