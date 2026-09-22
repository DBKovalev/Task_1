package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Класс  и тесты в нем могут оказаться лишними, т.к. все элементы enum можно проверить в тестах на класс Ingredient,
и все равно добиться нужного покрытия, но решил, что может быть не лишним проверять все отдельно
*/
public class IngredientTypeTest {

    @Test
    @DisplayName("Количество ингредиентов в enum соответствует ожидаемому")
    void checkQuantityOfIngredientsTest(){
        assertEquals(2, IngredientType.values().length,"Ожидаемое и фактическое кол-во ингредиентов в enum не совпали");
    }

    static private Stream<Arguments> validNames() {
        return Stream.of(
                Arguments.of("SAUCE", IngredientType.SAUCE),
                Arguments.of("FILLING", IngredientType.FILLING)
        );
    }

    @ParameterizedTest
    @MethodSource("validNames")
    @DisplayName("Присутствуют все ожидаемые типы ингредиентов")
    void valueOfWorksForValidNames(String name, IngredientType expectedType) {
        assertEquals(expectedType, IngredientType.valueOf(name), "Отсутствует элемент " + name);
    }

    static private Stream<String> invalidNames() {
        return Stream.of( "sauce", "Sauce", "filling", "Filling", "UNKNOWN", "");
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    @DisplayName("Ошибка на невалидные имена")
    void valueOfThrowsForInvalidNames(String invalidName) {
    assertThrows(IllegalArgumentException.class,
            () -> IngredientType.valueOf(invalidName));
    }
}



