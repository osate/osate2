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

/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package org.osate.units

import java.math.BigDecimal
import org.eclipse.xtend.lib.annotations.Data

@Data class Time {
	BigDecimal msec
	
	def +(Time other) {
		new Time(this.msec + other.msec)
	}
	
	def -(Time other) {
		new Time(this.msec - other.msec)
	}

	def *(int times) {
		new Time(this.msec * new BigDecimal(times))
	}
// handle times on int as first operand
	static def *(int times, Time d){
		return new Time(d.msec * new BigDecimal(times))
	}

	def *(double times) {
		new Time(this.msec * new BigDecimal(times))
	}
	
	
	def /(int times) {
		new Time(this.msec / new BigDecimal(times))
	}
	
	def /(double times) {
		new Time(this.msec / new BigDecimal(times))
	}
	
	def static msec(int msec) {
		new Time(new BigDecimal(msec))
	}
	
	def static sec(int sec) {
		msec(sec * 1000)
	}
	
	def static min(int min) {
		sec(min * 60)
	}
	
	def static h(int h) {
		min(h * 60)
	}
	def static h() {
		h(1)
	}
}