package jansparadise.jansparadise.sonstiges.RecipeBuilder;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.SciFiBarren;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.SciFiFragment;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiSilencer;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiWand;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class SciFiRezepte {

    public static ShapedRecipe Recipe1(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFiFrag"), SciFiFragment.SciFiFragment());
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X', Material.AMETHYST_SHARD);
        recipe.setIngredient('F',Material.ENDER_PEARL);
        return recipe;
    }

    public static ShapedRecipe Recipe2(){
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFiKrista"), SciFiBarren.SciFiBarren());
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', SciFiFragment.SciFiFragment());
        recipe2.setIngredient('F', Material.ENDER_PEARL);
        return recipe2;
    }

    public static ShapedRecipe Recipe3(){
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFi"), SciFiAxt.SciFiSchwert());
        recipe3.shape("xFF", "xSF", "xSx");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', SciFiBarren.SciFiBarren());
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
    }
    public static ShapedRecipe Recipe4(){
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFi2"), SciFiSilencer.SciFiSchwert());
        recipe4.shape("xFx", "xFx", "xSx");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', SciFiBarren.SciFiBarren());
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
    }

    public static ShapedRecipe Recipe5(){
        ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFi3"), SciFiWand.Wand());
        recipe5.shape("xFx", "xFx", "xFx");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', SciFiBarren.SciFiBarren());
        return recipe5;
    }

    public static ShapedRecipe Recipe6(){
        ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "SciFi4"), SciFiBogen.SciFiSchwert());
        recipe5.shape("xSF", "SxF", "xSF");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', SciFiBarren.SciFiBarren());
        recipe5.setIngredient('S', Material.STICK);
        return recipe5;
    }
}
