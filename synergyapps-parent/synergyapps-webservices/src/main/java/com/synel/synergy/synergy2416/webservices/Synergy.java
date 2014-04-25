/**
 * Synergy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.synel.synergy.synergy2416.webservices

public interface Synergy extends javax.xml.rpc.Service {
    public java.lang.String getSynergySoapAddress();

    public com.xacttime.SynergySoap getSynergySoap() throws javax.xml.rpc.ServiceException;

    public com.xacttime.SynergySoap getSynergySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
