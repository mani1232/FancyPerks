package de.oliver.fancyperks.perks;

import de.oliver.fancyperks.perks.impl.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PerkRegistry {

    public static final Perk FAST_DIGGING = new EffectPerk("Fast Digging", "Gives you the haste effect", new ItemStack(Material.NETHERITE_PICKAXE), PotionEffectType.FAST_DIGGING);
    public static final Perk NIGHT_VISION = new EffectPerk("Night Vision", "Gives you the night vision effect", new ItemStack(Material.SPYGLASS), PotionEffectType.NIGHT_VISION);
    public static final Perk WATER_BREATHING = new EffectPerk("Water Breathing", "Gives you the water breathing effect", new ItemStack(Material.WATER_BUCKET), PotionEffectType.WATER_BREATHING);
    public static final Perk STRENGTH = new EffectPerk("Strength", "Gives you the strength effect", new ItemStack(Material.DIAMOND_SWORD), PotionEffectType.INCREASE_DAMAGE);
    public static final Perk KEEP_EXP = new SimplePerk("Keep EXP", "Don't lose your exp after dying", new ItemStack(Material.EXPERIENCE_BOTTLE));
    public static final Perk FLY = new FlyPerk("Fly", "Gives you the ability to fly", new ItemStack(Material.ELYTRA));
    public static final Perk NO_HUNGER = new NoHungerPerk("No Hunger", "You don't need to eat again", new ItemStack(Material.COOKED_CHICKEN));
    public static final Perk KEEP_INVENTORY = new SimplePerk("Keep Inventory", "Don't lose your items after dying", new ItemStack(Material.CHEST));
    public static final Perk NO_FIRE_DAMAGE = new SimplePerk("No Fire Damage", "Don't get hurt by fire", new ItemStack(Material.FIRE_CHARGE));
    public static final Perk NO_FALL_DAMAGE = new SimplePerk("No Fall Damage", "Don't get hurt by fall damage", new ItemStack(Material.SLIME_BLOCK));
    public static final Perk GOD = new SimplePerk("God", "Don't get any damage", new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
    public static final Perk MOBS_IGNORE = new SimplePerk("Mobs ignore", "Mobs don't notice you anymore", new ItemStack(Material.ZOMBIE_SPAWN_EGG));
    public static final Perk DOUBLE_EXP = new SimplePerk("Double Exp", "Receive double exp for killing monsters", new ItemStack(Material.EXPERIENCE_BOTTLE));
    public static final Perk DOUBLE_DROPS = new SimplePerk("Double Mob Drops", "Receive double drops for killing Mobs", new ItemStack(Material.ROTTEN_FLESH));
    public static final Perk VANISH = new VanishPerk("Vanish", "Hide from all players", new ItemStack(Material.ENDER_PEARL));

    public static final List<Perk> ALL_PERKS = new ArrayList<>();

    static {
        registerPerk(FAST_DIGGING);
        registerPerk(NIGHT_VISION);
        registerPerk(WATER_BREATHING);
        registerPerk(MOBS_IGNORE);
        registerPerk(STRENGTH);
        registerPerk(KEEP_EXP);
        registerPerk(FLY);
        registerPerk(VANISH);
        registerPerk(NO_HUNGER);
        registerPerk(KEEP_INVENTORY);
        registerPerk(NO_FIRE_DAMAGE);
        registerPerk(NO_FALL_DAMAGE);
        registerPerk(GOD);
        registerPerk(DOUBLE_EXP);
        registerPerk(DOUBLE_DROPS);
    }

    public static Perk getPerkByName(String name){
        for (Perk perk : ALL_PERKS) {
            if(perk.getName().equalsIgnoreCase(name.replaceAll("_", " ")) || perk.getSystemName().equalsIgnoreCase(name)){
                return perk;
            }
        }

        return null;
    }

    public static void registerPerk(Perk perk){
        ALL_PERKS.add(perk);
    }

}
