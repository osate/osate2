package org.osate.core.tests.issues;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.impl.FlowEndImpl;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1991Test {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	private List<String> errorList;
	private final String PATH = "org.osate.core.tests/models/issue1991/";

	@Test
	public void fgTest() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + "FeatureGroupTest.aadl");
		ThreadImplementation impl = (ThreadImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		List<FlowEndImpl> objects = new ArrayList<FlowEndImpl>();
		impl.eAllContents().forEachRemaining(x -> {
			if (x instanceof FlowEndImpl) {
				objects.add((FlowEndImpl) x);
			}
		});
		objects.get(0).getContext();
		FluentIssueCollection list = testHelper.testFile(PATH + "FeatureGroupTest.aadl", "");
		errorList = new ArrayList<String>();
		list.errorsOnly().forEach(x -> errorList.add(x.getMessage()));

		// AssertHelper.assertError(eObject, allIssues, issueCollection, expectedMessages);

		Assert.assertEquals("'fg.inPort' must be an out or in out feature.", errorList.get(0));
		Assert.assertEquals("'fg_inv.outPort' must be an out or in out feature.", errorList.get(1));
		Assert.assertEquals("'fg.outPort' must be an in or in out feature.", errorList.get(2));
		Assert.assertEquals("'fg_inv.inPort' must be an in or in out feature.", errorList.get(3));
		Assert.assertEquals("'fg.outPort' must be an in or in out feature.", errorList.get(4));
		Assert.assertEquals("'fg_inv.outPort' must be an out or in out feature.", errorList.get(5));
		Assert.assertEquals("'fg_inv.inPort' must be an in or in out feature.", errorList.get(6));
		Assert.assertEquals("'fg.inPort' must be an out or in out feature.", errorList.get(7));
	}

	@Test
	public void fgtTest() throws Exception {
		FluentIssueCollection list = testHelper.testFile(PATH + "FeatureGroupTypeTest.aadl", "");
		errorList = new ArrayList<String>();
		list.errorsOnly().forEach(x -> errorList.add(x.getMessage()));

		Assert.assertEquals("'fg.inPort' must be an out or in out feature.", errorList.get(0));
		Assert.assertEquals("'fg_inv.outPort' must be an out or in out feature.", errorList.get(1));
		Assert.assertEquals("'fg.outPort' must be an in or in out feature.", errorList.get(2));
		Assert.assertEquals("'fg_inv.inPort' must be an in or in out feature.", errorList.get(3));
		Assert.assertEquals("'fg.outPort' must be an in or in out feature.", errorList.get(4));
		Assert.assertEquals("'fg_inv.outPort' must be an out or in out feature.", errorList.get(5));
		Assert.assertEquals("'fg_inv.inPort' must be an in or in out feature.", errorList.get(6));
		Assert.assertEquals("'fg.inPort' must be an out or in out feature.", errorList.get(7));
	}

}
