package org.example;

//интерфейс нашего процессора
public interface ICpu
{
    // интерфейс исполнения команды
    void exec (Command c) throws Exception_div_zero;
}
