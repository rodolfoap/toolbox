package org.rap.prgtests.xtend

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ActiveAnnotations_Accessors {
	var int variable
	new(int initial){
		variable=initial
	}
}

/* Generates:
 
package org.rap.prgtests.xtend;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ActiveAnnotations_Accessors {
  private int variable;
  
  public ActiveAnnotations_Accessors(final int initial) {
    this.variable = initial;
  }
  
  @Pure
  public int getVariable() {
    return this.variable;
  }
  
  public void setVariable(final int variable) {
    this.variable = variable;
  }
}
 
 */
