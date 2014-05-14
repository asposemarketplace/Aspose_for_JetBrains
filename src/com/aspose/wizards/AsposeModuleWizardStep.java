package com.aspose.wizards;


import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponents;
import com.aspose.utils.ModalTaskImpl;
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
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.*;
import com.intellij.util.ui.AsyncProcessIcon;
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

/**
 * @author Adeel Ilyas
 */

public class AsposeModuleWizardStep extends ModuleWizardStep {
  private static final Icon WIZARD_ICON = IconLoader.getIcon("/resources/long_banner.png");


  private Project myProjectOrNull;
  private final AsposeModuleBuilder myBuilder;
  private final WizardContext myContext;
  Timer timer;
  private JComponent myMainPanel ;
  final int interval = 100;
  int i;


  private Object myCurrentUpdaterMarker;
  private final AsyncProcessIcon myLoadingIcon = new AsyncProcessIcon.Big(getClass() + ".loading");


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
    myLoadingIcon.dispose();
    super.disposeUIResources();
  }



    void updateComponentsSelectionList()
    {
        AsposeConstants.println("2. ================ updateComponentsSelectionList ================");

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeCells().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_CELLS).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeWords().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_WORDS).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposePdf().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_PDF).set_selected(true);
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_PDF_KIT).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeSlides().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_SLIDES).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeBarCode().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_BARCODE).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeEmail().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_EMAIL).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeOCR().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_OCR).set_selected(true);
        }

        if (((AsposePanelVisualComponent) getComponent()).getjCheckBoxAsposeImaging().isSelected())
        {
            AsposeJavaComponents.list.get(AsposeConstants.ASPOSE_IMAGING).set_selected(true);
        }

    }

    //=========================================================================
    private boolean downloadComponents()
    {
        //diplayMessage("Preparing to download selected APIs", true);
       // StatusDisplayer.getDefault().setStatusText("Preparing to download selected components");
        final ModalTaskImpl modalTask = new ModalTaskImpl(myBuilder.getMyProject(),this);

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
        ((AsposePanelVisualComponent) getComponent()).clearMessage();
    }


   @Override
  public JComponent getComponent() {

       if (myMainPanel == null)
       {
           myMainPanel = new AsposePanelVisualComponent(this);
       }
    return myMainPanel;
  }

  @Override
  public boolean validate() throws ConfigurationException {
   if (getComponent() instanceof AsposePanelVisualComponent) {
       AsposePanelVisualComponent _page = (AsposePanelVisualComponent) getComponent();
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
    private void diplayMessage(final String msg, final boolean important)
    {
       ApplicationManager.getApplication().invokeAndWait(new Runnable() {
            @Override
            public void run() {
                ((AsposePanelVisualComponent) getComponent()).diplayMessage(msg, important);
            }
       }, ModalityState.defaultModalityState());


    }
    public int showMessage(String title, String message, int buttons, int icon)
    {
        int result = JOptionPane.showConfirmDialog(((AsposePanelVisualComponent) getComponent()), message, title, buttons, icon);
        return result;
    }




    public boolean downloadFileFromInternet(String urlStr, String outputFile, String name,@NotNull ProgressIndicator progressIndicator)
    {
        InputStream input;
        int bufferSize = 4096;
        String localPath = getLibaryDownloadPath();
        try
        {
            //diplayMessage("Downloading " + name, true);
            progressIndicator.setText("Downloading " + name);
           // StatusDisplayer.getDefault().setStatusText("Downloading " + name);


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