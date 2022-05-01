package com.ya;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.MatcherAssert;

@RunWith(Parameterized.class)
public class CardHolderParameterizedNameBoundaryTest {

    private final String name;

    @Parameterized.Parameters(name = "Имя держателя карты: {0}")
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Аб"},
                {"Имядвадцать Символов"},
        };
    }

    public CardHolderParameterizedNameBoundaryTest(String name) {
        this.name = name;
    }

    @DisplayName("Создание карты с невалидными именеми держателя")
    @Description("Параметризированный тест, проверяющий граничные значения")
    @Test
    public void checkCardHolderName() throws Exception {
        Account account = new Account(name);
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));
    }

}
