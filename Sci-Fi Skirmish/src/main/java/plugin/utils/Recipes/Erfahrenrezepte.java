package plugin.utils.Recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import plugin.Main;
import plugin.utils.ItemBuilder.ErfahrenItems;
import plugin.utils.ItemBuilder.SpecialResources;

public class Erfahrenrezepte {

    Main plugin;

    public Erfahrenrezepte(Main plugin) {
        this.plugin = plugin;
    }

    public static ShapedRecipe Recipe1(){
    ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenFragment"), SpecialResources.ErfahrenFragment(1));
        recipe.shape("XXX","XFX","XXX");
        recipe.setIngredient('X',Material.GOLD_NUGGET);
        recipe.setIngredient('F',Material.EXPERIENCE_BOTTLE);
        return recipe;
    }

    public static ShapedRecipe Recipe2(){
    ShapedRecipe recipe2 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenBarren"), SpecialResources.ErfahrenBarren(1));
        recipe2.shape("xxx", "xFx", "xxx");
        recipe2.setIngredient('x', SpecialResources.ErfahrenFragment(1));
        recipe2.setIngredient('F', Material.EXPERIENCE_BOTTLE);
        return recipe2;
    }

    public static ShapedRecipe Recipe3(){
    ShapedRecipe recipe3 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenAxt"), ErfahrenItems.Axt());
        recipe3.shape("xFF", "xSF", "xSx");
        recipe3.setIngredient('x', Material.AIR);
        recipe3.setIngredient('F', SpecialResources.ErfahrenBarren(1));
        recipe3.setIngredient('S', Material.STICK);
        return recipe3;
    }
    public static ShapedRecipe Recipe4(){
    ShapedRecipe recipe4 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenSchwert"), ErfahrenItems.sword());
        recipe4.shape("xFx", "xFx", "xSx");
        recipe4.setIngredient('x', Material.AIR);
        recipe4.setIngredient('F', SpecialResources.ErfahrenBarren(1));
        recipe4.setIngredient('S', Material.STICK);
        return recipe4;
    }

    public static ShapedRecipe Recipe5(){
    ShapedRecipe recipe5 = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "ErfahrenBogen"), ErfahrenItems.bow());
        recipe5.shape("xSF", "SxF", "xSF");
        recipe5.setIngredient('x', Material.AIR);
        recipe5.setIngredient('F', SpecialResources.ErfahrenBarren(1));
        recipe5.setIngredient('S', Material.STICK);
        return recipe5;
    }


}
