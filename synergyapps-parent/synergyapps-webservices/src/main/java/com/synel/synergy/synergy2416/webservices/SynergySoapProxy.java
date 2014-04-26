package com.synel.synergy.synergy2416.webservices;

public class SynergySoapProxy implements SynergySoap {
  private String _endpoint = null;
  private SynergySoap synergySoap = null;
  
  public SynergySoapProxy() {
    _initSynergySoapProxy();
  }
  
  public SynergySoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSynergySoapProxy();
  }
  
  private void _initSynergySoapProxy() {
    try {
      synergySoap = (new SynergyLocator()).getSynergySoap();
      if (synergySoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)synergySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)synergySoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (synergySoap != null)
      ((javax.xml.rpc.Stub)synergySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SynergySoap getSynergySoap() {
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap;
  }
  
  public PunchStatus recordPunch(java.lang.String webServicesKey, int terminalId, PunchData punch) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.recordPunch(webServicesKey, terminalId, punch);
  }
  
  public PunchStatus[] recordPunches(java.lang.String webServicesKey, int terminalId, PunchData[] punches) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.recordPunches(webServicesKey, terminalId, punches);
  }
  
  public Employee[] getEmployees(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.getEmployees(webServicesKey, terminalId);
  }
  
  public LaborLevel[] getLaborLevels(java.lang.String webServicesKey) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.getLaborLevels(webServicesKey);
  }
  
  public Options getOptions(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.getOptions(webServicesKey, terminalId);
  }
  
  public Fingerprint[] getFingerprints(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.getFingerprints(webServicesKey, terminalId);
  }
  
  public boolean setFingerprint(java.lang.String webServicesKey, Fingerprint fingerprint) throws java.rmi.RemoteException{
    if (synergySoap == null)
      _initSynergySoapProxy();
    return synergySoap.setFingerprint(webServicesKey, fingerprint);
  }
  
  
}