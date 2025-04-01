package com.interview.stream;

import java.util.*;
import java.util.stream.Collectors;
/*
 Compute Average Salary by Department
*/

class Worker {
    String name;
    int departmentId;
    double salary;

    public Worker(String name, int departmentId, double salary) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }
}

public class AverageSalaryCalculator {

    public static Map<Integer, Double> calculateAverageByDepartments(List<Worker> workers) {
        Map<Integer, Double> grouppedByDept = workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId, Collectors.averagingDouble(Worker::getSalary)));
        return grouppedByDept;
    }

    public static void main(String[] args) {
        Worker worker1 = new Worker("Pupsik", 1, 1200);
        Worker worker2 = new Worker("Patrik", 2, 1300);
        Worker worker3 = new Worker("Belkin", 1, 2200);
        Worker worker4 = new Worker("Artist", 3, 4200);
        Worker worker5 = new Worker("Boris", 3, 1200);
        Worker worker6 = new Worker("Pidor", 2, 7200);
        List<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);
        workers.add(worker6);

        Map<Integer, Double> averageSalaryByDept = calculateAverageByDepartments(workers);

        averageSalaryByDept.forEach((dept, salary) -> System.out.println(" Key = " + dept + " Value = " + salary));
    }
}