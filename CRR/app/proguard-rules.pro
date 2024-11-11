##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over

-dontwarn javax.annotation.Nullable

# Preference objects are inflated via reflection
-keep public class androidx.preference.Preference {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keep public class * extends androidx.preference.Preference {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#-webView
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

#-view
-keep class * extends android.view.View

#-okhttp3
-keep class com.squareup.okhttp3.** {*;}
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

#-lottie
#-keep class com.airbnb.android
-dontwarn com.airbnb.lottie.**
-keep class com.airbnb.lottie.** {*;}

-keep class androidx.databinding.** { *; }

# Retrofit
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class org.apache.james.mime4j.** { *; }
-keep class javax.inject.** { *; }
-keep class javax.xml.stream.** { *; }
-keep class retrofit.** { *; }
-keep class com.google.appengine.** { *; }
-keepattributes *Annotation*
-keepattributes Signature
-dontwarn com.squareup.okhttp.*
-dontwarn rx.**
-dontwarn javax.xml.stream.**
-dontwarn com.google.appengine.**
-dontwarn java.nio.file.**
-dontwarn org.codehaus.**


-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

-keepattributes EnclosingMethod
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keepclasseswithmembers interface * {
    @retrofit2.* <methods>;
}
-keepattributes
*Annotation*,JavascriptInterface,Exceptions,InnerClasses,Signature,*Annotation*,EnclosingMethod,*Annotation*,Signature
-dontwarn com.google.**
-dontwarn com.google.firebase.** -dontwarn com.google.android.gms.**
-keep public class com.crr.unity.plugin.android.** { public *;
}
-keep public interface com.crr.unity.plugin.android.** {*;}

-dontwarn java.lang.invoke.StringConcatFactory
-dontwarn com.unity3d.player.UnityPlayer