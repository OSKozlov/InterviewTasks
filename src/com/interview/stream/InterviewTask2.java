package com.interview.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewTask2 {

    public static void main(String[] args) {

        List<Task> tasks = Arrays.asList(
                new Task(1, "task1"),
                new Task(2, "task2"),
                new Task(3, "task3"),
                new Task(4, "task4"),
                new Task(5, "task5"),
                new Task(6, "task6"),
                new Task(7, "task7"),
                new Task(8, "task8"));

        List<Developer> devs = Arrays.asList(
                new Developer(123, "Vasya"),
                new Developer(456, "Petya"),
                new Developer(789, "Masha"));

        List<Assignment> assignments = Arrays.asList(
                new Assignment(1, 123),
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

        Map<Integer, String> taskMap = tasks.stream().collect(Collectors.toMap(Task::getId, Task::getTitle));
        Map<Integer, String> devMap = developers.stream().collect(Collectors.toMap(Developer::getId, Developer::getName));

        Map<Integer, List<Assignment>> assignmentMap = assignments.stream().collect(Collectors.groupingBy(Assignment::getTaskId));

        Map<String, List<String>> result = new HashMap<>();

        assignmentMap.entrySet().forEach(entry -> {
            result.put(taskMap.get(entry.getKey()),
                    entry.getValue().stream().map(v -> devMap.get(v.getDeveloperId())).collect(Collectors.toList()));
        });

        return result;
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