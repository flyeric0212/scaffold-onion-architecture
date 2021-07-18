package top.flyeric.base;

// @Import({DbTestConfig.class})
// @TestExecutionListeners(
// value = {DependencyInjectionTestExecutionListener.class,
// DirtiesContextTestExecutionListener.class,
// TransactionalTestExecutionListener.class,
// DbUnitTestExecutionListener.class},
// mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
// @DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection", dataSetLoader =
// YamlDataSetLoader.class)
// @AutoConfigureTestDatabase(replace = NONE)
// @DataJpaTest
// @RunWith(SpringRunner.class)
// @ActiveProfiles("test")
public abstract class DbTestBase {

}
