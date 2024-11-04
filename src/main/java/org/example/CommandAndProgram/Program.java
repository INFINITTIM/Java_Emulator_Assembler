package org.example.CommandAndProgram;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program implements Iterable<Command>{
    int command_index = 0;
    List<Command> program_commands = new ArrayList<>();

    public void add(Command c)
    {
        program_commands.add(c);
        command_index++;
    }

    @Override
    public Iterator<Command> iterator() {
        return program_commands.iterator();
    }

    private Map<Task, Long> MapWithPopulationTasks()
    {
        //мап инскрукция и кол-во вхождений данной инструкции
        Map<Task, Long> map_with_population_tasks = program_commands
                .stream()
                .collect(Collectors.groupingBy(Command::getTask, Collectors.counting()));
        return map_with_population_tasks;
    }

    public Map<List<Task>, Long> PopulationTasks()
    {
        //максимальное значение вхождений какой-либо инструкции
        Long max_count = Collections.max(MapWithPopulationTasks().values());

        //мап с самыми часто встречающимися инструкциями и их кол-вом вхождений
        Map<List<Task>, Long> map_with_most_population_tasks = new HashMap<>();
                map_with_most_population_tasks
                        .put(MapWithPopulationTasks().entrySet()
                                .stream()
                                .filter(element -> element.getValue().equals(max_count))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList()), max_count);
                return map_with_most_population_tasks;
    }

    public List<Map.Entry<Task, Long>> ListWithTasksAndCounters()
    {
        List<Map.Entry<Task, Long>> list_with_tasks_and_counters = MapWithPopulationTasks()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Task, Long>comparingByValue().reversed()) // Сортировка по убыванию
                .collect(Collectors.toList());
        return list_with_tasks_and_counters;
    }

    public String ListDiap() {
        List<Integer> list_diap = new ArrayList<>();
        list_diap = program_commands
                .stream()
                .filter(command -> (command.getTask()==Task.init)
                        ||  (command.getTask()==Task.ld)
                        || (command.getTask()==Task.st))
                .map(command -> command.getTask() == Task.init ?
                        Integer.parseInt(command.getArgument1()) :
                        Integer.parseInt(command.getArgument2()))
                .collect(Collectors.toList());
        int min = Collections.min(list_diap);
        int max = Collections.max(list_diap);
        return "Диапазон памяти: " + min + "..." + max;
        /*for (Command command : program_commands) {
            switch (command.getTask())
            {
                case init:
                    list_diap.add(Integer.parseInt(command.getArgument1()));
                    break;
                case ld:
                    list_diap.add(Integer.parseInt(command.getArgument2()));
                    break;
                case st:
                    list_diap.add(Integer.parseInt(command.getArgument2()));
                    break;
            }
        }
        return list_diap;*/
    }
}
