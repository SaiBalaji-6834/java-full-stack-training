package DAY8;

import java.io.*;
import java.lang.ref.*;
import java.util.*;

class MemoryLeakDetector {
    private static final int SIZE = 100000;
    private static final WeakHashMap<Integer, byte[]> cache = new WeakHashMap<>();
    
    static void createLeak() {
        for (int i = 0; i < SIZE; i++) cache.put(i, new byte[1024]);
    }
    
    static void monitorMemory() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());
    }
    
    public static void main(String[] args) {
        createLeak();
        monitorMemory();
        System.gc();
        System.out.println("After GC:");
        monitorMemory();
    }
}
