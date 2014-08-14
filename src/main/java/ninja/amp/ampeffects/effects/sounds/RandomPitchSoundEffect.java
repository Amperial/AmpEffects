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

import java.util.Random;

/**
 * A {@link SoundEffect} that chooses a random pitch to play at.
 */
public class RandomPitchSoundEffect extends SoundEffect {
    private float minPitch;
    private float maxPitch;

    private static final Random RANDOM = new Random();

    /**
     * Creates a new RandomPitchSoundEffect.
     *
     * @param sound    The sound.
     * @param volume   The volume of the sound.
     * @param minPitch The minimum pitch of the sound.
     * @param maxPitch The maximum pitch of the sound.
     */
    public RandomPitchSoundEffect(Sound sound, float volume, float minPitch, float maxPitch) {
        super(sound, volume, 1);
        this.minPitch = minPitch;
        this.maxPitch = maxPitch;
    }

    /**
     * Creates a new RandomPitchSoundEffect with the default minimum and maximum pitch.
     *
     * @param sound  The sound.
     * @param volume The volume of the sound.
     */
    public RandomPitchSoundEffect(Sound sound, float volume) {
        this(sound, volume, 0, 2);
    }

    /**
     * Sets the RandomPitchSoundEffect's minimum pitch.
     *
     * @param minPitch The minimum pitch.
     * @return The RandomPitchGameSound.
     */
    public RandomPitchSoundEffect setMinimumPitch(float minPitch) {
        this.minPitch = minPitch;
        return this;
    }

    /**
     * Sets the RandomPitchSoundEffect's maximum pitch.
     *
     * @param maxPitch The maximum pitch.
     * @return The RandomPitchGameSound.
     */
    public RandomPitchSoundEffect setMaximumPitch(float maxPitch) {
        this.maxPitch = maxPitch;
        return this;
    }

    @Override
    public Effect play(Location location) {
        setPitch(RANDOM.nextFloat() * (maxPitch - minPitch + 1) + minPitch);
        return super.play(location);
    }

    @Override
    public Effect play(Location location, Player... players) {
        setPitch(RANDOM.nextFloat() * (maxPitch - minPitch + 1) + minPitch);
        return super.play(location, players);
    }
}
