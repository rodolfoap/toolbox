package org.rap.prgtests.xtend
import org.eclipse.xtend.lib.annotations.Data 

@Data 
class ActiveAnnotations_Data {
  String street
  String zip
  String city
  
  def static void main(String[] args) {
  	var me=new ActiveAnnotations_Data("MyStreet", "31520", "MyCity")
  	println(me.toString);
  }
}

/* Prints:

ActiveAnnotations_Data [
  street = "MyStreet"
  zip = "31520"
  city = "MyCity"
]

Generates:

package org.rap.prgtests.xtend;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class ActiveAnnotations_Data {
  private final String street;
  
  private final String zip;
  
  private final String city;
  
  public ActiveAnnotations_Data(final String street, final String zip, final String city) {
    super();
    this.street = street;
    this.zip = zip;
    this.city = city;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.street== null) ? 0 : this.street.hashCode());
    result = prime * result + ((this.zip== null) ? 0 : this.zip.hashCode());
    result = prime * result + ((this.city== null) ? 0 : this.city.hashCode());
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
    ActiveAnnotations_Data other = (ActiveAnnotations_Data) obj;
    if (this.street == null) {
      if (other.street != null)
        return false;
    } else if (!this.street.equals(other.street))
      return false;
    if (this.zip == null) {
      if (other.zip != null)
        return false;
    } else if (!this.zip.equals(other.zip))
      return false;
    if (this.city == null) {
      if (other.city != null)
        return false;
    } else if (!this.city.equals(other.city))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("street", this.street);
    b.add("zip", this.zip);
    b.add("city", this.city);
    return b.toString();
  }
  
  @Pure
  public String getStreet() {
    return this.street;
  }
  
  @Pure
  public String getZip() {
    return this.zip;
  }
  
  @Pure
  public String getCity() {
    return this.city;
  }
}

 */