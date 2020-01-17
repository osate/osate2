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
package org.osate.ge.internal.services.impl;

import java.lang.ref.WeakReference;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.ClipboardService;

public class DefaultClipboardService implements ClipboardService {
	public static class ContextFunction extends SimpleServiceContextFunction<ClipboardService> {
		@Override
		public ClipboardService createService(final IEclipseContext context) {
			return new DefaultClipboardService();
		}
	}

	// The clipboard is a weak reference so that it will be automatically cleared when there are no users of the clipboard.
	private WeakReference<Clipboard> weakClipboard = new WeakReference<>(null);

	@Override
	public synchronized Clipboard getClipboard() {
		Clipboard clipboard = weakClipboard.get();
		if(clipboard == null) {
			clipboard = new SimpleClipboard();
			weakClipboard = new WeakReference<>(clipboard);
		}

		return clipboard;
	}

	private static class SimpleClipboard implements Clipboard {
		private Object contents;

		@Override
		public Object getContents() {
			return contents;
		}

		@Override
		public void setContents(final Object value) {
			this.contents = value;
		}
	}
}
