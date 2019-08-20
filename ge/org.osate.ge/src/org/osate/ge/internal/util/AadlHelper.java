/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.SubprogramCallSequence;

/**
 * Stand-alone static methods for working with AADL models
 *
 */
public class AadlHelper {
	/**
	 * Checks whether the named elements have the same name. Ignores case.
	 * @param ne1
	 * @param ne2
	 * @return
	 */
	public static boolean namesMatch(final NamedElement ne1, final NamedElement ne2) {
		if(ne1 == null || ne2 == null) {
			return ne1 == ne2;
		}

		if(ne1 == ne2) {
			return true;
		}

		final String n1 = ne1.getName();
		final String n2 = ne2.getName();
		return n1 != null && n1.equalsIgnoreCase(n2);
	}

	public static List<InternalFeature> getAllInternalFeatures(final ComponentImplementation ci) {
		EList<InternalFeature> returnList = new BasicEList<InternalFeature>();
		ComponentImplementation tmpCi = ci;
		while(tmpCi != null) {
			returnList.addAll(tmpCi.getOwnedInternalFeatures());
			tmpCi = tmpCi.getExtended();
		}

		return returnList;
	}

	public static List<ProcessorFeature> getAllProcessorFeatures(final ComponentImplementation ci) {
		EList<ProcessorFeature> returnList = new BasicEList<ProcessorFeature>();
		ComponentImplementation tmpCi = ci;
		while(tmpCi != null) {
			returnList.addAll(tmpCi.getOwnedProcessorFeatures());
			tmpCi = tmpCi.getExtended();
		}

		return returnList;
	}

	public static List<SubprogramCallSequence> getAllSubprogramCallSequences(final BehavioredImplementation bi) {
		EList<SubprogramCallSequence> returnList = new BasicEList<SubprogramCallSequence>();
		ComponentImplementation tmpCi = bi;
		while(tmpCi != null) {
			if(tmpCi instanceof BehavioredImplementation) {
				final BehavioredImplementation tmpBi = (BehavioredImplementation)tmpCi;
				returnList.addAll(tmpBi.getOwnedSubprogramCallSequences());
			}
			tmpCi = tmpCi.getExtended();
		}

		return returnList;
	}

	/**
	 * If the element is a refinable element, returns the root refined element. That is, it returns the refined element which is not refined.
	 * Otherwise it returns the specified element.
	 * @param ne
	 * @return
	 */
	public static NamedElement getRootRefinedElement(NamedElement ne) {
		if(ne instanceof RefinableElement) {
			NamedElement refined = ne;
			do {
				ne = refined;
				refined = ((RefinableElement) ne).getRefinedElement();
			} while(refined != null);
		}

		return ne;
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path from the container to the business object
	 * @param container
	 * @param bo
	 * @return
	 */
	public static Object[] getPathToBusinessObject(final EObject container, final EObject bo) {
		if (bo == null) {
			return null;
		}

		final LinkedList<Object> path = new LinkedList<>();
		EObject tmp = bo;
		do {
			path.addFirst(tmp);
			tmp = tmp.eContainer();
		} while (tmp != null && tmp != container);

		return path.toArray();
	}

	public static Set<IEObjectDescription> getEditablePackages(final IProject project) {
		return ScopedEMFIndexRetrieval
				.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage())
				.stream().filter(od -> od.getEObjectURI() != null && !od.getEObjectURI().isPlatformPlugin())
				.collect(Collectors.toSet());
	}

	public static <T extends Element> Optional<IProject> getCommonProject(final List<T> elements) {
		if (elements.isEmpty()) {
			return Optional.empty();
		}

		final IProject firstProject = ProjectUtil.getProjectForBo(elements.get(0)).orElse(null);
		for (int i = 1; i < elements.size(); i++) {
			if (firstProject != ProjectUtil.getProjectForBo(elements.get(i)).orElse(null)) {
				return Optional.empty();
			}
		}

		return Optional.ofNullable(firstProject);
	}

	public static <T extends Element> Optional<AadlPackage> getCommonPackage(final Collection<T> elements) {
		return Optional.ofNullable(elements.stream()
				.map(e -> e.getElementRoot() instanceof AadlPackage ? (AadlPackage) e.getElementRoot() : null)
				.reduce(null, (p1, p2) -> p1 == p2 ? p1 : null));
	}

}
