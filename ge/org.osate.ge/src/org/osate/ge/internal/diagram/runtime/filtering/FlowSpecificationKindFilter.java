package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Objects;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.util.StringUtil;

public class FlowSpecificationKindFilter implements ContentFilter {
	private final FlowKind kind;
	private final String id;

	public FlowSpecificationKindFilter(final FlowKind kind) {
		this.kind = Objects.requireNonNull(kind, "kind must not be null");
		this.id = getId(kind);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return FlowSpecificationFilter.ID;
	}

	@Override
	public String getName() {
		switch (kind) {
		case PATH:
			return "Paths";
		case SINK:
			return "Sinks";
		case SOURCE:
			return "Sources";
		default:
			throw new RuntimeException("Unsupported kind: " + kind);
		}
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ComponentClassifier || bo instanceof Subcomponent;
	}

	@Override
	public boolean test(Object bo) {
		return bo instanceof FlowSpecification && ((FlowSpecification) bo).getKind() == kind;
	}

	public static String getId(final FlowKind kind) {
		return "flow" + StringUtil.capitalize(kind.getLiteral()) + "Specification";
	}
}
