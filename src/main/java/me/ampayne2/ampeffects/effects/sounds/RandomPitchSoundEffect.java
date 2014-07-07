package me.ampayne2.ampeffects.effects.sounds;

import me.ampayne2.ampeffects.Effect;
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
