package Lib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Work {

    final File dir;
    PersonData personData;

    public Work() {
        dir = new File(System.getProperty("user.dir") + "\\result");
        if (dir.exists() == false) {
            dir.mkdir();
        }
        getData();
        saveData();
    }

    // Запрос данных у пользователя
    private void getData() {
        boolean resScan = false;
        InputData in = new InputData();
        while (!resScan) {
            try {
                personData = in.ScanerData();
                resScan = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // сохранение данных в файл
    private void saveData() {

        String fileName = dir.getName() + "\\" + personData.last_name;
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(fileName, file.exists())) {
            String output = String.format("%s %s %s %s %d %s\n",
                    personData.last_name,
                    personData.first_name,
                    personData.patronymic,
                    new SimpleDateFormat("dd.mm.yyyy").format(personData.birthday),
                    personData.telephone,
                    personData.pol
                    );
            fw.write(output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
