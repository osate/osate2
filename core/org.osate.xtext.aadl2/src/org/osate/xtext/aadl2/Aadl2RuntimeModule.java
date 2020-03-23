/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.osate.xtext.aadl2.documentation.Aadl2DocumentationProvider;
import org.osate.xtext.aadl2.findReferences.Aadl2ReferenceFinder;
import org.osate.xtext.aadl2.findReferences.Aadl2TargetURICollector;
import org.osate.xtext.aadl2.formatting2.regionaccess.Aadl2TextRegionAccessBuilder;
import org.osate.xtext.aadl2.generator.Aadl2OutputConfigurationProvider;
import org.osate.xtext.aadl2.parsing.AnnexParserAgent;
import org.osate.xtext.aadl2.resource.Aadl2DerivedStateComputer;
import org.osate.xtext.aadl2.resource.Aadl2ResourceServiceProvider;
import org.osate.xtext.aadl2.resource.NoCacheDerivedStateAwareResource;
import org.osate.xtext.aadl2.resource.persistence.Aadl2ResourceStorageFacade;
import org.osate.xtext.aadl2.scoping.Aadl2ImportedNamespaceAwareLocalScopeProvider;
import org.osate.xtext.aadl2.scoping.Aadl2ScopeProvider;
import org.osate.xtext.aadl2.scoping.Aadl2SerializerScopeProvider;
import org.osate.xtext.aadl2.serializer.InstanceEnabledSerializer;
import org.osate.xtext.aadl2.serializer.InstanceEnabledSerializerBinding;
import org.osate.xtext.aadl2.util.Aadl2QualifiedNameFragmentProvider;
import org.osate.xtext.aadl2.validation.Aadl2ConcreteSyntaxValidator;
import org.osate.xtext.aadl2.validation.Aadl2NamesAreUniqueValidationHelper;
import org.osate.xtext.aadl2.valueconversion.Aadl2ValueConverter;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class Aadl2RuntimeModule extends org.osate.xtext.aadl2.AbstractAadl2RuntimeModule {
	@Override
	public Class<? extends org.eclipse.xtext.linking.ILinkingService> bindILinkingService() {
		return org.osate.xtext.aadl2.linking.Aadl2LinkingService.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return Aadl2ValueConverter.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.osate.xtext.aadl2.naming.Aadl2QualifiedNameProvider.class;
	}

	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.osate.xtext.aadl2.naming.Aadl2QualifiedNameConverter.class;
	}

	/*
	 * // It has some problems. It recurses on the package in the outline view
	 * DB: Fixing the reference problem. Reviewed getName() on
	 * PublicPackageSection to fix the recurses problem. (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.xtext.service.DefaultRuntimeModule#bindIFragmentProvider()
	 */
	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return Aadl2QualifiedNameFragmentProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return AnnexParserAgent.class;
	}

	public Class<? extends org.eclipse.xtext.validation.INamesAreUniqueValidationHelper> bindINamesAreUniqueValidationHelper() {
		return Aadl2NamesAreUniqueValidationHelper.class;
	}

	public Class<? extends org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return org.osate.xtext.aadl2.serializer.Aadl2CrossReferenceSerializer.class;
	}

	// we are not using it for unassigned values. We use token like PNAME
	// instead
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer> bindITokenSerializer$IValueSerializer() {
		return org.osate.xtext.aadl2.serializing.Aadl2ValueSerializer.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.osate.xtext.aadl2.serializing.Aadl2TransientValueService.class;
	}

	public Class<? extends org.eclipse.xtext.resource.EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return org.osate.xtext.aadl2.util.Aadl2EObjectAtOffsetHelper.class;
	}

	public Class<? extends org.eclipse.xtext.resource.DefaultLocationInFileProvider> bindDefaultLocationInFileProvider() {
		return org.osate.xtext.aadl2.util.Aadl2LocationInFile.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.osate.aadl2.modelsupport.scoping.EClassGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends IConcreteSyntaxValidator> bindConcreteSyntaxValidator() {
		return Aadl2ConcreteSyntaxValidator.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return Aadl2ScopeProvider.class;
	}

	public Class<? extends org.eclipse.xtext.findReferences.IReferenceFinder> bindIReferenceFinder() {
		return Aadl2ReferenceFinder.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(Aadl2ImportedNamespaceAwareLocalScopeProvider.class);
	}

	/**
	 * Turn this feature off because it breaks proxy resolution in OSATE. No
	 * idea why. TODO: find root cause for breakage and re-enable fragment index
	 */
	@Override
	public void configureUseIndexFragmentsForLazyLinking(com.google.inject.Binder binder) {
		binder.bind(Boolean.TYPE).annotatedWith(Names.named(LazyURIEncoder.USE_INDEXED_FRAGMENTS_BINDING))
				.toInstance(Boolean.FALSE);
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return NoCacheDerivedStateAwareResource.class;
	}

	public Class<? extends IResourceDescription.Manager> bindIResourceDescriptionManager() {
		return org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager.class;
	}

	public Class<? extends org.eclipse.xtext.resource.persistence.IResourceStorageFacade> bindIResourceStorageFacade() {
		return Aadl2ResourceStorageFacade.class;
	}

	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return InMemoryFileSystemAccess.class;
	}

	// needed for builder participant even though we don't generate anything
	// builder participant is needed to write bin files
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return org.eclipse.xtext.generator.IGenerator.NullGenerator.class;
	}

	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return Aadl2OutputConfigurationProvider.class;
	}

	public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		return Aadl2DerivedStateComputer.class;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(ISerializer.class).annotatedWith(InstanceEnabledSerializerBinding.class)
				.to(InstanceEnabledSerializer.class);
	}

	@Override
	public void configureSerializerIScopeProvider(com.google.inject.Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(SerializerScopeProviderBinding.class)
				.to(Aadl2SerializerScopeProvider.class);
	}

	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return Aadl2DocumentationProvider.class;
	}

	public Class<? extends TextRegionAccessBuilder> bindTextRegionAccessBuilder() {
		return Aadl2TextRegionAccessBuilder.class;
	}

	public Class<? extends org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return org.osate.xtext.aadl2.properties.linking.PropertiesLinkingDiagnosticMessageProvider.class;
	}

	public Class<? extends IGlobalServiceProvider> bindIGlobalServiceProvider() {
		return Aadl2ResourceServiceProvider.class;
	}

	/**
	 * @since 2.0
	 */
	public Class<? extends TargetURICollector> bindTargetURICollector() {
		return Aadl2TargetURICollector.class;
	}
}
