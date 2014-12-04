/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.examples.otherexamples;

import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adeel Ilyas
 *
 *  Integration of Apache POI Examples / Other FrameWork Examples *
 */
public class OtherExamples {
   
    private final List<ExamplesFrameWork> frameWorkDependencies=new ArrayList<ExamplesFrameWork>();
    private String gitExamplesRepositoryLocation;
    private String exampleName;
   

    /**
     * @return the gitExamplesRepositoryLocation
     */
    public String getGitExamplesRepositoryLocation() {
        return gitExamplesRepositoryLocation;
    }

    /**
     * @param gitExamplesRepositoryLocation the gitExamplesRepositoryLocation to set
     */
    public void setGitExamplesRepositoryLocation(String gitExamplesRepositoryLocation) {
        this.gitExamplesRepositoryLocation = gitExamplesRepositoryLocation;
    }
    
    /**
     * clear framework dependencies if any
     */
    public void  clearFrameWorkDependency() {
        this.frameWorkDependencies.clear();
    }

    /**
     * @param frameWork the frameWork to add
     */
    public void addFrameWorkDependency(ExamplesFrameWork frameWork) {
        this.frameWorkDependencies.add(frameWork);
    }
    
     /**
     * @return frameWorkDependencies
     */
    public List<ExamplesFrameWork> getFrameWorkDependencies() {
        return this.frameWorkDependencies;
    }

    /**
     * @return the exampleName
     */
    public String getExampleName() {
        return exampleName;
    }

    /**
     * @param exampleName the exampleName to set
     */
    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }
}
