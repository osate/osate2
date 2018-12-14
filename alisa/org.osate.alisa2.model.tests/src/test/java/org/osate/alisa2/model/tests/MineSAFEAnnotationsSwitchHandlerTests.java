package org.osate.alisa2.model.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.alisa2.model.safe2.builder.MineSAFEAnnotationsSwitchHandler;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
class MineSAFEAnnotationsSwitchHandlerTests extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	private MineSAFEAnnotationsSwitchHandler handler;

	@BeforeEach
	public void setUpOnce() {
		handler = new MineSAFEAnnotationsSwitchHandler();
		try {
			testHelper.testFile("org.osate.alisa2.model.tests/pkg.aadl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		assertTrue(handler.propFound);
	}

}
