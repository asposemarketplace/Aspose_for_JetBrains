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
package com.aspose.wizards.execution;

import com.aspose.utils.AsposeComponentsManager;
import com.aspose.wizards.AsposeModuleWizardStep;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModalTaskImpl extends Task.Modal {
    private boolean done = false;
    AsposeModuleWizardStep page;
    public ModalTaskImpl(@Nullable Project project,AsposeModuleWizardStep page) {
        super(project, "Downloading Aspose API", true);
        this.page = page;
    }

    @Override
    public void run(@NotNull ProgressIndicator progressIndicator) {
           progressIndicator.setIndeterminate(true);
           progressIndicator.setText("Preparing to download selected APIs");
           AsposeComponentsManager comManager = new AsposeComponentsManager(
                   page);

           done = comManager.downloadComponents(progressIndicator);
    }

    @Override
    public void onSuccess() {
        super.onSuccess();
        done=true;
    }

    @Override
    public void onCancel() {
        super.onCancel();
        done=false;
   }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
