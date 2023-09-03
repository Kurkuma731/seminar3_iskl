import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String userInput = scanner.nextLine();
        scanner.close();

        String[] userData = userInput.split(" ");

        // Проверяем количество данных
        if (userData.length != 6) {
            System.err.println("Ошибка: Неверное количество данных.");
            return;
        }

        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String birthDate = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];

        try {
            // Парсим дату рождения
            String[] dateParts = birthDate.split("\\.");
            if (dateParts.length != 3) {
                throw new IllegalArgumentException("Ошибка: Неверный формат даты рождения.");
            }

            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Дополнительные проверки для номера телефона и пола можно добавить здесь

            // Создаем файл с именем фамилии
            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            // Записываем данные в файл
            String dataToWrite = lastName + firstName + middleName + birthDate + phoneNumber + gender;
            writer.write(dataToWrite);
            writer.newLine();
            writer.close();

            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат числа.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}