/*
 * Copyright 2013 Carnegie Mellon University

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 */

package org.osate.importer.model;

public class Connection {
	String content;
	Component source;
	Component destination;

	public Connection(String c, Component s, Component d) {
		this.content = c;
		this.source = s;
		this.destination = d;
	}

	public Connection(Component s, Component d) {
		this("1", s, d);
	}

	public Connection(Component s, Component d, int st) {

		this(new String("" + st), s, d);
	}

	public Component getSource() {
		return this.source;
	}

	public Component getDestination() {
		return this.destination;
	}

	public String getContent() {
		return this.content;
	}

	public void setSource(Component s) {
		this.source = s;
	}

	public void setDestination(Component d) {
		this.destination = d;
	}

	public String toString() {
		String r;
		r = "Connection value=" + this.content;
		if (this.source != null) {
			r += " (src=" + this.source + ") ";
		}
		if (this.destination != null) {
			r += " (dst=" + this.destination + ") ";
		}
		return r;
	}
}
