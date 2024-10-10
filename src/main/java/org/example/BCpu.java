package org.example;

//реализация интерфейса нашего процессора
public class BCpu
{
    // выделаяем память под регистры
    // и под основной массив элементов
    public static Cpu build() {
        return new Cpu();
    }
}
