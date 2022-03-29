package info.novatec.bpm.demo_migrator.migratorconfig;

import java.util.Arrays;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.migration.MigrationInstructionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.novatec.camunda.migrator.MigrationInstructions;
import info.novatec.camunda.migrator.MinorMigrationInstructions;
import info.novatec.camunda.migrator.ProcessInstanceMigrator;

@Configuration
public class MigratorConfiguration {

    @Autowired
    private ProcessEngine processEngine;

    @Bean
    public ProcessInstanceMigrator processInstanceMigrator() {
        ProcessInstanceMigrator migrator = new ProcessInstanceMigrator(processEngine);
        migrator.setMigrationInstructions(generateMigrationInstructions());
        return migrator;
    }

    private MigrationInstructions generateMigrationInstructions() {
        return MigrationInstructions.builder()
            .putInstructions("planeSelling", Arrays.asList(
                                instructionsPlaneSelling100To110(),
                                instructionsPlaneSelling110To120()
//                                , instructionsPlaneSelling120To130()
//                                , instructionsPlaneSelling130To140()
                                ))
            .build();
    }

    private MinorMigrationInstructions instructionsPlaneSelling100To110() {
        return MinorMigrationInstructions.builder()
            .sourceMinorVersion(0)
            .targetMinorVersion(1)
            .majorVersion(1)
            .migrationInstructions(Arrays.asList(
                    new MigrationInstructionImpl("UserTask_UnterlagenAnfordern", "UserTask_UnterlagenErstellen")))
            .build();
    }

    private MinorMigrationInstructions instructionsPlaneSelling110To120() {
        return MinorMigrationInstructions.builder()
            .sourceMinorVersion(1)
            .targetMinorVersion(2)
            .majorVersion(1)
            .migrationInstructions(Arrays.asList(
                    new MigrationInstructionImpl("ReceiveTask_DokumenteErhalten", "ReceiveTask_DokumenteErhalten")))
            .build();
    }
    
//    private MinorMigrationInstructions instructionsPlaneSelling120To130() {
//        return MinorMigrationInstructions.builder()
//            .sourceMinorVersion(2)
//            .targetMinorVersion(3)
//            .majorVersion(1)
//            .migrationInstructions(Arrays.asList(
//                    new MigrationInstructionImpl("UserTask_UnterlagenErstellen", "ServiceTask_UnterlagenErstellen")))
//            .build();
//    }
//
//    private MinorMigrationInstructions instructionsPlaneSelling130To140() {
//        return MinorMigrationInstructions.builder()
//            .sourceMinorVersion(3)
//            .targetMinorVersion(4)
//            .majorVersion(1)
//            .migrationInstructions(Arrays.asList(
//                    new MigrationInstructionImpl("ServiceTask_UnterlagenErstellen", "UserTask_ErstellenKnopfDruecken")))
//            .build();
//    }

}