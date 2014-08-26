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

package com.aspose.examples;

import com.aspose.examples.examplesmodel.Example;
import com.aspose.utils.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AsposeExampleDialog extends DialogWrapper {
  private static final Logger LOG = Logger.getInstance("#com.aspose.examples.AsposeExampleDialog");

  private final String myDescription;
    private AsposeExamplePanel component;
    private Project project;

  public AsposeExampleDialog(final String title, String description, Project project) {
    super(false);
    myDescription = description;
    this.project = project;
    setTitle(title);
    init();
    setOKButtonText("Create");
    setOKActionEnabled(false);
  }

  public void updateControls(boolean selection) {
    setOKActionEnabled(selection);
  }

  @Override
  protected void doOKAction() {
    super.doOKAction();
    createExample();
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
      AsposeConstants.println("AsposeExamplePanel getComponent(): is called ...");
      if (component == null)
      {
          component = new AsposeExamplePanel(this, project);
      }

    return component.getComponentSelection();
  }

  @Override
  protected JComponent createCenterPanel() {
      AsposeConstants.println("AsposeExamplePanel getComponent(): is called ...");
      if (component == null)
      {
          component = new AsposeExamplePanel(this, project);
      }
      return component;
  }

  @Override
  protected String getDimensionServiceKey() {
    return "#com.aspose.examples.AsposeExampleDialog";
  }

    //=========================================================================


    //=========================================================================
    private boolean createExample()
    {
        String projectPath = component.getSelectedProjectRootPath();
        CustomMutableTreeNode comp = getSelectedNode();
        if (comp == null)
        {
            return false;
        }
        try
        {
            String path = comp.getExPath();
            Example ex = comp.getExample();
            AsposeJavaComponent asposeComponent = AsposeJavaComponents.list.get(component.getComponentSelection().getSelectedItem());
            copyExample(GitHelper.getLocalRepositoryPath(asposeComponent) + File.separator + path, projectPath + File.separator + path);
            if (ex == null)
            {
                return false;
            }

        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }

    //=========================================================================
    private CustomMutableTreeNode getSelectedNode()
    {
        return (CustomMutableTreeNode) component.getExamplesTree().getLastSelectedPathComponent();
    }

    //=========================================================================
    private void copyExample(String sourcePath, String destinationPath)
    {
        try
        {
            AsposeComponentsManager.copyDirectory(sourcePath, destinationPath);
        }
        catch (IOException ex)
        {
         //   Exceptions.printStackTrace(ex);
        }
    }
}
