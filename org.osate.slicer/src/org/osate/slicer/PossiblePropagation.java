package org.osate.slicer;

import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class PossiblePropagation {

	private final String srcName;
	private final String dstName;
	private final AnonymousTypeSet srcTypes;
	private final AnonymousTypeSet dstTypes;

	public PossiblePropagation(PropagationPathInstance ppi) {
		var src = ((ConnectionPath) ppi).getSourcePropagations().get(0);
		var dst = ((ConnectionPath) ppi).getDestinationPropagations().get(0);
		srcName = src.getInstanceObjectPath().replace(".EMV2", "");
		srcTypes = src.getOutTypeSet();
		dstName = dst.getInstanceObjectPath().replace(".EMV2", "");
		dstTypes = dst.getInTypeSet();
	}

	public Optional<String> getTarget(OsateSlicerVertex v) {
		String typeSetName = v.getName().substring(v.getName().lastIndexOf('.') + 1).replace("{", "").replace("}", "");
		if (Sets.powerSet(srcTypes.getElements().stream().map(TypeSetElement::getName).collect(Collectors.toSet()))
				.contains(ImmutableSet.of(typeSetName))
				&& Sets.powerSet(
						dstTypes.getElements().stream().map(TypeSetElement::getName).collect(Collectors.toSet()))
						.contains(ImmutableSet.of(typeSetName))) {
			return Optional.of(dstName + ".{" + typeSetName + "}");
		}
		return Optional.empty();
	}
}
