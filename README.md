AmpEffects
==========

A very basic library to make effects a little simpler and more efficient in Bukkit.

Why should you use AmpEffects instead of just the Bukkit API?
* Stores the information needed to play an effect to simplify playing it - especially good for the PacketEffect as creating packets is more intensive
* All of the different effects extend Effect and can be played the same way
* Ability to combine Effects with an EffectGroup - since EffectGroup extends Effect you can even group mixed Effects and EffectGroups
* Has a ParticleEffect class that you can use to display particles or create particle packets with for the PacketEffect
* Small and simple

For Developers
--------------

If you're using [Maven](http://maven.apache.org/download.html) to manage project dependencies, simply include the following in your `pom.xml`:

    <repository>
      <id>greatman-repo</id>
      <url>http://repo.greatmancode.com/content/groups/public/</url>
    </repository>

    <dependency>
      <groupId>ninja.amp</groupId>
      <artifactId>ampeffects</artifactId>
      <version>1.1</version>
      <scope>compile</scope>
    </dependency>

Usage:

    // Playing an Effect
    effect.play(location);
    
    // Playing an Effect to certain player(s)
    effect.play(location, player);
    
    // Making a BukkitEffect
    Effect blood = new BukkitEffect(org.bukkit.Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
    
    // Making a SoundEffect
    Effect howl = new SoundEffect(Sound.WOLF_HOWL, 1, 1);
    
    // Making a RandomPitchSoundEffect
    Effect click = new RandomPitchSoundEffect(Sound.CLICK, 1, 0, 2);
    
    // Using the ParticleEffect class to display a particle effect
    ParticleEffect.FIREWORKS_SPARK.display(location, 0, 0, 0, 0, 1);
    
    // Using the ParticleEffect class to get the packet of a particle effect to make a PacketEffect
    Effect fireworkSpark = new PacketEffect(ParticleEffect.createPacket(ParticleEffect.FIREWORKS_SPARK, location, 0, 0, 0, 0, 1));
    
    // Making an EffectGroup
    EffectGroup chaos = new EffectGroup(blood, howl, click, fireworkSpark);
    
    // Playing an EffectGroup - since it extends Effect it's the same!
    chaos.play(location);

Compilation
-----------

AmpEffects uses Maven to handle its dependencies.

* Download and install [Maven 3](http://maven.apache.org/download.html)  
* Checkout this repo and run: `mvn clean install`

The License
-----------

AmpEffects is licensed under the [GNU Lesser General Public License Version 3](https://github.com/ampayne2/AmpEffects/blob/master/LICENSE.txt)

Contributing
------------

Guidelines:
* All new files must include the license header. This can be done automatically with Maven by running mvn clean install.
* Generally follow the Oracle code conventions and the current style.
* Use four spaces for indentation, not tabs.
* No trailing whitespace (spaces/tabs on new lines and end of lines).
* 200 column limit for readability.