package com.github.zjgyjd.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    public Integer sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        HashMap<Integer, Employee> e = new HashMap<>();
        for (Employee i : employees) {
            e.put(i.id, i);
        }
        DFS(e, id);
        return sum;
    }

    public void DFS(HashMap<Integer, Employee> em, int id) {
        Employee e = em.get(id);
        sum += e.importance;
        if (!e.subordinates.isEmpty()) {
            for (Integer x : e.subordinates) {
                DFS(em, x);
            }
        }
    }

    public int getImportance_01(List<Employee> employees, int id) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            Employee target = map.get(queue.getFirst());
            sum += target.importance;
            if(!target.subordinates.isEmpty()){
                queue.addAll(target.subordinates);
            }
            queue.remove();
        }
        return sum;
    }
}
