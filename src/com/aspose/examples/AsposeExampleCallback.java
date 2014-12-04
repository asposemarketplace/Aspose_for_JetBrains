package com.aspose.examples;

import com.aspose.utils.AsposeJavaComponent;
import com.aspose.utils.AsposeJavaComponents;
import com.aspose.utils.CustomMutableTreeNode;
import com.aspose.utils.GitHelper;
import com.aspose.wizards.execution.CallBackHandler;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Adeel Ilyas on 8/22/2014.
 */
public class AsposeExampleCallback implements CallBackHandler {

    public AsposeExamplePanel getPage() {
        return page;
    }

    private AsposeExamplePanel page;
    CustomMutableTreeNode top;
    public AsposeExampleCallback(AsposeExamplePanel page,CustomMutableTreeNode top) {
        this.page = page;
        this.top = top;
    }
    @Override
    public boolean executeTask(@NotNull ProgressIndicator progressIndicator) {
      // progressIndicator.setIndeterminate(true);
        // Set the progress bar percentage and text
        progressIndicator.setFraction(0.10);

        progressIndicator.setText("Preparing to refresh examples");

       final String item = (String) page.getComponentSelection().getSelectedItem();

               if (item != null && !item.equals("Select Java API")) {
                   ApplicationManager.getApplication().invokeAndWait(new Runnable() {
                       @Override
                       public void run() {
                           page.diplayMessage("Please wait. Preparing to refresh examples", true);
                       }
                   }, ModalityState.defaultModalityState());

                   progressIndicator.setFraction(0.20);
                   AsposeJavaComponent component = AsposeJavaComponents.list.get(item);
                   page.checkAndUpdateRepo(component,progressIndicator);
                   if (page.isExamplesDefinitionAvailable()) {
                       progressIndicator.setFraction(0.60);
                       page.populateExamplesTree(component, top,progressIndicator);
                   }
               }

        progressIndicator.setFraction(1);
    return true;
   }
}
