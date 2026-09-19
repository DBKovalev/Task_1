# Final_project
## Описание
Stellar burgers https://qa-stellarburgers.education-services.ru/ingredient/691577430cc94f001a65b85a

Юнит-тесты для классов Bun, Burger, Ingredient, IngredientType

## Стек
**Язык:** Java 11

**Сборка:** Apache Maven

**Тестирование:**
- JUnit 5 (5.14.4) — фреймворк для написания и запуска модульных тестов
- Mockito (5.23.0) — библиотека для создания моков в тестах

**Анализ покрытия:**
- JaCoCo (0.8.15) — плагин для анализа покрытия кода тестами


## Запуск тестов
### Реализация запуска всех тестов
```bash
mvn clean test 
```

### Реализация запуска тестов по одному
#### BunTest
```bash
mvn clean test -Dtest=BunTest
```

#### BurgerTest
```bash
mvn clean test -Dtest=BurgerTest
```

#### IngredientTest
```bash
mvn clean test -Dtest=IngredientTest
```

#### IngredientTypeTest
```bash
mvn clean test -Dtest=IngredientTypeTest
```



