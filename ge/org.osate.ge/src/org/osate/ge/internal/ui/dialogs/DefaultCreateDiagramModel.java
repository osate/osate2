package org.osate.ge.internal.ui.dialogs;

import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.diagram.runtime.types.DiagramTypeProvider;
import org.osate.ge.internal.diagram.runtime.types.PackageDiagramType;
import org.osate.ge.internal.diagram.runtime.types.StructureDiagramType;

import com.google.common.collect.ImmutableCollection;

public class DefaultCreateDiagramModel implements CreateDiagramDialog.Model<DiagramType> {
	private final DiagramTypeProvider diagramTypeProvider;
	private final IProject project;
	private final Object contextBo;

	public DefaultCreateDiagramModel(final DiagramTypeProvider diagramTypeProvider, final IProject project,
			final Object contextBo) {
		this.diagramTypeProvider = Objects.requireNonNull(diagramTypeProvider, "diagramTypeProvider must nto be null");
		this.project = project;
		this.contextBo = contextBo;
	}

	@Override
	public ImmutableCollection<DiagramType> getDiagramTypes() {
		return diagramTypeProvider.getApplicableDiagramTypes(contextBo);
	}

	@Override
	public String getDiagramTypeName(DiagramType diagramType) {
		return diagramType.getName();
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public String getDefaultName() {
		if (contextBo instanceof NamedElement) {
			return ((NamedElement) contextBo).getQualifiedName().replaceAll("::|:|\\.", "_");
		} else {
			return null;
		}
	}

	@Override
	public DiagramType getDefaultDiagramType() {
		if (contextBo == null) {
			return diagramTypeProvider.getDiagramTypeById(CustomDiagramType.ID).orElse(null);
		} else if (contextBo instanceof AadlPackage) {
			return diagramTypeProvider.getDiagramTypeById(PackageDiagramType.ID).orElse(null);
		} else if (contextBo instanceof Classifier || contextBo instanceof SystemInstance) {
			return diagramTypeProvider.getDiagramTypeById(StructureDiagramType.ID).orElse(null);
		} else {
			return null;
		}
	}
}
