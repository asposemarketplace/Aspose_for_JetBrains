package com.aspose.wizards;


    import com.aspose.utils.*;
    import com.aspose.wizards.execution.RunnableHelper;
    import com.intellij.ide.util.projectWizard.*;
    import com.intellij.openapi.module.JavaModuleType;

    import com.intellij.openapi.module.Module;
    import com.intellij.openapi.module.ModuleUtil;
    import com.intellij.openapi.module.StdModuleTypes;
    import com.intellij.openapi.project.Project;
    import com.intellij.openapi.roots.ModifiableRootModel;
    import com.intellij.openapi.roots.ModuleRootManager;
    import com.intellij.openapi.roots.OrderRootType;
    import com.intellij.openapi.roots.libraries.Library;
    import com.intellij.openapi.roots.libraries.LibraryTable;
    import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
    import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
    import icons.AsposeIcons;
    import org.jetbrains.annotations.NonNls;
    import org.jetbrains.annotations.NotNull;
    import javax.swing.*;
    import java.io.File;
    import java.io.IOException;
    import java.util.Collection;
    import java.util.Iterator;
/**
 * @author Adeel Ilyas
 */


public class AsposeModuleBuilder extends JavaModuleBuilder {
     
    private Project myProject;

    @Override
    public String getBuilderId() {
    return getClass().getName();
    }
     
    @Override
    public String getPresentableName() {
    return "Aspose Application";
    }
    @Override
    public String getDescription() {
        return "<B>Aspose Application</B> creates a new IntelliJ project by downloading and referencing libraries of <B>Aspose" +
                " Java API.</B>  Aspose Project Wizard allows you to select components from Aspose Java product lines" +
                " like Aspose.Cells for Java and Aspose.Words for Java etc.  Once specific API is selected, its" +
                " reference is automatically downloaded from Aspose servers and referenced in classpath of the project." +
                " With this plugin, you never need to check for new releases of Aspose " +
                "APIs. Whenever a new release is published, you will be notified while creating new project.";



    }

     
    @Override
    public Icon getBigIcon() {
    return AsposeIcons.AsposeMedium;
    }
     
   @Override
    public Icon getNodeIcon() {
      return AsposeIcons.AsposeLogo;
    }


     
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
    return new ModuleWizardStep[]{
    new AsposeModuleWizardStep(wizardContext.getProject(), this, wizardContext)
    };
    }


    @Override
    public void setupRootModel(ModifiableRootModel rootModel) throws com.intellij.openapi.options.ConfigurationException{
        setMyProject(rootModel.getProject());
        super.setupRootModel(rootModel);
        RunnableHelper.runWhenInitialized(getMyProject(), new Runnable() {
            public void run() {
                final LibraryTablesRegistrar libTablesRegistrar = LibraryTablesRegistrar.getInstance();

                final LibraryTable libraryTable = libTablesRegistrar.getLibraryTable(getMyProject());

                final LibraryTable.ModifiableModel libTableModel = libraryTable.getModifiableModel();


                Library library = libTableModel.createLibrary(AsposeConstants.LIBRARY_NAME);
                libTableModel.commit();

                @NonNls final String path = getContentEntryPath() + File.separator + AsposeConstants.LIB_FOLDER;
                new File(path).mkdirs();


                for (AsposeJavaComponent component : AsposeJavaComponents.list.values()) {
                    if (component.is_selected()) {
                        try {
                            AsposeComponentsManager.copyDirectory(AsposeComponentsManager.getLibaryDownloadPath() + component.get_name().toLowerCase(), path);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                String[] children = new File(path + File.separator).list();
                for (int i = 0; i < children.length; i++) {
                    String jarPath = "jar://" + path + File.separator + children[i] + "!/";

                    Library.ModifiableModel model = library.getModifiableModel();

                    model.addRoot(jarPath, OrderRootType.CLASSES);

                    model.commit();

                }


                Collection<Module> modules = ModuleUtil.getModulesOfType(getMyProject(), StdModuleTypes.JAVA);
                Iterator itr = modules.iterator();
                Module module = null;
                while (itr.hasNext()) {
                    module = (Module) itr.next();
                    break;
                }
                final ModuleRootManager moduleRootManager = ModuleRootManager.getInstance(module);

                final ModifiableRootModel moduleRootModel = moduleRootManager.getModifiableModel();

                final Library lib = libraryTable.getLibraryByName(AsposeConstants.LIBRARY_NAME);

                if (moduleRootModel.findLibraryOrderEntry(lib) == null) {

                    moduleRootModel.addLibraryEntry(lib);

                }
                moduleRootModel.commit();


            }
        });
    }

    @Override
    public String getGroupName() {
    return JavaModuleType.JAVA_GROUP;
    }

        public Project getMyProject() {
            return myProject;
        }

        public void setMyProject(Project myProject) {
            this.myProject = myProject;
        }
    }

