package top.flyeric.archtest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = LayeredArchitectureTest.PACKAGE)
public class LayeredArchitectureTest {

    public static final String PACKAGE = "top.flyeric";

    @ArchTest
    static final ArchRule onion_dependencies_are_respected = Architectures
            .onionArchitecture()
            .domainModels("..domain.model..")
            .domainServices("..domain.service..")
            .applicationServices("..application..")
            .adapter("infra", "..infrastructure..")
            .adapter("rest", "..presentation..")
            .withOptionalLayers(true);
}
