package com.ya;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkNameToEmboss(String name) throws Exception {

        int whiteSpaceIndex = name.indexOf(' ');
        int whiteSpaceIndexAfter = name.lastIndexOf(' ');

        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        if (name.isEmpty()) {
            System.out.println("Имя держателя карты отсутствует.Добавьте имя");
            return false;
        } else if(name != null) {
            if (whiteSpaceIndex == -1 || whiteSpaceIndex == 0 || whiteSpaceIndexAfter == name.length()-1) {
                System.out.println("В имени держателя карты присутствует некорретное использование пробелов. Добавьте имя повторно");
                return false;
            } else {
                if (whiteSpaceIndex != name.lastIndexOf(" ")) {
                    System.out.println("В имени держателя карты присутствует 2 или более пробела. Добавьте имя повторно");
                    return false;
                } else {
                    if (name.length() < 3) { // проверяет длину
                        System.out.println("Имя слишком короткое.Имя держателя карты должно содержать от 3 до 13 символов. Добавьте имя повторно");
                        return false;
                    } else if (name.length() > 19) { // проверяет длину
                        System.out.println("Имя слишком длинное.Имя держателя карты должно содержать от 3 до 13 символов. Добавьте имя повторно");
                        return false;
                    }
                    System.out.println("Подходящее имя.");
                    return true;
                }
            }
        } else {
            throw new Exception("Ошибка. Добавьте имя держателя карты");
        }
    }

}
