//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.22 at 09:26:46 AM PKT 
//


package com.aspose.examples.examplesmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Folders" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Examples" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "folders",
    "examples"
})
@XmlRootElement(name = "Data")
public class Data {

    @XmlElement(name = "Folders")
    protected List<Folders> folders;
    @XmlElement(name = "Examples")
    protected List<Examples> examples;

    /**
     * Gets the value of the folders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the folders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFolders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Folders }
     * 
     * 
     */
    public List<Folders> getFolders() {
        if (folders == null) {
            folders = new ArrayList<Folders>();
        }
        return this.folders;
    }

    /**
     * Gets the value of the examples property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the examples property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExamples().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Examples }
     * 
     * 
     */
    public List<Examples> getExamples() {
        if (examples == null) {
            examples = new ArrayList<Examples>();
        }
        return this.examples;
    }

}
