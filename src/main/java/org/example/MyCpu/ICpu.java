package org.example.MyCpu;

import org.example.AllExceptions.Exception_div_zero;
import org.example.CommandAndProgram.Command;

//интерфейс нашего процессора
public interface ICpu
{
    // интерфейс исполнения команды
    void exec (Command c) throws Exception_div_zero;
}
