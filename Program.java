import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол('m' или 'f')");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных");
            return;
        }

        User user = new User();

        try {
            user.setFamilyName(data[0]);
            user.setName(data[1]);
            user.setSurname(data[2]);
            user.setBirthDate(data[3]);
            user.setPhoneNumber(data[4]);
            user.setGender(data[5]);

            System.out.println(user);
            FileWriter fileWriter = new FileWriter(user.getFamilyName() + ".txt", true);
            fileWriter.append(user + "\n");
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл " + user);
        }

        catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты рождения");
        }
        catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона");
        }
        catch (ShortStringException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
