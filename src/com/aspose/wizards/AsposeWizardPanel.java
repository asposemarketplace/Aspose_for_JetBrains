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
package com.aspose.wizards;

import com.aspose.utils.AsposeConstants;
import com.aspose.utils.AsposeJavaComponent;
import com.aspose.utils.AsposeJavaComponents;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

public class AsposeWizardPanel extends JPanel {
    public AsposeWizardPanel() {
        initComponents();
    }
    @Override
    public String getName()
    {
        return "Aspose API";
    }
    private AsposeModuleWizardStep panel;

    public AsposeWizardPanel(AsposeModuleWizardStep panel)
    {
        initComponents();
        this.panel = panel;
    }
    private void jCheckBoxSelectAllActionPerformed(ActionEvent e) {
        setSelectionOfComponents(jCheckBoxSelectAll.isSelected());
        validateDialog();
    }

    private void jCheckBoxAsposeCellsActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeWordsActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposePdfActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeSlidesActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeBarCodeActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeTasksActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeEmailActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeOCRActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeImagingActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jCheckBoxAsposeDiagramActionPerformed(ActionEvent e) {
        validateDialog();
    }

    private void jLabel1ComponentResized(java.awt.event.ComponentEvent evt) {
        int labelwidth = jLabel5.getWidth();
        int labelheight = jLabel5.getHeight();
        Image img = icon.getImage();
        jLabel5.setIcon( new ImageIcon(img.getScaledInstance(labelwidth,labelheight ,Image.SCALE_FAST)));
    }

