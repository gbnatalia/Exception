package Lib;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class InputData {

    private PersonData ParserData(String line) throws MyException {

        List<String> list = new ArrayList<>(Arrays.asList(line.split(" ")));
        if (list.size() != 6)
            throw new RuntimeException("Введено некорректное число данных! Введено " + list.size() +
                    ", необходимо: " + 6);

        PersonData person = new PersonData();

        // занесение информации о дате рождения
        FindDate date = new FindDate(list);
        person.birthday = date.getDate();
        list.remove(date.getIndexDate());

        // занесение информации о телефоне
        FindTelephone tel = new FindTelephone(list);
        person.telephone = tel.getTelephone();
        list.remove(tel.getIndexTelephone());

        // занесение информации о поле
        FindPol pol = new FindPol(list);
        person.pol = pol.getPol();
        list.remove(pol.getIndexPol());

        // занесение информации о фамилии
        FindName lastName = new FindName(list);
        person.last_name = lastName.getName();
        list.remove(lastName.getIndexName());

        // занесение информации о имени
        FindName firstName = new FindName(list);
        person.first_name = firstName.getName();
        list.remove(firstName.getIndexName());

        // занесение информации об отчестве
        FindName patronymic = new FindName(list);
        person.patronymic = patronymic.getName();

        return person;
    }

    public PersonData ScanerData() throws MyException{
        System.out.println("Введите следующие данные:");
        System.out.println("- Фамилия, Имя, Отчество, разделенные пробелами на русском языке");
        System.out.println("- Дата рождения в формате: dd.mm.yyyy");
        System.out.println("- Номер телефона в формате: ХХХХХХХХХХХ (11 цифр)");
        System.out.println("- Пол: м или ж");
        System.out.println("Данные должны быть введены в одной строке и быть разделенными пробелами");
        System.out.println("Данные могут быть введены в произвольном порядке.");

        Scanner in = new Scanner(System.in);
        return ParserData(in.nextLine());
    }
}
