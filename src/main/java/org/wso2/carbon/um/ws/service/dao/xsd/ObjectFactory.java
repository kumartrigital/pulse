
package org.wso2.carbon.um.ws.service.dao.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.carbon.um.ws.service.dao.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClaimDTOClaimUri_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "claimUri");
    private final static QName _ClaimDTODescription_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "description");
    private final static QName _ClaimDTODialectURI_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "dialectURI");
    private final static QName _ClaimDTODisplayTag_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "displayTag");
    private final static QName _ClaimDTORegEx_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "regEx");
    private final static QName _ClaimDTOValue_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "value");
    private final static QName _PermissionDTOAction_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "action");
    private final static QName _PermissionDTOResourceId_QNAME = new QName("http://dao.service.ws.um.carbon.wso2.org/xsd", "resourceId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.carbon.um.ws.service.dao.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PermissionDTO }
     * 
     */
    public PermissionDTO createPermissionDTO() {
        return new PermissionDTO();
    }

    /**
     * Create an instance of {@link ClaimDTO }
     * 
     */
    public ClaimDTO createClaimDTO() {
        return new ClaimDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "claimUri", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTOClaimUri(String value) {
        return new JAXBElement<String>(_ClaimDTOClaimUri_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "description", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTODescription(String value) {
        return new JAXBElement<String>(_ClaimDTODescription_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "dialectURI", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTODialectURI(String value) {
        return new JAXBElement<String>(_ClaimDTODialectURI_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "displayTag", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTODisplayTag(String value) {
        return new JAXBElement<String>(_ClaimDTODisplayTag_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "regEx", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTORegEx(String value) {
        return new JAXBElement<String>(_ClaimDTORegEx_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "value", scope = ClaimDTO.class)
    public JAXBElement<String> createClaimDTOValue(String value) {
        return new JAXBElement<String>(_ClaimDTOValue_QNAME, String.class, ClaimDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "action", scope = PermissionDTO.class)
    public JAXBElement<String> createPermissionDTOAction(String value) {
        return new JAXBElement<String>(_PermissionDTOAction_QNAME, String.class, PermissionDTO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dao.service.ws.um.carbon.wso2.org/xsd", name = "resourceId", scope = PermissionDTO.class)
    public JAXBElement<String> createPermissionDTOResourceId(String value) {
        return new JAXBElement<String>(_PermissionDTOResourceId_QNAME, String.class, PermissionDTO.class, value);
    }

}
