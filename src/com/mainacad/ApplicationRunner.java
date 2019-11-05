package com.mainacad;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.multithreads.MultithreadWrapper;

import java.util.*;
import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {
//        List<String> connectionIPList = Collections.synchronizedList(new ArrayList<>());
//        List<Thread> threads = new ArrayList<>();
//
//        ConnectionInfo connectionInfo = ConnectionHelperInfo.getRandomConnactionInfo();
//        for (int i = 1; i <= 100; i++) {
//            MultithreadWrapper multithreadWrapper = new MultithreadWrapper("thread " + i, connectionInfo, connectionIPList);
//            threads.add(multithreadWrapper);
//            multithreadWrapper.start();
//        }
//
//        while (threadsAlive(threads)) {
//            try {
//                LOG.info("\n__________________________________________\nThreads still alive");
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        LOG.info(connectionIPList.size() + " connection were written to file");

//        // MAP ///////////////////////////////////////////////////////////////////////////////////////////
//
//        Map<String, String> users = new HashMap<>();
//        users.put("111", "Alex1");
//        users.put("118", "Alex8");
//        users.put("113", "Alex3");
//        users.put("114", "Alex4");
//        users.put("115", "Alex5");
//
//        users.put("111", "Nikita");
//        users.put(null, "Gleb");
//
//        System.out.println(users.toString());
//
////        for (String key : users.keySet()) {
////            String value = users.get(key);
////            LOG.info("Key with " + key + " has value \"" + value + "\"");
////        }
//
//        users.keySet().forEach(key -> LOG.info("Key with " + key + " has value \"" + users.get(key) + "\""));

//        Operation operation = new Operation() {
//            @Override
//            public int calculate(int num1, int num2) {
//                return num1 + num2;
//            }
//        };

//        // functional interface
//        Operation operation = ((num1, num2) -> num1 + num2);
//        int result = operation.calculate(10, 20);
//        System.out.println("result = " + result);
//
//        operation = ((num1, num2) -> num1 + num2 + 1000);
//        result = operation.calculate(10, 20);
//        System.out.println("result = " + result);
//
//
//        // streams
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i < 20; i++) {
//            numbers.add(i);
//        }
//
//        numbers.stream().filter(it -> it % 2 != 0).forEach(it -> LOG.info("Filter is " + it));
//
//        System.out.println("numbers = " + numbers);
//        System.out.println("numbers = " + numbers);
    }

    private static boolean threadsAlive(List<Thread> threads) {
        for (Thread each : threads) {
            if (each.isAlive() || each.getState().equals(Thread.State.NEW)) {
                return true;
            } else return false;
        }
        return false;
    }

    class InnerClas {  // static

    }

    enum InnerEnum {
        ONE,
        TWO
    }

    interface Operation {
        int calculate(int num1, int num2);
    }


}
