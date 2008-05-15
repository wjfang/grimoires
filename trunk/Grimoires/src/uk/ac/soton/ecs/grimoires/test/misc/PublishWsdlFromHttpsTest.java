package uk.ac.soton.ecs.grimoires.test.misc;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.bl.GrimoiresBusinessLogicProxyFactory;
import junit.framework.TestCase;

public class PublishWsdlFromHttpsTest extends TestCase {
	final private static String WSDL_URL = 
		"https://omii-test.ecs.soton.ac.uk:18443/grimoires/services/inquire?wsdl";
	
	private GrimoiresProxy grimoiresProxy;
	
	@Override
	protected void setUp() throws Exception {
		grimoiresProxy = 
			GrimoiresBusinessLogicProxyFactory.getInstance().createProxy(null);
	}
	
	public void test() throws Exception {
		grimoiresProxy.saveWSDL(WSDL_URL);
	}
	
	public void testWithoutCert() throws Exception {
		setUpSslWithoutCert();
		grimoiresProxy.saveWSDL(
				WSDL_URL);
//				"https://rigel.omii.ac.uk:18443/grimoires/services/publish?wsdl");
	}
	
	private void setUpSslWithoutCert() throws Exception {
		// Create a trust manager that does not validate certificate chains
	    TrustManager[] trustAllCerts = new TrustManager[]{
	        new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            
	            public void checkClientTrusted(
	            		java.security.cert.X509Certificate[] certs, String authType) {
	            	// do nothing
	            }
	            
	            public void checkServerTrusted(
	            		java.security.cert.X509Certificate[] certs, String authType) {
	            	// do nothing
	            }
	        }
	    };
	    
	    // Install the all-trusting trust manager
	    try {
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    } catch (Exception e) {
	    }
	}

}
