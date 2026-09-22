package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private Burger burger;
    private Bun bunMock;
    private Ingredient sauceMock;
    private Ingredient fillingMock;

    @BeforeEach
    public void setUp() {
        bunMock = Mockito.mock(Bun.class);
        sauceMock = Mockito.mock(Ingredient.class);
        fillingMock = Mockito.mock(Ingredient.class);

        burger = new Burger();

        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);

        when(bunMock.getPrice()).thenReturn(10.0f);
        when(sauceMock.getPrice()).thenReturn(0.5f);
        when(fillingMock.getPrice()).thenReturn(100.0f);

        when(bunMock.getName()).thenReturn("Булка с кунжутом");
        when(sauceMock.getName()).thenReturn("1000 островов");
        when(fillingMock.getName()).thenReturn("Котлета");

        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);
        when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    @DisplayName("Булка задается через setBun()")
    public void setBunsSetBunTest() {
        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun, "Ожидалось, что булка в бургере будет той, которую передали в setBuns()");
    }

    @Test
    @DisplayName("addIngredient() добавляет ингредиент")
    public void addIngredientAddsIngredientTest() {
        Ingredient newIngredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(newIngredient);
        assertEquals(3, burger.ingredients.size(), "Ожидалось ингредиентов: 3");
        assertSame(newIngredient, burger.ingredients.get(2), "На последнем месте новый ингредиент");
    }

    @Test
    @DisplayName("removeIngredient() удаляет ингредиент")
    public void removeIngredientRemovesIngredientTest() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size(), "Ожидалось ингредиентов: 1");
        assertSame(fillingMock, burger.ingredients.get(0), "Должен остаться ингредиент-начинка ");
    }

    @Test
    @DisplayName("moveIngredient() перемещает ингредиент на новое место")
    public void moveIngredientMovesIngredientTest() {
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size(), "Ожидалось ингредиентов: 2");
        assertEquals(1, burger.ingredients.indexOf(sauceMock), "На месте с индексом 1 ожидался" + sauceMock);
    }

    @Test
    @DisplayName("getPrice() возвращает вычисленную по всем ингредиентам цену бургера")
    public void getPriceReturnsBurgerPriceTest() {
        burger.setBuns(bunMock);
        float expectedBurgerPrice = (bunMock.getPrice()*2) + sauceMock.getPrice() + fillingMock.getPrice();
        assertEquals(expectedBurgerPrice, burger.getPrice(), 0.001f, "Ожидаемая и фактическая цена бургера не совпали");
    }

    @Test
    @DisplayName("getReceipt() возвращает корректуню строку с булкой, ингредиентами бургера, их типами и ценой")
    public void getReceiptReturnsCorrectStringTest() {
        burger.setBuns(bunMock);
        float expectedBurgerPrice = (bunMock.getPrice()*2) + sauceMock.getPrice() + fillingMock.getPrice();
        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                bunMock.getName(),
                sauceMock.getType().toString().toLowerCase(), sauceMock.getName(),
                fillingMock.getType().toString().toLowerCase(), fillingMock.getName(),
                bunMock.getName(),
                expectedBurgerPrice
        );
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt, "Ожидаемый и фактический текст чека не совпали");
    }
}
