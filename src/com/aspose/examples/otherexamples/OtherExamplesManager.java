/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.examples.otherexamples;

import com.aspose.examples.examplesmodel.*;
import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponent;
import com.aspose.utils.CustomMutableTreeNode;
import com.aspose.utils.GitHelper;
import com.aspose.wizards.execution.ModalTaskImpl;
import com.aspose.wizards.execution.TasksExecutor;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * @author Adeel Ilyas
 *         <p/>
 *         Integration of Apache POI Examples / Other FrameWork Examples *
 */
public class OtherExamplesManager {
    // Factories for creating Apache POI Exampels for Aspose API

    private static ExamplesFrameWork poiFrameWork;

    public static ExamplesFrameWork getPOIFrameWork() {
        if (poiFrameWork != null) {
            return poiFrameWork;
        }

        poiFrameWork = new ExamplesFrameWork();

        poiFrameWork.setFrameworkName(AsposeConstants.APACHE_POI);

        //Defining FrameWork Lib Dependencies:
        poiFrameWork.addLibDependency(new LibDependency("dom4j-1.6.1.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/dom4j-1.6.1.jar"));
        poiFrameWork.addLibDependency(new LibDependency("poi-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("poi-ooxml-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-ooxml-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("poi-ooxml-schemas-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-ooxml-schemas-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("poi-scratchpad-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-scratchpad-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("xmlbeans-2.3.0.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/xmlbeans-2.3.0.jar"));

        poiFrameWork.addLibDependency(new LibDependency("poi-examples-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-examples-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("poi-excelant-3.11-beta1-20140306.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/poi-excelant-3.11-beta1-20140306.jar"));
        poiFrameWork.addLibDependency(new LibDependency("stax-api-1.0.1.jar", "https://raw.githubusercontent.com/asposemarketplace/Aspose_for_Apache_POI/master/lib/ApachePOI/stax-api-1.0.1.jar"));
        return poiFrameWork;
    }

    public static OtherExamples getPOIExamples(AsposeJavaComponent component) {

        OtherExamples _otherExamples = new OtherExamples();
        _otherExamples.addFrameWorkDependency(OtherExamplesManager.getPOIFrameWork());

        if (component.get_name().equals(AsposeConstants.ASPOSE_WORDS)) {
            _otherExamples.setGitExamplesRepositoryLocation("https://github.com/asposemarketplace/Aspose_Words_for_Apache_POI.git");
            _otherExamples.setExampleName(AsposeConstants.ASPOSE_WORDS_APACHE_POI);
        } else if (component.get_name().equals(AsposeConstants.ASPOSE_CELLS)) {
            _otherExamples.setGitExamplesRepositoryLocation("https://github.com/asposemarketplace/Aspose_Cells_for_Apache_POI.git");
            _otherExamples.setExampleName(AsposeConstants.ASPOSE_CELLS_APACHE_POI);
        } else if (component.get_name().equals(AsposeConstants.ASPOSE_SLIDES)) {
            _otherExamples.setGitExamplesRepositoryLocation("https://github.com/asposemarketplace/Aspose_Slides_for_Apache_POI.git");
            _otherExamples.setExampleName(AsposeConstants.ASPOSE_SLIDES_APACHE_POI);
        } else if (component.get_name().equals(AsposeConstants.ASPOSE_EMAIL)) {
            _otherExamples.setGitExamplesRepositoryLocation("https://github.com/asposemarketplace/Aspose_Email_for_Apache_POI.git");
            _otherExamples.setExampleName(AsposeConstants.ASPOSE_EMAIL_APACHE_POI);
        }

        return _otherExamples;

    }

    private static final TasksExecutor tasksExecution = new TasksExecutor("Installing examples dependencies . . .");

    public static void installExamplesDependencies(OtherExamples _otherExamples, final String projectPath, final Project project) {
        if (_otherExamples.getFrameWorkDependencies().isEmpty()) {
            return;
        }
        tasksExecution.clearTasks();
        for (final ExamplesFrameWork frameWork : _otherExamples.getFrameWorkDependencies()) {
            // checking if framework & its libs is available in aspose work directory
            if (!frameWork.getFrameWorkStatus().isFrameWorkSuccessfullyDownloaded()) {
                // Download Examples FrameWork here i.e Apache POI etc.
                frameWork.download(tasksExecution, project);
            }

            // checking if framework & its libs is available inside project
            if (!frameWork.getFrameWorkStatus().isFrameWorkAddedToProjects(projectPath)) {

                // copy Framework & Its libs from aspose work directory to projectpath
                tasksExecution.addNewTask(new ModalTaskImpl(project, "Installing framework ...") {
                    @Override
                    public void run(@NotNull ProgressIndicator p) {
                        p.setFraction(0.5);
                        frameWork.addFrameWorkLibrariesToProject(projectPath);
                        p.setFraction(1);
                    }
                });

            }
            if (!frameWork.getFrameWorkStatus().isFrameWorkAddedToProjectsClassPath(projectPath)) {
                tasksExecution.addNewTask(new ModalTaskImpl(project, "Initializing framework ...") {
                    @Override
                    public void run(@NotNull final ProgressIndicator p) {
                        ApplicationManager.getApplication().invokeLater(new Runnable() {
                            public void run() {
                                ApplicationManager.getApplication().runWriteAction(new Runnable() {
                                    public void run() {
                                        p.setFraction(0.5);
                                        frameWork.addFrameWorkInProjectClassPath(projectPath, project);

                                    }
                                });

                                p.setFraction(1);
                            }

                        });


                    }
                });
            }
        }
        if (tasksExecution.areThereTasks()) {
            tasksExecution.execute();
        }
    }

    /**
     * @param _otherExamples
     * @param component
     * @return
     */
    public static String getOtherExamplesDefinitionsPath(OtherExamples _otherExamples, AsposeJavaComponent component) {
        return getOtherExamplesLocalRepositoryPath(_otherExamples, component) + File.separator + "Examples.xml";
    }

    /**
     * @param _otherExamples
     * @param component
     * @return
     */
    public static String getOtherExamplesLocalRepositoryPath(OtherExamples _otherExamples, AsposeJavaComponent component) {
        return GitHelper.getLocalRepositoryPath(component) + File.separator + _otherExamples.getExampleName();
    }

    /**
     * @param component
     * @return
     */
    public static void updateOtherExamplesRepositories(AsposeJavaComponent component, ProgressIndicator p) throws Exception {
        if (!component.getOtherFrameworkExamples().isEmpty()) {
            for (OtherExamples _otherExample : component.getOtherFrameworkExamples()) {
                if (repositoryExists(_otherExample.getGitExamplesRepositoryLocation().replace(".git", ""))) {
                    p.setText2("Downloading " + _otherExample.getExampleName() + " examples ...");
                    GitHelper.checkAndCreateFolder(OtherExamplesManager.getOtherExamplesLocalRepositoryPath(_otherExample, component));
                    GitHelper.updateRepository(getOtherExamplesLocalRepositoryPath(_otherExample, component), _otherExample.getGitExamplesRepositoryLocation());
                }
            }
        }

    }

    public static boolean repositoryExists(String URLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);

            HttpURLConnection con
                    = (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }

    public static void addOtherExamples(CustomMutableTreeNode top, AsposeJavaComponent asposeComponent, ProgressIndicator p) throws JAXBException {
        if (!asposeComponent.getOtherFrameworkExamples().isEmpty()) {
            for (OtherExamples _otherExample : asposeComponent.getOtherFrameworkExamples()) {
                File otherExamplesDefinitionFile = new File(OtherExamplesManager.getOtherExamplesDefinitionsPath(_otherExample, asposeComponent));
                if (otherExamplesDefinitionFile.exists()) {
                    String examplesName = _otherExample.getExampleName();
                    p.setText("Populating " + examplesName + " examples ...");
                    JAXBContext jaxbContextOther = JAXBContext.newInstance(ObjectFactory.class);
                    Unmarshaller unmarshallerOther;
                    unmarshallerOther = jaxbContextOther.createUnmarshaller();
                    Data dataOther = (Data) unmarshallerOther.unmarshal(otherExamplesDefinitionFile);
                    List<Folders> rootFoldersListOther = dataOther.getFolders();
                    CustomMutableTreeNode child = new CustomMutableTreeNode(examplesName);
                    child.setExPath(examplesName + File.separator + "src");
                    parseFoldersTree(rootFoldersListOther, child);
                    top.add(child);
                }
                p.setFraction(p.getFraction() + 0.1);
            }
        }

    }

    public static void parseFoldersTree(List<Folders> rootFoldersList, CustomMutableTreeNode parentItem) {
        for (Folders folders : rootFoldersList) {
            // Get list of folder
            List<Folder> folderList = folders.getFolder();
            for (Folder folder : folderList) {
                CustomMutableTreeNode child = new CustomMutableTreeNode(folder.getTitle());
                child.setExPath(parentItem.getExPath() + File.separator + folder.getFolderName());
                parseExamples(folder.getExamples(), child);
                parseFoldersTree(folder.getFolders(), child);
                parentItem.add(child);
            }
        }
    }

    public static void parseExamples(List<Examples> examplesList, CustomMutableTreeNode parentItem) {
        for (Examples examples : examplesList) {
            List<Example> exampleList = examples.getExample();
            for (Example example : exampleList) {
                parseExample(example, parentItem);
            }
        }
    }

    //=========================================================================
    public static void parseExample(Example example, CustomMutableTreeNode parentItem) {
        CustomMutableTreeNode child = new CustomMutableTreeNode(example.getTitle());
        child.setExample(example);
        child.setExPath(parentItem.getExPath() + File.separator + example.getFolderName());
        parentItem.add(child);
    }
}
