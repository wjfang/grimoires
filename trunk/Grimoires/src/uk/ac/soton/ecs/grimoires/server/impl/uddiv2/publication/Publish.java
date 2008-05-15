/**
 * Publish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC3 Feb 28, 2005 (10:15:14 EST) WSDL2Java emitter.
 */

package uk.ac.soton.ecs.grimoires.server.impl.uddiv2.publication;

public interface Publish extends java.rmi.Remote {
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport add_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Add_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport delete_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Delete_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport discard_authToken(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Discard_authToken body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AssertionStatusReport get_assertionStatusReport(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_assertionStatusReport body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.AuthToken get_authToken(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_authToken body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions get_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.RegisteredInfo get_registeredInfo(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Get_registeredInfo body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BindingDetail save_binding(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_binding body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail save_business(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.ServiceDetail save_service(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_service body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail save_tModel(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
    public uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.PublisherAssertions set_publisherAssertions(uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Set_publisherAssertions body) throws java.rmi.RemoteException, uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
}
