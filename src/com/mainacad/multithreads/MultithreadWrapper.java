package com.mainacad.multithreads;

import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.FileService;

import java.util.List;
import java.util.logging.Logger;

public class MultithreadWrapper extends Thread {
    private final ConnectionInfo connectionInfo;
    private final String threadName;
    private static final Logger LOG = Logger.getLogger(MultithreadWrapper.class.getName());
    private List connectionIPList;

    public MultithreadWrapper(String threadName, ConnectionInfo connectionInfo, List connectionIPList) {
        this.connectionInfo = connectionInfo;
        this.threadName = threadName;
        this.connectionIPList = connectionIPList;
    }

    @Override
    public void run() {
        LOG.info(threadName + " was started!");
        FileService.writeTextToFile(connectionInfo.toString(), "multi.txt", true);
        connectionIPList.add(connectionInfo.getIp());
    }
}
