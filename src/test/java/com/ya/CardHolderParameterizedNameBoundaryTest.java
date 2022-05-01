package com.ya;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.MatcherAssert;

@RunWith(Parameterized.class)
public class CardHolderParameterizedNameTest {

    private final String name;

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Крестовоздвиженский-Богоявленский Константин"},
                {""},
                {"НетПробела"},
                {" Пробел Первый"},
                {"Обычное Имя"},
                {"Кк"},
                {"Имя С Тремя Пробелами"},
                {"Пробел Последний "},
        };
    }

    public CardHolderParameterizedNameTest(String name) {
        this.name = name;
    }

    @Test
    public void checkCardHolderName() throws Exception {
        Account account = new Account(name);
        Boolean isNameCorrect = account.checkNameToEmboss(account.getName());
        MatcherAssert.assertThat(isNameCorrect, is(not(false)));
    }

}
