package org.osate.ge.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		OpenElementPackageDiagramTest.class, InModesTest.class, CreateFlowImplTest.class,
		InstantiateAndOpenImplTest.class,
		CreateNewAADLPackageTest.class, OpenExistingAADLModelTest.class, RenameClassifierTest.class,
		OpenAssociatedDiagramTest.class, GoToTypeDiagramTest.class, DeletingClassifierTest.class,
		SelectingDiagramElementContainerTest.class, PerformDiagramLayoutTest.class, CreateConnectionTest.class,
		SetExtendedClassifierTest.class, FeatureGroupTest.class, ModesTransitionTest.class,
		MoveShapeUsingKeysTest.class, ElementAppearanceTest.class, DiagramExporterTest.class, DirtyStateTest.class,
		AlignElementsTest.class, CopyAndPasteTest.class, DemoSystemTest.class
})
public class AllTests {
}
