/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.examples.otherexamples;

/**
 *
 * @author Adeel Ilyas
 *
 *  Integration of Apache POI Examples / Other FrameWork Examples *
 */
public class LibDependency {
    private String libName;
    private String libDownloadLink;

    public LibDependency(String libName,String libDownloadLink) {
        if (libName==null || libDownloadLink ==null) {
            throw new RuntimeException("Cannot create Lib Dependency! You need to provide LibName &  Libray Download link");
        }
        this.libName=libName;
        this.libDownloadLink=libDownloadLink;
     }
    /**
     * @return the libName
     */
    public String getLibName() {
        return libName;
    }

    /**
     * @param libName the libName to set
     */
    public void setLibName(String libName) {
        this.libName = libName;
    }

    /**
     * @return the libDownloadLink
     */
    public String getLibDownloadLink() {
        return libDownloadLink;
    }

    /**
     * @param libDownloadLink the libDownloadLink to set
     */
    public void setLibDownloadLink(String libDownloadLink) {
        this.libDownloadLink = libDownloadLink;
    }
}
