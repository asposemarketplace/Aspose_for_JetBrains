    /* ==========================================================================
    * Copyright 2006 Mevenide Team
    *
    * Licensed under the Apache License, Version 2.0 (the "License");
    * you may not use this file except in compliance with the License.
    * You may obtain a copy of the License at
    *
    * http://www.apache.org/licenses/LICENSE-2.0
    *
    * Unless required by applicable law or agreed to in writing, software
    * distributed under the License is distributed on an "AS IS" BASIS,
    * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    * See the License for the specific language governing permissions and
    * limitations under the License.
    * =========================================================================
    */

    package com.aspose.wizards.project;
     
    import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
    import com.intellij.openapi.ui.LabeledComponent;
    import com.intellij.openapi.ui.TextFieldWithBrowseButton;
    import com.intellij.openapi.util.Comparing;
    import com.intellij.openapi.util.text.StringUtil;
    import com.intellij.ui.DocumentAdapter;
    import com.intellij.ui.PanelWithAnchor;
    import com.intellij.ui.components.JBLabel;
    import com.intellij.util.Alarm;
    import com.intellij.util.ui.UIUtil;
    import org.jetbrains.annotations.NotNull;
    import org.jetbrains.annotations.Nullable;

    import javax.swing.*;
    import javax.swing.event.DocumentEvent;
    import javax.swing.event.DocumentListener;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.File;
     
    public class AsposeEnvironmentForm implements PanelWithAnchor {
    private JPanel panel=new JPanel();
    private LabeledComponent<TextFieldWithBrowseButton> asposeHomeComponent=new LabeledComponent<TextFieldWithBrowseButton>();


    private JCheckBox mavenHomeOverrideCheckBox;
    private JCheckBox settingsOverrideCheckBox;
    private JCheckBox localRepositoryOverrideCheckBox;
    private JLabel myFakeLabel = new JLabel("Fake");
    private JComponent anchor;
     


     
    private boolean isUpdating = false;
    private final Alarm myUpdateAlarm = new Alarm(Alarm.ThreadToUse.SWING_THREAD);
     
    public AsposeEnvironmentForm() {
    DocumentAdapter listener = new DocumentAdapter() {
    @Override
    protected void textChanged(DocumentEvent e) {
    UIUtil.invokeLaterIfNeeded(new Runnable() {
    @Override
    public void run() {
    if (isUpdating) return;
    if (!panel.isShowing()) return;
     
    myUpdateAlarm.cancelAllRequests();
    myUpdateAlarm.addRequest(new Runnable() {
    @Override
    public void run() {
    isUpdating = true;


    isUpdating = false;
    }
    }, 100);
    }
    });
    }
    };




    setAnchor(asposeHomeComponent.getLabel());
    }



    public JComponent createComponent() {
    // all listeners will be removed when dialog is closed
    return panel;
    }
     
    @Override
    public JComponent getAnchor() {
    return anchor;
    }
     
    @Override
    public void setAnchor(JComponent anchor) {
    this.anchor = anchor;
    asposeHomeComponent.setAnchor(anchor);

    }

    private static abstract class PathProvider {
    public String getPath() {
    final File file = getFile();
    return file == null ? "" : file.getPath();
    }
     
    @Nullable
    abstract protected File getFile();
    }

    private static class PathOverrider {
    private final TextFieldWithBrowseButton component;
    private final JCheckBox checkBox;
    private final PathProvider pathProvider;

    private Boolean isOverridden;
    private String overrideText;

    public PathOverrider(final LabeledComponent<TextFieldWithBrowseButton> component,
    final JCheckBox checkBox,
    DocumentListener docListener,
    PathProvider pathProvider) {
    this.component = component.getComponent();
    this.component.getTextField().getDocument().addDocumentListener(docListener);
    this.checkBox = checkBox;
    this.pathProvider = pathProvider;
    checkBox.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent e) {
    update();
    }
    });
    }

    private void update() {
    final boolean override = checkBox.isSelected();
    if (Comparing.equal(isOverridden, override)) return;

    isOverridden = override;

    component.setEditable(override);
    component.setEnabled(override && checkBox.isEnabled());

    if (override) {
    if (overrideText != null) component.setText(overrideText);
    }
    else {
    if (!StringUtil.isEmptyOrSpaces(component.getText())) overrideText = component.getText();
    component.setText(pathProvider.getPath());
    }
    }

    private void updateDefault() {
    if (!checkBox.isSelected()) {
    component.setText(pathProvider.getPath());
    }
    }

    public void reset(String text) {
    isOverridden = null;
    checkBox.setSelected(!StringUtil.isEmptyOrSpaces(text));
    overrideText = StringUtil.isEmptyOrSpaces(text) ? null : text;
    update();
    }

    public String getResult() {
    return checkBox.isSelected() ? component.getText().trim() : "";
    }
    }
    }