/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class AsposeJavaComponents {

    public static Map<String, AsposeJavaComponent> list = new HashMap<String, AsposeJavaComponent>();

    public AsposeJavaComponents() {
        list.clear();
        //if(!compInitialized)
        {
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

            //compInitialized = true;
        }
    }
}