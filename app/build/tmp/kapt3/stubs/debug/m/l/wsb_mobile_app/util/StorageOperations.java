package m.l.wsb_mobile_app.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lm/l/wsb_mobile_app/util/StorageOperations;", "", "()V", "SHARED_PREFS_NAME", "", "TASK_LIST_KEY", "readTaskList", "", "Lm/l/wsb_mobile_app/model/Task;", "context", "Landroid/content/Context;", "writeTaskList", "", "taskList", "app_debug"})
public final class StorageOperations {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SHARED_PREFS_NAME = "TASK_SHARED_NAME";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TASK_LIST_KEY = "TASK_LIST_KEY";
    @org.jetbrains.annotations.NotNull
    public static final m.l.wsb_mobile_app.util.StorageOperations INSTANCE = null;
    
    private StorageOperations() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"CommitPrefEdits"})
    public final void writeTaskList(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<m.l.wsb_mobile_app.model.Task> taskList) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<m.l.wsb_mobile_app.model.Task> readTaskList(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}