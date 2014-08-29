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
package com.aspose.examples;

import com.aspose.examples.examplesmodel.*;

import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.aspose.utils.*;
import com.aspose.wizards.execution.ModalTaskImpl;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;

/**
 * @author Adeel Ilyas
 */
public final class AsposeExamplePanel extends JPanel
{
    Project selectedProject;
    boolean examplesNotAvailable;

    public boolean isExamplesDefinitionAvailable() {
        return examplesDefinitionAvailable;
    }

    boolean examplesDefinitionAvailable;
    AsposeExampleDialog dialog;
    /**
     * Creates new form AsposeExamplePanel
     */
    public AsposeExamplePanel(AsposeExampleDialog dialog, Project selectedProject)
    {
        AsposeConstants.println("AsposeExamplePanel is called ...");
        this.selectedProject = selectedProject;
        initComponents();
        initComponentsUser();
        this.dialog = dialog;

    }

    private void initComponentsUser()
    {
        examplesNotAvailable = false;
        examplesDefinitionAvailable = false;
        getComponentSelection().removeAllItems();
        getComponentSelection().addItem("Select API");
        read();
        CustomMutableTreeNode top = new CustomMutableTreeNode("");
        DefaultTreeModel model = (DefaultTreeModel) getExamplesTree().getModel();
        model.setRoot(top);
        model.reload(top);

        validateDialog();
    }

    @Override
    public String getName()
    {
        return "Aspose Java API and Example";
    }

    private void initComponents()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        componentSelection = new ComboBox();

        jLabel1 = new JLabel();
        jLabelMessage = new JLabel();
        jLabelMessage.setOpaque(true);
        jScrollPane1 = new JBScrollPane();

        examplesTree = new Tree();

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new Color(255, 255, 255));

        jLabel2.setIcon(icon); // NOI18N
        jLabel2.setText(bundle.getString("AsposeExamplePanel.jLabel2.text"));


        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setDoubleBuffered(true);
        jLabel2.setOpaque(true);
        jLabel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabel2ComponentResized(evt);
            }
        });


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        componentSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        componentSelection.setSelectedIndex(-1);
        componentSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componentSelectionActionPerformed(evt);
            }
        });
        componentSelection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                componentSelection_Propertychanged(evt);
            }
        });
        jLabel1.setText(bundle.getString("AsposeExamplePanel.jLabel1.text"));
        jLabelMessage.setText(bundle.getString("AsposeExamplePanel.jLabelMessage.text"));
        examplesTree.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                examplesTree_clicked(evt);
            }
        });
        jScrollPane1.setViewportView(examplesTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(componentSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(componentSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1,javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    //=========================================================================
    private void jLabel2ComponentResized(java.awt.event.ComponentEvent evt) {
        int labelwidth = jLabel2.getWidth();
        int labelheight = jLabel2.getHeight();
        Image img = icon.getImage();
        jLabel2.setIcon( new ImageIcon(img.getScaledInstance(labelwidth,labelheight ,Image.SCALE_FAST)));
    }
    public String getSelectedProjectRootPath()
    {
        return selectedProject.getBasePath();
    }

    //=========================================================================
    void read()
    {
        AsposeConstants.println(" === New File Visual Panel.read() === " + selectedProject.getBaseDir().getName());
        populateComponentsList();
    }

    //=========================================================================
    private boolean populateComponentsList()
    {
        File file = new File(getSelectedProjectRootPath() + File.separator + "lib");
        String[] directories = file.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return new File(dir, name).isDirectory();
            }
        });

        getComponentSelection().removeAllItems();
        getComponentSelection().addItem("Select API");
        for (String directory : directories)
        {
            if (!directory.equals("CopyLibs"))
            {
                getComponentSelection().addItem(directory);
            }
        }
        return true;
    }

    //=========================================================================
    private void componentSelectionActionPerformed(java.awt.event.ActionEvent evt)
    {
        final String item = (String) getComponentSelection().getSelectedItem();
        CustomMutableTreeNode top = new CustomMutableTreeNode("");
        DefaultTreeModel model = (DefaultTreeModel) getExamplesTree().getModel();
        model.setRoot(top);
        model.reload(top);
        if (item != null && !item.equals("Select API")) {

            AsposeExampleCallback callback = new AsposeExampleCallback(this,top);
            final ModalTaskImpl modalTask = new ModalTaskImpl(selectedProject, callback, "Please wait...");
            ProgressManager.getInstance().run(modalTask);
            top.setTopTreeNodeText(item);
            model.setRoot(top);
            model.reload(top);
            getExamplesTree().expandPath(new TreePath(top.getPath()));

            }
        validateDialog();
    }

//=========================================================================

    @Override
    public void validate()
    {
        AsposeConstants.println("AsposeExamplePanel validate called..");
    }

