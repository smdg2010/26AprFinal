package gipsy.GEE.multitier.DST.ws;
import java.rmi.Remote;

import gipsy.GEE.IDP.demands.DemandSignature;
import gipsy.GEE.IDP.demands.IDemand;
import gipsy.GEE.multitier.DST.DSTWrapper; 

public class WSDSTWrapperProxy extends DSTWrapper implements Remote {
  private String _endpoint = null;
  private WSDSTWrapper wSDSTWrapper = null;
  
  public WSDSTWrapperProxy() {
    _initWSDSTWrapperProxy();
  }
  
  public WSDSTWrapperProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSDSTWrapperProxy();
  }
  
  private void _initWSDSTWrapperProxy() {
    try {
      wSDSTWrapper = (new WSDSTWrapperServiceLocator()).getWSDSTWrapper();
      if (wSDSTWrapper != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSDSTWrapper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSDSTWrapper)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSDSTWrapper != null)
      ((javax.xml.rpc.Stub)wSDSTWrapper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WSDSTWrapper getWSDSTWrapper() {
    if (wSDSTWrapper == null)
      _initWSDSTWrapperProxy();
    return wSDSTWrapper;
  }
  
  public IDemand getPendingDemand() throws Exception{
    if (wSDSTWrapper == null)
      _initWSDSTWrapperProxy();
    return wSDSTWrapper.getPendingDemand();
  }
  
  public IDemand getHashTableValue(DemandSignature podSignature) throws Exception{
    if (wSDSTWrapper == null)
      _initWSDSTWrapperProxy();
    return wSDSTWrapper.getHashTableValue(podSignature);
  }
  
  public DemandSignature setHashTable(IDemand poIdObj) throws Exception{
    if (wSDSTWrapper == null)
      _initWSDSTWrapperProxy();
    return wSDSTWrapper.setHashTable(poIdObj);
  }
  
  
}
