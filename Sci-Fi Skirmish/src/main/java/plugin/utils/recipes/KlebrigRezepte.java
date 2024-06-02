package plugin.utils.recipes;

import plugin.Main;
import plugin.utils.itembuilder.Klebrig;
import plugin.utils.itembuilder.SpecialResources;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class KlebrigRezepte {

    Main plugin;

    public KlebrigRezepte(Main plugin) {
        this.plugin = plugin;
    }

    public static ShapedRecipe Recipe1(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "KlebrigFragment"), SpecialResources.KlebrigFragment(1));
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X', Material.SCUTE);
        recipe.setIngredient('F', Material.COBWEB);
        return recipe;
    }

    public static ShapedRecipe Recipe2(){
        ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "KlebrigBarren"), SpecialResources.KlebrigBarren(1));
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', SpecialResources.KlebrigFragment(1));
        recipe2.setIngredient('F', Material.COBWEB);
        return recipe2;
    }

    public static ShapedRecipe Recipe3(){
        ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "KlebrigSchwert"), Klebrig.Schwert());
        recipe3.shape("xFx", "xFx", "xSx");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', SpecialResources.KlebrigBarren(1));
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
    }
    public static ShapedRecipe Recipe4(){
        ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "KlebrigAngel"), Klebrig.Angel());
        recipe4.shape("xxS", "xSF", "SxF");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', SpecialResources.KlebrigBarren(1));
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
    }

    public static ShapedRecipe Recipe5(){
        ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "KlebrigBogen"), Klebrig.Bogen());
        recipe5.shape("xSF", "SxF", "xSF");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', SpecialResources.KlebrigBarren(1));
        recipe5.setIngredient('S', Material.STICK);
        return recipe5;
    }

}
