package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    static private Stream<Arguments> ingredients() {
        return Stream.of(
                Arguments.of(IngredientType.valueOf("SAUCE"), "1000 островов", 0.5f),
                Arguments.of(IngredientType.valueOf("FILLING"), "Котлета", 100f)
        );
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректная цена ингредиента")
    @MethodSource("ingredients")
    void getIngredientPriceReturnsCorrectIngredientPriceTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(),  0.001f, "Ожидаемая и фактическая цена ингредиента не совпали");
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректное имя ингредиента")
    @MethodSource("ingredients")
    void getIngredientNameReturnsCorrectIngredientNameTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName(), "Ожидаемое и фактическое имя булки не совпали");
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректный тип ингредиента")
    @MethodSource("ingredients")
    void getIngredientTypeReturnsCorrectIngredientTypeTest(IngredientType type, String name, float price){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType(), "Ожидаемый и фактический тип ингредиента не совпали");
    }
}
