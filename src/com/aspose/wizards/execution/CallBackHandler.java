package com.aspose.wizards.execution;

import com.intellij.openapi.progress.ProgressIndicator;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Adeel Ilyas on 8/22/2014.
 */
public interface CallBackHandler {
    public boolean executeTask(@NotNull ProgressIndicator progressIndicator);
}
