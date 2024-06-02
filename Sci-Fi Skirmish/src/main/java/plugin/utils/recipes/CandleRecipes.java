package plugin.utils.recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;
import plugin.Main;
import plugin.utils.itembuilder.Candles;
import plugin.utils.itembuilder.SpecialResources;

public class CandleRecipes {

    public static SmithingRecipe healCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "healCandle"),
                Candles.healCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.ErfahrenBarren(1))
        );
        return recipe;
    }

    public static SmithingRecipe crateCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "crateCandle"),
                Candles.crateCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.SciFiBarren(1))
        );
        return recipe;
    }

    public static SmithingRecipe boostCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "boostCandle"),
                Candles.boostCandle(), // any material seems fine
                new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                new RecipeChoice.ExactChoice(SpecialResources.ExplosivBarren(1))
        );
          return recipe;
        }


        public static SmithingRecipe teleportCandle() {
            SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "teleportCandle"),
                    Candles.teleportCandle(), // any material seems fine
                    new RecipeChoice.ExactChoice(Candles.emptyCandle()),
                    new RecipeChoice.ExactChoice(SpecialResources.KlebrigBarren(1))
            );
            return recipe;
        }

        public static ShapedRecipe superRecipe(){

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "superCandleRecipe"), Candles.superCandle());

        recipe.shape("abc", "def", "ghi");
        recipe.setIngredient('a', Candles.healCandle());
        recipe.setIngredient('b', SpecialResources.ErfahrenBarren(1));
        recipe.setIngredient('c', Candles.crateCandle());
        recipe.setIngredient('d', SpecialResources.KlebrigBarren(1));
        recipe.setIngredient('e', Candles.emptyCandle());
        recipe.setIngredient('f', SpecialResources.SciFiBarren(1));
        recipe.setIngredient('g', Candles.teleportCandle());
        recipe.setIngredient('h', SpecialResources.ExplosivBarren(1));
        recipe.setIngredient('i', Candles.boostCandle());

        return recipe;
        }
    }

