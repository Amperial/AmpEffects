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
package ninja.amp.ampeffects.effects;

import ninja.amp.ampeffects.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Holds the information needed to play a bukkit effect to simplify playing it.
 */
public class BukkitEffect implements Effect {
    private org.bukkit.Effect effect;
    private Object data;

    /**
     * Creates a new BukkitEffect.
     *
     * @param effect The Effect.
     * @param data   The Effect's data.
     */
    public BukkitEffect(org.bukkit.Effect effect, Object data) {
        this.effect = effect;
        this.data = data;
    }

    /**
     * Gets the BukkitEffect's effect.
     *
     * @return The effect.
     */
    public org.bukkit.Effect getEffect() {
        return effect;
    }

    /**
     * Sets the BukkitEffect's effect.
     *
     * @param effect The effect.
     * @return The BukkitEffect.
     */
    public BukkitEffect setEffect(org.bukkit.Effect effect) {
        this.effect = effect;
        return this;
    }

    /**
     * Gets the BukkitEffect's data.
     *
     * @return The data.
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the BukkitEffect's data.
     *
     * @param data The data.
     * @return The BukkitEffect.
     */
    public BukkitEffect setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public Effect play(Location location) {
        location.getWorld().playEffect(location, effect, data);
        return this;
    }

    @Override
    public Effect play(Location location, Player... players) {
        for (Player player : players) {
            player.playEffect(location, effect, data);
        }
        return this;
    }
}
