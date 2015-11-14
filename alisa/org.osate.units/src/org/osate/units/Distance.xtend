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
