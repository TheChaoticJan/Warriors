package plugin.utils.Recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;
import plugin.Main;
import plugin.utils.ItemBuilder.Candles;
import plugin.utils.ItemBuilder.SpecialResources;

public class CandleRecipes {

    public static SmithingRecipe healCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "healCandle"),
                Candles.healCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.ErfahrenBarren())
        );
        return recipe;
    }

    public static SmithingRecipe crateCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "crateCandle"),
                Candles.crateCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.SciFiBarren())
        );
        return recipe;
    }

    public static SmithingRecipe boostCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "boostCandle"),
                Candles.boostCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.ExplosivBarren())
        );
          return recipe;
        }


        public static SmithingRecipe teleportCandle() {
            SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "teleportCandle"),
                    Candles.teleportCandle(), // any material seems fine
                    new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                    new RecipeChoice.ExactChoice(SpecialResources.KlebrigBarren())
            );
            return recipe;
        }

        public static ShapedRecipe superRecipe(){

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "superCandleRecipe"), Candles.superCandle());

        recipe.shape("abc", "def", "ghi");
        recipe.setIngredient('a', Candles.healCandle());
        recipe.setIngredient('b', SpecialResources.ErfahrenBarren());
        recipe.setIngredient('c', Candles.crateCandle());
        recipe.setIngredient('d', SpecialResources.KlebrigBarren());
        recipe.setIngredient('e', Candles.emptyCandle());
        recipe.setIngredient('f', SpecialResources.SciFiBarren());
        recipe.setIngredient('g', Candles.teleportCandle());
        recipe.setIngredient('h', SpecialResources.ExplosivBarren());
        recipe.setIngredient('i', Candles.boostCandle());

        return recipe;
        }
    }

