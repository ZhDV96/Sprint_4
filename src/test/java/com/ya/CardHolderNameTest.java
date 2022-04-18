package com.ya;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.MatcherAssert;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;

public class CardHolderNameTest {

    @Before
    public void setUp() {

    }

    @DisplayName("Создание карты с валидным именем держателя")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с валидным именем")
    @Test
    public void checkCardHolderValidName() {

        Account account = new Account("Приемлемое Имя");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(not(false)));

    }

    @DisplayName("Создание карты с двумя пробелами")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с двумя пробелами")
    @Test
    public void checkCardHolderNameDoubleWhitespaces() {

        Account account = new Account("Имя С Пробелами");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с первым пробелом")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пробелом в начале имени")
    @Test
    public void checkCardHolderNameFirstWhitespace() {

        Account account = new Account(" Первый Пробел");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с последним пробелом")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пробелом в конце имени")
    @Test
    public void checkCardHolderNameSecondWhitespace() {

        Account account = new Account("Последний Пробел ");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с пустым именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пустым именем")
    @Test
    public void checkCardHolderNameEmpty() {

        Account account = new Account("");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с длинным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с избыточным количеством символов")
    @Test
    public void checkCardHolderNameTooLong() {

        Account account = new Account("Крестовоздвиженский-Богоявленский Константин");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

}
