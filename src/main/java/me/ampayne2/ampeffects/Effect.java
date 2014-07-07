package me.ampayne2.ampeffects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Represents any type of effect such as particles or sound.
 */
public interface Effect {

    /**
     * Plays the effect at a location.
     *
     * @param location The location to play the effect at.
     * @return The Effect.
     */
    Effect play(Location location);

    /**
     * Plays the effect to a player or players at a location.
     *
     * @param players  The players to play the effect to.
     * @param location The location to play the effect at.
     * @return The Effect.
     */
    Effect play(Location location, Player... players);
}
