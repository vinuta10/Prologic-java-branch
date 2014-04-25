/**
 * SynergyLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices

public class SynergyLocator extends org.apache.axis.client.Service implements com.xacttime.Synergy {

    public SynergyLocator() {
    }


    public SynergyLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SynergyLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SynergySoap
    private java.lang.String SynergySoap_address = "https://xacttime.taserver.com/site/webservices/v2/synergy.asmx";

    public java.lang.String getSynergySoapAddress() {
        return SynergySoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SynergySoapWSDDServiceName = "SynergySoap";

    public java.lang.String getSynergySoapWSDDServiceName() {
        return SynergySoapWSDDServiceName;
    }

    public void setSynergySoapWSDDServiceName(java.lang.String name) {
        SynergySoapWSDDServiceName = name;
    }

    public com.xacttime.SynergySoap getSynergySoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SynergySoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSynergySoap(endpoint);
    }

    public com.xacttime.SynergySoap getSynergySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.xacttime.SynergySoapStub _stub = new com.xacttime.SynergySoapStub(portAddress, this);
            _stub.setPortName(getSynergySoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSynergySoapEndpointAddress(java.lang.String address) {
        SynergySoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.xacttime.SynergySoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.xacttime.SynergySoapStub _stub = new com.xacttime.SynergySoapStub(new java.net.URL(SynergySoap_address), this);
                _stub.setPortName(getSynergySoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SynergySoap".equals(inputPortName)) {
            return getSynergySoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xacttime.com/", "Synergy");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xacttime.com/", "SynergySoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SynergySoap".equals(portName)) {
            setSynergySoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
