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
