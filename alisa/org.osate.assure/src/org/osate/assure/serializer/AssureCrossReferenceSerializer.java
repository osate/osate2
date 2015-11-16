/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

public class AssureCrossReferenceSerializer extends CrossReferenceSerializer {
	@Override
	protected String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
			final IScope scope, Acceptor errors) {
//		if (target instanceof AadlPackage) {
//			return ((NamedElement) target).getName();
//		} else if (target instanceof Classifier) {
//			return AadlUtil.getClassifierName((Classifier) target, (Element) semanticObject);
//		} else if (target instanceof Property || target instanceof PropertyType || target instanceof PropertyConstant) {
//			return AadlUtil.getPropertySetElementName((NamedElement) target);
//		} else if (target instanceof NamedElement) {
//			return ((NamedElement) target).getName();
//		} else {
//			return "<noname>";
//		}
		if (target instanceof EObject) {
			EObject io = (EObject) target;
			URI uri = EcoreUtil.getURI(io);
			return "\"" + uri.toString() + "\"";
		}
		return super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}
}