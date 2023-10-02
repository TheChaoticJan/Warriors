package jansparadise.jansparadise.sonstiges.RecipeBuilder;

import jansparadise.jansparadise.Main;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;

import jansparadise.jansparadise.sonstiges.ItemBuilder.SpecialResources;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Erfahrenrezepte {

    Main plugin;

    public Erfahrenrezepte(Main plugin) {
        this.plugin = plugin;
    }

    public static ShapedRecipe Recipe1(){
    ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "supergold"), SpecialResources.ErfahrenFragment());
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X',Material.GOLD_NUGGET);
        recipe.setIngredient('F',Material.EXPERIENCE_BOTTLE);
        return recipe;
}

    public static ShapedRecipe Recipe2(){
    ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "supergoldblock"), SpecialResources.ErfahrenBarren());
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', SpecialResources.ErfahrenFragment());
        recipe2.setIngredient('F', Material.EXPERIENCE_BOTTLE);
        return recipe2;
                }

    public static ShapedRecipe Recipe3(){
    ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenAxt"), ErfahrenAxt.ErfahrenBeil());
        recipe3.shape("xFF", "xSF", "xSx");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', SpecialResources.ErfahrenBarren());
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
                }
    public static ShapedRecipe Recipe4(){
    ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "supergoldblock1"), ErfahrenSchwert.ErfahrenKatana());
        recipe4.shape("xFx", "xFx", "xSx");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', SpecialResources.ErfahrenBarren());
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
                }

    public static ShapedRecipe Recipe5(){
    ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "supergoldblock2"), ErfahrenBogen.ErfahrenBow());
        recipe5.shape("xSF", "SxF", "xSF");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', SpecialResources.ErfahrenBarren());
        recipe5.setIngredient('S', Material.STICK);
        return recipe5;
                }

}
