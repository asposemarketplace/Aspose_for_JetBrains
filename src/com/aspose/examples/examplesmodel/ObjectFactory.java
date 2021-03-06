//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.22 at 09:26:46 AM PKT 
//


package com.aspose.examples.examplesmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aspose.ecplugin.examplesmodel package. 
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

    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _Url_QNAME = new QName("", "Url");
    private final static QName _Type_QNAME = new QName("", "Type");
    private final static QName _Order_QNAME = new QName("", "Order");
    private final static QName _FolderName_QNAME = new QName("", "FolderName");
    private final static QName _DisplayName_QNAME = new QName("", "DisplayName");
    private final static QName _Title_QNAME = new QName("", "Title");
    private final static QName _Path_QNAME = new QName("", "Path");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aspose.ecplugin.examplesmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputFiles }
     * 
     */
    public InputFiles createInputFiles() {
        return new InputFiles();
    }

    /**
     * Create an instance of {@link OutputFiles }
     * 
     */
    public OutputFiles createOutputFiles() {
        return new OutputFiles();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Folders }
     * 
     */
    public Folders createFolders() {
        return new Folders();
    }

    /**
     * Create an instance of {@link Example }
     * 
     */
    public Example createExample() {
        return new Example();
    }

    /**
     * Create an instance of {@link Folder }
     * 
     */
    public Folder createFolder() {
        return new Folder();
    }

    /**
     * Create an instance of {@link DataFile }
     * 
     */
    public DataFile createDataFile() {
        return new DataFile();
    }

    /**
     * Create an instance of {@link DocLink }
     * 
     */
    public DocLink createDocLink() {
        return new DocLink();
    }

    /**
     * Create an instance of {@link Examples }
     * 
     */
    public Examples createExamples() {
        return new Examples();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Url")
    public JAXBElement<String> createUrl(String value) {
        return new JAXBElement<String>(_Url_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Order")
    public JAXBElement<String> createOrder(String value) {
        return new JAXBElement<String>(_Order_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FolderName")
    public JAXBElement<String> createFolderName(String value) {
        return new JAXBElement<String>(_FolderName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DisplayName")
    public JAXBElement<String> createDisplayName(String value) {
        return new JAXBElement<String>(_DisplayName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Path")
    public JAXBElement<String> createPath(String value) {
        return new JAXBElement<String>(_Path_QNAME, String.class, null, value);
    }

}
