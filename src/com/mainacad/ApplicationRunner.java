package com.mainacad;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.multithreads.MultithreadWrapper;

import java.util.*;
import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {
        List<String> connectionIPList = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();

        ConnectionInfo connectionInfo = ConnectionHelperInfo.getRandomConnactionInfo();
        for (int i = 1; i <= 100; i++) {
            MultithreadWrapper multithreadWrapper = new MultithreadWrapper("thread " + i, connectionInfo, connectionIPList);
            threads.add(multithreadWrapper);
            multithreadWrapper.start();
        }
        while (threadsAlive(threads)) {
            try {
                LOG.info("\n__________________________________________\nThreads still alive");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOG.info(connectionIPList.size() + " connection were written to file");

        // MAP ///////////////////////////////////////////////////////////////////////////////////////////

        Map<String, String> users = new HashMap<>();
        users.put("111", "Alex1");
        users.put("118", "Alex8");
        users.put("113", "Alex3");
        users.put("114", "Alex4");
        users.put("115", "Alex5");

        users.put("111", "Nikita");
        users.put(null, "Gleb");

        System.out.println(users.toString());

//        for (String key : users.keySet()) {
//            String value = users.get(key);
//            LOG.info("Key with " + key + " has value \"" + value + "\"");
//        }

        users.keySet().forEach(key -> LOG.info("Key with " + key + " has value \"" + users.get(key) + "\""));

//        // lambda
//        LOG.info("Result is " + (15,10));
//        {(15, 10) ->

    }

    private static boolean threadsAlive(List<Thread> threads) {
        for (Thread each : threads) {
            if (each.isAlive() || each.getState().equals(Thread.State.NEW)) {
                return true;
            } else return false;
        }
        return false;
    }
}
