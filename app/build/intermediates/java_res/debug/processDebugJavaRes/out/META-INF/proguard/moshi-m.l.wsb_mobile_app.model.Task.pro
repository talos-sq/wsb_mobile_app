-if class m.l.wsb_mobile_app.model.Task
-keepnames class m.l.wsb_mobile_app.model.Task
-if class m.l.wsb_mobile_app.model.Task
-keep class m.l.wsb_mobile_app.model.TaskJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class m.l.wsb_mobile_app.model.Task
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class m.l.wsb_mobile_app.model.Task
-keepclassmembers class m.l.wsb_mobile_app.model.Task {
    public synthetic <init>(java.lang.String,java.lang.String,m.l.wsb_mobile_app.model.ColorType,java.lang.String,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
