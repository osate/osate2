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
package org.osate.xtext.aadl2.resource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.ParseResultHolder;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;
import com.google.inject.Singleton;

// TODO: cache injectors per resource
@Singleton
public class Aadl2DerivedStateComputer implements IDerivedStateComputer {

	@Override
	public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		var annexElements = getAllAnnexElements(resource);
		var injectors = collectInjectors(annexElements);

		for (var injector : injectors) {
			try {
				var dsc = injector.getInstance(IDerivedStateComputer.class);
				dsc.installDerivedState(resource, preLinkingPhase);
			} catch (ConfigurationException e) {
				// ignore: no derived state for this annex
			}
		}
	}

	@Override
	public void discardDerivedState(DerivedStateAwareResource resource) {
		var annexElements = getAllAnnexElements(resource);
		var injectors = collectInjectors(annexElements);

		for (var injector : injectors) {
			try {
				injector.getInstance(IDerivedStateComputer.class).discardDerivedState(resource);
			} catch (ConfigurationException e) {
				// ignore: no derived state for this annex
			}
		}
	}

	/*
	 * The return type stays ArrayList because this is published API of the bundle and the Xtend compiler inferred
	 * ArrayList for it.
	 */
	public static ArrayList<NamedElement> getAllAnnexElements(Resource resource) {
		var allContents = EcoreUtil.getAllContents(resource, false);
		var result = new ArrayList<NamedElement>();
		try {
			while (allContents.hasNext()) {
				var object = (EObject) allContents.next();
				/*
				 * Descend into packages and their sections, collect the parsed annex of every default annex, and
				 * prune everything else. A null container is the resource's root object.
				 */
				switch (object.eContainer()) {
				case AadlPackage aadlPackage -> {
					// keep descending into the package
				}
				case PackageSection packageSection -> {
					if (object instanceof DefaultAnnexLibrary library) {
						var parsedAnnexLibrary = library.getParsedAnnexLibrary();
						if (parsedAnnexLibrary != null) {
							result.add(parsedAnnexLibrary);
						}
						allContents.prune();
					}
				}
				case Classifier classifier -> {
					if (object instanceof DefaultAnnexSubclause subclause) {
						var parsedAnnexSubclause = subclause.getParsedAnnexSubclause();
						if (parsedAnnexSubclause != null) {
							result.add(parsedAnnexSubclause);
						}
					}
					allContents.prune();
				}
				case null -> {
					// the root object, keep descending
				}
				default -> allContents.prune();
				}
			}
		} catch (IndexOutOfBoundsException e) {
			// ignore: stop collecting when the tree iterator runs past the end
		}
		return result;
	}

	public static ArrayList<Injector> collectInjectors(List<NamedElement> annexElements) {
		var names = new HashSet<String>();
		var injectors = new ArrayList<Injector>();
		for (var annex : annexElements) {
			if (!names.contains(annex.getName())) {
				var annexParseResult = ParseResultHolder.Factory.INSTANCE.adapt(annex).getParseResult();
				if (annexParseResult != null) {
					var injector = AnnexUtil.getInjector(annexParseResult);
					if (injector != null) {
						injectors.add(injector);
					}
					names.add(annex.getName());
				}
			}
		}
		return injectors;
	}

	public static String getGrammarName(INode node) {
		var grammarResource = node.getGrammarElement().eResource();
		var contents = grammarResource.getContents();
		var grammar = contents.isEmpty() ? null : contents.getFirst();

		return grammar instanceof Grammar namedGrammar ? namedGrammar.getName() : null;
	}

}
