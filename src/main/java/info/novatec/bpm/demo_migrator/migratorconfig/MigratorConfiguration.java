package info.novatec.bpm.demo_migrator.migratorconfig;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.novatec.camunda.migrator.ProcessInstanceMigrator;

@Configuration
public class MigratorConfiguration {

    @Autowired
    private ProcessEngine processEngine;

    @Bean
    public ProcessInstanceMigrator processInstanceMigrator() {
        return new ProcessInstanceMigrator(processEngine);
    }

}