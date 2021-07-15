# To enable ProGuard in your project, edit project.properties
# to define the proguard.config property as described in that file.
#
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
# Save the obfuscation mapping to a file, so you can de-obfuscate any stack
# traces later on.

-dontoptimize
-ignorewarnings

# You can print out the seeds that are matching the keep options below.

#-printseeds bin/classes-processed.seeds

# Preverification is irrelevant for the dex compiler and the Dalvik VM.

-dontpreverify

# Reduce the size of the output some more.

-repackageclasses ''
-allowaccessmodification

# Switch off some optimizations that trip older versions of the Dalvik VM.

-optimizations !code/simplification/arithmetic

# Keep a fixed source file attribute and all line number tables to get line
# numbers in the stack traces.
# You can comment this out if you're not interested in stack traces.

-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# RemoteViews might need annotations.

-keepattributes *Annotation*
-keepattributes Signature

# Preserve all fundamental application classes.
-keep interface * {
  <methods>;
}
-keep public class com.emeint.android.fawryplugin.Plugininterfacing.FawrySdk{*;}
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends com.emeint.android.fawryplugin.models.BaseResponse{*;}
-keep public class com.emeint.android.fawryplugin.models.RawResponse{*;}
-keep public class com.emeint.android.fawryplugin.models.BaseResponse{*;}
-keep class com.emeint.android.fawryplugin.models.*{*;}
-keep class androidx.core.app.CoreComponentFactory { *; }
-keep class * implements java.io.Serializable {*;}
-keep class * implements android.os.Parcelable {*;}
-keep class * implements com.emeint.android.fawryplugin.views.interfaces.ChooserListDialogItemInterface {*;}
-keep enum * {*;}
-keepnames class com.emeint.android.fawryplugin.utils.UiUtils{*;}
-keepclassmembers class com.emeint.android.fawryplugin.utils.UiUtils{*;}
-keepclassmembers class com.emeint.android.fawryplugin.managers.FawryPluginAppClass{*;}
-keepclassmembers enum * { *; }
# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
# Preserve all View implementations, their special context constructors, and
# their setters.

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# Preserve all classes that have special context constructors, and the
# constructors themselves.

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Preserve all classes that have special context constructors, and the
# constructors themselves.

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Preserve the special fields of all Parcelable implementations.

-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.

-keepclassmembers class **.R$* {
  public static <fields>;
}

# The Android Compatibility library references some classes that may not be
# present in all versions of the API, but we know that's ok.

-dontwarn android.support.**

# Preserve all native method names and the names of their classes.

-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve the special static methods that are required in all enumeration
# classes.

-keepclassmembers class * extends java.lang.Enum {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
# You can comment this out if your application doesn't use serialization.
# If your code contains serializable classes that have to be backward
# compatible, please refer to the manual.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-dontwarn retrofit2.**
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn okhttp3.internal.platform.ConscryptPlatform

-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}





