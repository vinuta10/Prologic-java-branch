/**
 * SynergySoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices;

public interface SynergySoap extends java.rmi.Remote {
    public PunchStatus recordPunch(java.lang.String webServicesKey, int terminalId, PunchData punch) throws java.rmi.RemoteException;
    public PunchStatus[] recordPunches(java.lang.String webServicesKey, int terminalId, PunchData[] punches) throws java.rmi.RemoteException;
    public Employee[] getEmployees(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException;
    public LaborLevel[] getLaborLevels(java.lang.String webServicesKey) throws java.rmi.RemoteException;
    public Options getOptions(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException;
    public Fingerprint[] getFingerprints(java.lang.String webServicesKey, int terminalId) throws java.rmi.RemoteException;
    public boolean setFingerprint(java.lang.String webServicesKey, Fingerprint fingerprint) throws java.rmi.RemoteException;
}
