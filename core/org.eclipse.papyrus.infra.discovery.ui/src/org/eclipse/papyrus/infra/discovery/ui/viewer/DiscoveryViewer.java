/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation for Papyrus extra components needs
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.viewer;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.discovery.Category;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;
import org.eclipse.papyrus.infra.discovery.Group;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.Message;
import org.eclipse.papyrus.infra.discovery.Overview;
import org.eclipse.papyrus.infra.discovery.Severity;
import org.eclipse.papyrus.infra.discovery.ui.Activator;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.CommonImages;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.CommonThemes;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.DiscoveryImages;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.GradientCanvas;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.OverviewToolTip;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.SelectionProviderAdapter;
import org.eclipse.papyrus.infra.discovery.ui.internal.common.WorkbenchUtil;
import org.eclipse.papyrus.infra.discovery.ui.internal.viewer.DiscoveryCategoryComparator;
import org.eclipse.papyrus.infra.discovery.ui.internal.wizards.Messages;
import org.eclipse.papyrus.infra.discovery.ui.wizards.DiscoveryWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleControlAdapter;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.progress.WorkbenchJob;
import org.eclipse.ui.themes.IThemeManager;

/**
 * The main wizard page that allows users to select connectors that they wish to
 * install.
 *
 * @author David Green
 * @author Steffen Pingel
 * @author Cedric Brun
 * @author Remi Schnekenburger
 */
public class DiscoveryViewer {

	public class ConnectorBorderPaintListener implements PaintListener {
		public void paintControl(PaintEvent e) {
			Composite composite = (Composite) e.widget;
			Rectangle bounds = composite.getBounds();
			GC gc = e.gc;
			gc.setLineStyle(SWT.LINE_DOT);
			gc.drawLine(bounds.x, bounds.y, bounds.x + bounds.width, bounds.y);
		}
	}

