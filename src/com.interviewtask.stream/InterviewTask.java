package com.interviewtask.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewTask {

    public static void main(String[] args) {

        List<Task> tasks = Arrays.asList(new Task(1, "task1"),
                new Task(2, "task2"),
                new Task(3, "task3"),
                new Task(4, "task4"),
                new Task(5, "task5"),
                new Task(6, "task6"),
                new Task(7, "task7"),
                new Task(8, "task8"));

        List<Developer> devs = Arrays.asList(new Developer(123, "Vasya"),
                new Developer(456, "Petya"),
                new Developer(789, "Masha"));

        List<Assignment> assignments = Arrays.asList(new Assignment(1, 123),
                new Assignment(2, 456),
                new Assignment(3, 123),
                new Assignment(4, 123),
                new Assignment(5, 456),
                new Assignment(6, 789),
                new Assignment(7, 789),
                new Assignment(8, 123));

        Map<String, List<String>> map = report(tasks, devs, assignments);
        map.forEach((dev, strings) -> strings.forEach(s -> System.out.println("### - " + dev + " assigned task " + s)));
    }

    /*
       Return Map where:
       Key is Developer Names
       Value is List of Tasks Title assigned to Developer

       Handle non-consistent cases:
       1. Developer::getId not present in Assignment::getDeveloperId - add Developer::getName with Collections::emptyList
       2. Assignment::getTaskId not present in Task::getId - Skip Assignment
    */
    public static Map<String, List<String>> report(
            List<Task> tasks,
            List<Developer> developers,
            List<Assignment> assignments
    ) {

        // TODO: implement the method

        Map<Integer, List<Integer>> groupedTaskEntries = assignments.stream().collect(Collectors.groupingBy(
                Assignment::getDeveloperId, Collectors.mapping(Assignment::getTaskId, Collectors.toList())));

        return groupedTaskEntries.entrySet().stream().map((Function<Map.Entry<Integer, List<Integer>>, Map.Entry<String, List<String>>>) entry -> new Map.Entry<>() {

            @Override
            public String getKey() {
                Map<Integer, String> devMap = developers.stream().collect(Collectors.toMap(Developer::getId, Developer::getName));
                return devMap.get(entry.getKey());
            }

            @Override
            public List<String> getValue() {
                Map<Integer, String> taskMap = tasks.stream().collect(Collectors.toMap(Task::getId, Task::getTitle));
                return entry.getValue().stream().map(value -> taskMap.get(value)).collect(Collectors.toList());
            }

            @Override
            public List<String> setValue(List<String> value) {
                return null;
            }
        }).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    public record Task(int id, String title) {

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

    }

    public record Developer(int id, String name) {

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public record Assignment(int taskId, int developerId)  {

        public int getTaskId() {
            return taskId;
        }

        public int getDeveloperId() {
            return developerId;
        }

    }
}

