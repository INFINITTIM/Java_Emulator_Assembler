package org.example.CommandAndProgram;

import org.example.AllExceptions.Exception_div_zero;
import org.example.MyCpu.ICpu;

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
    public void run_program(Program prog) {
        // при каждой итерации цикла в переменную command будет
        // помещаться очередной элемент массива assembler_program
        // состоящего из комманд нашей запускаемой программы
        for (Command command : prog) {
            try {
                cpu.exec(command);
            } catch (Exception_div_zero e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
