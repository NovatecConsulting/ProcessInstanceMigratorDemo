package info.novatec.bpm.demo_migrator.migratorconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import info.novatec.camunda.migrator.ProcessInstanceMigrator;

@Component
public class OnStartupMigrator {

    @Autowired
    private ProcessInstanceMigrator processInstanceMigrator;

    @EventListener(ApplicationReadyEvent.class)
    public void migrateAllProcessInstances() {
        //processInstanceMigrator.migrateInstancesOfAllProcesses();
    }
}
