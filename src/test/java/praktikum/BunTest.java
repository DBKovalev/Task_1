package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    static private Stream<Arguments> bunsAndPrices() {
        return Stream.of(
                Arguments.of("Булка с кунжутом", 100f),
                Arguments.of("Булка с отрубями", 1f),
                Arguments.of("Булка с сыром", 0.5f)
        );
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректное имя булки")
    @MethodSource("bunsAndPrices")
    void getBunNameReturnsCorrectBunNameTest(String name, float price){
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName(), "Ожидаемое и фактическое имя булки не совпали");
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректная цена булки")
    @MethodSource("bunsAndPrices")
    void getBunPriceReturnsCorrectBunPriceTest(String name, float price){
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(),  0.001f, "Ожидаемая и фактическая цена булки не совпали");
    }
}
