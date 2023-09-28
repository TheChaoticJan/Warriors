package jansparadise.jansparadise.sonstiges.RecipeBuilder;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.Erfahrenbarren;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.Erfahrenfragment;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.KlebrigSlime;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.KlebrigSuperSlime;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigSchwert;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class KlebrigRezepte {

    JansParadise plugin;

    public KlebrigRezepte(JansParadise plugin) {
        this.plugin = plugin;
    }

    public static ShapedRecipe Recipe1(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "superball"), KlebrigSlime.Slime());
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X', Material.SCUTE);
        recipe.setIngredient('F', Material.COBWEB);
        return recipe;
    }

    public static ShapedRecipe Recipe2(){
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "superemerald"), KlebrigSuperSlime.Emerald());
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', KlebrigSlime.Slime());
        recipe2.setIngredient('F', Material.COBWEB);
        return recipe2;
    }

    public static ShapedRecipe Recipe3(){
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "KlebrigSchwert"), KlebrigSchwert.KlebrigBogen());
        recipe3.shape("xFx", "xFx", "xSx");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', KlebrigSuperSlime.Emerald());
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
    }
    public static ShapedRecipe Recipe4(){
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "KlebrigAngel"), KlebrigAngel.KlebrigAngel());
        recipe4.shape("xxS", "xSF", "SxF");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', KlebrigSuperSlime.Emerald());
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
    }

    public static ShapedRecipe Recipe5(){
        ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "KlebrigBogen"), KlebrigBogen.KlebrigBogen());
        recipe5.shape("xSF", "SxF", "xSF");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', KlebrigSuperSlime.Emerald());
        recipe5.setIngredient('S', Material.STICK);
        return recipe5;
    }

}
