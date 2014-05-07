package com.synel.synergy.synergy2416.util;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

public final class PropertyManager {

	private static String rootpath = "/home/admin/synergy/resources/";
	private static final String mPropBundleName = "sysconfig.properties";
	private static Properties mSysResourceBundle;
	private static Properties mAppResourceBundle;
	private static String mThisBundleName;
	private static FileInputStream mPropReader;
	private static FileOutputStream mPropWriter;
	private static HashMap<String, Image> mImageList = new HashMap<String, Image>();

	static{
		try {
			System.out.println(rootpath+System.getProperty("user.dir"));
			mPropReader = new FileInputStream(rootpath+mPropBundleName);
			mSysResourceBundle = new Properties();
			mSysResourceBundle.load(mPropReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Properties open( String appBundleName ) throws FileNotFoundException, IOException{
		if( mAppResourceBundle == null ){
			mAppResourceBundle.load(new FileInputStream(appBundleName));
			mThisBundleName = appBundleName;
		}
		return mAppResourceBundle;
	}

	public static void close(){
		ResourceBundle.clearCache();
		mSysResourceBundle = null;
		mAppResourceBundle = null;
	}

	public static String getResourceName(){
		return mThisBundleName;
	}

	/**
	 * Gets a string from the resource bundle. Returns an alternate string if the key is not found.
	 * @param key the key string
	 * @param alt an alternate value to return if the key was not found.
	 * @return the value of the key or the alternate.
	 */
	public static String getString( String key, String alt ){
		String lResult = alt;
		if( key != null && key.length() > 0 ){
			try{
				// First try the application bundle
				if( mAppResourceBundle != null ){
					try{
						lResult = mAppResourceBundle.getProperty(key);
					}
					catch( Exception ignore ){
						// On any error, get it from the system resource
						lResult = mSysResourceBundle.getProperty(key);
					}
				}
				else{
					// No app resource opened, get it from the system resource
					lResult = mSysResourceBundle.getProperty(key);
				}
			}
			catch( Exception e ){
			}
		}
		return lResult;
	}

	/**
	 * Gets a string from the resource bundle. We don't want to crash because of a missing String.
	 * Returns the key if not found.
	 * @param key the key string
	 * @return the value of the key
	 */
	public static String getString( String key ){
		return getString( key, null );
	}

	/**
	 * Gets an integer value from the resource bundle. The resource value is a String so it must be
	 * able to be parsed into an integer value.
	 * <p/>
	 * @param key the key string
	 * @return the integer value of the key or -1 if not found or not parsable into integer.
	 */
	public static int getInt( String key ){
		return getInt( key, -1 );
	}

	/**
	 * Gets an integer value from the resource bundle. The resource value is a String so it must be
	 * able to be parsed into an integer value. If the key is not found or is not parsable, the
	 * provided alternate value is returned.
	 * <p/>
	 * @param key the key string
	 * @param alt the alternate value to return.
	 * @return the integer value of the key or the alternate if not found or not parsable into
	 *         integer.
	 */
	public static int getInt( String key, int alt ){
		String lValue = getString( key );
		int lResult;
		try{
			lResult = Integer.parseInt( lValue );
		}
		catch( NumberFormatException numberFormatException ){
			lResult = alt;
		}
		return lResult;
	}

	/**
	 * Gets a double value from the resource bundle. The resource value is a String so it must be
	 * able to be parsed into a double value.
	 * <p/>
	 * @param key the key string
	 * @return the double value of the key or Double.NaN if not found or not parsable into integer.
	 */
	public static double getDouble( String key ){
		return getDouble( key, Double.NaN );
	}

	/**
	 * Gets a double value from the resource bundle. The resource value is a String so it must be
	 * able to be parsed into a double value. If the key is not found or is not parsable, the
	 * provided alternate value is returned.
	 * <p/>
	 * @param key the key string
	 * @param alt the alternate value to return.
	 * @return the double value of the key or the alternate if not found or not parsable into
	 *         double.
	 */
	public static double getDouble( String key, double alt ){
		String lValue = getString(key);
		double lResult;
		try{
			lResult = Double.parseDouble(lValue);
		}
		catch( NumberFormatException numberFormatException ){
			lResult = alt;
		}
		return lResult;
	}

	public static String setProperty(String key, String value) throws FileNotFoundException, IOException{
		mPropWriter = new FileOutputStream(mPropBundleName);
		mSysResourceBundle.setProperty(key, value);
		mSysResourceBundle.store(mPropWriter, null);
		return null;
	}
	/**
	 * Gets a boolean value from the resource bundle. The resource value is a String so it must be
	 * "true" or "false". For any other value, or if it doesn't exist at all, a false is returned.
	 * <p/>
	 * @param key the key string
	 * @return the boolean value of the key or {@code false} if not found or not parsable into
	 *         boolean.
	 */
	public static boolean getBoolean( String key ){
		String lValue = getString( key );
		return "true".equalsIgnoreCase( lValue );
	}

	/**
	 * Gets an image from the resource bundle. Actually, from the bundle itself, it only gets the
	 * image filename. It then creates the input stream from the file and reads in the image.
	 * <p/>
	 * @param key the key string.
	 * @return the Image object derived from the image file, or {@code null} if not found.
	 */
	public static Image getImage( String key ){
		// First, see if we already have this image
		Image lResult = mImageList.get(key);
		if( lResult == null ){
			// No, well read in the filename and build it
			String lImgFileName = getString( key, null );
			if( lImgFileName != null ){
				InputStream imgFileStream = null;
				try {
					imgFileStream = new BufferedInputStream(new FileInputStream(lImgFileName));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if( imgFileStream != null ){
					// Success, now create the image and add it to the list so
					// we don't have to go through all this again
					try {
						lResult = ImageIO.read(imgFileStream);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return lResult;
	}

}
