
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
package com.aspose.wizards;


import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponents;
import com.aspose.wizards.execution.ModalTaskImpl;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.ide.wizard.CommitStepException;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.aspose.utils.AsposeComponentsManager;
import static com.aspose.utils.AsposeComponentsManager.extractFolder;
import static com.aspose.utils.AsposeComponentsManager.getLibaryDownloadPath;
import static com.aspose.utils.AsposeComponentsManager.removeExtention;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class AsposeModuleWizardStep extends ModuleWizardStep {
  private static final Icon WIZARD_ICON = IconLoader.getIcon("/resources/long_bannerIntelliJ.png");


  private Project myProjectOrNull;
  private final AsposeModuleBuilder myBuilder;
  private final WizardContext myContext;
  private JComponent myMainPanel ;



  public AsposeModuleWizardStep(@Nullable Project project, AsposeModuleBuilder builder, WizardContext context) {
    myProjectOrNull = project;
    myBuilder = builder;
    myContext = context;

   }


  @Override
  public JComponent getPreferredFocusedComponent() {
    return myMainPanel;
  }



  @Override
  public void onWizardFinished() throws CommitStepException {

      AsposeConstants.println("2. ================ performFinish ================");
      new AsposeJavaComponents();
      updateComponentsSelectionList();

      if (downloadComponents() == false)
      {
          clearMessage();
          return;
      }
  }


  @Override
  public void disposeUIResources() {
    super.disposeUIResources();
  }



    void updateComponentsSelectionList()
    {
        AsposeConstants.println("2. ================ updateComponentsSelectionList ================");
        AsposeJavaComponents.clearSelection();
        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeCells().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_CELLS).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeWords().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_WORDS).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposePdf().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_PDF).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeSlides().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_SLIDES).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeBarCode().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_BARCODE).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeTasks().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_TASKS).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeEmail().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_EMAIL).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeOCR().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_OCR).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeImaging().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_IMAGING).set_selected(true);
        }

        if (((AsposeWizardPanel) getComponent()).getjCheckBoxAsposeDiagram().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_DIAGRAM).set_selected(true);
        }

    }

    //=========================================================================
    private boolean downloadComponents()
    {
        AsposeComponentManagerCallback callback = new AsposeComponentManagerCallback(this);
        final ModalTaskImpl modalTask = new ModalTaskImpl(myBuilder.getMyProject(), callback,"Downloading Aspose API");
        ApplicationManager.getApplication().invokeAndWait(new Runnable() {
            @Override
            public void run() {
                ProgressManager.getInstance().run(modalTask);
            }
        }, ModalityState.defaultModalityState());


        if (!modalTask.isDone())
        {

            return false;
        }
        return true;
    }
    public void clearMessage()
    {
        ((AsposeWizardPanel) getComponent()).clearMessage();
    }


   @Override
  public JComponent getComponent() {

       if (myMainPanel == null)
       {
           myMainPanel = new AsposeWizardPanel(this);
       }
    return myMainPanel;
  }

  @Override
  public boolean validate() throws ConfigurationException {
   if (getComponent() instanceof AsposeWizardPanel) {
       AsposeWizardPanel _page = (AsposeWizardPanel) getComponent();
       if (!_page.isComponentSelected())
      throw new ConfigurationException(AsposeConstants.IS_COMPONENT_SELECTED);
    }

    return true;
  }

  @Override
  public void updateStep() {
  }

  @Override
  public void updateDataModel() {
   myContext.setProjectBuilder(myBuilder);

  }
  @Override
  public Icon getIcon() {
    return WIZARD_ICON;
  }

    private static class MyRenderer extends ColoredTreeCellRenderer {
    public void customizeCellRenderer(JTree tree,
                                      Object value,
                                      boolean selected,
                                      boolean expanded,
                                      boolean leaf,
                                      int row,
                                      boolean hasFocus) {
      Object userObject = ((DefaultMutableTreeNode)value).getUserObject();

    }
  }

    public int showMessage(String title, String message, int buttons, int icon)
    {
        int result = JOptionPane.showConfirmDialog(((AsposeWizardPanel) getComponent()), message, title, buttons, icon);
        return result;
    }




    public boolean downloadFileFromInternet(String urlStr, String outputFile, String name,@NotNull ProgressIndicator progressIndicator)
    {
        InputStream input;
        int bufferSize = 4096;
        String localPath = getLibaryDownloadPath();
        try
        {
            progressIndicator.setText("Downloading " + name);

            URL url = new URL(urlStr);
            input = url.openStream();
            byte[] buffer = new byte[bufferSize];
            File f = new File(localPath + outputFile);
            OutputStream output = new FileOutputStream(f);
            int bytes = 0;
            long totalLength = AsposeComponentsManager.getFileDownloadLength(urlStr);
            long pages = totalLength / bufferSize;

            int currentPage = 0;
            try
            {
                int bytesRead;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0)
                {
                    output.write(buffer, 0, bytesRead);
                    bytes = bytes + buffer.length;
                    currentPage = currentPage + 1;
                }

                output.flush();
                output.close();
                extractFolder(localPath + outputFile, localPath + removeExtention(outputFile));
            }
            finally
            {
            }
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
}