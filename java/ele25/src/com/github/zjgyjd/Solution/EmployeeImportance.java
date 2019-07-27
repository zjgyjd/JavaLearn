package com.github.zjgyjd.Solution;

import java.util.HashMap;
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
        HashMap<Integer,Employee> e = new HashMap<>();
        for(Employee i : employees){
            e.put(i.id,i);
        }
        DFS(e, id);
        return sum;
    }

    public void DFS(HashMap<Integer,Employee> em, int id) {
                Employee e = em.get(id);
                sum += e.importance;
                if (!e.subordinates.isEmpty()) {
                    for (Integer x : e.subordinates) {
                        DFS(em, x);
                    }
                }
    }
}
