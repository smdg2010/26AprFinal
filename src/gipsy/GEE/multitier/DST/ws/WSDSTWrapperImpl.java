/**
 * WSDSTWrapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gipsy.GEE.multitier.DST.ws;

import java.io.IOException;
import java.net.Socket;
import java.rmi.Naming;

import gipsy.Configuration;
import gipsy.GEE.IDP.DemandGenerator.ws.WSTransportAgent;
import gipsy.GEE.IDP.demands.IDemand;
import gipsy.GEE.logger.Logger;
import gipsy.GEE.multitier.MultiTierException;
import gipsy.GEE.multitier.DST.DSTWrapper;
import gipsy.tests.GEE.IDP.demands.DemandTest;
import gipsy.util.Trace;

public class WSDSTWrapperImpl extends DSTWrapper {
	private static final String LOOKUP_SERVICE_PORT = "gipsy.GEE.multitier.DST.mongodb.port";
	private static final String HOSTNAME = "gipsy.GEE.multitier.DST.mongodb.hostname";
	
	
	private Logger log = new Logger();
	int WSPortNum = 27017;

	private WSTransportAgent oIWSTA =null;
	private WSDSTWrapperProxy obj=null;
	/**
	 * The TA configuration exposed by this DST.
	 */
	private Configuration oTAConfig = null;

	/**
	 * The PID of the DST process started.
	 */
	private String strPID = null;

	/**
	 * For logging.
	 */
	private static final String MSG_PREFIX = "[" + Trace.getEnclosingClassName() + "] ";

	/**
	 * Create an instance based on configuration.
	 * 
	 * @param poDSTConfig
	 *            - The DST configuration.
	 */
	public WSDSTWrapperImpl(Configuration poDSTConfig) {
		this.oConfiguration = poDSTConfig;
	}

	public static void main(String args[]) {
		WSDSTWrapperImpl mdstw = new WSDSTWrapperImpl(null);
		try {
			mdstw.startTier();
		} catch (MultiTierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Allocates Mongo DST
	public void startTier() throws MultiTierException {
		//obj = new MongoDST();
        
		synchronized (this) {
			if(this.strPID != null)
			{   log.debug("Checking whether any WS DST is running ");
				if(this.isDSTRunning())
				{
					// Simply return.
					System.out.println(MSG_PREFIX +" WS DST is still running!");
					log.info(MSG_PREFIX + " WS DST is still running");
					return;
				}
				else
				{
					System.out.println(MSG_PREFIX + " Old WS DST dead, allocating new RMI DST ...");
					log.info(MSG_PREFIX + " Old WS DST dead, allocating new RMI DST ... ");
				}
			 }
			 else
			 { 
				log.debug("No running WS DST is found");
				System.out.println(MSG_PREFIX + "Allocating new WS DST ...");
				log.info(MSG_PREFIX + " Allocating new WS DST ... ") ; 
	   		 }
	     }
		
	  
	    try
		{
			 //String strDSTWorkingDir = this.oConfiguration.getProperty(DSTWrapper.DST_WORKING_DIR);
			//String strLookupServicePort = this.oConfiguration.getProperty(LOOKUP_SERVICE_PORT);
			
			System.out.println( "RMI registry successfully started.");
				 
			log.info("WS started successfully");
				 
			obj = new WSDSTWrapperProxy();
			log.info(obj.getClass().toString() + " " + "Object created");
			oIWSTA = new WSTransportAgent();
			
				
				 
			Naming.rebind("lookUp", obj); //Re-binding the object for lookUp in registry.
			log.info(obj.getClass().toString() + " " + "Object bind to lookUp");
			Naming.rebind("oTA", oIWSTA );
			log.info(oIWSTA.getClass().toString() + " " + "Object bind to oTA");
				 			
		}
		catch(Exception e)
		{
			log.error(e.getClass().toString() + "Problem in starting registry for RMI");
		}
		
		
	}

	// Stops the tier

	public void stopTier() throws MultiTierException {

		synchronized (this) {
			// Assume we are only run in Windows or Linux like systems
			String strOSName = System.getProperty("os.name");

			String strKillProcessCMD = null;

			if (strOSName.contains("Linux") || strOSName.startsWith("Linux")) {
				strKillProcessCMD = "cmd /c taskkill /PID " + this.strPID;
				//log.info(" storing Windows command for task kill");
			} else {
				strKillProcessCMD = "kill -9 " + this.strPID;
				//log.info("storing  Linux command for task kill ");
			}

			try {
				Runtime.getRuntime().exec(strKillProcessCMD);

				// Only try 3 times
				int iCounter = 0;

				while (this.isDSTRunning()) {
					if (iCounter < 3) {
						Thread.sleep(5000);
						//log.info(" Make DST to sleep if it is more than three count ");
					} else {
						//log.debug(" MultiTier Exception is thrown, since DST still running more than 3 times");
						throw new MultiTierException("The DST is still running!");
					}

					iCounter++;
				}
			} catch (IOException oException) {
				//log.error(oException.getClass().toString() + " throwing IO exception");
				oException.printStackTrace(System.err);
				throw new MultiTierException(oException);
			} catch (InterruptedException oException) {
				//log.error(oException.getClass().toString() + " throwing Interrupted exception");
				oException.printStackTrace(System.err);
				throw new MultiTierException(oException);
			}

			this.strPID = null;
		}
	}

	public synchronized Configuration exportTAConfig() {
		return this.oTAConfig;
	}

	/**
	 * check whether or not DST is running
	 * 
	 * @return boolean
	 */
	private boolean isDSTRunning() {
		System.out.println("--------------Testing port " + WSPortNum);
		Socket s = null;
		try {
			s = new Socket("localhost", WSPortNum);
			IDemand oDemand = new DemandTest("_1");
			
			// If the code makes it this far without an exception it means
			// something is using the port and has responded.
			System.out.println("--------------Port " + WSPortNum + " is not available");
			return false;
		} catch (IOException e) {
			System.out.println("--------------Port " + WSPortNum + " is available");
			return true;
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					throw new RuntimeException("You should handle this error.", e);
				}
			}
		}
	}
}

