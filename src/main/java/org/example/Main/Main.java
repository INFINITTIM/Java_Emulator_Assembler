package org.example.Main;

import org.example.CommandAndProgram.Command;
import org.example.CommandAndProgram.Executer;
import org.example.CommandAndProgram.Program;
import org.example.MyCpu.BCpu;
import org.example.MyCpu.ICpu;

import static org.example.CommandAndProgram.Task.*;

public class Main
{
    public static void main(String[] args)
    {

        //создаём объект команды
        Program prog = new Program();

        //добавляем в нашу программу команды
        prog.add(new Command(init, "10", "2"));
        prog.add(new Command(init, "11", "5"));
        prog.add(new Command(init, "12", "10"));
        prog.add(new Command(ld, "a", "10"));
        prog.add(new Command(ld, "b", "11"));
        prog.add(new Command(ld, "c", "12"));
        prog.add(new Command(print));
        prog.add(new Command(mv, "a", "b"));
        prog.add(new Command(mv, "b", "c"));
        prog.add(new Command(mult));
        prog.add(new Command(print));
        prog.add(new Command(mv, "a", "d"));
       // prog.add(new Command(mv, "b", "c"));
        prog.add(new Command(div));
        prog.add(new Command(print));

        for(Command c: prog) System.out.println(c);
        System.out.println();

        //выделяем память под регистры и основные комманды программы
        ICpu cpu = BCpu.build();

        //созадем объект исполнителя
        Executer exec = new Executer(cpu);

        //объект исполнитя запускает программу с помощью нашего процессора cpu
        exec.run_program(prog);

        System.out.println();

        System.out.println(prog.PopulationTasks());
        System.out.println(prog.ListWithTasksAndCounters());
        System.out.println(prog.ListDiap());
    }
}
