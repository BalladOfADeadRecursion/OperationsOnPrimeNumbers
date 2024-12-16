class SmallInteger {
    private static final int MAX_VALUE = 10000; // Максимальное значение SmallInteger
    private static final int MIN_VALUE = -10000; // Минимальное значение SmallInteger

    private int value; // Значение SmallInteger

    public SmallInteger(int value) { // Конструктор класса SmallInteger
        if (value < MIN_VALUE || value > MAX_VALUE) { // Проверка, находится ли значение в допустимом диапазоне
            throw new IllegalArgumentException("Значение вне допустимого диапазона"); // Генерация исключения при недопустимом значении
        }
        this.value = value; // Присваивание значения
    }

    public SmallInteger operation(SmallInteger arg, char operator) { // Метод для выполнения операций над SmallInteger
        int result; // Результат операции
        switch (operator) { // Выбор операции в зависимости от переданного оператора
            case '+':
                result = this.value + arg.value; // Сложение
                break;
            case '-':
                result = this.value - arg.value; // Вычитание
                break;
            case '*':
                result = this.value * arg.value; // Умножение
                break;
            case '/':
                if (arg.value == 0) { // Проверка деления на ноль
                    throw new ArithmeticException("Деление на ноль"); // Генерация исключения
                }
                result = this.value / arg.value; // Деление
                break;
            case '%':
                if (arg.value == 0) { // Проверка остатка от деления на ноль
                    throw new ArithmeticException("Остаток от деления на ноль"); // Генерация исключения
                }
                result = this.value % arg.value; // Остаток от деления
                break;
            default:
                throw new IllegalArgumentException("Неверная операция"); // Генерация исключения при недопустимом операторе
        }

        if (result < MIN_VALUE || result > MAX_VALUE) { // Проверка на выход за пределы допустимого диапазона
            throw new ArithmeticException("Результат вне допустимого диапазона"); // Генерация исключения
        }

        return new SmallInteger(result); // Возврат результата в виде нового объекта SmallInteger
    }

    // Методы для выполнения арифметических операций, использующие метод operation
    public SmallInteger add(SmallInteger arg) {
        return operation(arg, '+');
    }

    public SmallInteger subtract(SmallInteger arg) {
        return operation(arg, '-');
    }

    public SmallInteger multiply(SmallInteger arg) {
        return operation(arg, '*');
    }

    public SmallInteger divide(SmallInteger arg) {
        return operation(arg, '/');
    }

    public SmallInteger modulo(SmallInteger arg) {
        return operation(arg, '%');
    }

    public int getValue() { // Метод для получения значения SmallInteger
        return value;
    }

    @Override
    public String toString() { // Переопределение метода toString для удобного вывода значения
        return Integer.toString(value);
    }
}
