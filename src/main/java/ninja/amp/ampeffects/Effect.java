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
package ninja.amp.ampeffects;

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
