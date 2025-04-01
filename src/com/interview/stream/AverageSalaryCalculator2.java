package com.interview.stream;

import java.util.*;

/*
 Compute Average Salary by Department
*/

class Worker2 {
    String name;
    int departmentId;
    double salary;

    public Worker2(String name, int departmentId, double salary) {
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

public class AverageSalaryCalculator2 {

    public static Map<Integer, Double> calculateAverageByDepartments(List<Worker2> workers) {
        Map<Integer, List<Worker2>> grouppedByDept = new HashMap<>();
        for(Worker2 worker2 : workers) {
            if (!grouppedByDept.containsKey(worker2.getDepartmentId())) {
                List<Worker2> list = new ArrayList<>();
                list.add(worker2);
                grouppedByDept.put(worker2.getDepartmentId(), list);
            } else {
                List<Worker2> list = grouppedByDept.get(worker2.getDepartmentId());
                list.add(worker2);
            }
        }

        Map<Integer, Double> averages = new HashMap<>();
        for(Map.Entry<Integer, List<Worker2>> entry : grouppedByDept.entrySet()) {
            List<Worker2> list = entry.getValue();
            double average = 0;
            for(Worker2 w2 : list) {
                average = average + w2.getSalary();
            }
            average = average/list.size();
            averages.put(entry.getKey(), average);
        }
        return averages;
    }

    public static void main(String[] args) {
        Worker2 worker1 = new Worker2("Pupsik", 1, 1200);
        Worker2 worker2 = new Worker2("Patrik", 2, 1300);
        Worker2 worker3 = new Worker2("Belkin", 1, 2200);
        Worker2 worker4 = new Worker2("Artist", 3, 4200);
        Worker2 worker5 = new Worker2("Boris", 3, 1200);
        Worker2 worker6 = new Worker2("Pidor", 2, 7200);
        List<Worker2> workers = new ArrayList<>();
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