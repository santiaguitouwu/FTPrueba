
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
@WebServiceClient(name = "ServicioAsignarMateria", targetNamespace = "http://Servicios/", wsdlLocation = "http://localhost:8080/PruebaFT_V.1.1/ServicioAsignarMateria?wsdl")
public class ServicioAsignarMateria_Service
    extends Service
{

    private final static URL SERVICIOASIGNARMATERIA_WSDL_LOCATION;
    private final static WebServiceException SERVICIOASIGNARMATERIA_EXCEPTION;
    private final static QName SERVICIOASIGNARMATERIA_QNAME = new QName("http://Servicios/", "ServicioAsignarMateria");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/PruebaFT_V.1.1/ServicioAsignarMateria?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOASIGNARMATERIA_WSDL_LOCATION = url;
        SERVICIOASIGNARMATERIA_EXCEPTION = e;
    }

    public ServicioAsignarMateria_Service() {
        super(__getWsdlLocation(), SERVICIOASIGNARMATERIA_QNAME);
    }

    public ServicioAsignarMateria_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOASIGNARMATERIA_QNAME, features);
    }

    public ServicioAsignarMateria_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOASIGNARMATERIA_QNAME);
    }

    public ServicioAsignarMateria_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOASIGNARMATERIA_QNAME, features);
    }

    public ServicioAsignarMateria_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioAsignarMateria_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioAsignarMateria
     */
    @WebEndpoint(name = "ServicioAsignarMateriaPort")
    public ServicioAsignarMateria getServicioAsignarMateriaPort() {
        return super.getPort(new QName("http://Servicios/", "ServicioAsignarMateriaPort"), ServicioAsignarMateria.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioAsignarMateria
     */
    @WebEndpoint(name = "ServicioAsignarMateriaPort")
    public ServicioAsignarMateria getServicioAsignarMateriaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Servicios/", "ServicioAsignarMateriaPort"), ServicioAsignarMateria.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOASIGNARMATERIA_EXCEPTION!= null) {
            throw SERVICIOASIGNARMATERIA_EXCEPTION;
        }
        return SERVICIOASIGNARMATERIA_WSDL_LOCATION;
    }

}