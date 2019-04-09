package com.github.zjgyjd.generic;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method m : type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }
    static void difference(Class<?> superset,Class<?> subset){
        System.out.print(superset.getSimpleName()+" extends "+subset.getSimpleName()+", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset),methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }
//打印Collection与Map的一些信息
    public static void main(String[] args) {
        System.out.println("Collection: "+methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class,Collection.class);
        difference(HashSet.class,Set.class);
        difference(LinkedHashSet.class,HashSet.class);
        difference(TreeSet.class,Set.class);
        difference(List.class,Collection.class);
        difference(ArrayList.class,List.class);
        difference(LinkedList.class,List.class);
        difference(Queue.class,Collection.class);
        difference(PriorityQueue.class,Queue.class);
        System.out.println("Map: "+methodSet(Map.class));
        difference(HashSet.class,Map.class);
        difference(LinkedHashSet.class,HashMap.class);
        difference(SortedMap.class,Map.class);
        difference(TreeMap.class,Map.class);
    }
}
