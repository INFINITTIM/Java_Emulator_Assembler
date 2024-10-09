package org.example;

//исполнитель
public class Executer {

    ICpu cpu;

    //задание каким из процессоров будет производиться исполнение программы
    public Executer(ICpu cpu)
    {
        this.cpu = cpu;
    }

    //запуск нашей программы, то есть
    //подается набор комманд и мы с помощью нашего процессора
    // исполняем наши программы методов exec
    public void run_program(Command[] assembler_program) {
        // при каждой итерации цикла в переменную command будет
        // помещаться очередной элемент массива assembler_program
        // состоящего из комманд нашей запускаемой программы
        for (Command command : assembler_program) {
            try {
                cpu.exec(command);
            } catch (Exception_div_zero e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
