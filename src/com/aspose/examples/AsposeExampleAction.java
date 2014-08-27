package com.aspose.examples;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * Created by Adeel Ilyas on 8/20/2014.
 */
public class AsposeExampleAction extends AnAction implements DumbAware {
    public void actionPerformed(AnActionEvent e) {
        final  Project project = getEventProject(e);
        if (project == null) {
            return;
        }

        final AsposeExampleDialog dialog = new AsposeExampleDialog("Aspose Example","Aspose Examples allow you to add Aspose samples. Available samples are displayed in tree format from where you can select one. Selected sample will be added to current project including source files and required data files.",project);
        dialog.show();
    }


}
