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
    public void checkCardHolderValidName() throws Exception {

        Account account = new Account("Приемлемое Имя");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(not(false)));

    }

    @DisplayName("Создание карты с двумя пробелами")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с двумя пробелами")
    @Test
    public void checkCardHolderNameDoubleWhitespaces() throws Exception {

        Account account = new Account("Имя С Пробелами");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с первым пробелом")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пробелом в начале имени")
    @Test
    public void checkCardHolderNameFirstWhitespace() throws Exception {

        Account account = new Account(" Первый Пробел");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с последним пробелом")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пробелом в конце имени")
    @Test
    public void checkCardHolderNameSecondWhitespace() throws Exception {

        Account account = new Account("Последний Пробел ");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с пустым именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с пустым именем")
    @Test
    public void checkCardHolderNameEmpty() throws Exception {

        Account account = new Account("");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с длинным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с избыточным количеством символов")
    @Test
    public void checkCardHolderNameTooLong() throws Exception {

        Account account = new Account("Крестовоздвиженский-Богоявленский Константин");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(false));

    }

    @DisplayName("Создание карты с валидным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с граничным значением 3")
    @Test
    public void checkCardHolderNameBoundaryThree() throws Exception {

        Account account = new Account("А Б");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(true));

    }

    @DisplayName("Создание карты с валидным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с граничным значением 4")
    @Test
    public void checkCardHolderNameBoundaryFour() throws Exception {

        Account account = new Account("Аб В");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(true));

    }

    @DisplayName("Создание карты с валидным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с граничным значением 18")
    @Test
    public void checkCardHolderNameBoundaryEighteen() throws Exception {

        Account account = new Account("Восемнадцать буквв");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(true));

    }

    @DisplayName("Создание карты с валидным именем")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени с граничным значением 4")
    @Test
    public void checkCardHolderNameBoundaryNineteen() throws Exception {

        Account account = new Account("Девятнадцать Букввв");
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(true));

    }

    @DisplayName("Создание карты с null")
    @Description("Тест, проверяющий работу метода проверки корректности вводимого имени при использовании значения null")
    @Test
    public void checkCardHolderNameWithNullValue() throws Exception {

        Account account = new Account(null);


        try {
            account.checkNameToEmboss(account.getName());
        } catch (NullPointerException exception) {
            System.out.println("Проблемы с доступом к файлу");
        }


    }

}
