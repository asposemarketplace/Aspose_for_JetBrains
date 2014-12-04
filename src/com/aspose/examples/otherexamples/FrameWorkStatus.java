/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.examples.otherexamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adeel Ilyas
 *
 *  Integration of Apache POI Examples / Other FrameWork Examples *
 */
public class FrameWorkStatus {

    private Boolean frameWorkSuccessfullyDownloaded = false;
    private final List<String> frameWorkAddedToProjects = new ArrayList<String>();
    private final List<String> frameWorkAddedToProjectsClassPath = new ArrayList<String>();
    private final ExamplesFrameWork frameWork;

    public FrameWorkStatus(ExamplesFrameWork frameWork) {
        this.frameWork = frameWork;
    }

    /**
     * @return the frameWorkSuccessfullyDownloaded
     */
    private Boolean getFrameWorkSuccessfullyDownloaded() {
        return frameWorkSuccessfullyDownloaded;
    }

    /**
     * @return the frameWorkSuccessfullyDownloaded
     */
    public Boolean isFrameWorkSuccessfullyDownloaded() {

        if (!getFrameWorkSuccessfullyDownloaded()) {
            String asposeExamplesFrameWorkPath=frameWork.getExamplesFrameWorkPath();
            setFrameWorkSuccessfullyDownloaded(frameWork.findFrameWorkInPath(asposeExamplesFrameWorkPath.substring(0, asposeExamplesFrameWorkPath.length()-1)));
            return getFrameWorkSuccessfullyDownloaded();
        } else {
            return Boolean.TRUE;
        }

    }

    /**
     * @param frameWorkSuccessfullyDownloaded the
     * frameWorkSuccessfullyDownloaded to set
     */
    private void setFrameWorkSuccessfullyDownloaded(Boolean frameWorkSuccessfullyDownloaded) {
        this.frameWorkSuccessfullyDownloaded = frameWorkSuccessfullyDownloaded;
    }

    /**
     * @return the frameWorkAddedToProjects
     */
    public List<String> getFrameWorkAddedToProjects() {
        return frameWorkAddedToProjects;
    }

    /**
     * @return
     */
    public Boolean isFrameWorkAddedToProjects(String projectPath) {
        String fullFrameworkProjectPath = frameWork.getExamplesFrameWorkProjectPath(projectPath);
        if (!getFrameWorkAddedToProjects().contains(fullFrameworkProjectPath)) {

            if (frameWork.findFrameWorkInPath(fullFrameworkProjectPath)) {
                getFrameWorkAddedToProjects().add(fullFrameworkProjectPath);
            }
        }
        return getFrameWorkAddedToProjects().contains(fullFrameworkProjectPath);

    }

     /**
     * @return the frameWorkAddedToProjectsClassPath
     */
    public List<String> getFrameWorkAddedToProjectsClassPath() {
        return frameWorkAddedToProjectsClassPath;
    }

    /**
     * @return
     */
    public Boolean isFrameWorkAddedToProjectsClassPath(String projectPath) {
        return getFrameWorkAddedToProjectsClassPath().contains(frameWork.getExamplesFrameWorkProjectPath(projectPath));
    }

}
