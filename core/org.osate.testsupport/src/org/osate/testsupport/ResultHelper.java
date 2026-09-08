/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.testsupport;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osate.result.AnalysisResult;
import org.osate.result.BooleanValue;
import org.osate.result.Diagnostic;
import org.osate.result.IntegerValue;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.result.StringValue;
import org.osate.result.Value;

public class ResultHelper {
	/*
	 * These two methods keep the undeclared checked exceptions that the Xtend compiler produced, because they are
	 * public API of this test support bundle and Xtend callers in the analyses test bundles rely on not having to
	 * declare them.
	 */
	@SuppressWarnings("deprecation") // URL(String) is deprecated since Java 20; kept to preserve URL parsing behavior
	public static AnalysisResult loadResult(ResourceSet resourceSet, String path) {
		try {
			Resource resource = resourceSet.createResource(URI.createURI(path));
			URL url = new URL("file:" + System.getProperty("user.dir") + "/../" + path);
			InputStream inputStream = url.openConnection().getInputStream();
			resource.load(inputStream, null);
			inputStream.close();
			List<EObject> contents = resource.getContents();
			return contents.isEmpty() ? null : (AnalysisResult) contents.getFirst();
		} catch (Throwable e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	public static void generateOrAssert(boolean generate, String resultPath, AnalysisResult actual) {
		try {
			ResourceSet resourceSet = actual.getModelElement().eResource().getResourceSet();
			if (generate) {
				URI uri = URI.createFileURI(System.getProperty("user.dir") + "/../" + resultPath);
				Resource resource = resourceSet.createResource(uri);
				resource.getContents().add(actual);
				resource.save(null);
			} else {
				AnalysisResult expected = loadResult(resourceSet, resultPath);
				assertAnalysisResult(resultPath, expected, actual);
			}
		} catch (Throwable e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	public static void assertAnalysisResult(String name, AnalysisResult expected, AnalysisResult actual) {
		assertEquals(expected.getResultType(), actual.getResultType());
		assertEquals(expected.getAnalysis(), actual.getAnalysis());
		assertEquals(expected.getMessage(), actual.getMessage());
		assertEObject(expected.getModelElement(), actual.getModelElement());
		assertEquals(expected.getResults().size(), actual.getResults().size());
		int resultCount = expected.getResults().size();
		for (int i = 0; i < resultCount; i++) {
			assertResult(name, expected.getResults().get(i), actual.getResults().get(i));
		}
	}

	public static void assertResult(String name, Result expected, Result actual) {
		assertEquals(expected.getResultType(), actual.getResultType());
		assertEquals(expected.getMessage(), actual.getMessage());
		assertEObject(expected.getModelElement(), actual.getModelElement());
		assertEquals(expected.getValues().size(), actual.getValues().size());
		int valueCount = expected.getValues().size();
		for (int i = 0; i < valueCount; i++) {
			assertValue(expected.getValues().get(i), actual.getValues().get(i));
		}
		assertEquals(expected.getDiagnostics().size(), actual.getDiagnostics().size());
		int diagnosticCount = expected.getDiagnostics().size();
		for (int i = 0; i < diagnosticCount; i++) {
			assertDiagnostic(expected.getDiagnostics().get(i), actual.getDiagnostics().get(i));
		}
		assertEquals(name, expected.getSubResults().size(), actual.getSubResults().size());
		int subResultCount = expected.getSubResults().size();
		for (int i = 0; i < subResultCount; i++) {
			assertResult(name, expected.getSubResults().get(i), actual.getSubResults().get(i));
		}
	}

	public static void assertValue(Value expected, Value actual) {
		assertEquals(expected.eClass().getName(), actual.eClass().getName());
		switch (expected) {
		case BooleanValue booleanValue -> assertEquals(booleanValue.isValue(), ((BooleanValue) actual).isValue());
		case IntegerValue integerValue -> {
			assertEquals(integerValue.getValue(), ((IntegerValue) actual).getValue());
			assertEquals(integerValue.getUnit(), ((IntegerValue) actual).getUnit());
		}
		case RealValue realValue -> {
			assertEquals(realValue.getValue(), ((RealValue) actual).getValue(), 0.000_001);
			assertEquals(realValue.getUnit(), ((RealValue) actual).getUnit());
		}
		case StringValue stringValue -> assertEquals(stringValue.getValue(), ((StringValue) actual).getValue());
		default -> {
			/* Other value kinds are not compared, matching the original Xtend switch without a default case. */
		}
		}
	}

	public static void assertDiagnostic(Diagnostic expected, Diagnostic actual) {
		assertEquals(expected.getDiagnosticType(), actual.getDiagnosticType());
		assertEquals(expected.getMessage(), actual.getMessage());
	}

	public static void assertEObject(EObject expected, EObject actual) {
		URI expectedURI = expected != null ? EcoreUtil.getURI(expected) : null;
		URI actualURI = actual != null ? EcoreUtil.getURI(actual) : null;
		assertEquals(expectedURI, actualURI);
	}
}
