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

import java.util.HashMap;
import java.util.Map;

public class AsposeJavaComponents {

    public static Map<String, AsposeJavaComponent> list = new HashMap<String, AsposeJavaComponent>();

       static {
            //ASPOSE_CELLS
            AsposeJavaComponent asposeCells = new AsposeJavaComponent();
            asposeCells.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.cells.aspx");
            asposeCells.set_downloadFileName("aspose-cells.zip");
            asposeCells.set_name(AsposeConstants.ASPOSE_CELLS);
            asposeCells.set_remoteExamplesRepository("https://github.com/asposecells/Aspose_Cells_Java.git");
            list.put(AsposeConstants.ASPOSE_CELLS, asposeCells);

            //ASPOSE_WORDS
            AsposeJavaComponent asposeWords = new AsposeJavaComponent();
            asposeWords.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.words.aspx");
            asposeWords.set_downloadFileName("aspose-words.zip");
            asposeWords.set_name(AsposeConstants.ASPOSE_WORDS);
            asposeWords.set_remoteExamplesRepository("https://github.com/asposewords/Aspose_Words_Java.git");
            list.put(AsposeConstants.ASPOSE_WORDS, asposeWords);

            //ASPOSE_PDF
            AsposeJavaComponent asposePDF = new AsposeJavaComponent();
            asposePDF.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.pdf.aspx");
            asposePDF.get_downloadFileName();
            asposePDF.set_name(AsposeConstants.ASPOSE_PDF);
            asposePDF.set_remoteExamplesRepository("https://github.com/asposepdf/Aspose_Pdf_Java.git");
            list.put(AsposeConstants.ASPOSE_PDF, asposePDF);

            //ASPOSE_Slides
            AsposeJavaComponent asposeSlides = new AsposeJavaComponent();
            asposeSlides.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.slides.aspx");
            asposeSlides.get_downloadFileName();
            asposeSlides.set_name(AsposeConstants.ASPOSE_SLIDES);
            asposeSlides.set_remoteExamplesRepository("https://github.com/asposeslides/Aspose_Slides_Java.git");
            list.put(AsposeConstants.ASPOSE_SLIDES, asposeSlides);

            //ASPOSE_PDF KIT
            AsposeJavaComponent asposePDFKit = new AsposeJavaComponent();
            asposePDFKit.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.pdf.kit.aspx");
            asposePDFKit.get_downloadFileName();
            asposePDFKit.set_name(AsposeConstants.ASPOSE_PDF_KIT);
            list.put(AsposeConstants.ASPOSE_PDF_KIT, asposePDFKit);

            //ASPOSE_BarCode
            AsposeJavaComponent asposeBarcode = new AsposeJavaComponent();
            asposeBarcode.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.barcode.aspx");
            asposeBarcode.get_downloadFileName();
            asposeBarcode.set_name(AsposeConstants.ASPOSE_BARCODE);
            asposeBarcode.set_remoteExamplesRepository("https://github.com/asposebarcode/Aspose_BarCode_Java.git");
            list.put(AsposeConstants.ASPOSE_BARCODE, asposeBarcode);


           //ASPOSE_Tasks
           AsposeJavaComponent asposeTasks = new AsposeJavaComponent();
           asposeTasks.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.tasks.aspx");
           asposeTasks.get_downloadFileName();
           asposeTasks.set_name(AsposeConstants.ASPOSE_TASKS);
           asposeTasks.set_remoteExamplesRepository("https://github.com/asposetasks/Aspose_Tasks_Java.git");
           list.put(AsposeConstants.ASPOSE_TASKS, asposeTasks);

            //ASPOSE_MetaFiles
            AsposeJavaComponent asposeMetafiles = new AsposeJavaComponent();
            asposeMetafiles.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.metafiles.aspx");
            asposeMetafiles.get_downloadFileName();
            asposeMetafiles.set_name(AsposeConstants.ASPOSE_METAFILES);
            list.put(AsposeConstants.ASPOSE_METAFILES, asposeMetafiles);

            //ASPOSE_Email
            AsposeJavaComponent asposeEmail = new AsposeJavaComponent();
            asposeEmail.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.email.aspx");
            asposeEmail.get_downloadFileName();
            asposeEmail.set_name(AsposeConstants.ASPOSE_EMAIL);
            asposeEmail.set_remoteExamplesRepository("https://github.com/asposeemail/Aspose_Email_Java.git");
            list.put(AsposeConstants.ASPOSE_EMAIL, asposeEmail);

            //ASPOSE_OCR
            AsposeJavaComponent asposeOCR = new AsposeJavaComponent();
            asposeOCR.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.ocr.aspx");
            asposeOCR.get_downloadFileName();
            asposeOCR.set_name(AsposeConstants.ASPOSE_OCR);
            list.put(AsposeConstants.ASPOSE_OCR, asposeOCR);

            //ASPOSE_Imaging
            AsposeJavaComponent asposeImaging = new AsposeJavaComponent();
            asposeImaging.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.imaging.aspx");
            asposeImaging.set_downloadFileName("");
            asposeImaging.set_name(AsposeConstants.ASPOSE_IMAGING);
            asposeImaging.set_remoteExamplesRepository("https://github.com/asposeimaging/Aspose_Imaging_Java.git");
            list.put(AsposeConstants.ASPOSE_IMAGING, asposeImaging);

           //ASPOSE_Diagram
           AsposeJavaComponent asposeDiagram = new AsposeJavaComponent();
           asposeDiagram.set_downloadUrl("http://community.aspose.com/community/secureservices/asposedownloads/java/aspose.diagram.aspx");
           asposeDiagram.set_downloadFileName("");
           asposeDiagram.set_name(AsposeConstants.ASPOSE_DIAGRAM);
           asposeDiagram.set_remoteExamplesRepository("https://github.com/asposediagram/Aspose_Diagram_Java.git");
           list.put(AsposeConstants.ASPOSE_DIAGRAM, asposeDiagram);


       }
}