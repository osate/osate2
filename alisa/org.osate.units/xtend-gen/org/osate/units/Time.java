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
package org.osate.units;

import java.math.BigDecimal;
import java.math.MathContext;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Time {
  private final BigDecimal msec;
  
  public Time operator_plus(final Time other) {
    BigDecimal _plus = this.msec.add(other.msec);
    return new Time(_plus);
  }
  
  public Time operator_minus(final Time other) {
    BigDecimal _minus = this.msec.subtract(other.msec);
    return new Time(_minus);
  }
  
  public Time operator_multiply(final int times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = this.msec.multiply(_bigDecimal);
    return new Time(_multiply);
  }
  
  public static Time operator_multiply(final int times, final Time d) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = d.msec.multiply(_bigDecimal);
    return new Time(_multiply);
  }
  
  public Time operator_multiply(final double times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = this.msec.multiply(_bigDecimal);
    return new Time(_multiply);
  }
  
  public Time operator_divide(final int times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = this.msec.divide(_bigDecimal, MathContext.DECIMAL128);
    return new Time(_divide);
  }
  
  public Time operator_divide(final double times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = this.msec.divide(_bigDecimal, MathContext.DECIMAL128);
    return new Time(_divide);
  }
  
  public static Time msec(final int msec) {
    BigDecimal _bigDecimal = new BigDecimal(msec);
    return new Time(_bigDecimal);
  }
  
  public static Time sec(final int sec) {
    return Time.msec((sec * 1000));
  }
  
  public static Time min(final int min) {
    return Time.sec((min * 60));
  }
  
  public static Time h(final int h) {
    return Time.min((h * 60));
  }
  
  public static Time h() {
    return Time.h(1);
  }
  
  public Time(final BigDecimal msec) {
    super();
    this.msec = msec;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.msec== null) ? 0 : this.msec.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Time other = (Time) obj;
    if (this.msec == null) {
      if (other.msec != null)
        return false;
    } else if (!this.msec.equals(other.msec))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("msec", this.msec);
    return b.toString();
  }
  
  @Pure
  public BigDecimal getMsec() {
    return this.msec;
  }
}
