/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.utils;

import com.aspose.examples.examplesmodel.Example;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Administrator
 */
public final class CustomMutableTreeNode extends DefaultMutableTreeNode{
    private Example _Example;
    private String _ExPath;

    public void setTopTreeNodeText(String data) {
        this.userObject = data;
    }
    public CustomMutableTreeNode(String data)
    {
      this.userObject = data;  
    }
    
    /**
     * @return the _Example
     */
    public Example getExample() {
        return _Example;
    }

    /**
     * @param Example the _Example to set
     */
    public void setExample(Example Example) {
        this._Example = Example;
    }

    /**
     * @return the _ExPath
     */
    public String getExPath() {
        return _ExPath;
    }

    /**
     * @param ExPath the _ExPath to set
     */
    public void setExPath(String ExPath) {
        this._ExPath = ExPath;
    }
    
}
