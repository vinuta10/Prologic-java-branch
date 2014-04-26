package com.synel.synergy.synergy2416.webservices.api;

import java.rmi.RemoteException;
import java.util.List;

import com.synel.synergy.synergy2416.webservices.Employee;
import com.synel.synergy.synergy2416.webservices.LaborLevelDetail;

public interface SynergyWebServiceApi {
	/**
	 * Sends transaction from ID Device to web Service in real time, not from a database in a separate thread. Usually blocking.
	 * 
	 * @param userID from Identification Device
	 * @param transactionTime milliseconds since epoch of time swipe from user with userID was received 
	 * @param punchTypeNum NonWork or Transfer or StartLunch or StartBreak or ClockIn or ClockOut or EndLunch or EndBreak or PayAdjustment or SwipeAndGo or CallBack
	 * @param laborLevelDetialIds array of indexes to the labor level detail table. 
	 * @return 0 if successful, return negative number (-400) if failed, this will load the LogToFile Module
	 */
	public int sendPunchRt(int userID, long transactionTimeEpoch, int punchTypeNum , int[] lldetailIds) throws Exception;
	
	/**
	 * When your module fails to keep or establish a connection to your web service end point the persistent layer class logs
	 * to a database the transactions that have accorded on the clock. The clock will attempt to retry the web service call 
	 * in the time interval you specify in the appconfig.properties file. 
	 * 
	 * When the servers connection is reestablished all of the punches that have not been uploaded to the server should be uploaded
	 * this method is called by the clock program when your web service connection is reestablished.
	 * 
	 * This section should contain code that accesses the database and uploads the transaction that have not yet been uploaded
	 * @return 0 if successful
	 */
	
	public int sendPunchesBatch() throws Exception;
	
	/**
	 * Allows you to get finger prints from the server or web service. Finger print templates are typically stored as strings on
	 * the web server. 
	 * When a template is sent from the terminal the template file is encoded with Base64 Encoding and sent as a 1404 character
	 * string to a web server. The Web Server can then store this string in a database for later retrieval by another terminal. The
	 * terminal will then receive a series of Templates (encoded as strings) then the terminal will decode these back into template
	 * files. 
	 * @return Returns success message 0 if successful
	 * @throws RemoteException if the server end point cannot be reached
	 */
	
	public int getFingerPrints() throws Exception;
	/**
	 * Sends a finger print template in a base64 encoded representation (string) to the web server along with the userID for which the
	 * finger print template belongs to
	 * @param userID of the template 
	 * @return 0 if successful
	 */
	public int sendFingerPrint(long userID, int fingerNumber) throws Exception;
	
	/**
	 * Get the Employee data from the server 
	 * This function is used when the clock initially boot and loading the database file about employees who are 
	 * allowed to punch on the clock
	 * @param int terminal id.
	 * @return a list of employees
	 */
	public List<Employee> getEmployees(int deviceId) throws Exception;
	
	/**
	 * Get the labor levels description
	 * @param 
	 * @return List of LaborLevel Details
	 * 
	 */
	public List<LaborLevelDetail> getLaborLevelDetails();
	
	/**
	 * Test purpose in general.
	 * Used for the Heat beat time. This is not a recommended way to synchronize time as NTP is a preferred solution
	 * @return 0 if successful
	 */
	public int getServerTime() throws Exception;
	
	/**
	 * Send the heartbeat signal to the server, can piggyback on other informations about the health of the hardware etc.
	 * @return xml <ok> if successfully acknowledged by the server.
	 */
    public String sendHeartBeat();  

}