package plugin.utils.recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingRecipe;
import plugin.Main;
import plugin.utils.inventorybuilder.Rezepte.ErfahrenRezeptInventare;
import plugin.utils.itembuilder.SpecialResources;
import plugin.utils.itembuilder.candles.*;

public class CandleRecipes {

    public static SmithingRecipe healCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "healCandle"),
                RepairCandle.create(), // any material seems fine
                new RecipeChoice.ExactChoice(EmptyCandle.create()),
                new RecipeChoice.ExactChoice(SpecialResources.ErfahrenBarren(1))
        );
        return recipe;
    }

    public static SmithingRecipe boostCandle() {
        SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "boostCandle"),
                JumpCandle.create(), // any material seems fine
                new RecipeChoice.ExactChoice(EmptyCandle.create()),
                new RecipeChoice.ExactChoice(SpecialResources.ExplosivBarren(1))
        );
          return recipe;
        }


        public static SmithingRecipe teleportCandle() {
            SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(Main.getInstance(), "teleportCandle"),
                    TeleportCandle.create(), // any material seems fine
                    new RecipeChoice.ExactChoice(EmptyCandle.create()),
                    new RecipeChoice.ExactChoice(SpecialResources.KlebrigBarren(1))
            );
            return recipe;
        }

        public static ShapedRecipe superRecipe(){

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "superCandleRecipe"), UltimateCandle.create());

        recipe.shape("abc", "def", "ghi");
        recipe.setIngredient('a',SpecialResources.ErfahrenBarren(1));
        recipe.setIngredient('b', RepairCandle.create());
        recipe.setIngredient('c', SpecialResources.ErfahrenBarren(1));
        recipe.setIngredient('d', SpecialResources.KlebrigBarren(1));
        recipe.setIngredient('e', TeleportCandle.create());
        recipe.setIngredient('f', SpecialResources.KlebrigBarren(1));
        recipe.setIngredient('g', SpecialResources.ExplosivBarren(1));
        recipe.setIngredient('h', JumpCandle.create());
        recipe.setIngredient('i', SpecialResources.ExplosivBarren(1));

        return recipe;
        }
    }

