/**
 * Contact.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Contact  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description;
    private java.lang.String personName;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone[] phone;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email[] email;
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address[] address;
    private java.lang.String useType;  // attribute

    public Contact() {
    }

    public Contact(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address[] address,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email[] email,
           java.lang.String personName,
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone[] phone,
           java.lang.String useType) {
           this.description = description;
           this.personName = personName;
           this.phone = phone;
           this.email = email;
           this.address = address;
           this.useType = useType;
    }


    /**
     * Gets the description value for this Contact.
     * 
     * @return description
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Contact.
     * 
     * @param description
     */
    public void setDescription(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description[] description) {
        this.description = description;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description getDescription(int i) {
        return this.description[i];
    }

    public void setDescription(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Description _value) {
        this.description[i] = _value;
    }


    /**
     * Gets the personName value for this Contact.
     * 
     * @return personName
     */
    public java.lang.String getPersonName() {
        return personName;
    }


    /**
     * Sets the personName value for this Contact.
     * 
     * @param personName
     */
    public void setPersonName(java.lang.String personName) {
        this.personName = personName;
    }


    /**
     * Gets the phone value for this Contact.
     * 
     * @return phone
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone[] getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this Contact.
     * 
     * @param phone
     */
    public void setPhone(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone[] phone) {
        this.phone = phone;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone getPhone(int i) {
        return this.phone[i];
    }

    public void setPhone(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Phone _value) {
        this.phone[i] = _value;
    }


    /**
     * Gets the email value for this Contact.
     * 
     * @return email
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email[] getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Contact.
     * 
     * @param email
     */
    public void setEmail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email[] email) {
        this.email = email;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email getEmail(int i) {
        return this.email[i];
    }

    public void setEmail(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Email _value) {
        this.email[i] = _value;
    }


    /**
     * Gets the address value for this Contact.
     * 
     * @return address
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address[] getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Contact.
     * 
     * @param address
     */
    public void setAddress(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address[] address) {
        this.address = address;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address getAddress(int i) {
        return this.address[i];
    }

    public void setAddress(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Address _value) {
        this.address[i] = _value;
    }


    /**
     * Gets the useType value for this Contact.
     * 
     * @return useType
     */
    public java.lang.String getUseType() {
        return useType;
    }


    /**
     * Sets the useType value for this Contact.
     * 
     * @param useType
     */
    public void setUseType(java.lang.String useType) {
        this.useType = useType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              java.util.Arrays.equals(this.description, other.getDescription()))) &&
            ((this.personName==null && other.getPersonName()==null) || 
             (this.personName!=null &&
              this.personName.equals(other.getPersonName()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              java.util.Arrays.equals(this.phone, other.getPhone()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              java.util.Arrays.equals(this.email, other.getEmail()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              java.util.Arrays.equals(this.address, other.getAddress()))) &&
            ((this.useType==null && other.getUseType()==null) || 
             (this.useType!=null &&
              this.useType.equals(other.getUseType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDescription() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDescription());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDescription(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPersonName() != null) {
            _hashCode += getPersonName().hashCode();
        }
        if (getPhone() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPhone());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPhone(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEmail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAddress() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAddress());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAddress(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUseType() != null) {
            _hashCode += getUseType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
