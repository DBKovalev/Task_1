package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of("Булка с кунжутом", 100f),
                Arguments.of("Булка с отрубями", 1f),
                Arguments.of("Булка с сыром", 0.5f)
        );
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректное имя булки")
    @MethodSource("getTestData")
    void getBunNameReturnsCorrectBunName(String name, float price){
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName(), "Ожидаемое и фактическое имя булки не совпали");
    }

    @ParameterizedTest
    @DisplayName("Возвращается корректная цена булки")
    @MethodSource("getTestData")
    void getBunPriceReturnsCorrectBunPrice(String name, float price){
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(),  0.001f, "Ожидаемая и фактическая цена булки не совпали");
    }
}
