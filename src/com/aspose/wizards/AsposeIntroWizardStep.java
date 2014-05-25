
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


import com.aspose.utils.AsposeComponentsManager;
import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponents;
import com.aspose.wizards.execution.ModalTaskImpl;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.ide.wizard.CommitStepException;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.util.ui.AsyncProcessIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static com.aspose.utils.AsposeComponentsManager.*;

/**
 * @author Adeel Ilyas
 */

public class AsposeIntroWizardStep extends ModuleWizardStep implements Disposable{
  private static final Icon WIZARD_ICON = IconLoader.getIcon("/resources/long_bannerIntelliJ.png");

    @Override
    public void dispose() {
    }

  private final AsposeModuleBuilder myBuilder;
  private JLabel jLabelAsposeIntro;
  private JComponent myMainPanel ;


  public AsposeIntroWizardStep(AsposeModuleBuilder builder) {
    myBuilder = builder;

   }


  @Override
  public JComponent getPreferredFocusedComponent() {
    return myMainPanel;
  }



  @Override
  public void onWizardFinished() throws CommitStepException {

  }





   @Override
  public JComponent getComponent() {

       if (myMainPanel == null)
       {
           myMainPanel = new JPanel();
           {
               ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
               myMainPanel.setBorder(new TitledBorder(bundle.getString("AsposePanelVisualComponent.myMainPanel.border.title")));
               myMainPanel.setPreferredSize(new Dimension(333, 364));


               jLabelAsposeIntro = new JLabel();
               jLabelAsposeIntro.setText(bundle.getString("AsposePanelVisualComponent.myMainPanel.description"));
               Font labelFont = jLabelAsposeIntro.getFont();

               jLabelAsposeIntro.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));

               GroupLayout jPanel4Layout = new GroupLayout(myMainPanel);
               myMainPanel.setLayout(jPanel4Layout);
               jPanel4Layout.setHorizontalGroup(
                       jPanel4Layout.createParallelGroup()
                               .addGroup(jPanel4Layout.createSequentialGroup()
                                       .addComponent(jLabelAsposeIntro)
                                       .addGap(0, 0, Short.MAX_VALUE))
               );
               jPanel4Layout.setVerticalGroup(
                       jPanel4Layout.createParallelGroup()
                               .addGroup(jPanel4Layout.createSequentialGroup()
                                       .addComponent(jLabelAsposeIntro)
                                       .addContainerGap(0, Short.MAX_VALUE))
               );
           }
       }
    return myMainPanel;
  }





  @Override
  public void updateDataModel() {

  }


}