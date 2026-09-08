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
package org.osate.xtext.aadl2.serializer;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext.RuleContext;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

import com.google.inject.Inject;

public class Aadl2SemanticSequencer extends AbstractAadl2SemanticSequencer {

	@Inject
	private Aadl2GrammarAccess grammarAccess;

	AnnexUnparserRegistry unparserRegistry;

	protected AnnexUnparserRegistry getAnnexUnparserRegistry() {
		if (unparserRegistry == null) {
			unparserRegistry = (AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID);
		}
		return unparserRegistry;
	}

	@Override
	public void createSequence(ISerializationContext context, EObject semanticObject) {
		/*
		 * A default annex whose parser rule does not match falls through to the superclass, so these are guarded
		 * patterns rather than plain type patterns.
		 */
		switch (semanticObject) {
		case DefaultAnnexLibrary library when context.getParserRule() == grammarAccess.getAnnexLibraryRule()
				|| context.getParserRule() == grammarAccess.getDefaultAnnexLibraryRule() -> {
			unparseAnnexLibrary(library);
			sequence_DefaultAnnexLibrary(context, library);
		}
		case DefaultAnnexSubclause subclause when context.getParserRule() == grammarAccess.getAnnexSubclauseRule()
				|| context.getParserRule() == grammarAccess.getDefaultAnnexSubclauseRule() -> {
			unparseAnnexSubclause(subclause);
			sequence_DefaultAnnexSubclause(context, subclause);
		}
		case null, default -> super.createSequence(context, semanticObject);
		}
	}

	/*
	 * Serialize if there is an unparser and the annex has been parsed, otherwise use the original annex text.
	 * The Xtend template rendered a null substitution as the empty string, so an unparser that returns null still
	 * yields an empty annex rather than the text "null".
	 */
	private void unparseAnnexLibrary(DefaultAnnexLibrary library) {
		var parsedLibrary = library.getParsedAnnexLibrary();
		var annexUnparser = getAnnexUnparserRegistry().getAnnexUnparser(library.getName());
		if (parsedLibrary == null || annexUnparser == null) {
			return;
		}
		try {
			performModification(library, () -> {
				var unparsed = annexUnparser.unparseAnnexLibrary(parsedLibrary, "  ");
				library.setSourceText("{**" + Objects.requireNonNullElse(unparsed, "") + "**}");
			});
		} catch (Exception e) {
			throw new RuntimeException("Error while serializing " + library.getName() + " annex library", e);
		}
	}

	private void unparseAnnexSubclause(DefaultAnnexSubclause subclause) {
		var parsedSubclause = subclause.getParsedAnnexSubclause();
		var annexUnparser = getAnnexUnparserRegistry().getAnnexUnparser(subclause.getName());
		if (parsedSubclause == null || annexUnparser == null) {
			return;
		}
		try {
			performModification(subclause, () -> {
				var unparsed = annexUnparser.unparseAnnexSubclause(parsedSubclause, "  ");
				subclause.setSourceText("{**" + Objects.requireNonNullElse(unparsed, "") + "**}");
			});
		} catch (Exception e) {
			throw new RuntimeException("Error while serializing " + subclause.getName() + " annex subclause", e);
		}
	}

	protected TransactionalEditingDomain performModification(EObject semanticObject, Runnable runnable) {
		var resource = semanticObject != null ? semanticObject.eResource() : null;
		var resourceSet = resource != null ? resource.getResourceSet() : null;
		TransactionalEditingDomain domain = null;
		if (resourceSet != null) {
			domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);
		}

		if (domain == null) {
			runnable.run();
		} else {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					runnable.run();
				}
			});
		}

		return domain;
	}

	@Override
	protected void sequence_FlowPathSpec_FlowSinkSpec_FlowSourceSpec_FlowSpecRefinement(ISerializationContext context,
			FlowSpecification spec) {
		if (spec.getRefined() != null) {
			sequence_FlowSpecRefinement(new RuleContext(context, grammarAccess.getFlowSpecRefinementRule()), spec);
			return;
		}
		var kind = spec.getKind();
		if (kind == null) {
			return;
		}
		switch (kind) {
		case SOURCE -> sequence_FlowSourceSpec(new RuleContext(context, grammarAccess.getFlowSourceSpecRule()), spec);
		case PATH -> sequence_FlowPathSpec(new RuleContext(context, grammarAccess.getFlowPathSpecRule()), spec);
		case SINK -> sequence_FlowSinkSpec(new RuleContext(context, grammarAccess.getFlowSinkSpecRule()), spec);
		}
	}

	@Override
	protected void sequence_FlowPathImpl_FlowSinkImpl_FlowSourceImpl(ISerializationContext context,
			FlowImplementation impl) {
		var kind = impl.getKind();
		if (kind == null) {
			return;
		}
		switch (kind) {
		case SOURCE -> sequence_FlowSourceImpl(new RuleContext(context, grammarAccess.getFlowSourceImplRule()), impl);
		case PATH -> sequence_FlowPathImpl(new RuleContext(context, grammarAccess.getFlowPathImplRule()), impl);
		case SINK -> sequence_FlowSinkImpl(new RuleContext(context, grammarAccess.getFlowSinkImplRule()), impl);
		}
	}

}
