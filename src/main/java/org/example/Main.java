package org.example;

import static org.example.Task.*;

public class Main
{
    public static void main(String[] args)
    {

        //набор команд программы на псевдоассемблере
        Command[] prog = {
                new Command(init, "10", "2"),
                new Command(init, "11", "5"),
                new Command(init, "12", "10"),
                new Command(ld, "a", "10"),
                new Command(ld, "b", "11"),
                new Command(ld, "c", "12"),
                new Command(print),
                new Command(mv, "a", "b"),
                new Command(mv, "b", "c"),
                new Command(mult),
                new Command(print),
                new Command(mv, "a", "d"),
                new Command(div),
                new Command(print)
        };

        //выделяем память под регистры и основные комманды программы
        
        ICpu cpu = BCpu.build();

        //созадем объект исполнителя
        Executer exec = new Executer(cpu);

        //объект исполнитя запускает программу с помощью нашего процессора cpu
        exec.run_program(prog);

    }
}
