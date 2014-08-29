
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


import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.wizard.CommitStepException;
import com.intellij.openapi.Disposable;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Adeel Ilyas
 */

public class AsposeIntroWizardStep extends ModuleWizardStep implements Disposable{

    @Override
    public void dispose() {
    }

  private JLabel jLabelAsposeIntro;
  private JComponent myMainPanel ;

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
               myMainPanel.setBorder(new TitledBorder(bundle.getString("AsposeWizardPanel.myMainPanel.border.title")));
               myMainPanel.setPreferredSize(new Dimension(333, 364));


               jLabelAsposeIntro = new JLabel();
               jLabelAsposeIntro.setText(bundle.getString("AsposeWizardPanel.myMainPanel.description"));
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