
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
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupManager;

public class RunnableHelper

{
    public static void runWhenInitialized(final Project project, final Runnable r) {
        if (project.isDisposed()) return;

        if (!project.isInitialized()) {
            StartupManager.getInstance(project).registerStartupActivity(new RunnableHelper.WriteAction(r));
            return;
        }

        RunnableHelper.runWriteCommand(project,r);

    }
    public static void runReadCommand(Project project, Runnable cmd)

    {

        CommandProcessor.getInstance().executeCommand(project, new ReadAction(cmd), "Aspose", "Components");

    }



    public static void runWriteCommand(Project project, Runnable cmd)

    {

        CommandProcessor.getInstance().executeCommand(project, new WriteAction(cmd), "Aspose", "Components");

    }



    public static class ReadAction implements Runnable

    {

      public  ReadAction(Runnable cmd)

        {

            this.cmd = cmd;

        }



        public void run()

        {

            ApplicationManager.getApplication().runReadAction(cmd);

        }



        Runnable cmd;

    }



    public static class WriteAction implements Runnable

    {

       public WriteAction(Runnable cmd)

        {

            this.cmd = cmd;

        }

 

        public void run()

        {
            ApplicationManager.getApplication().invokeLater(new Runnable() {
                public void run() {
                    ApplicationManager.getApplication().runWriteAction(cmd);
                }
            });
        }

 

        Runnable cmd;

    }

 

    private RunnableHelper() {}

}