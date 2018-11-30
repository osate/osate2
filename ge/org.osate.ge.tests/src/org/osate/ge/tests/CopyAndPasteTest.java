package org.osate.ge.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

public class CopyAndPasteTest {
	private static final String projectName = "copy_and_paste_test";
	private static final String pkgName = "pkg1";
	private static final String sysName = "sys1";

	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.createNewProject(projectName);
	}

	@After
	public void tearDown() {
		bot.deleteProject(projectName);
	}

	@Test
	public void testCopyingAndPasting() {
		final AgeSWTBotGefEditor pkgDiagramEditor = bot.createAADLPackage(projectName, pkgName);

		// Create initial package, system, and port
		pkgDiagramEditor.element(pkgName).createChild("System Type", sysName, new Point(20, 20));
		pkgDiagramEditor.element(pkgName, sysName).createChild("Data Port", "p1", new Point(15, 15));
		pkgDiagramEditor.element(pkgName).resize(300, 300);

		// Verify that paste is disabled
		assertFalse("paste is disabled", getPasteMenuItem().isEnabled());

		// Select System and Copy
		pkgDiagramEditor.element(pkgName, sysName).select();
		getCopyMenuItem().click();

		// Make copy of children of package and a reference to the original system element for later comparison
		final DiagramElement pkgElement = pkgDiagramEditor.element(pkgName).getDiagramElement();
		final Set<DiagramElement> originalPkgChildren = ImmutableSet.copyOf(pkgElement.getDiagramElements());
		final DiagramElement sysElement = pkgDiagramEditor.element(pkgName, sysName).getDiagramElement();

		// Select Package and Paste
		pkgDiagramEditor.element(pkgName).select();
		getPasteMenuItem().click();

		// Sleep to allow time for the paste to complete
		bot.sleep(1);

		// Verify that a single new child for the package element was created
		final HashSet<DiagramElement> newPkgChildren = new HashSet<>(pkgElement.getDiagramElements());
		newPkgChildren.removeAll(originalPkgChildren);
		assertEquals("Package should have a single new child", 1, newPkgChildren.size());

		// Compare the new element with the system element
		final DiagramElement newElement = newPkgChildren.iterator().next();
		assertElementsMatch(sysElement, newElement, false, false);

		// Create second diagram for package
		final AgeSWTBotGefEditor customDiagramEditor = pkgDiagramEditor.element(pkgName).openNewDiagram("diagram2", "Custom Diagram");

		// Verify that the package on the new diagram is empty
		final DiagramElement pkgElement2 = customDiagramEditor.element(pkgName).getDiagramElement();
		assertEquals("Package on custom diagram should be empty", 0, pkgElement2.getDiagramElements().size());

		// Copy diagram element from first
		pkgDiagramEditor.show();
		pkgDiagramEditor.element(pkgName, sysName).select();
		getCopyDiagramElementsMenuItem().click();

		// Switch to second diagram and paste the diagram elements.
		customDiagramEditor.show();
		customDiagramEditor.element(pkgName).select();
		getPasteMenuItem().click();

		// Verify that the diagrams elements exist. Since only the diagram element were pasted, the model element names
		// should be the same. The names for the diagram elements should match.
		assertEquals("Package on custom diagram should have a single child", 1,
				pkgElement2.getDiagramElements().size());
		final DiagramElement newElement2 = pkgElement2.getDiagramElements().iterator().next();
		assertElementsMatch(sysElement, newElement2, true, false);
	}

	private SWTBotMenu getCopyMenuItem() {
		return bot.getActiveShell().menu().menu("Edit", "Copy");
	}

	private SWTBotMenu getCopyDiagramElementsMenuItem() {
		return bot.getActiveShell().menu().menu("Edit", "Copy Diagram Elements");
	}

	private SWTBotMenu getPasteMenuItem() {
		return bot.getActiveShell().menu().menu("Edit", "Paste");
	}

	/**
	 * Asserts that the specified elements "match" for the purposes of this test. Checks size, style, and descendants.
	 * Optionally compares name and position of specified element. Names and positions are always checks for descendants.
	 * @param e1
	 * @param e2
	 * @param compareNames
	 * @param comparePositions
	 */
	private void assertElementsMatch(final DiagramElement e1, final DiagramElement e2,
			final boolean compareNames, final boolean comparePositions) {
		assertEquals("sizes do not match", e1.getSize(), e2.getSize());
		assertEquals("styles do not match", e1.getStyle(), e2.getStyle());

		// Optionally, compare names. Useful for children
		if (compareNames) {
			assertEquals("names do not match", e1.getLabelName(), e2.getLabelName());
		}

		// Optionally, compare position. Useful for children
		if (comparePositions) {
			assertEquals("positions do not match", e1.getPosition(), e2.getPosition());
		}

		assertEquals("number of children do not match for " + e1.getLabelName(), e1.getDiagramElements().size(),
				e2.getDiagramElements().size());

		for (DiagramElement c1 : e1.getDiagramElements()) {
			assertElementsMatch(c1, getChildByName(e2, c1.getLabelName()), true, true);
		}
	}

	private DiagramElement getChildByName(final DiagramElement parent, final String searchName) {
		for (DiagramElement c : parent.getDiagramElements()) {
			if (Objects.equal(c.getLabelName(), searchName)) {
				return c;
			}
		}

		throw new RuntimeException("Unable to find diagram element with name: " + searchName);
	}
}
