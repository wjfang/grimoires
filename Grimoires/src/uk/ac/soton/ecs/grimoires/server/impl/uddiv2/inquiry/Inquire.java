/**
 * Inquire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.inquiry;

public interface Inquire extends java.rmi.Remote {
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail find_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList find_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RelatedBusinessesList find_relatedBusinesses(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_relatedBusinesses body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceList find_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList find_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Find_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail get_bindingDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_bindingDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail get_businessDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetailExt get_businessDetailExt(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_businessDetailExt body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail get_serviceDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_serviceDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail get_tModelDetail(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_tModelDetail body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
}
