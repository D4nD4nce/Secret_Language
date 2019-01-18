package com.myguisecretproject.secretlang.langs_logic.codes;

public class AllCodesInfo {

    /*
     * names
     */
    public static final String caesar_name = "Шифр Цезаря";
    public static final String simple_name = "Шифр простой подстановки";
    public static final String example_name = "тест";

    /*
     * descriptions
     */
    public static final String caesar_description =
            "Код, который якобы был придуман и использовался еще самим Юлием Цезарем: " +
                    "при переводе текста символы сдвигаются в соответствии с выбранным алфавитом";
    public static final String simple_description =
            "Простейший шифр: каждый символ введенного текста заменяется на цифру в соответствии с ее местов в алфавите." +
                    "Далее цифры 0-9 шифруются любыми буквами, и подставляются вместо введенного текста.";
    public static final String example_description =
            "тестовый тест";

    /*
     * paths to resources
     */
    public static final String main_win_path = "../ui/resources/main_win.fxml";
    public static final String caesar_key_path = "../resources/set_caesar_key.fxml";
    public static final String simple_key_path = "../resources/set_caesar_key.fxml";
    public static final String example_key_path = "../resources/set_caesar_key.fxml";

}
