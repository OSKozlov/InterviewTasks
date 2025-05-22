package com.interview.stream;

import java.util.*;

/*
 Compute Average Salary by Department
*/

public class AverageSalaryCalculator2 {

    public static Map<Integer, Double> calculateAverageByDepartments(List<Worker> workers) {
        // Группируем сотрудников по департаментам
        // для этого создаем мапу где ключ номер департамента
        // и значение это список сотрудников
        Map<Integer, List<Worker>> groupedByDept = new HashMap<>();
        for(Worker worker : workers) {
            if (worker==null) continue;
            if (!groupedByDept.containsKey(worker.getDepartmentId())) {
                // Если нет в мапе департамента то добавляем его
                // и создаем новый список сотрудников
                groupedByDept.put(worker.getDepartmentId(), new ArrayList<>());
            }
            // Достаем список сотрудников по номеру департамента
            // и добавляем нового сотрудника в список
            groupedByDept.get(worker.getDepartmentId()).add(worker);
        }

        Map<Integer, Double> averages = new HashMap<>();
        for(Map.Entry<Integer, List<Worker>> entry : groupedByDept.entrySet()) {
            double average = 0;
            for(Worker w : entry.getValue()) {
                average = average + w.getSalary();
            }
            averages.put(entry.getKey(), average/entry.getValue().size());
        }
        return averages;
    }

    public static void main(String[] args) {
        Worker worker1 = new Worker("Pupsik", 1, 1200);
        Worker worker2 = new Worker("Patrik", 2, 1300);
        Worker worker3 = new Worker("Belkin", 1, 2200);
        Worker worker4 = new Worker("Artist", 3, 4200);
        Worker worker5 = new Worker("Boris", 3, 1200);
        Worker worker6 = new Worker("Pidor", 3, 7200);
        Worker worker7 = null;
        List<Worker> workers = new ArrayList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);
        workers.add(worker6);
        workers.add(worker7);

        Map<Integer, Double> averageSalaryByDept = calculateAverageByDepartments(workers);

        averageSalaryByDept.forEach((dept, salary) -> System.out.println(" Key = " + dept + " Value = " + salary));
    }
}