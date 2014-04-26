package com.synel.synergy.synergy2416.system;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import com.synel.synergy.synergy2416.util.PropertyManager;


public class SystemInformation {

	//private static final String SYS_ENV_LOCATION = "sysconfig.properties";
	//private static final String APP_ENV_LOCATION = "/root/SYNERGY/etc/appconfig.property";
	private static String mGuid = "";
	private static String mAuth = "";
	private static final String mSalt = "e=mc2+pi314+eu271";

	public static String getDeviceId()
	{
		if (mGuid == ""){
			mGuid = PropertyManager.getString("DeviceId","ABCDEFGHIJKLMNOP");
		}
		return mGuid;
	}

	public static String getWebServiceHost()
	{
		return PropertyManager.getString("WebServiceHost", "localhost");
	}
	
	public static String getWebServiceEndPoint()
	{
		return  PropertyManager.getString("WebServiceEndPoint", "https://xacttime.taserver.com/site/webservices/v2/synergy.asmx");
	}


	public static String getWebServicePortNumber() {
		return PropertyManager.getString("WebServicePortNumber", "8000");
	}
	
	public static int systemUpTimeSeconds(){
		return (int)System.nanoTime()/1000000000;
	}
	
	/*
	 * @return the authcode based on the md5sum of the salted guid:
	 */
	
	public static String getAuthCode(){
		if (mAuth != "") return mAuth;
		String systemGuid = getDeviceId();
		String saltedGuid = systemGuid + mSalt;
		//calculate md5 hash of the saltedGuid as password/authcode
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(saltedGuid.getBytes());
		byte byteData[] = md.digest();
		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i=0; i < byteData.length; i++){
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		String authcode = sb.toString();
		System.out.println("AuthCode is"+authcode);
		return authcode;	
	}
	
	/*
	 * @return A base64 encoded usrname:passwd string for http basic auth use.
	 */
	public static String getBasicAuthCode(){
		String systemGuid = getDeviceId();
		String authcode = getAuthCode();
		byte[] encoding = Base64.encodeBase64((systemGuid+":"+authcode).getBytes());
		String basicAuthEncoded = new String(encoding);
		return basicAuthEncoded;
	}

	public static String getWebServicesKey() {
		return PropertyManager.getString("WebServiceKey","279330F8-ABCF-490F-979C-48C8A706E75B");
	}

	public static int getTerminalId() {
		
		return PropertyManager.getInt("TerminalId", 0);
	}

	public static int getWebServicesTimeoutValue() {
		return PropertyManager.getInt("WebServiceTimeout",100000);
	}
}
