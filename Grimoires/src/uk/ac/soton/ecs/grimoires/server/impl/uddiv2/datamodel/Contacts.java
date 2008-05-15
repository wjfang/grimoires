/**
 * Contacts.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel;

public class Contacts  implements java.io.Serializable , uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitable {
    private uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact[] contact;

    public Contacts() {
    }

    public Contacts(
           uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact[] contact) {
           this.contact = contact;
    }


    /**
     * Gets the contact value for this Contacts.
     * 
     * @return contact
     */
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact[] getContact() {
        return contact;
    }


    /**
     * Sets the contact value for this Contacts.
     * 
     * @param contact
     */
    public void setContact(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact[] contact) {
        this.contact = contact;
    }

    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact getContact(int i) {
        return this.contact[i];
    }

    public void setContact(int i, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Contact _value) {
        this.contact[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contacts)) return false;
        Contacts other = (Contacts) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              java.util.Arrays.equals(this.contact, other.getContact())));
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
        if (getContact() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContact());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContact(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

 /** Grimoires specific methods and constructors */ 

 public Object accept(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.handlers.UDDIv2DataModelVisitor v) throws Exception {       return v.process(this);       }       

}
