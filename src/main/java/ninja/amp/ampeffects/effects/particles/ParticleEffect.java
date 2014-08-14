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
package ninja.amp.ampeffects.effects.particles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * The possible types of particle effects and methods to display them.
 *
 * @author DarkBlade12, highly modified by Ampayne2.
 */
public enum ParticleEffect {
    HUGE_EXPLOSION("hugeexplosion"),
    LARGE_EXPLODE("largeexplode"),
    FIREWORKS_SPARK("fireworksSpark"),
    BUBBLE("bubble"),
    SUSPEND("suspend"),
    DEPTH_SUSPEND("depthSuspend"),
    TOWN_AURA("townaura"),
    CRIT("crit"),
    MAGIC_CRIT("magicCrit"),
    MOB_SPELL("mobSpell"),
    MOB_SPELL_AMBIENT("mobSpellAmbient"),
    SPELL("spell"),
    INSTANT_SPELL("instantSpell"),
    WITCH_MAGIC("witchMagic"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    EXPLODE("explode"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    SPLASH("splash"),
    LARGE_SMOKE("largesmoke"),
    CLOUD("cloud"),
    RED_DUST("reddust"),
    SNOWBALL_POOF("snowballpoof"),
    DRIP_WATER("dripWater"),
    DRIP_LAVA("dripLava"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    ANGRY_VILLAGER("angryVillager"),
    HAPPY_VILLAGER("happyVillager");

    private static Constructor<?> PARTICLE_PACKET_CONSTRUCTOR;

    static {
        try {
            PARTICLE_PACKET_CONSTRUCTOR = ReflectionUtil.getConstructor(ReflectionUtil.getClass("PacketPlayOutWorldParticles", ReflectionUtil.DynamicPackage.MINECRAFT_SERVER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String name;

    ParticleEffect(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the ParticleEffectType.
     *
     * @return The ParticleEffectType's name.
     */
    public String getName() {
        return name;
    }

    private static Object createPacket(String name, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        try {
            Object p = PARTICLE_PACKET_CONSTRUCTOR.newInstance();
            ReflectionUtil.setValues(p, new ReflectionUtil.FieldEntry("a", name), new ReflectionUtil.FieldEntry("b", (float) loc.getX()), new ReflectionUtil.FieldEntry("c", (float) loc.getY()), new ReflectionUtil.FieldEntry("d", (float) loc.getZ()),
                    new ReflectionUtil.FieldEntry("e", offsetX), new ReflectionUtil.FieldEntry("f", offsetY), new ReflectionUtil.FieldEntry("g", offsetZ), new ReflectionUtil.FieldEntry("h", speed), new ReflectionUtil.FieldEntry("i", amount));
            return p;
        } catch (Exception e) {
            Bukkit.getLogger().warning("[AmpEffects] Failed to create a particle packet!");
            return null;
        }
    }

    /**
     * Creates a particle effect packet.
     *
     * @return The particle effect packet.
     */
    public static Object createPacket(ParticleEffect type, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        return createPacket(type.getName(), loc, offsetX, offsetY, offsetZ, speed, amount);
    }

    /**
     * Creates an icon crack (icon break) effect packet.
     *
     * @return The icon crack packet.
     */
    public static Object createIconCrackPacket(int id, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        return createPacket("iconcrack_" + id, loc, offsetX, offsetY, offsetZ, speed, amount);
    }

    /**
     * Creates a block crack (block break) effect packet.
     *
     * @return The block crack packet.
     */
    public static Object createBlockCrackPacket(int id, byte data, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        return createPacket("blockcrack_" + id + "_" + data, loc, offsetX, offsetY, offsetZ, speed, amount);
    }

    /**
     * Creates a block dust effect packet.
     *
     * @return The block dust packet.
     */
    public static Object createBlockDustPacket(int id, byte data, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        return createPacket("blockdust_" + id + "_" + data, loc, offsetX, offsetY, offsetZ, speed, amount);
    }

    /**
     * Displays a particle effect which is only visible for specific players.
     */
    public void display(Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount, Player... players) {
        ReflectionUtil.sendPacket(Arrays.asList(players), createPacket(this, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays a particle effect which is visible for all players in the world.
     */
    public void display(Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        ReflectionUtil.sendPacket(loc.getWorld().getPlayers(), createPacket(this, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays an icon crack (item break) effect which is only visible for specific players.
     */
    public static void displayIconCrack(Location loc, int id, float offsetX, float offsetY, float offsetZ, float speed, int amount, Player... players) {
        ReflectionUtil.sendPacket(Arrays.asList(players), createIconCrackPacket(id, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays an icon crack (item break) effect which is visible for all players in the world.
     */
    public static void displayIconCrack(Location loc, int id, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        ReflectionUtil.sendPacket(loc.getWorld().getPlayers(), createIconCrackPacket(id, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays a block crack (block break) effect which is only visible for specific players.
     */
    public static void displayBlockCrack(Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Player... players) {
        ReflectionUtil.sendPacket(Arrays.asList(players), createBlockCrackPacket(id, data, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays a block crack (block break) effect which is visible for all players in the world.
     */
    public static void displayBlockCrack(Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        ReflectionUtil.sendPacket(loc.getWorld().getPlayers(), createBlockCrackPacket(id, data, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays a block dust effect which is only visible for specific players.
     */
    public static void displayBlockDust(Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Player... players) {
        ReflectionUtil.sendPacket(Arrays.asList(players), createBlockDustPacket(id, data, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Displays a block dust effect which is visible for all players in the world.
     */
    public static void displayBlockDust(Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        ReflectionUtil.sendPacket(loc.getWorld().getPlayers(), createBlockDustPacket(id, data, loc, offsetX, offsetY, offsetZ, speed, amount));
    }
}