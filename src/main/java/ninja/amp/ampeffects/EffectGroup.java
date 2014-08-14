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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Holds multiple {@link Effect}s to simplify playing them all at once.
 */
public class EffectGroup implements Effect {
    private final Set<Effect> effects = new HashSet<>();

    /**
     * Creates a new EffectGroup.
     *
     * @param effects The {@link Effect}s of the EffectGroup.
     */
    public EffectGroup(Effect... effects) {
        this.effects.addAll(Arrays.asList(effects));
    }

    /**
     * Adds an effect to the EffectGroup.
     *
     * @param effect The {@link Effect}.
     * @return The EffectGroup.
     */
    public EffectGroup addEffect(Effect effect) {
        effects.add(effect);
        return this;
    }

    /**
     * Removes an effect from the EffectGroup.
     *
     * @param effect The {@link Effect}.
     * @return The EffectGroup.
     */
    public EffectGroup removeEffect(Effect effect) {
        effects.remove(effect);
        return this;
    }

    /**
     * Gets the EffectGroup's {@link Effect}s.
     *
     * @return The {@link Effect}s of the EffectGroup.
     */
    public Set<Effect> getEffects() {
        return effects;
    }

    /**
     * Plays all of the {@link Effect}s at a location.
     *
     * @param location The location to play the effects at.
     * @return The EffectGroup.
     */
    @Override
    public Effect play(Location location) {
        for (Effect effect : effects) {
            effect.play(location);
        }
        return this;
    }

    /**
     * Plays all of the {@link Effect}s to a player or players at a location.
     *
     * @param players  The players to play the effects to.
     * @param location The location to play the effects at.
     * @return The EffectGroup.
     */
    @Override
    public Effect play(Location location, Player... players) {
        for (Effect effect : effects) {
            effect.play(location, players);
        }
        return this;
    }
}
