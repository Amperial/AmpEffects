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
import ninja.amp.ampeffects.effects.particles.ReflectionUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Contains a packet that can be sent multiple times.
 */
public class PacketEffect implements Effect {
    private Object packet;

    /**
     * Creates a new PacketEffect.
     *
     * @param packet The packet.
     */
    public PacketEffect(Object packet) {
        this.packet = packet;
    }

    /**
     * Gets the PacketEffect's packet.
     *
     * @return The packet.
     */
    public Object getPacket() {
        return packet;
    }

    /**
     * Sets the PacketEffect's packet.
     *
     * @param packet The packet.
     * @return The PacketEffect.
     */
    public PacketEffect setPacket(Object packet) {
        this.packet = packet;
        return this;
    }

    @Override
    public Effect play(Location location) {
        ReflectionUtil.sendPacket(location.getWorld().getPlayers(), packet);
        return this;
    }

    @Override
    public Effect play(Location location, Player... players) {
        ReflectionUtil.sendPacket(Arrays.asList(players), packet);
        return this;
    }
}
