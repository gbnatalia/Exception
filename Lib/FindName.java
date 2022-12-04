package Lib;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindName {
    private String name;
    private int index;

    FindName(List<String> arr) throws MyException {
        for (int i = 0; i < arr.size(); i++) {
            if (isName(arr.get(i))) {
                index = i;
                name = arr.get(i);
                return;
            }
        }
        throw new MyException("В введенной строке не найден пол или его формат не соответствует заданному!");
    }
    private boolean isName(String text) {
        Pattern regex = Pattern.compile("^[А-Я]{1}[а-я]+$"); // шаблон строки
        Matcher m = regex.matcher(text);
        if (m.find())
            return true;
        return false;
    }

    public int getIndexName() {
        return index;
    }

    public String getName() { return name; }
}
