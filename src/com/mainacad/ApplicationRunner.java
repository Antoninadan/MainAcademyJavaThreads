package com.mainacad;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.multithreads.MultithreadWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
