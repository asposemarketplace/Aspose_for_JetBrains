package com.aspose.wizards;

import com.aspose.utils.AsposeComponentsManager;
import com.aspose.wizards.AsposeModuleWizardStep;
import com.aspose.wizards.execution.CallBackHandler;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Adeel Ilyas on 8/22/2014.
 */
public class AsposeComponentManagerCallback implements CallBackHandler {

   private AsposeModuleWizardStep page;
    public AsposeComponentManagerCallback(AsposeModuleWizardStep page) {
        this.page = page;
    }
    @Override
    public boolean executeTask(@NotNull ProgressIndicator progressIndicator) {

       progressIndicator.setIndeterminate(true);
       progressIndicator.setText("Preparing to download selected APIs");
       AsposeComponentsManager comManager = new AsposeComponentsManager(
               page);

       return comManager.downloadComponents(progressIndicator);
   }
}
