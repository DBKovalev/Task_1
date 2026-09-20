package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

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
}
