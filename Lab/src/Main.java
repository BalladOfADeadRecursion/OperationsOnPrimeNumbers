import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для чтения ввода пользователя

        while (true) { // Бесконечный цикл для повторения операций
            try { // Обработка исключений
                int num1, num2; // Объявление переменных для хранения введенных чисел

                // Ввод первого числа
                while (true) { // Бесконечный цикл для повторного запроса ввода в случае ошибки
                    System.out.println("Введите первое целое число:"); // Вывод приглашения для ввода первого числа
                    if (scanner.hasNextInt()) { // Проверка, является ли следующий ввод целым числом
                        num1 = scanner.nextInt(); // Считывание введенного целого числа
                        break; // Выход из цикла, если ввод корректен
                    } else {
                        System.out.println("Ошибка: Введено не целое число. Пожалуйста, введите целое число.");
                        scanner.next(); // Очистка буфера ввода
                    }
                }

                // Ввод второго числа (аналогично первому числу)
                while (true) {
                    System.out.println("Введите второе целое число:");
                    if (scanner.hasNextInt()) {
                        num2 = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка: Введено не целое число. Пожалуйста, введите целое число.");
                        scanner.next();
                    }
                }

                SmallInteger smallNum1 = new SmallInteger(num1); // Создание объекта SmallInteger для первого числа
                SmallInteger smallNum2 = new SmallInteger(num2); // Создание объекта SmallInteger для второго числа

                // Вывод доступных операций
                System.out.println("Выберите операцию:");
                System.out.println("1. Сложение");
                System.out.println("2. Вычитание");
                System.out.println("3. Умножение");
                System.out.println("4. Деление");
                System.out.println("5. Остаток от деления");
                System.out.println("x. Выход");

                String choice = scanner.next(); // Считывание выбора операции

                if (choice.equals("x")) { // Проверка на выбор выхода из программы
                    System.out.println("Выход из программы...");
                    break; // Выход из бесконечного цикла
                }

                SmallInteger result; // Переменная для хранения результата операции
                switch (choice) { // Выбор операции в зависимости от ввода пользователя
                    case "1":
                        result = smallNum1.add(smallNum2); // Выполнение сложения
                        System.out.println("Результат сложения: " + result);
                        break;
                    case "2":
                        result = smallNum1.subtract(smallNum2); // Выполнение вычитания
                        System.out.println("Результат вычитания: " + result);
                        break;
                    case "3":
                        result = smallNum1.multiply(smallNum2); // Выполнение умножения
                        System.out.println("Результат умножения: " + result);
                        break;
                    case "4":
                        result = smallNum1.divide(smallNum2); // Выполнение деления
                        System.out.println("Результат деления: " + result);
                        break;
                    case "5":
                        result = smallNum1.modulo(smallNum2); // Выполнение остатка от деления
                        System.out.println("Результат остатка от деления: " + result);
                        break;
                    default:
                        System.out.println("Неверный выбор операции"); // Вывод сообщения об ошибке в случае неверного выбора операции
                }
            } catch (IllegalArgumentException | ArithmeticException e) { // Обработка исключений IllegalArgumentException и ArithmeticException
                System.out.println("Ошибка: " + e.getMessage()); // Вывод сообщения об ошибке
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        scanner.close(); // Закрытие Scanner после завершения работы программы
    }
}