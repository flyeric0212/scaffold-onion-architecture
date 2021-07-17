package top.flyeric.archtest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "top.flyeric")
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .optionalLayer("Presentation").definedBy("top.flyeric.presentation..")
            .optionalLayer("Application").definedBy("top.flyeric.application..")
            .optionalLayer("Domain").definedBy("top.flyeric.domain..")
            .optionalLayer("Infrastructure").definedBy("top.flyeric.infrastructure..")
            .optionalLayer("Common").definedBy("top.flyeric.common..")

            .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Presentation")
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Infrastructure")
            // TODO: fixme
            .whereLayer("Infrastructure").mayOnlyBeAccessedByLayers("Presentation");

}
