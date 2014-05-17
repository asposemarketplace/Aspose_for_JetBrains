/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.utils;
/*
 * Copyright (c) 2001-2013 Aspose Pty Ltd. All Rights Reserved.

 */
import com.aspose.componentsdownload.ObjectFactoryComponents;
import com.aspose.componentsdownload.ProductRelease;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import com.aspose.wizards.AsposeModuleWizardStep;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class AsposeComponentsManager {

    AsposeModuleWizardStep _pageOne = null;

    public AsposeComponentsManager(AsposeModuleWizardStep page) {
        _pageOne = page;
    }

    /**
     *
     * @return
     */
    public boolean downloadComponents(@NotNull ProgressIndicator progressIndicator) {
        if (!isIneternetConnected()) {
           _pageOne.showMessage(AsposeConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE_TITLE, AsposeConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE, JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            return false;
        }

        for (AsposeJavaComponent component : AsposeJavaComponents.list.values()) {
            progressIndicator.checkCanceled();
            if (component.is_selected()) {

                ProductRelease productRelease = getProductReleaseInfo(component.get_downloadUrl());
                if (productRelease == null) {
                    continue;
                }
                component.set_downloadUrl(productRelease.getDownloadLink());
                component.set_downloadFileName(productRelease.getFileName());
                component.set_changeLog(productRelease.getChangeLog());
                component.set_latestVersion(productRelease.getVersionNumber());
                
                if (libraryAlreadyExists(component.get_downloadFileName())) 
                {
                    component.set_currentVersion(readVersion(component));
                    if (readVersion(component).equals(component.get_latestVersion())) 
                    {
                        component.set_downloaded(true);
                    }
                    else 
                    {
                        storeReleaseNotes(component);
                        String htmlFilePath = getLibaryDownloadPath() + component.get_name() + ".htm"; // path to your new file
                        File htmlFile = new File(htmlFilePath);

                        // open the default web browser for the HTML page
                        try {
                            Desktop.getDesktop().browse(htmlFile.toURI());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            Desktop.getDesktop().open(htmlFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (_pageOne.showMessage(component.get_name() + " - " + AsposeConstants.NEW_VERSION_MESSAGE_TITLE, AsposeConstants.NEW_VERSION_MESSAGE + "\nLatest Version: " + component.get_latestVersion() + "\nCurrent Version: " + component.get_currentVersion(), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                            if (_pageOne.downloadFileFromInternet(component.get_downloadUrl(), component.get_downloadFileName(), component.get_name(),progressIndicator)) {
                                component.set_downloaded(true);
                                storeVersion(component);
                            }
                        } else {
                            component.set_downloaded(true);
                        }
                    }
                } else {
                    if (_pageOne.downloadFileFromInternet(component.get_downloadUrl(), component.get_downloadFileName(), component.get_name(),progressIndicator)) {
                        component.set_downloaded(true);
                        storeVersion(component);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     *
     * @param component
     * @return
     */
    public String readVersion(AsposeJavaComponent component) {
        String localPath = getLibaryDownloadPath() + component.get_name() + ".ver";
        BufferedReader reader;
        String line = null;

        try {
            reader = new BufferedReader(new FileReader(localPath));
            line = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    /**
     *
     * @param component
     */
    public void storeReleaseNotes(AsposeJavaComponent component) {
        String localPath = getLibaryDownloadPath() + component.get_name() + ".htm";
        PrintWriter writer;
        try {
            writer = new PrintWriter(localPath, "UTF-8");
            writer.println(component.get_changeLog());
            writer.close();
        } catch (FileNotFoundException e) {
            //writer.close();
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            //writer.close();
            e.printStackTrace();
        }

    }

    /**
     *
     * @param component
     */
    public void storeVersion(AsposeJavaComponent component) {
        String localPath = getLibaryDownloadPath() + component.get_name() + ".ver";
        PrintWriter writer;
        try {
            writer = new PrintWriter(localPath, "UTF-8");
            writer.println(component.get_latestVersion());
            writer.close();
        } catch (FileNotFoundException e) {
            //writer.close();
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            //writer.close();
            e.printStackTrace();
        }

    }

    public String readURLContents(String Url) throws MalformedURLException, IOException {
        URL url = new URL(Url);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        String body = new String(baos.toByteArray(), encoding);
        return body;
    }

    /**
     *
     * @param productUrl
     * @return
     */
    public ProductRelease getProductReleaseInfo(String productUrl) {

        ProductRelease data = null;
        try {
            String productInfo;
            productInfo = readURLContents(productUrl);
            productInfo = productInfo.substring(40);
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactoryComponents.class);
            Unmarshaller unmarshaller;
            unmarshaller = jaxbContext.createUnmarshaller();
            data = (ProductRelease) unmarshaller.unmarshal(new StreamSource(new StringReader(productInfo.toString())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return data;
    }

    /**
     *
     * @param libFileName
     * @return
     */
    public static boolean libraryAlreadyExists(String libFileName) {
        File confirmPath = new File(getLibaryDownloadPath() + libFileName);
        if (confirmPath.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void copyDirectory(String sourceLocation, String targetLocation) throws IOException {

       // GitHelper.checkAndCreateFolder(targetLocation);
        copyDirectory(new File(sourceLocation + File.separator), new File(targetLocation + File.separator));
    }

    private static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }

    /**
     *
     * @param urlStr
     * @return
     */
    public static long getFileDownloadLength(String urlStr) {
        URL url;
        long fileLenth = 0;
        try {
            url = new URL(urlStr);

            URLConnection connection = url.openConnection();
            connection.connect();

            fileLenth = connection.getContentLength();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLenth;
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static String removeExtention(String filePath) {
        File f = new File(filePath);
        if (f.isDirectory()) {
            return filePath;
        }
        String name = f.getName();
        final int lastPeriodPos = name.lastIndexOf('.');
        if (lastPeriodPos <= 0) {
            return filePath;
        } else {
            File renamed = new File(f.getParent(), name.substring(0, lastPeriodPos));
            return renamed.getPath();
        }
    }

    /**
     *
     * @return
     */
    public static boolean isIneternetConnected() {
        try {
            InetAddress address = InetAddress.getByName(AsposeConstants.INTERNTE_CONNNECTIVITY_PING_URL);
            if (address == null) {
                return false;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @return
     */
    public static String getLibaryDownloadPath() {
        String path = "";
        path = System.getProperty("user.home");
        path = path + File.separator +"aspose"+File.separator+"intellijplugin"+File.separator;
        File confirmPath = new File(path);
        if (!confirmPath.exists()) {
            new File(path).mkdirs();
        }
        return path;
    }

    public static String getAsposeHomePath() {
        String path = "";
        path = System.getProperty("user.home");
        path = path + "/aspose/";
        return path;
    }

    /**
     *
     * @param zipFile
     * @param outputFolder
     */
    public void unZipFile(String zipFile, String outputFolder) {

        byte[] buffer = new byte[1024];

        try {
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }
            ZipInputStream zis =
                    new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);
                AsposeConstants.println("file unzip : " + newFile.getAbsoluteFile());
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

            AsposeConstants.println("Done");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param zipFile
     * @param newPath
     * @throws java.util.zip.ZipException
     * @throws java.io.IOException
     */
    static public void extractFolder(String zipFile, String newPath) throws ZipException, IOException {
        AsposeConstants.println(zipFile);
        int BUFFER = 2048;
        File file = new File(zipFile);

        ZipFile zip = new ZipFile(file);
        File dir = new File(newPath);

        if (dir.exists()) {
             for(File _file: dir.listFiles()) _file.delete();
        } else {
            dir.mkdir();
        }
        @SuppressWarnings("rawtypes")
        Enumeration zipFileEntries = zip.entries();
        while (zipFileEntries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            String currentEntry = entry.getName();
            File destFile = new File(newPath, currentEntry);
            File destinationParent = destFile.getParentFile();
            destinationParent.mkdirs();

            if (!entry.isDirectory()) {
                BufferedInputStream is = new BufferedInputStream(zip
                        .getInputStream(entry));
                int currentByte;
                byte data[] = new byte[BUFFER];

                FileOutputStream fos = new FileOutputStream(destFile);
                BufferedOutputStream dest = new BufferedOutputStream(fos,
                        BUFFER);
                while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, currentByte);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        }
    }
}
