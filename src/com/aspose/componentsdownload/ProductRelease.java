/**
* Copyright (c) Aspose 2002-2014. All Rights Reserved.
*
* LICENSE: This program is free software; you can redistribute it 
* and/or modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 3
* of the License, or (at your option) any later version.
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
* You should have received a copy of the GNU General Public License
* along with this program. If not, 
* see http://opensource.org/licenses/gpl-3.0.html
*
* @author Adeel Ilyas <adeel.ilyas@aspose.com>
*  
*/


package com.aspose.componentsdownload;

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
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChangeLog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DownloadLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "fileName",
    "versionNumber",
    "changeLog",
    "downloadLink"
})
@XmlRootElement(name = "ProductRelease")
public class ProductRelease {

    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "VersionNumber", required = true)
    protected String versionNumber;
    @XmlElement(name = "ChangeLog", required = true)
    protected String changeLog;
    @XmlElement(name = "DownloadLink", required = true)
    protected String downloadLink;

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionNumber(String value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the changeLog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeLog() {
        return changeLog;
    }

    /**
     * Sets the value of the changeLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeLog(String value) {
        this.changeLog = value;
    }

    /**
     * Gets the value of the downloadLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadLink() {
        return downloadLink;
    }

    /**
     * Sets the value of the downloadLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadLink(String value) {
        this.downloadLink = value;
    }

}
