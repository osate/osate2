package org.osate.ge.ba.ui.properties;

import java.io.IOException;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork.Void;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.utils.AadlBaLocationReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

public class EditDispatchConditionsPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorTransition);
		}
	}

	private BusinessObjectSelection selectedBos;
	private StyledText transitionText;
	private final Injector injector = Aadl2Activator.getInstance()
			.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	private TransactionalEditingDomain editingDomain;
	private RecordingCommand cmd;
	private Void<XtextResource> work;
	private XtextResource xtextResource;
	private IXtextDocument xtextDocument;
	private BehaviorAnnexStyledTextXtextAdapter xtextAdapter;
	private int offset = 0;

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

//	@Override
//	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
//		super.createControls(parent, aTabbedPropertySheetPage);
//		super.createControls(parent, aTabbedPropertySheetPage);
//		final Composite composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
//		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());
//		transitionText = new StyledText(composite, SWT.BORDER | SWT.V_SCROLL);
//		transitionText.setLayoutData(
//				GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(100, 100).create());
//
//		transitionText.addListener(SWT.FocusOut, event -> {
//			selectedBos.modify(BehaviorTransition.class, bt -> {
//				BehaviorAnnex ba = (BehaviorAnnex) bt.getOwner();
//				System.err.println(ba.getTransitions().indexOf(bt) + " index");
//
//			});
//		});
//	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());
		transitionText = new StyledText(composite, SWT.BORDER | SWT.V_SCROLL);
		transitionText.setLayoutData(
				GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(100, 100).create());


		transitionText.addListener(SWT.FocusOut, event -> {
			System.err.println("out");
			if (xtextDocument != null) {
				xtextDocument.modify(work);
			} else {
				try {
					editingDomain.getCommandStack().execute(cmd);

					// TODO this is copied from other code. Figure out what it does and if it is needed.
					final String serializedSrc = xtextResource.getSerializer()
							.serialize(xtextResource.getContents().get(0));
					boolean modificationSuccessful = serializedSrc != null && !serializedSrc.trim().isEmpty();
					if (!modificationSuccessful) {
						if (!editingDomain.getCommandStack().canUndo()
								|| editingDomain.getCommandStack().getUndoCommand() != cmd) {
							throw new RuntimeException(
									"Property modification failed and unable to undo. Unexpected state.");
						}

						editingDomain.getCommandStack().undo();
					}

					xtextResource.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
				} catch (final IOException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		});
	}

	int i = 0;
	@Override
	public void refresh() {
		// TODO call behaviorannexaction to make sure it's valid?
		// TODO support multiple selection?
		// TODO filter out eproxy or resolve?
		final Optional<BusinessObjectContext> selected = selectedBos.bocStream()
				.filter(boc -> boc.getBusinessObject() instanceof BehaviorTransition
						&& !((BehaviorTransition) boc.getBusinessObject()).eIsProxy()
						&& ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny();
		if (selected.isPresent()) {
			final BusinessObjectContext selectedBoc = selected.get();
			final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
			System.err.println(behaviorTransition.eIsProxy() + " proxy");
			System.err.println(behaviorTransition + " behaviorTransiton");
			xtextAdapter = getXtextAdapter(
					ProjectUtil.getProjectForBoOrThrow(behaviorTransition));

			xtextResource = getXtextResource(behaviorTransition)
					.orElseThrow(() -> new RuntimeException("resource must be XtextResource"));
			final IParseResult parseResult = xtextResource.getParseResult();

			final IAadlPropertySource propertySource = Adapters
					.adapt(new StructuredSelection(selected.get()),
					IAadlPropertySource.class);
			xtextDocument = propertySource == null ? null : propertySource.getDocument();

			// Root text
			final String rootNodeText = parseResult.getRootNode().getText();
			final BehaviorCondition condition = behaviorTransition.getCondition();
			final String wholeText;
			final String conditionText;

			if (condition != null) {
				System.err.println("AAA");
				// Xtext location reference for transition condition
				final AadlBaLocationReference conditionLocationReference = behaviorTransition.getCondition()
						.getAadlBaLocationReference();
				final String prefix = rootNodeText.substring(0, conditionLocationReference.getOffset()) + "\n";
				conditionText = rootNodeText.substring(conditionLocationReference.getOffset()).split("]")[0];
				final String suffix = "\n]" + rootNodeText
						.substring(conditionLocationReference.getOffset() + conditionLocationReference.getLength())
						.split("]", 2)[1];

				wholeText = new StringBuilder().append(prefix).append(conditionText).append(suffix).toString();

				transitionText.setText(wholeText);

				offset = conditionLocationReference.getOffset() + 1;
				xtextAdapter.getSourceviewer().setDocument(xtextAdapter.getXtextDocument(),
						xtextAdapter.getSourceviewer().getAnnotationModel(), conditionLocationReference.getOffset() + 1,
						conditionText.trim().length());

				editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
						.getEditingDomainFor(behaviorTransition);
				work = new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(final XtextResource state) throws Exception {
						System.err.println(transitionText.getText() + " GETTEXT");
						state.update(conditionLocationReference.getOffset(),
								conditionText.length(),
								transitionText.getText());
					}
				};

				cmd = new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						try {
							work.exec(xtextResource);
						} catch (final Exception e) {
							throw new RuntimeException(e.getMessage());
						}
					}
				};
			} else {
				System.err.println("BB");
				final AadlBaLocationReference conditionLocationReference = behaviorTransition
						.getAadlBaLocationReference();
				final String toTransitionText = rootNodeText.substring(0, conditionLocationReference.getOffset());
				final String transitionToConditionText = rootNodeText.substring(conditionLocationReference.getOffset())
						.split("\\[", 2)[0] + "[\n";

				final String suffixA = "\n]" + rootNodeText
						.substring(toTransitionText.length() + transitionToConditionText.length() - 1).split("]", 2)[1];
				wholeText = new StringBuilder().append(toTransitionText).append(transitionToConditionText)
						.append(suffixA).toString();
				conditionText = "";

				transitionText.setText(wholeText);
				offset = toTransitionText.length() + transitionToConditionText.length();
				xtextAdapter.getSourceviewer().setDocument(xtextAdapter.getXtextDocument(),
						xtextAdapter.getSourceviewer().getAnnotationModel(),
						toTransitionText.length() + transitionToConditionText.length(), 0);

				editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
						.getEditingDomainFor(behaviorTransition);
				work = new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(final XtextResource state) throws Exception {
						state.update(toTransitionText.length() + transitionToConditionText.length() - 1,
								0/* conditionLocationReference.getLength() */,
								transitionText.getText());
					}
				};

				cmd = new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						try {
							work.exec(xtextResource);
						} catch (final Exception e) {
							throw new RuntimeException(e.getMessage());
						}
					}
				};
			}
		}
	}

	private Optional<XtextResource> getXtextResource(final BehaviorTransition behaviorTransition) {
		final Resource resource = behaviorTransition.eResource();
		return Optional.ofNullable(resource instanceof XtextResource ? (XtextResource) resource : null);
	}

	private BehaviorAnnexStyledTextXtextAdapter getXtextAdapter(final IProject project) {
		final BehaviorAnnexStyledTextXtextAdapter xtextAdapter = new BehaviorAnnexStyledTextXtextAdapter(injector,
				IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER, project);
		xtextAdapter.adapt(transitionText);
		return xtextAdapter;
	}

	private static class BehaviorAnnexStyledTextXtextAdapter extends OsateStyledTextXtextAdapter {
		public BehaviorAnnexStyledTextXtextAdapter(Injector injector,
				IXtextFakeContextResourcesProvider contextFakeResourceProvider, final IProject project) {
			super(injector, contextFakeResourceProvider, project);
		}

		public SourceViewer getSourceviewer() {
			return super.getXtextSourceviewer();
		}

		@Override
		public XtextDocument getXtextDocument() {
			return super.getXtextDocument();
		}
	}
}
