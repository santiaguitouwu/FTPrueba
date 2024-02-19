
package servicios;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioCRUD", targetNamespace = "http://Servicios/", wsdlLocation = "http://localhost:8080/PruebaFT_V.1.1/ServicioCRUD?wsdl")
public class ServicioCRUD_Service
    extends Service
{

    private final static URL SERVICIOCRUD_WSDL_LOCATION;
    private final static WebServiceException SERVICIOCRUD_EXCEPTION;
    private final static QName SERVICIOCRUD_QNAME = new QName("http://Servicios/", "ServicioCRUD");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/PruebaFT_V.1.1/ServicioCRUD?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOCRUD_WSDL_LOCATION = url;
        SERVICIOCRUD_EXCEPTION = e;
    }

    public ServicioCRUD_Service() {
        super(__getWsdlLocation(), SERVICIOCRUD_QNAME);
    }

    public ServicioCRUD_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOCRUD_QNAME, features);
    }

    public ServicioCRUD_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOCRUD_QNAME);
    }

    public ServicioCRUD_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOCRUD_QNAME, features);
    }

    public ServicioCRUD_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioCRUD_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioCRUD
     */
    @WebEndpoint(name = "ServicioCRUDPort")
    public ServicioCRUD getServicioCRUDPort() {
        return super.getPort(new QName("http://Servicios/", "ServicioCRUDPort"), ServicioCRUD.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioCRUD
     */
    @WebEndpoint(name = "ServicioCRUDPort")
    public ServicioCRUD getServicioCRUDPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Servicios/", "ServicioCRUDPort"), ServicioCRUD.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOCRUD_EXCEPTION!= null) {
            throw SERVICIOCRUD_EXCEPTION;
        }
        return SERVICIOCRUD_WSDL_LOCATION;
    }

}
