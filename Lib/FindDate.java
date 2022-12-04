package Lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindDate {

    private Date dt;
    private int  index;

    FindDate(List<String> arr) throws MyException{
        for (int i = 0; i < arr.size(); i++){
            if (isDate(arr.get(i)))
            {
                index = i;
                return;
            }
        }
        throw new MyException("В введенной строке не найдена дата рождения или ее формат не соответствует заданному!");
    }

    private boolean isDate(String text){
        try {
            DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
            dt = df.parse(text);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public int getIndexDate() {
        return index;
    }

    public Date getDate() {
        return dt;
    }
}
