package com.aspose.wizards.execution;

import com.intellij.openapi.progress.ProgressManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adeel on 12/2/2014.
 */
public class TasksExecutor {
    String title;
    List<ModalTaskImpl> tasks = new ArrayList<ModalTaskImpl>();

    public TasksExecutor(String title) {
        this.title = title;
    }

    public void addNewTask(ModalTaskImpl task) {
        if (task != null) {
            tasks.add(task);
        }

    }

    public void execute() {
        if (!tasks.isEmpty()) {
            for (ModalTaskImpl task : tasks) {
                ProgressManager.getInstance().run(task);
            }

        }
    }

    public void clearTasks() {
        tasks.clear();
    }

    public boolean areThereTasks() {
        return !tasks.isEmpty();
    }
}
