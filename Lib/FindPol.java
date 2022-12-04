package Lib;

import java.util.List;

public class FindPol {

    private char pol;
    private int index;

    FindPol(List<String> arr) throws MyException {
        for (int i = 0; i < arr.size(); i++) {
            if (isPol(arr.get(i))) {
                index = i;
                pol = arr.get(i).charAt(0);
                return;
            }
        }
        throw new MyException("В введенной строке не найден пол или его формат не соответствует заданному!");
    }
    private boolean isPol(String text) {
        if (text.equals("м") || text.equals("ж"))
            return true;
        return false;
    }

    public int getIndexPol() {
        return index;
    }

    public char getPol() { return pol; }
}
