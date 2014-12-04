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
package com.aspose.utils;

public class AsposeConstants
{
    /**
     * AsposeConstants
     */

    //Aspose Java components
    public static final String ASPOSE_CELLS = "Aspose.Cells";
    public static final String ASPOSE_WORDS = "Aspose.Words";
    public static final String ASPOSE_PDF = "Aspose.Pdf";
    public static final String ASPOSE_SLIDES = "Aspose.Slides";
    public static final String ASPOSE_BARCODE = "Aspose.BarCode";
    public static final String ASPOSE_EMAIL = "Aspose.Email";
    public static final String ASPOSE_OCR = "Aspose.OCR";
    public static final String ASPOSE_IMAGING = "Aspose.Imaging";
    public static final String ASPOSE_DIAGRAM = "Aspose.Diagram";
    public static final String ASPOSE_TASKS = "Aspose.Tasks";

    // Added by adeel.ilyas@aspose.com - Integration of Apache POI Examples / Other FrameWork Examples
    // Apache POI Comparison Examples
    public static final String ASPOSE_WORDS_APACHE_POI = "Aspose.Words_ApachePOI.WP";
    public static final String ASPOSE_CELLS_APACHE_POI = "Aspose.Cells_ApachePO.SS";
    public static final String ASPOSE_SLIDES_APACHE_POI = "Aspose.Slides_ApachePOI.SL";
    public static final String ASPOSE_EMAIL_APACHE_POI = "Aspose.Email_ApachePOI.SM";

    // Examples FrameWork
    public static final String APACHE_POI = "APACHE_POI";
    // adeel.ilyas@aspose.com

    //Project
    public static final String LIBRARY_NAME = "AposeAPI";
    public static final String LIB_FOLDER = "lib";
    public static final String INTERNTE_CONNNECTIVITY_PING_URL = "java.sun.com";

    //Messages UI text
    public static final String IS_COMPONENT_SELECTED = "Please select at least one Aspose component to create a new project";
    public static final String INTERNET_CONNECTION_REQUIRED_MESSAGE_TITLE = "Internet connectivity";
    public static final String INTERNET_CONNECTION_REQUIRED_MESSAGE = "Internet connectivity is required to download Aspose components";
    public static final String NEW_VERSION_MESSAGE_TITLE = "New version available";
    public static final String NEW_VERSION_MESSAGE = "New version is available, do you want to download it? browser is opened with release notes";

    //New file messages
    public static final String EXAMPLES_NOT_AVAILABLE_MESSAGE = "This component does not have examples yet, We will add examples soon";
    public static final String EXAMPLES_INTERNET_CONNECTION_REQUIRED_MESSAGE = "Internet connectivity is required to download examples";
    //advertise

    private static final boolean printing_allowed = false; 
    
    public static final void println(String message)
    {
        if(printing_allowed)
        {
            System.out.println(message);
        }
    }
}
