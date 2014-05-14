package com.aspose.utils;


import com.aspose.wizards.AsposeModuleWizardStep;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
/**
 * @author Adeel Ilyas
 */

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
