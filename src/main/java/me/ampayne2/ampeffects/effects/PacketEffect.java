package me.ampayne2.ampeffects.effects;

import me.ampayne2.ampeffects.Effect;
import me.ampayne2.ampeffects.effects.particles.ReflectionUtil;
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
