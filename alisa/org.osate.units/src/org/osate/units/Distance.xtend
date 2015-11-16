/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.units
/*
 * http://blog.efftinge.de/2012/04/xtend-example-working-with-distances.html
 */
class Distance {
	int mm

	new(int mm) {
		this.mm = mm
	}

	def static mm(int millimeters) {
		new Distance(millimeters) // not yet existing
	}

	def static cm(int centimeters) {
		mm(centimeters * 10)
	}

	def static m(int meters) {
		cm(meters * 100)
	}

	def static km(int kilometers) {
		m(kilometers * 1000)
	}

	override equals(Object obj) {
		switch obj {
			Distance: this.mm == obj.mm
			default: super.equals(obj)
		}
	}

	override hashCode() {
		this.mm
	}

	def +(Distance other) {
		return new Distance(this.mm + other.mm)
	}

	def operator_minus(Distance other) {
		return new Distance(this.mm - other.mm)
	}

	def operator_multiply(int times) {
		return new Distance(this.mm * times)
	}
	
	static def *(int times, Distance d){
		return new Distance(d.mm * times)
	}

}
