package me.ampayne2.ampeffects.effects;

import me.ampayne2.ampeffects.Effect;
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
    public BukkitEffect(org.bukkit.Effect effect, int data) {
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
    public BukkitEffect setData(int data) {
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
