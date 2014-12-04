/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.examples.otherexamples;


import com.aspose.utils.AsposeComponentsManager;
import com.aspose.utils.GitHelper;
import com.aspose.wizards.execution.ModalTaskImpl;
import com.aspose.wizards.execution.TasksExecutor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;


/**
 * @author Adeel Ilyas
 *         <p/>
 *         Integration of Apache POI Examples / Other FrameWork Examples *
 */
public class ExamplesFrameWork {

    private String frameworkName;
    private final List<LibDependency> libDependencies = new ArrayList<LibDependency>();
    private final FrameWorkStatus frameWorkStatus = new FrameWorkStatus(this);

    /**
     * @return the framworkName
     */
    public String getFrameworkName() {
        return frameworkName;
    }

    /**
     * @param framworkName the framworkName to set
     */
    public void setFrameworkName(String framworkName) {
        this.frameworkName = framworkName;
    }

    /**
     * @param dependency to add the dependencies
     */
    public void addLibDependency(LibDependency dependency) {
        this.libDependencies.add(dependency);
    }

    /**
     * @return libDependencies
     */
    public List<LibDependency> getLibDependencies() {
        return this.libDependencies;
    }

    /**
     * remove any dependencies
     */
    public void clearLibDependencies() {
        this.libDependencies.clear();
    }

    private void downloadFrameWorkLibFromInternet(LibDependency libsDependency, ProgressIndicator p) {

        InputStream input;
        int bufferSize = 4096;
        String localPath = getExamplesFrameWorkPath();
        try {
            URL url = new URL(libsDependency.getLibDownloadLink());
            input = url.openStream();
            byte[] buffer = new byte[bufferSize];
            File f = new File(localPath + libsDependency.getLibName());
            OutputStream output = new FileOutputStream(f);
            long totalLength = AsposeComponentsManager.getFileDownloadLength(libsDependency.getLibDownloadLink());
            long pages = totalLength / bufferSize;

            int currentPage = 0;
            try {
                int bytesRead;
                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
                    p.setText("Downloading framework dependency jars...");
                    p.setText2(libsDependency.getLibName());
                    output.write(buffer, 0, bytesRead);
                    currentPage = currentPage + 1;
                    p.setFraction(currentPage / (double) pages);
                }

                output.flush();
                output.close();

            } finally {
                if (p != null) {
                    p.stop();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @param tasksExecutor,project
     */
    public void download(TasksExecutor tasksExecutor, Project project) {
        if (!getFrameWorkStatus().isFrameWorkSuccessfullyDownloaded()) {

            for (final LibDependency libDependency : getLibDependencies()) {
                GitHelper.checkAndCreateFolder(getExamplesFrameWorkPath());
                if (!isFrameworkLibAlreadyDownloaded(libDependency.getLibName())) {
                    // Then download here.
                    if (tasksExecutor == null) {
                        downloadFrameWorkLibFromInternet(libDependency, null);
                    } else {
                        tasksExecutor.addNewTask(new ModalTaskImpl(project, "Installing " + getFrameworkName() + " framework") {
                            public void run(@NotNull ProgressIndicator p) {
                                downloadFrameWorkLibFromInternet(libDependency, p);
                            }
                        });
                    }
                }

            }

        }
    }

    /**
     * @return
     */
    public String getExamplesFrameWorkPath() {
        return AsposeComponentsManager.getAsposeHomePath() + "GitSampleRepos" + File.separator + getFrameworkName() + File.separator;
    }

    /**
     * @param libFileName
     * @return
     */
    private boolean isFrameworkLibAlreadyDownloaded(String libFileName) {
        File confirmPath = new File(getExamplesFrameWorkPath() + libFileName);
        if (confirmPath.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param projectPath
     * @return
     */
    public String getExamplesFrameWorkProjectPath(String projectPath) {
        return projectPath + File.separator + "lib" + File.separator + "ExamplesFrameWorks" + File.separator + getFrameworkName();
    }


    /**
     * @param frameworkPath
     * @return
     */
    public boolean findFrameWorkInPath(String frameworkPath) {

        if (!new File(frameworkPath).exists()) {
            return false;
        }
        boolean isFrameWorkAvailableInPath = true;
        for (LibDependency libDependency : getLibDependencies()) {
            if (!new File(frameworkPath + File.separator + libDependency.getLibName()).exists()) {
                isFrameWorkAvailableInPath = false;
                break;
            }
        }
        return isFrameWorkAvailableInPath;
    }

    public void addFrameWorkInProjectClassPath(String projectPath, Project project) {
        String fullFrameworkProjectPath = getExamplesFrameWorkProjectPath(projectPath);
        if (getFrameWorkStatus().isFrameWorkAddedToProjects(projectPath) && !getFrameWorkStatus().isFrameWorkAddedToProjectsClassPath(projectPath)) {
            try {
                final LibraryTablesRegistrar libTablesRegistrar = LibraryTablesRegistrar.getInstance();

                final LibraryTable libraryTable = libTablesRegistrar.getLibraryTable(project);

                final LibraryTable.ModifiableModel libTableModel = libraryTable.getModifiableModel();


                Library library = libTableModel.createLibrary(getFrameworkName());
                libTableModel.commit();
                for (LibDependency libDependency : getLibDependencies()) {
                    String libraryName = libDependency.getLibName();
                    String libraryPath = fullFrameworkProjectPath + File.separator + libraryName;
                    libraryPath = libraryPath.replace("\\", "\\\\");
                    String jarPath = "jar://" + libraryPath + "!/";

                    final Library.ModifiableModel model = library.getModifiableModel();

                    model.addRoot(jarPath, OrderRootType.CLASSES);

                    model.commit();


                }


                Collection<Module> modules = ModuleUtil.getModulesOfType(project, StdModuleTypes.JAVA);
                Iterator itr = modules.iterator();
                Module module = null;
                while (itr.hasNext()) {
                    module = (Module) itr.next();
                    break;
                }
                final ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(module);

                final ModifiableRootModel moduleRootModel = moduleRootManager.getModifiableModel();

                final Library lib = libraryTable.getLibraryByName(getFrameworkName());

                if (moduleRootModel.findLibraryOrderEntry(lib) == null) {

                    moduleRootModel.addLibraryEntry(lib);

                }
                moduleRootModel.commit();
                getFrameWorkStatus().getFrameWorkAddedToProjectsClassPath().add(fullFrameworkProjectPath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addFrameWorkLibrariesToProject(String projectPath) {
        String fullFrameworkProjectPath = getExamplesFrameWorkProjectPath(projectPath);
        if (getFrameWorkStatus().isFrameWorkSuccessfullyDownloaded() && !getFrameWorkStatus().isFrameWorkAddedToProjects(projectPath)) {
            try {
                String sourcePath = getExamplesFrameWorkPath();
                AsposeComponentsManager.copyDirectory(sourcePath, fullFrameworkProjectPath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (findFrameWorkInPath(fullFrameworkProjectPath)) {
                getFrameWorkStatus().getFrameWorkAddedToProjects().add(fullFrameworkProjectPath);
            }
        }

    }

    /**
     * @return the frameWorkStatus
     */
    public FrameWorkStatus getFrameWorkStatus() {
        return frameWorkStatus;
    }

}
