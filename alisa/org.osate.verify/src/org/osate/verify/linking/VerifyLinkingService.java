package org.osate.verify.linking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.verify.verify.ResoluteMethod;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

public class VerifyLinkingService extends DefaultLinkingService {// PropertiesLinkingService {
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		String name = getCrossRefNodeAsString(node);
		EObject e = getLinkedObject(context, reference, name);
		if (e != null) {
			return Collections.singletonList(e);
		}
		return super.getLinkedObjects(context, reference, node);
	}

	private EObject getLinkedObject(EObject context, EReference reference, String name) {
//			name = name.replaceAll("::", ".");

		if (context instanceof ResoluteMethod) {
			return getFunctionDefinition(context, name);
		}

		return null;
	}

//		@Override
//		public String getQualifiedName(String packageOrPropertySetName, String elementName) {
//			if (packageOrPropertySetName == null) {
//				return elementName;
//			} else {
//				return packageOrPropertySetName + "." + elementName;
//			}
//		}

	private static EObject getFunctionDefinition(EObject context, String name) {
		return getNamedElementByType(context, name, ResolutePackage.Literals.FUNCTION_DEFINITION);
	}

	private static EObject getNamedElementByType(EObject context, String name, EClass eclass) {
		// This code will only link to objects in the projects visible from the current project
		Iterable<IEObjectDescription> allObjectTypes = EMFIndexRetrieval.getAllEObjectsOfTypeInWorkspace(context,
				eclass);

		String contextProject = context.eResource().getURI().segment(1);
		List<String> visibleProjects = getVisibleProjects(contextProject);

		for (IEObjectDescription eod : allObjectTypes) {
			if (sameName(eod, name) && isVisible(eod, visibleProjects)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, context.eResource().getResourceSet());
				if (!Aadl2Util.isNull(res)) {
					return res;
				}
			}
		}

		return null;
	}

	private static boolean sameName(IEObjectDescription eod, String name) {
		return eod.getName().getLastSegment().equalsIgnoreCase(name);
	}

	private static boolean isVisible(IEObjectDescription eod, List<String> visibleProjects) {
		URI uri = eod.getEObjectURI();
		String project = uri.segment(1);
		return visibleProjects.contains(project);
	}

	private static List<String> getVisibleProjects(String contextProjectName) {
		List<String> result = new ArrayList<>();
		result.add(contextProjectName);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject contextProject = root.getProject(URI.decode(contextProjectName));
		if (!contextProject.exists() || !contextProject.isAccessible() || !contextProject.isOpen())
			return result;
		try {
			IProjectDescription description = contextProject.getDescription();
			for (IProject referencedProject : description.getReferencedProjects()) {
				result.add(URI.encodeSegment(referencedProject.getName(), false));
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		return result;
	}

}
