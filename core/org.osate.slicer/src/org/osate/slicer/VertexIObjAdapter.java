package org.osate.slicer;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.slicer.VertexIObjAdapter.AccessPropagationAdapter;
import org.osate.slicer.VertexIObjAdapter.BoundComponentInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.ErrorFlowInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.FeatureInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.PointPropagationAdapter;

sealed interface VertexIObjAdapter permits FeatureInstanceAdapter, PointPropagationAdapter, BoundComponentInstanceAdapter, AccessPropagationAdapter, ErrorFlowInstanceAdapter {

	record FeatureInstanceAdapter(String name, FeatureInstance instanceObject) implements VertexIObjAdapter {
		public FeatureInstanceAdapter(FeatureInstance feat) {
			this(feat.getInstanceObjectPath(), feat);
		}

		public EObject container() {
			return instanceObject.eContainer();
		}
	};

	record PointPropagationAdapter(String name, ComponentInstance instanceObject)
			implements VertexIObjAdapter {
		public PointPropagationAdapter(ComponentInstance comp, String propagationName) {
			this(comp.getInstanceObjectPath().replace(".EMV2", "") + "." + propagationName, comp);
		}
	}

	record BoundComponentInstanceAdapter(String name, ComponentInstance instanceObject)
			implements VertexIObjAdapter {
		public BoundComponentInstanceAdapter(ComponentInstance comp, BindingType bindingType) {
			this(comp.getInstanceObjectPath().replace(".EMV2", "") + "." + bindingType, comp);
		}
	}

	record AccessPropagationAdapter(String name, ComponentInstance instanceObject) implements VertexIObjAdapter {
		public AccessPropagationAdapter(ComponentInstance comp) {
			this(comp.getInstanceObjectPath() + ".access", comp);
		}

		public EObject container() {
			return instanceObject.eContainer();
		}
	}

	record ErrorFlowInstanceAdapter(String name, ErrorFlowInstance instanceObject) implements VertexIObjAdapter {
		public ErrorFlowInstanceAdapter(ErrorFlowInstance efi) {
			this(efi.getInstanceObjectPath().replace(".EMV2", ""), efi);
		}
	}

	public InstanceObject instanceObject();

	public String name();

}