package Lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTelephone {

    private long telephone;
    private int  index;

    FindTelephone(List<String> arr) throws MyException{
        for (int i = 0; i < arr.size(); i++){
            if (isTelephone(arr.get(i)))
            {
                index = i;
                return;
            }
        }
        throw new MyException("В введенной строке не найден телефон или его формат не соответствует заданному!");
    }

    private boolean isTelephone(String text){
        try {
            if (text.length() != 11)
                return false;
            telephone = Long.parseLong(text);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public int getIndexTelephone() {
        return index;
    }

    public long getTelephone() {
        return telephone;
    }
}
