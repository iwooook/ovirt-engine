package org.ovirt.engine.core.bll.hostdeploy;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.ovirt.engine.core.common.BackendService;
import org.ovirt.engine.core.utils.threadpool.ThreadPools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DummyService implements BackendService {

    private static final Logger log = LoggerFactory.getLogger(DummyService.class);

    @Inject
    @ThreadPools(ThreadPools.ThreadPoolType.EngineScheduledThreadPool)
    private ManagedScheduledExecutorService scheduledExecutor;

    @PostConstruct
    public void scheduleJob() {
        long rateInMinutes = 1;
        scheduledExecutor.scheduleWithFixedDelay(this::printLog, 15, rateInMinutes, TimeUnit.MINUTES);
    }

    private void printLog() {
        //log.info("info log from DummyService");
    }
}