	private class ConnectorDescriptorItemUi extends AdapterImpl implements
			Runnable {

		private final Button checkbox;

		private final Label iconLabel;

		private final Label nameLabel;

		private ToolItem infoButton;

		private final Link providerLabel;

		private final Label description;

		private final Composite checkboxContainer;

		private final Composite connectorContainer;

		private final Display display;

		private Image iconImage;

		private Image warningIconImage;

		private InstallableComponent connector;

		public ConnectorDescriptorItemUi(final InstallableComponent connector,
				Composite categoryChildrenContainer, Color background) {
			display = categoryChildrenContainer.getDisplay();
			this.connector = connector;
			connector.eAdapters().add(this);

			connectorContainer = new Composite(categoryChildrenContainer,
					SWT.NULL);

			configureLook(connectorContainer, background);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(
					connectorContainer);
			GridLayout layout = new GridLayout(4, false);
			layout.marginLeft = 7;
			layout.marginTop = 2;
			layout.marginBottom = 2;
			connectorContainer.setLayout(layout);

			checkboxContainer = new Composite(connectorContainer, SWT.NULL);
			configureLook(checkboxContainer, background);
			GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.BEGINNING)
					.span(1, 2).applyTo(checkboxContainer);
			GridLayoutFactory.fillDefaults().spacing(1, 1).numColumns(2)
					.applyTo(checkboxContainer);

			checkbox = new Button(checkboxContainer, SWT.CHECK);
			checkbox.setText(" "); //$NON-NLS-1$
			// help UI tests
			checkbox.setData("connectorId", connector.getId()); //$NON-NLS-1$
			configureLook(checkbox, background);
			checkbox.setSelection(installableConnectors.contains(connector));
			checkbox.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					bodyScrolledComposite.showControl(connectorContainer);
				}
			});

			GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.CENTER)
					.applyTo(checkbox);

			iconLabel = new Label(checkboxContainer, SWT.NULL);
			configureLook(iconLabel, background);
			GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.CENTER)
					.applyTo(iconLabel);

			if (connector.getImage32() != null) {
				iconImage = computeIconImage(connector.eResource(), connector
						.getImage32(), 32, false);
				if (iconImage != null) {
					if (connector.isIncubation()) {
						iconImage = new DecorationOverlayIcon(iconImage,
								DiscoveryImages.OVERLAY_INCUBATION_32,
								IDecoration.BOTTOM_LEFT).createImage();
						disposables.add(iconImage);
					}
					iconLabel.setImage(iconImage);
				}
			}

			nameLabel = new Label(connectorContainer, SWT.NULL);
			configureLook(nameLabel, background);
			GridDataFactory.fillDefaults().grab(true, false).align(
					SWT.BEGINNING, SWT.CENTER).applyTo(nameLabel);
			nameLabel.setFont(h2Font);
			if (connector.isIncubation()) {
				nameLabel.setText(connector.getName() + " (Incubation)");
			} else {
				nameLabel.setText(connector.getName());
			}

			providerLabel = new Link(connectorContainer, SWT.RIGHT);
			configureLook(providerLabel, background);
			GridDataFactory.fillDefaults().align(SWT.END, SWT.CENTER).applyTo(
					providerLabel);

			providerLabel
					.setText(NLS
							.bind(
									Messages.ConnectorDiscoveryWizardMainPage_provider_and_license,
									connector.getProvider(), connector
											.getLicense()));

			if (hasTooltip(connector)) {
				ToolBar toolBar = new ToolBar(connectorContainer, SWT.FLAT);
				toolBar.setBackground(background);

				infoButton = new ToolItem(toolBar, SWT.PUSH);
				infoButton.setImage(infoImage);
				infoButton
						.setToolTipText(Messages.ConnectorDiscoveryWizardMainPage_tooltip_showOverview);
				hookTooltip(toolBar, infoButton, connectorContainer, nameLabel,
						connector.eResource(), connector.getOverview(), null);
				GridDataFactory.fillDefaults().align(SWT.END, SWT.CENTER)
						.applyTo(toolBar);
			} else {
				Label label = new Label(connectorContainer, SWT.NULL);
				label.setText(" "); //$NON-NLS-1$
				configureLook(label, background);
			}

			description = new Label(connectorContainer, SWT.NULL | SWT.WRAP);
			configureLook(description, background);

			GridDataFactory.fillDefaults().grab(true, false).span(3, 1).hint(
					100, SWT.DEFAULT).applyTo(description);
			String descriptionText = connector.getDescription();
			if (descriptionText != null) {
				int maxDescriptionLength = 162;
				if (descriptionText.length() > maxDescriptionLength) {
					descriptionText = descriptionText.substring(0,
							maxDescriptionLength);
				}
				description.setText(descriptionText.replaceAll("(\\r\\n)|\\n|\\r", " ")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// always disabled color to make it less prominent
			providerLabel.setForeground(colorDisabled);

			checkbox.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
				}

				public void widgetSelected(SelectionEvent e) {
					boolean selected = checkbox.getSelection();
					maybeModifySelection(selected);
				}
			});
			MouseListener connectorItemMouseListener = new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					boolean selected = !checkbox.getSelection();
					if (maybeModifySelection(selected)) {
						checkbox.setSelection(selected);
					}
				}
			};
			checkboxContainer.addMouseListener(connectorItemMouseListener);
			connectorContainer.addMouseListener(connectorItemMouseListener);
			iconLabel.addMouseListener(connectorItemMouseListener);
			nameLabel.addMouseListener(connectorItemMouseListener);
			// the provider has clickable links
			// providerLabel.addMouseListener(connectorItemMouseListener);
			providerLabel.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					if (e.text != null) {
						WorkbenchUtil.openUrl(e.text,
								IWorkbenchBrowserSupport.AS_EXTERNAL);
					}
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
				}
			});
			description.addMouseListener(connectorItemMouseListener);
		}

		protected boolean maybeModifySelection(boolean selected) {
			if (selected) {
				if (!connector.isAvailable()) {
					MessageDialog
							.openWarning(
									shellProvider.getShell(),
									Messages.ConnectorDiscoveryWizardMainPage_warningTitleConnectorUnavailable,
									NLS
											.bind(
													Messages.ConnectorDiscoveryWizardMainPage_warningMessageConnectorUnavailable,
													connector.getName()));
					return false;
				}
			}
			DiscoveryViewer.this.modifySelection(connector, selected);
			return true;
		}

		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			display.asyncExec(this);
		}

		public void run() {
			if (!connectorContainer.isDisposed()) {
				updateAvailability();
			}

		}

		public void updateAvailability() {
			boolean enabled = connector.isAvailable();

			checkbox.setEnabled(enabled);
			nameLabel.setEnabled(enabled);
			providerLabel.setEnabled(enabled);
			description.setEnabled(enabled);
			Color foreground;
			if (enabled) {
				foreground = connectorContainer.getForeground();
			} else {
				foreground = colorDisabled;
			}
			nameLabel.setForeground(foreground);
			description.setForeground(foreground);

			if (iconImage != null) {
				boolean unavailable = !enabled;
				if (unavailable) {
					if (warningIconImage == null) {
						warningIconImage = new DecorationOverlayIcon(iconImage,
								DiscoveryImages.OVERLAY_WARNING_32,
								IDecoration.BOTTOM_RIGHT).createImage();
						disposables.add(warningIconImage);
					}
					iconLabel.setImage(warningIconImage);
				} else if (warningIconImage != null) {
					iconLabel.setImage(iconImage);
				}
			}
		}
	}

	// e3.5 replace with SWT.ICON_CANCEL
	public static final int ICON_CANCEL = 1 << 8;

	private static final int MINIMUM_HEIGHT = 100;

	private static boolean useNativeSearchField(Composite composite) {
		if (useNativeSearchField == null) {
			useNativeSearchField = Boolean.FALSE;
			Text testText = null;
			try {
				testText = new Text(composite, SWT.SEARCH | ICON_CANCEL);
				useNativeSearchField = new Boolean(
						(testText.getStyle() & ICON_CANCEL) != 0);
			} finally {
				if (testText != null) {
					testText.dispose();
				}
			}

		}
		return useNativeSearchField;
	}

	private boolean showConnectorDescriptorKindFilter;

	private boolean showConnectorDescriptorTextFilter;

	private static final String COLOR_WHITE = "white"; //$NON-NLS-1$

	private static final String COLOR_DARK_GRAY = "DarkGray"; //$NON-NLS-1$

	private static Boolean useNativeSearchField;

	private final List<InstallableComponent> installableConnectors = new ArrayList<InstallableComponent>();

	private Composite body;

	private final List<org.eclipse.swt.graphics.Resource> disposables;

	private Font h2Font;

	private Font h1Font;

	private Color colorWhite;

	private Text filterText;

	private WorkbenchJob refreshJob;

	private String previousFilterText = ""; //$NON-NLS-1$

	private Pattern filterPattern;

	private Label clearFilterTextControl;

	private Image infoImage;

	private Cursor handCursor;

	private Color colorCategoryGradientStart;

	private Color colorCategoryGradientEnd;

	private Color colorDisabled;

	private ScrolledComposite bodyScrolledComposite;

	private boolean verifyUpdateSiteAvailability;

	private final Map<Group, Boolean> connectorDescriptorKindToVisibility = new HashMap<Group, Boolean>();

	{

	}

	private boolean complete;

	private final IRunnableContext context;

	private final IShellProvider shellProvider;

	private Control control;

	private final SelectionProviderAdapter selectionProvider;

	private List<InstallableComponent> allConnectors;

	private int minimumHeight;

	private DiscoveryContentProvider provider;

	public DiscoveryViewer(IShellProvider shellProvider,
			IRunnableContext context, DiscoveryContentProvider provider) {
		this.shellProvider = shellProvider;
		this.context = context;
		this.selectionProvider = new SelectionProviderAdapter();
		this.allConnectors = Collections.emptyList();
		this.disposables = new ArrayList<org.eclipse.swt.graphics.Resource>();
		this.provider = provider;
		setShowConnectorDescriptorKindFilter(true);
		setShowConnectorDescriptorTextFilter(true);
		setMinimumHeight(MINIMUM_HEIGHT);
		setComplete(false);
		for (Group kind : getDiscovery().getFilters()) {
			connectorDescriptorKindToVisibility.put(kind, true);
		}
		;
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionProvider.addSelectionChangedListener(listener);
	}

	private void clearDisposables() {
		disposables.clear();
		h1Font = null;
		h2Font = null;
		infoImage = null;
		handCursor = null;
		colorCategoryGradientStart = null;
		colorCategoryGradientEnd = null;
	}

	private void clearFilterText() {
		filterText.setText(""); //$NON-NLS-1$
		filterTextChanged();
	}

	private Image computeIconImage(Resource discoverySource, String imagePath,
			int dimension, boolean fallback) {
		if (imagePath != null && imagePath.length() > 0) {
			URI uri = discoverySource.getURI();
			URI trimed = uri.trimSegments(1);
			String urlPath = trimed.toString() + "/" + imagePath;
			URL resource = null;
			try {
				resource = new URL(urlPath);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
			}
			if (resource != null) {
				ImageDescriptor descriptor = ImageDescriptor
						.createFromURL(resource);
				Image image = descriptor.createImage();
				if (image != null) {
					disposables.add(image);
					return image;
				}
			}
		}
		return null;
	}

	private void configureLook(Control control, Color background) {
		control.setBackground(background);
	}

	/**
	 * cause the UI to respond to a change in visibility filters
	 *
	 * @see #setVisibility(ConnectorDescriptorKind, boolean)
	 */
	public void connectorDescriptorKindVisibilityUpdated() {
		createBodyContents();
	}

	public void createBodyContents() {
		// remove any existing contents
		for (Control child : body.getChildren()) {
			child.dispose();
		}
		clearDisposables();
		allConnectors = new ArrayList<InstallableComponent>();
		initializeCursors();
		initializeImages();
		initializeFonts();
		initializeColors();

		GridLayoutFactory.fillDefaults().applyTo(body);

		bodyScrolledComposite = new ScrolledComposite(body, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);

		configureLook(bodyScrolledComposite, colorWhite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				bodyScrolledComposite);

		final Composite scrolledContents = new Composite(bodyScrolledComposite,
				SWT.NONE);
		configureLook(scrolledContents, colorWhite);
		scrolledContents.setRedraw(false);
		try {
			createDiscoveryContents(scrolledContents);
		} finally {
			scrolledContents.layout(true);
			scrolledContents.setRedraw(true);
		}
		Point size = scrolledContents.computeSize(body.getSize().x,
				SWT.DEFAULT, true);
		scrolledContents.setSize(size);

		bodyScrolledComposite.setExpandHorizontal(true);
		bodyScrolledComposite.setMinWidth(100);
		bodyScrolledComposite.setExpandVertical(true);
		bodyScrolledComposite.setMinHeight(1);

		bodyScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				// XXX small offset in case list has a scroll bar
				Point size = scrolledContents.computeSize(
						body.getSize().x - 20, SWT.DEFAULT, true);
				scrolledContents.setSize(size);
				bodyScrolledComposite.setMinHeight(size.y);
			}
		});

		bodyScrolledComposite.setContent(scrolledContents);

		Dialog.applyDialogFont(body);
		// we've changed it so it needs to know
		body.layout(true);
	}

	private Label createClearFilterTextControl(Composite filterContainer,
			final Text filterText) {
		final Image inactiveImage = CommonImages.FIND_CLEAR_DISABLED
				.createImage();
		final Image activeImage = CommonImages.FIND_CLEAR.createImage();
		final Image pressedImage = new Image(filterContainer.getDisplay(),
				activeImage, SWT.IMAGE_GRAY);

		final Label clearButton = new Label(filterContainer, SWT.NONE);
		clearButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		clearButton.setImage(inactiveImage);
		clearButton
				.setToolTipText(Messages.ConnectorDiscoveryWizardMainPage_clearButton_toolTip);
		clearButton.setBackground(filterContainer.getDisplay().getSystemColor(
				SWT.COLOR_LIST_BACKGROUND));
		clearButton.addMouseListener(new MouseAdapter() {
			private MouseMoveListener fMoveListener;

			private boolean isMouseInButton(MouseEvent e) {
				Point buttonSize = clearButton.getSize();
				return 0 <= e.x && e.x < buttonSize.x && 0 <= e.y
						&& e.y < buttonSize.y;
			}

			@Override
			public void mouseDown(MouseEvent e) {
				clearButton.setImage(pressedImage);
				fMoveListener = new MouseMoveListener() {
					private boolean fMouseInButton = true;

					public void mouseMove(MouseEvent e) {
						boolean mouseInButton = isMouseInButton(e);
						if (mouseInButton != fMouseInButton) {
							fMouseInButton = mouseInButton;
							clearButton.setImage(mouseInButton ? pressedImage
									: inactiveImage);
						}
					}
				};
				clearButton.addMouseMoveListener(fMoveListener);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				if (fMoveListener != null) {
					clearButton.removeMouseMoveListener(fMoveListener);
					fMoveListener = null;
					boolean mouseInButton = isMouseInButton(e);
					clearButton.setImage(mouseInButton ? activeImage
							: inactiveImage);
					if (mouseInButton) {
						clearFilterText();
						filterText.setFocus();
					}
				}
			}
		});
		clearButton.addMouseTrackListener(new MouseTrackListener() {
			public void mouseEnter(MouseEvent e) {
				clearButton.setImage(activeImage);
			}

			public void mouseExit(MouseEvent e) {
				clearButton.setImage(inactiveImage);
			}

			public void mouseHover(MouseEvent e) {
			}
		});
		clearButton.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				inactiveImage.dispose();
				activeImage.dispose();
				pressedImage.dispose();
			}
		});
		clearButton.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					@Override
					public void getName(AccessibleEvent e) {
						e.result = Messages.ConnectorDiscoveryWizardMainPage_clearButton_accessibleListener;
					}
				});
		clearButton.getAccessible().addAccessibleControlListener(
				new AccessibleControlAdapter() {
					@Override
					public void getRole(AccessibleControlEvent e) {
						e.detail = ACC.ROLE_PUSHBUTTON;
					}
				});
		return clearButton;
	}

	public void createControl(Composite parent) {
		createRefreshJob();

		Composite container = new Composite(parent, SWT.NULL);
		container.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				refreshJob.cancel();
			}
		});
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		container.setLayout(layout);
		//
		{ // header
			Composite header = new Composite(container, SWT.NULL);
			GridLayoutFactory.fillDefaults().applyTo(header);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(header);

			// TODO: refresh button?
			if (isShowConnectorDescriptorKindFilter()
					|| isShowConnectorDescriptorTextFilter()) {
				Composite filterContainer = new Composite(header, SWT.NULL);
				GridDataFactory.fillDefaults().grab(true, false).applyTo(
						filterContainer);

				int numColumns = 1; // 1 for label
				if (isShowConnectorDescriptorKindFilter()) {
					numColumns += getDiscovery().getFilters().size();
				}
				if (isShowConnectorDescriptorTextFilter()) {
					++numColumns;
				}
				GridLayoutFactory.fillDefaults().numColumns(numColumns)
						.applyTo(filterContainer);
				Label label = new Label(filterContainer, SWT.NULL);
				label
						.setText(Messages.ConnectorDiscoveryWizardMainPage_filterLabel);

				if (isShowConnectorDescriptorTextFilter()) {
					Composite textFilterContainer;
					boolean nativeSearch = useNativeSearchField(header);
					if (nativeSearch) {
						textFilterContainer = new Composite(filterContainer,
								SWT.NULL);
					} else {
						textFilterContainer = new Composite(filterContainer,
								SWT.BORDER);
						textFilterContainer.setBackground(header.getDisplay()
								.getSystemColor(SWT.COLOR_LIST_BACKGROUND));
					}
					GridDataFactory.fillDefaults().grab(true, false).applyTo(
							textFilterContainer);
					GridLayoutFactory.fillDefaults().numColumns(2).applyTo(
							textFilterContainer);

					if (nativeSearch) {
						filterText = new Text(textFilterContainer, SWT.SINGLE
								| SWT.BORDER | SWT.SEARCH | ICON_CANCEL);
					} else {
						filterText = new Text(textFilterContainer, SWT.SINGLE);
					}

					filterText.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							filterTextChanged();
						}
					});
					if (nativeSearch) {
						filterText.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetDefaultSelected(SelectionEvent e) {
								if (e.detail == ICON_CANCEL) {
									clearFilterText();
								}
							}
						});
						GridDataFactory.fillDefaults().grab(true, false).span(
								2, 1).applyTo(filterText);
					} else {
						GridDataFactory.fillDefaults().grab(true, false)
								.applyTo(filterText);
						clearFilterTextControl = createClearFilterTextControl(
								textFilterContainer, filterText);
						clearFilterTextControl.setVisible(false);
					}
				}

				if (isShowConnectorDescriptorKindFilter()) { // filter
					// buttons

					for (final Group kind : getDiscovery().getFilters()) {
						final Button checkbox = new Button(filterContainer,
								SWT.CHECK);
						checkbox.setSelection(isVisible(kind));
						checkbox.setText(getFilterLabel(kind));
						checkbox.addSelectionListener(new SelectionListener() {
							public void widgetDefaultSelected(SelectionEvent e) {
								widgetSelected(e);
							}

							public void widgetSelected(SelectionEvent e) {
								boolean selection = checkbox.getSelection();
								setVisibility(kind, selection);
								connectorDescriptorKindVisibilityUpdated();
							}
						});
					}
				}

			}

		}
		{ // container
			body = new Composite(container, SWT.NULL);
			GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT,
					minimumHeight).applyTo(body);
		}
		Dialog.applyDialogFont(container);
		setControl(container);
	}

	public void setMinimumHeight(int minimumHeight) {
		this.minimumHeight = minimumHeight;
		if (body != null) {
			GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT,
					minimumHeight).applyTo(body);
		}
	}

	public static int getMinimumHeight() {
		return MINIMUM_HEIGHT;
	}

	private void createDiscoveryContents(Composite container) {

		Color background = container.getBackground();

		if (provider.getDiscovery() == null || isEmpty(provider.getDiscovery())) {
			GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(container);

			boolean atLeastOneKindFiltered = false;
			for (Group kind : getDiscovery().getFilters()) {
				if (!isVisible(kind)) {
					atLeastOneKindFiltered = true;
					break;
				}
			}
			Control helpTextControl;
			if (filterPattern != null) {
				Link link = new Link(container, SWT.WRAP);

				link.setFont(container.getFont());
				link
						.setText(Messages.ConnectorDiscoveryWizardMainPage_noMatchingItems_withFilterText);
				link.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						clearFilterText();
						filterText.setFocus();
					}
				});
				helpTextControl = link;
			} else {
				Label helpText = new Label(container, SWT.WRAP);
				helpText.setFont(container.getFont());
				if (atLeastOneKindFiltered) {
					helpText
							.setText(Messages.ConnectorDiscoveryWizardMainPage_noMatchingItems_filteredType);
				} else {
					helpText
							.setText(Messages.ConnectorDiscoveryWizardMainPage_noMatchingItems_noFilter);
				}
				helpTextControl = helpText;
			}
			configureLook(helpTextControl, background);
			GridDataFactory.fillDefaults().grab(true, false).hint(100,
					SWT.DEFAULT).applyTo(helpTextControl);
		} else {
			GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0)
					.applyTo(container);

			List<Category> categories = new ArrayList<Category>(provider
					.getDiscovery().getCategories());
			Collections.sort(categories, new DiscoveryCategoryComparator());

			Composite categoryChildrenContainer = null;
			for (Category category : categories) {
				if (isEmpty(category)) {
					// don't add empty categories
					continue;
				}
				{ // category header
					final GradientCanvas categoryHeaderContainer = new GradientCanvas(
							container, SWT.NONE);
					categoryHeaderContainer.setSeparatorVisible(true);
					categoryHeaderContainer.setSeparatorAlignment(SWT.TOP);
					categoryHeaderContainer
							.setBackgroundGradient(new Color[] {
									colorCategoryGradientStart,
									colorCategoryGradientEnd },
									new int[] { 100 }, true);
					categoryHeaderContainer.putColor(
							IFormColors.H_BOTTOM_KEYLINE1,
							colorCategoryGradientStart);
					categoryHeaderContainer.putColor(
							IFormColors.H_BOTTOM_KEYLINE2,
							colorCategoryGradientEnd);

					GridDataFactory.fillDefaults().span(2, 1).applyTo(
							categoryHeaderContainer);
					GridLayoutFactory.fillDefaults().numColumns(3)
							.margins(5, 5).equalWidth(false).applyTo(
									categoryHeaderContainer);

					Label iconLabel = new Label(categoryHeaderContainer,
							SWT.NULL);
					if (category.getImage48() != null) {
						Image image = computeIconImage(category.eResource(),
								category.getImage48(), 48, true);
						if (image != null) {
							iconLabel.setImage(image);
						}
					}
					iconLabel.setBackground(null);
					GridDataFactory.swtDefaults().align(SWT.CENTER,
							SWT.BEGINNING).span(1, 2).applyTo(iconLabel);

					Label nameLabel = new Label(categoryHeaderContainer,
							SWT.NULL);
					nameLabel.setFont(h1Font);
					nameLabel.setText(category.getName());
					nameLabel.setBackground(null);

					GridDataFactory.fillDefaults().grab(true, false).applyTo(
							nameLabel);
					if (hasTooltip(category)) {
						ToolBar toolBar = new ToolBar(categoryHeaderContainer,
								SWT.FLAT);
						toolBar.setBackground(null);
						ToolItem infoButton = new ToolItem(toolBar, SWT.PUSH);
						infoButton.setImage(infoImage);
						infoButton
								.setToolTipText(Messages.ConnectorDiscoveryWizardMainPage_tooltip_showOverview);
						hookTooltip(toolBar, infoButton,
								categoryHeaderContainer, nameLabel, category
										.eResource(),
								category.getOverview(),
								null);
						GridDataFactory.fillDefaults().align(SWT.END,
								SWT.CENTER).applyTo(toolBar);
					} else {
						new Label(categoryHeaderContainer, SWT.NULL)
								.setText(" "); //$NON-NLS-1$
					}
					Label description = new Label(categoryHeaderContainer,
							SWT.WRAP);
					GridDataFactory.fillDefaults().grab(true, false).span(2, 1)
							.hint(100, SWT.DEFAULT).applyTo(description);
					description.setBackground(null);
					if (category.getDescription() != null) {
						description.setText(category.getDescription());
					}
				}

				categoryChildrenContainer = new Composite(container, SWT.NULL);
				configureLook(categoryChildrenContainer, background);
				GridDataFactory.fillDefaults().span(2, 1).grab(true, false)
						.applyTo(categoryChildrenContainer);
				GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(
						categoryChildrenContainer);

				int numChildren = 0;
				List<InstallableComponent> connectors = new ArrayList<InstallableComponent>(
						category.getComponents());
				for (final InstallableComponent connector : connectors) {
					if (isFiltered(connector)) {
						continue;
					}

					if (++numChildren > 1) {
						// a separator between connector descriptors
						Composite border = new Composite(
								categoryChildrenContainer, SWT.NULL);
						GridDataFactory.fillDefaults().grab(true, false).hint(
								SWT.DEFAULT, 1).applyTo(border);
						GridLayoutFactory.fillDefaults().applyTo(border);
						border
								.addPaintListener(new ConnectorBorderPaintListener());
					}

					ConnectorDescriptorItemUi itemUi = new ConnectorDescriptorItemUi(
							connector, categoryChildrenContainer, background);
					itemUi.updateAvailability();
					allConnectors.add(connector);
				}
			}
			// last one gets a border
			Composite border = new Composite(categoryChildrenContainer,
					SWT.NULL);
			GridDataFactory.fillDefaults().grab(true, false).hint(SWT.DEFAULT,
					1).applyTo(border);
			GridLayoutFactory.fillDefaults().applyTo(border);
			border.addPaintListener(new ConnectorBorderPaintListener());
		}
		container.layout(true);
		container.redraw();
	}

	protected Pattern createPattern(String filterText) {
		if (filterText == null || filterText.length() == 0) {
			return null;
		}
		String regex = filterText;
		regex = regex.replace("\\", "\\\\").replace("?", ".").replace("*", ".*?"); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		return Pattern
				.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	}

	private void createRefreshJob() {
		refreshJob = new WorkbenchJob("filter") { //$NON-NLS-1$

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (filterText.isDisposed()) {
					return Status.CANCEL_STATUS;
				}
				String text = filterText.getText();
				text = text.trim();

				if (!previousFilterText.equals(text)) {
					previousFilterText = text;
					filterPattern = createPattern(previousFilterText);
					if (clearFilterTextControl != null) {
						clearFilterTextControl
								.setVisible(filterPattern != null);
					}
					createBodyContents();
				}
				return Status.OK_STATUS;
			}
		};
		refreshJob.setSystem(true);
	}

	private void discoveryUpdated(boolean wasCancelled) {
		createBodyContents();
		if (!wasCancelled) {
			int categoryWithConnectorCount = 0;
			for (Category category : provider.getDiscovery().getCategories()) {
				categoryWithConnectorCount += category.getComponents().size();
			}
			if (categoryWithConnectorCount == 0) {
				// nothing was discovered: notify the user
				MessageDialog
						.openWarning(
								getShell(),
								Messages.ConnectorDiscoveryWizardMainPage_noConnectorsFound,
								Messages.ConnectorDiscoveryWizardMainPage_noConnectorsFound_description);
			}
		}
		selectionProvider.setSelection(StructuredSelection.EMPTY);
	}

	public void dispose() {
		for (org.eclipse.swt.graphics.Resource resource : disposables) {
			resource.dispose();
		}
		clearDisposables();

	}

	private boolean filterMatches(String text) {
		return text != null && filterPattern.matcher(text).find();
	}

	private void filterTextChanged() {
		refreshJob.cancel();
		refreshJob.schedule(200L);
	}

	public Control getControl() {
		return control;
	}

	public DiscoveryDefinition getDiscovery() {
		return provider.getDiscovery();
	}

	private String getFilterLabel(Group kind) {
		return kind.getName();
	}

	public List<InstallableComponent> getInstallableConnectors() {
		return installableConnectors;
	}

	public IStructuredSelection getSelection() {
		return (IStructuredSelection) selectionProvider.getSelection();
	}

	private Shell getShell() {
		return shellProvider.getShell();
	}

	public boolean getVerifyUpdateSiteAvailability() {
		return verifyUpdateSiteAvailability;
	}

	private boolean hasTooltip(final Category category) {
		return category.getOverview() != null
				&& category.getOverview().getSummary() != null
				&& category.getOverview().getSummary().length() > 0;
	}

	private boolean hasTooltip(final InstallableComponent connector) {
		return connector.getOverview() != null
				&& connector.getOverview().getSummary() != null
				&& connector.getOverview().getSummary().length() > 0;
	}

	private void hookRecursively(Control control, Listener listener) {
		control.addListener(SWT.Dispose, listener);
		control.addListener(SWT.MouseHover, listener);
		control.addListener(SWT.MouseMove, listener);
		control.addListener(SWT.MouseExit, listener);
		control.addListener(SWT.MouseDown, listener);
		control.addListener(SWT.MouseWheel, listener);
		if (control instanceof Composite) {
			for (Control child : ((Composite) control).getChildren()) {
				hookRecursively(child, listener);
			}
		}
	}

	private void hookTooltip(final Control parent, final Widget tipActivator,
			final Control exitControl, final Control titleControl,
			Resource source, Overview overview, Image image) {
		final OverviewToolTip toolTip = new OverviewToolTip(parent, source,
				overview, image);
		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseHover:
					toolTip.show(titleControl);
					break;
				case SWT.Dispose:
				case SWT.MouseWheel:
					toolTip.hide();
					break;
				}

			}
		};
		tipActivator.addListener(SWT.Dispose, listener);
		tipActivator.addListener(SWT.MouseWheel, listener);
		if (image != null) {
			tipActivator.addListener(SWT.MouseHover, listener);
		}
		Listener selectionListener = new Listener() {
			public void handleEvent(Event event) {
				toolTip.show(titleControl);
			}
		};
		tipActivator.addListener(SWT.Selection, selectionListener);
		Listener exitListener = new Listener() {
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseWheel:
					toolTip.hide();
					break;
				case SWT.MouseExit:
					/*
					 * Check if the mouse exit happened because we move over the
					 * tooltip
					 */
					Rectangle containerBounds = exitControl.getBounds();
					Point displayLocation = exitControl.getParent().toDisplay(
							containerBounds.x, containerBounds.y);
					containerBounds.x = displayLocation.x;
					containerBounds.y = displayLocation.y;
					if (containerBounds.contains(Display.getCurrent()
							.getCursorLocation())) {
						break;
					}
					toolTip.hide();
					break;
				}
			}
		};
		hookRecursively(exitControl, exitListener);
	}

	private void initializeColors() {
		IThemeManager themeManager = PlatformUI.getWorkbench()
				.getThemeManager();
		if (colorWhite == null) {
			ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
			if (!colorRegistry.hasValueFor(COLOR_WHITE)) {
				colorRegistry.put(COLOR_WHITE, new RGB(255, 255, 255));
			}
			colorWhite = colorRegistry.get(COLOR_WHITE);
		}
		if (colorDisabled == null) {
			ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
			if (!colorRegistry.hasValueFor(COLOR_DARK_GRAY)) {
				colorRegistry.put(COLOR_DARK_GRAY, new RGB(0x69, 0x69, 0x69));
			}
			colorDisabled = colorRegistry.get(COLOR_DARK_GRAY);
		}
		if (colorCategoryGradientStart == null) {
			colorCategoryGradientStart = themeManager.getCurrentTheme()
					.getColorRegistry().get(
							CommonThemes.COLOR_CATEGORY_GRADIENT_START);
			colorCategoryGradientEnd = themeManager.getCurrentTheme()
					.getColorRegistry().get(
							CommonThemes.COLOR_CATEGORY_GRADIENT_END);
		}
	}

	private void initializeCursors() {
		if (handCursor == null) {
			handCursor = new Cursor(getShell().getDisplay(), SWT.CURSOR_HAND);
			disposables.add(handCursor);
		}
	}

	private void initializeFonts() {
		// create a level-2 heading font
		if (h2Font == null) {
			Font baseFont = JFaceResources.getDialogFont();
			FontData[] fontData = baseFont.getFontData();
			for (FontData data : fontData) {
				data.setStyle(data.getStyle() | SWT.BOLD);
				data.height = data.height * 1.25f;
			}
			h2Font = new Font(Display.getCurrent(), fontData);
			disposables.add(h2Font);
		}
		// create a level-1 heading font
		if (h1Font == null) {
			Font baseFont = JFaceResources.getDialogFont();
			FontData[] fontData = baseFont.getFontData();
			for (FontData data : fontData) {
				data.setStyle(data.getStyle() | SWT.BOLD);
				data.height = data.height * 1.35f;
			}
			h1Font = new Font(Display.getCurrent(), fontData);
			disposables.add(h1Font);
		}
	}

	private void initializeImages() {
		if (infoImage == null) {
			infoImage = DiscoveryImages.MESSAGE_INFO.createImage();
			disposables.add(infoImage);
		}
	}

	public boolean isComplete() {
		return complete;
	}

	/**
	 * indicate if there is nothing to display in the UI, given the current
	 * state of {@link DiscoveryWizard#isVisible(ConnectorDescriptorKind)
	 * filters}.
	 */
	private boolean isEmpty(DiscoveryDefinition discovery) {
		for (Category category : discovery.getCategories()) {
			if (!isEmpty(category)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * indicate if the category has nothing to display in the UI, given the
	 * current state of {@link DiscoveryWizard#isVisible(ConnectorDescriptorKind) filters}.
	 */
	private boolean isEmpty(Category category) {
		if (category.getComponents().isEmpty()) {
			return true;
		}
		for (InstallableComponent descriptor : category.getComponents()) {
			if (!isFiltered(descriptor)) {
				return false;
			}
		}
		return true;
	}

	private boolean isFiltered(InstallableComponent descriptor) {
		if (!descriptor.isVisible()) {
			return true;
		}
		boolean kindFiltered = false;
		for (Group kind : descriptor.getGroups()) {
			if (!isVisible(kind)) {
				kindFiltered = true;
				break;
			}
		}
		if (kindFiltered) {
			return true;
		}
		if (descriptor.isInstalled()) {
			// always filter installed features per bug 275777
			return true;
		}
		if (filterPattern != null) {
			if (!(filterMatches(descriptor.getName())
					|| filterMatches(descriptor.getDescription())
					|| filterMatches(descriptor.getProvider()) || filterMatches(descriptor
							.getLicense()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * indicate if the connector descriptor filters should be shown in the UI.
	 * Changing this setting only has an effect before the UI is presented.
	 */
	public boolean isShowConnectorDescriptorKindFilter() {
		return showConnectorDescriptorKindFilter;
	}

	/**
	 * indicate if a text field should be provided to allow the user to filter
	 * connector descriptors
	 */
	public boolean isShowConnectorDescriptorTextFilter() {
		return showConnectorDescriptorTextFilter;
	}

	/**
	 * indicate if the given kind of connector is currently visible in the
	 * wizard
	 *
	 * @see #setVisibility(ConnectorDescriptorKind, boolean)
	 */
	public boolean isVisible(Group kind) {
		if (kind == null) {
			throw new IllegalArgumentException();
		}
		return connectorDescriptorKindToVisibility.get(kind);
	}

	private void modifySelection(final InstallableComponent connector,
			boolean selected) {
		modifySelectionInternal(connector, selected);
		updateState();
	}

	private void modifySelectionInternal(final InstallableComponent connector,
			boolean selected) {

		Iterator<Message> it = connector.getMessages().iterator();
		while (selected && it.hasNext()) {
			Message message = it.next();
			if (message.getIcon() == Severity.WARNING) {
				MessageDialog.openWarning(getShell(), message.getTitle(),
						message.getMessage());
			} else if (message.getIcon() == Severity.INFO) {
				MessageDialog.openInformation(getShell(), message.getTitle(),
						message.getMessage());
			}
		}

		connector.setSelected(selected);
		if (selected) {
			installableConnectors.add(connector);
		} else {
			installableConnectors.remove(connector);
		}
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionProvider.removeSelectionChangedListener(listener);
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	protected void setControl(Control control) {
		this.control = control;
	}

	public void setSelection(IStructuredSelection selection) {
		Set<InstallableComponent> selected = new HashSet<InstallableComponent>();
		for (Object descriptor : selection.toArray()) {
			if (descriptor instanceof InstallableComponent) {
				selected.add((InstallableComponent) descriptor);
			}
		}
		for (InstallableComponent connector : allConnectors) {
			modifySelectionInternal(connector, selected.contains(connector));
		}
		updateState();
	}

	/**
	 * indicate if the connector descriptor filters should be shown in the UI.
	 * Changing this setting only has an effect before the UI is presented.
	 */
	public void setShowConnectorDescriptorKindFilter(
			boolean showConnectorDescriptorKindFilter) {
		this.showConnectorDescriptorKindFilter = showConnectorDescriptorKindFilter;
	}

	/**
	 * indicate if a text field should be provided to allow the user to filter
	 * connector descriptors
	 */
	public void setShowConnectorDescriptorTextFilter(
			boolean showConnectorDescriptorTextFilter) {
		this.showConnectorDescriptorTextFilter = showConnectorDescriptorTextFilter;
	}

	public void setVerifyUpdateSiteAvailability(
			boolean verifyUpdateSiteAvailability) {
		this.verifyUpdateSiteAvailability = verifyUpdateSiteAvailability;
	}

	/**
	 * configure the page to show or hide connector descriptors of the given
	 * kind
	 *
	 * @see #connectorDescriptorKindVisibilityUpdated()
	 */
	public void setVisibility(Group kind, boolean visible) {
		if (kind == null) {
			throw new IllegalArgumentException();
		}
		connectorDescriptorKindToVisibility.put(kind, visible);
	}

	public void updateDiscovery() {
		boolean wasCancelled = false;
		try {
			context.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					DiscoveryViewer.this.provider.update(monitor);
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
				}
			});
		} catch (InvocationTargetException e) {
			Activator.logHelper.error(Messages.ConnectorDiscoveryWizardMainPage_unexpectedException, e);
		} catch (InterruptedException e) {
			// cancelled by user so nothing to do here.
			wasCancelled = true;
		}
		if (provider.getDiscovery() != null) {
			discoveryUpdated(wasCancelled);
			if (verifyUpdateSiteAvailability && !allConnectors.isEmpty()) {
				try {
					context.run(true, true, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							AvailabilityUpdater availability = new AvailabilityUpdater(
									provider.getDiscovery());
							availability.update(monitor);
						}
					});
				} catch (InvocationTargetException e) {
					Activator.logHelper.error(Messages.ConnectorDiscoveryWizardMainPage_unexpectedException, e);
				} catch (InterruptedException e) {
					// cancelled by user so nothing to do here.
					wasCancelled = true;
				}
			}

			// shouldn't be necessary but for some
			// reason checkboxes don't
			// regain their enabled state
			createBodyContents();
		}
		// help UI tests
		body.setData("discoveryComplete", "true"); //$NON-NLS-1$//$NON-NLS-2$
	}

	private void updateState() {
		setComplete(!installableConnectors.isEmpty());
		selectionProvider.setSelection(new StructuredSelection(
				getInstallableConnectors()));
	}
}
