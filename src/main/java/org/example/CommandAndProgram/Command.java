package org.example.CommandAndProgram;

public class Command{
    Task task;
    String argument1;
    String argument2;

    //конструктор класса команды для задач без аргументов
    public Command(Task task) {
        this.task = task;
    }

    // конструктор класса команд для задач с аргументами
    public Command(Task task, String argument1, String argument2) {
        this.task = task;
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    // геттер для получения наших задач записанных в команды
    public Task getTask() {
        return task;
    }

    public String getArgument1() {
        return argument1;
    }

    public String getArgument2() {
        return argument2;
    }

    //переопределение метода вывода строки для всех трех вариантов команд
    @Override
    public String toString() {
        if (argument1 != null && argument2 != null) {
            return task + " " + argument1 + " " + argument2;
        } else if (argument1 != null) {
            return task + " " + argument1;
        } else {
            return task.toString();
        }
    }
}