//=========================================================================
    public boolean validateDialog()
    {
        if (isExampleSelected())
        {
            if (dialog!=null)
            dialog.updateControls(true);
            clearMessage();
            return true;
        }
        if (getComponentSelection().getSelectedIndex() == 0)
        {
            if (dialog!=null)
            dialog.updateControls(false);
            diplayMessage("Please select API", true);
            return false;
        }
        else if (!isExampleSelected())
        {
            if (dialog!=null)
            dialog.updateControls(false);
            diplayMessage("Please select example", true);
            return false;
        }
        if (dialog!=null)
        dialog.updateControls(true);
        clearMessage();
        return true;
    }

    //=========================================================================
    private boolean isExampleSelected()
    {
        CustomMutableTreeNode comp = (CustomMutableTreeNode) getExamplesTree().getLastSelectedPathComponent();
        if (comp == null)
        {
            return false;
        }
        try
        {
            Example ex = comp.getExample();
            if (ex == null)
            {
                return false;
            }
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }

    //=========================================================================
    public void diplayMessage(String message,boolean error) {

            if (error) {
                jLabelMessage.setForeground(Color.RED);
            } else {
                jLabelMessage.setForeground(Color.GREEN);
            }
            jLabelMessage.setText(message);
    }
    //=========================================================================
    private void clearMessage()
    {
        jLabelMessage.setText("");

    }

    //=========================================================================
    public int showMessage(String title, String message, int buttons, int icon)
    {
        int result = JOptionPane.showConfirmDialog(null, message, title, buttons, icon);
        return result;
    }

    //=========================================================================
    public void checkAndUpdateRepo(AsposeJavaComponent component)
    {
        if (null == component)
        {
            return;
        }
        if (null == component.get_remoteExamplesRepository())
        {
            showMessage("Examples not available", component.get_name() + " - " + AsposeConstants.EXAMPLES_NOT_AVAILABLE_MESSAGE, JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            examplesNotAvailable = true;
            examplesDefinitionAvailable = false;
            return;
        }
        else
        {
            examplesNotAvailable = false;
        }

        if (GitHelper.isExamplesDefinitionsPresent(component))
        {
            try
            {
                GitHelper.updateRepository(component);
                examplesDefinitionAvailable = true;
            }
            catch (Exception e)
            {
            }
        }

        else
        {

                if (AsposeComponentsManager.isIneternetConnected())
                {
                    GitHelper.updateRepository(component);
                    if (GitHelper.isExamplesDefinitionsPresent(component))
                    {
                            examplesDefinitionAvailable = true;
                    }
                }
                else
                {
                    showMessage(AsposeConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE_TITLE, component.get_name() + " - " + AsposeConstants.EXAMPLES_INTERNET_CONNECTION_REQUIRED_MESSAGE, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
             }
    }

    //====================================================================
    public  void populateExamplesTree(String examplesDefinitionFile, String com,CustomMutableTreeNode top)

    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller;

            unmarshaller = jaxbContext.createUnmarshaller();

            Data data = (Data) unmarshaller.unmarshal(new File(examplesDefinitionFile));
            getExamplesTree().removeAll();
            top.setExPath("src");
            List<Folders> rootFoldersList = data.getFolders();
            parseFoldersTree(rootFoldersList, top);
            parseExamples(data.getExamples(), top);
        }
        catch (JAXBException ex)
        {
          ex.printStackTrace();
        }
    }

    //=========================================================================
    void parseFoldersTree(List<Folders> rootFoldersList, CustomMutableTreeNode parentItem)
    {
        for (Folders folders : rootFoldersList)
        {
            // Get list of folder
            List<Folder> folderList = folders.getFolder();
            for (Folder folder : folderList)
            {
                CustomMutableTreeNode child = new CustomMutableTreeNode(folder.getTitle());
                child.setExPath(parentItem.getExPath() + File.separator + folder.getFolderName());
                parseExamples(folder.getExamples(), child);
                parseFoldersTree(folder.getFolders(), child);
                parentItem.add(child);
            }
        }
    }

    //=========================================================================
    void parseExamples(List<Examples> examplesList, CustomMutableTreeNode parentItem)
    {
        for (Examples examples : examplesList)
        {
            List<Example> exampleList = examples.getExample();
            for (Example example : exampleList)
            {
                // false: do not run
                parseExample(example, parentItem);
            }
        }
    }

    //=========================================================================
    void parseExample(Example example, CustomMutableTreeNode parentItem)
    {
        CustomMutableTreeNode child = new CustomMutableTreeNode(example.getTitle());
        child.setExample(example);
        child.setExPath(parentItem.getExPath() + File.separator + example.getFolderName());
        parentItem.add(child);
    }

    //=========================================================================
    private void componentSelection_Propertychanged(java.beans.PropertyChangeEvent evt)
    {

    }
    //=========================================================================
    private void examplesTree_clicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_examplesTree_clicked
    {
        // TODO add your handling code here:
        TreePath path = getExamplesTree().getSelectionPath();

        validateDialog();
    }
    // Variables declaration
    private javax.swing.JComboBox componentSelection;
    private javax.swing.JTree examplesTree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMessage;
    private JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/resources/long_bannerIntelliJ.png"));
    // End of variables declaration

    /**
     * @return the examplesTree
     */
    public javax.swing.JTree getExamplesTree()
    {
        return examplesTree;
    }

    /**
     * @return the componentSelection
     */
    public javax.swing.JComboBox getComponentSelection()
    {
        return componentSelection;
    }
}