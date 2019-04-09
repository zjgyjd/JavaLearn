package com.github.zjgyjd.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerrylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerrylliumSphere[] spheres = new BerrylliumSphere[10];//数组
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerrylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerrylliumSphere> sphereList = new ArrayList<BerrylliumSphere>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerrylliumSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList<>(
                Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
