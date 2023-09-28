package jansparadise.jansparadise.sonstiges.RecipeBuilder;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.ExplosivKelp;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.ExplosivPowder;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivPicke;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;


public class ExplosivRezepte {

    JansParadise plugin;

    public ExplosivRezepte(JansParadise plugin) {
        this.plugin = plugin;
    }

    public static ShapedRecipe Recipe1(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "superpowder"), ExplosivPowder.Powder());
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X', Material.GUNPOWDER);
        recipe.setIngredient('F',Material.TNT);
        return recipe;
    }

    public static ShapedRecipe Recipe2(){
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "superkelp"), ExplosivKelp.DriedKelp());
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', ExplosivPowder.Powder());
        recipe2.setIngredient('F', Material.TNT);
        return recipe2;
    }

    public static ShapedRecipe Recipe3(){
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "ExplosivAngel"), ExplosivAngel.ExplosivAngel());
        recipe3.shape("xxS", "xSF", "SxF");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', ExplosivKelp.DriedKelp());
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
    }
    public static ShapedRecipe Recipe4(){
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(JansParadise.getInstance(), "ExplivPicke"), ExplosivPicke.ErfahrenBow());
        recipe4.shape("FFF", "xSx", "xSx");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', ExplosivKelp.DriedKelp());
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
    }


}