    private void initComponents() {

        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jPanel2 = new JPanel();
        jPanel6 = new JPanel();
        jCheckBoxSelectAll = new JCheckBox();
        jCheckBoxAsposeCells = new JCheckBox();
        jCheckBoxAsposeWords = new JCheckBox();
        jCheckBoxAsposePdf =    new JCheckBox();
        jCheckBoxAsposeSlides = new JCheckBox();
        jCheckBoxAsposeBarCode = new JCheckBox();
        jCheckBoxAsposeTasks = new JCheckBox();
        jCheckBoxAsposeEmail = new JCheckBox();
        jCheckBoxAsposeOCR = new JCheckBox();
        jCheckBoxAsposeImaging = new JCheckBox();
        jCheckBoxAsposeDiagram = new JCheckBox();

        jPanel4 = new JPanel();
        jLabelCommonUses = new JLabel();
        jLabelMessage = new JLabel();
        jLabelMessage.setOpaque(true);


        //======== this ========



        //======== jPanel1 ========
        {
            jPanel1.setBackground(Color.white);
            jPanel1.setBorder(new EtchedBorder());
            jPanel1.setForeground(Color.white);

            //---- jLabel5 ----
            jLabel5.setText(bundle.getString("AsposeWizardPanel.jLabel5.text"));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setIcon(icon); // NOI18N
            jLabel5.setDoubleBuffered(true);
            jLabel5.setOpaque(true);
            jLabel5.addComponentListener(new java.awt.event.ComponentAdapter() {
                public void componentResized(java.awt.event.ComponentEvent evt) {
                    jLabel1ComponentResized(evt);
                }
            });
            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup()
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE));
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        //======== jPanel2 ========
        {

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGap(0, 285, Short.MAX_VALUE)
            );
        }

        //======== jPanel6 ========
        {
            jPanel6.setBorder(new TitledBorder(bundle.getString("AsposeWizardPanel.jPanel6.border.title")));

            //---- jCheckBoxSelectAll ----
            jCheckBoxSelectAll.setText(bundle.getString("AsposeWizardPanel.jCheckBoxSelectAll.text"));
            jCheckBoxSelectAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxSelectAllActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeCells ----
            jCheckBoxAsposeCells.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeCells.text"));
            jCheckBoxAsposeCells.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeCellsActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeWords ----
            jCheckBoxAsposeWords.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeWords.text"));
            jCheckBoxAsposeWords.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeWordsActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposePdf ----
            jCheckBoxAsposePdf.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposePdf.text"));
            jCheckBoxAsposePdf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposePdfActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeSlides ----
            jCheckBoxAsposeSlides.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeSlides.text"));
            jCheckBoxAsposeSlides.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeSlidesActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeTasks ----
            jCheckBoxAsposeTasks.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeTasks.text"));
            jCheckBoxAsposeTasks.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeTasksActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeBarCode ----
            jCheckBoxAsposeBarCode.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeBarCode.text"));
            jCheckBoxAsposeBarCode.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeBarCodeActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeEmail ----
            jCheckBoxAsposeEmail.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeEmail.text"));
            jCheckBoxAsposeEmail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeEmailActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeOCR ----
            jCheckBoxAsposeOCR.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeOCR.text"));
            jCheckBoxAsposeOCR.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeOCRActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeImaging ----
            jCheckBoxAsposeImaging.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeImaging.text"));
            jCheckBoxAsposeImaging.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeImagingActionPerformed(e);
                }
            });

            //---- jCheckBoxAsposeDiagram ----
            jCheckBoxAsposeDiagram.setText(bundle.getString("AsposeWizardPanel.jCheckBoxAsposeDiagram.text"));
            jCheckBoxAsposeDiagram.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jCheckBoxAsposeDiagramActionPerformed(e);
                }
            });

            GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup()
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup()
                            .addComponent(jCheckBoxSelectAll)
                            .addComponent(jCheckBoxAsposeCells)
                            .addComponent(jCheckBoxAsposeWords)
                            .addComponent(jCheckBoxAsposePdf)
                            .addComponent(jCheckBoxAsposeSlides)
                            .addComponent(jCheckBoxAsposeBarCode)
                            .addComponent(jCheckBoxAsposeTasks)
                            .addComponent(jCheckBoxAsposeEmail)
                            .addComponent(jCheckBoxAsposeOCR)
                            .addComponent(jCheckBoxAsposeImaging)
                            .addComponent(jCheckBoxAsposeDiagram))
                        .addContainerGap(8, Short.MAX_VALUE))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup()
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBoxSelectAll)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeCells)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeWords)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposePdf)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeSlides)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeBarCode)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeTasks)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeEmail)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeOCR)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeImaging)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxAsposeDiagram)
                        .addContainerGap(22, Short.MAX_VALUE))
            );
        }

        //======== jPanel4 ========
        {
            jPanel4.setBorder(new TitledBorder(bundle.getString("AsposeWizardPanel.jPanel4.border.title")));
            jPanel4.setPreferredSize(new Dimension(333, 438));


            //---- jLabelCommonUses ----
            jLabelCommonUses.setText(bundle.getString("AsposeWizardPanel.jLabelCommonUses.text"));
            Font labelFont = jLabelCommonUses.getFont();

            jLabelCommonUses.setFont(new Font(labelFont.getName(), Font.PLAIN, 14));

            GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup()
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelCommonUses)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup()
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelCommonUses)
                        .addContainerGap(0, Short.MAX_VALUE))
            );
        }

        //---- jLabelMessage ----
        jLabelMessage.setText(bundle.getString("AsposeWizardPanel.jLabelMessage.text"));
        jLabelMessage.setToolTipText(bundle.getString("AsposeWizardPanel.jLabelMessage.toolTipText"));

        GroupLayout layout = new GroupLayout(this);

        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelMessage)
                                                .addContainerGap()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jPanel2, 0, 0, 0))
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                            .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMessage)
                                    .addContainerGap())))
        );

    }


    private JPanel jPanel1;
    private JLabel jLabel5;
    private JPanel jPanel2;
    private JPanel jPanel6;
    private JCheckBox jCheckBoxSelectAll;
    private JCheckBox jCheckBoxAsposeCells;
    private JCheckBox jCheckBoxAsposeWords;
    private JCheckBox jCheckBoxAsposePdf;
    private JCheckBox jCheckBoxAsposeSlides;
    private JCheckBox jCheckBoxAsposeBarCode;
    private JCheckBox jCheckBoxAsposeTasks;
    private JCheckBox jCheckBoxAsposeEmail;
    private JCheckBox jCheckBoxAsposeOCR;
    private JCheckBox jCheckBoxAsposeImaging;
    private JCheckBox jCheckBoxAsposeDiagram;
    private JPanel jPanel4;
    private JLabel jLabelCommonUses;
    private JLabel jLabelMessage;
    private ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/resources/long_bannerIntelliJ.png"));

    //=========================================================================
    public void clearMessage()
    {
        jLabelMessage.setText("");
    }
    private boolean validateDialog()
    {
        if (!isComponentSelected())
        {
            diplayMessage(AsposeConstants.IS_COMPONENT_SELECTED, true);
            return false;
        }
        clearMessage();
        return true;

    }
    //=========================================================================
    public boolean isComponentSelected()
    {
        if (jCheckBoxAsposeCells.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeWords.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposePdf.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeSlides.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeBarCode.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeTasks.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeEmail.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeOCR.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeImaging.isSelected())
        {
            return true;
        }
        if (jCheckBoxAsposeDiagram.isSelected())
        {
            return true;
        }

        return false;
    }
    //=========================================================================
    public void diplayMessage(String message, boolean error)
    {
        if (error)
        {

            jLabelMessage.setForeground(Color.RED);
        }
        else
        {
            jLabelMessage.setForeground(Color.GREEN);
        }
        jLabelMessage.setSize(300,20);
        jLabelMessage.setText(message);
        jLabelMessage.update(jLabelMessage.getGraphics());
        this.validate();




    }
    //=========================================================================
    private void setSelectionOfComponents(boolean value)
    {
        jCheckBoxAsposeBarCode.setSelected(value);
        jCheckBoxAsposeTasks.setSelected(value);
        jCheckBoxAsposeCells.setSelected(value);
        jCheckBoxAsposeEmail.setSelected(value);
        jCheckBoxAsposeImaging.setSelected(value);
        jCheckBoxAsposeDiagram.setSelected(value);
        jCheckBoxAsposeOCR.setSelected(value);
        jCheckBoxAsposePdf.setSelected(value);
        jCheckBoxAsposeSlides.setSelected(value);
        jCheckBoxAsposeWords.setSelected(value);

    }
    //=========================================================================
    void updateComponentsSelectionList()
    {
        if (jCheckBoxAsposeCells.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_CELLS);
            component.set_selected(true);
        }

        if (jCheckBoxAsposeWords.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_WORDS);
            component.set_selected(true);
        }
        if (jCheckBoxAsposePdf.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_PDF);
            component.set_selected(true);

            AsposeJavaComponent component2 = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_PDF_KIT);
            component2.set_selected(true);

        }
        if (jCheckBoxAsposeSlides.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_SLIDES);
            component.set_selected(true);
        }

        if (jCheckBoxAsposeBarCode.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_BARCODE);
            component.set_selected(true);
        }
        if (jCheckBoxAsposeTasks.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_TASKS);
            component.set_selected(true);
        }

        if (jCheckBoxAsposeEmail.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_EMAIL);
            component.set_selected(true);
        }
        if (jCheckBoxAsposeOCR.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_OCR);
            component.set_selected(true);
        }
        if (jCheckBoxAsposeImaging.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_IMAGING);
            component.set_selected(true);
        }
        if (jCheckBoxAsposeDiagram.isSelected())
        {
            AsposeJavaComponent component = AsposeJavaComponents.list
                    .get(AsposeConstants.ASPOSE_DIAGRAM);
            component.set_selected(true);
        }

    }

    public JCheckBox getjCheckBoxAsposeCells() {
        return jCheckBoxAsposeCells;
    }

    public JCheckBox getjCheckBoxAsposeWords() {
        return jCheckBoxAsposeWords;
    }

    public JCheckBox getjCheckBoxAsposePdf() {
        return jCheckBoxAsposePdf;
    }

    public JCheckBox getjCheckBoxAsposeSlides() {
        return jCheckBoxAsposeSlides;
    }

    public JCheckBox getjCheckBoxAsposeBarCode() {
        return jCheckBoxAsposeBarCode;
    }

    public JCheckBox getjCheckBoxAsposeTasks() {
        return jCheckBoxAsposeTasks;
    }

    public JCheckBox getjCheckBoxAsposeEmail() {
        return jCheckBoxAsposeEmail;
    }

    public JCheckBox getjCheckBoxAsposeOCR() {
        return jCheckBoxAsposeOCR;
    }

    public JCheckBox getjCheckBoxAsposeImaging() {
        return jCheckBoxAsposeImaging;
    }

    public JCheckBox getjCheckBoxAsposeDiagram() {
        return jCheckBoxAsposeDiagram;
    }

}
