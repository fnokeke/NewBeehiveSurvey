# NewBeehiveSurvey

## New Survey App using ResearchStack 
Goal of app is click a button and it launches a simple survey with two questions. Survey questions will be generated from a json file.

#### 0) Create new android project 
- you may select android 5.0 and above
- select “empty activity” so you MainActivity is empty

### 1) Update project gradle script
In your project gradle script, under `buildscript >> repositories`, add: 
```
    maven { url 'https://maven.fabric.io/public' }
```

In your project gradle script, under `buildscript >> dependencies`, add: 
```
classpath 'me.tatarka:gradle-retrolambda:3.2.3'
classpath "com.neenbedankt.gradle.plugins:android-apt:1.4"
```

In your project gradle script, under `allprojects >> jcenter()`, add:
```
    maven { url "https://jitpack.io" }
    maven { url "https://dl.bintray.com/edu-cornell-tech-foundry/SDLRSX" }
    maven { url "https://dl.bintray.com/researchstack/ResearchStack" }
    maven { url "https://dl.bintray.com/edu-cornell-tech-foundry/ResearchSuiteAppFramework" }
```

### 2) Update app gradle script
At the top of your file, apply this plugin by adding:
```
apply plugin: 'me.tatarka.retrolambda'
```

Then in dependencies add the following
```
    compile 'org.researchstack:backbone:1.1.2'
    compile 'org.researchstack:skin:1.1.2'
    compile 'net.zetetic:android-database-sqlcipher:3.5.4@aar'
    compile 'com.madgag.spongycastle:core:1.54.0.0'
    compile 'com.madgag.spongycastle:prov:1.54.0.0'
    compile 'com.madgag.spongycastle:pkix:1.54.0.0'
    compile 'edu.cornell.tech.foundry:sdl_rsx:0.0.7'
    compile 'edu.cornell.tech.foundry:sdl_rsx_rstbsupport:0.0.1'
    compile 'edu.cornell.tech.foundry:sdl_rsx_rsrpsupport:0.0.3'
    compile 'edu.cornell.tech.foundry:sdl_rsx_rsrpohmagebackend:0.0.3'
    annotationProcessor 'co.touchlab.squeaky:squeaky-processor:0.4.0.0'
    compile 'edu.cornell.tech.foundry:researchsuitetaskbuilder:0.0.5'
    compile 'edu.cornell.tech.foundry:researchsuiteresultsprocessor:0.0.5'
```

### 3) Sync gradle!
Sync gradle by clicking `Sync Now` in android studio

### 4) Add app assets
#### 4a) Approach 1
- If you don't have `assets` folder in your android project, simply copy the assets folder in this repo to `app/src/main`
- Doing this will create `app/src/main/assets` which contains `json` and `images` subdirectories
- You can add your own custom survey questions by adding a json file to `app/src/main/assets/json`

#### 4b) Approach 2
If you have `assets` folder then you should not overwrite your contents. Follow the steps below:
- Go to `app/src/main` and add new folder `assets` (if using android studio, specifically, v3.0.1, you can change your view from Android to Project)
- Go to `app/src/main/assets` and add new folder `json`
- Go to `app/src/main/assets/json` and add your study json file (e.g. notificationDate.json file in this repo)
- Go to `app/src/main/assets` and add new folder `images`
- Go to `app/src/main/assets/images` and add folder `medl` with all its images (use the one in this repo)


### 5) Add resources folder
Copy `app/src/main/resources` directory to your own directory


### 6) Update res folder
#### 6a) Update `res/styles.xml` with the following: 
```
   <style name="Widget.RS.IconTabLayout" parent="@style/Widget.Backbone.IconTabLayout">
        <item name="tabIconColor">@android:color/white</item>
        <item name="tabIconIndicatorColor">@color/rsb_error</item>
        <item name="tabTextColor">@color/tab_text_color</item>
    </style>

    <style name="Widget.RS.SubmitBar" parent="@style/Widget.Backbone.SubmitBar"/>

    <style name="Base.Widget.RS.Toolbar" parent="@style/Widget.AppCompat.Toolbar">
        <item name="android:background">?attr/colorPrimary</item>
        <item name="android:minHeight">56dp</item>
        <item name="titleTextAppearance">@style/TextAppearance.Widget.RS.Toolbar.Title</item>
    </style>

    <style name="Widget.RS.Toolbar" parent="@style/Base.Widget.RS.Toolbar">
        <item name="android:elevation">4dp</item>
        <item name="android:outlineProvider">bounds</item>
    </style>

    <style name="Widget.RS.Toolbar.Transparent" parent="@style/Base.Widget.RS.Toolbar">
        <item name="android:elevation">0dp</item>
        <item name="android:outlineProvider">none</item>
        <item name="titleTextAppearance">@style/TextAppearance.Widget.RS.Toolbar.Title.Transparent</item>
    </style>

    <style name="Widget.RS.ActionButton.Overflow"
        parent="@style/Widget.AppCompat.ActionButton.Overflow">
        <item name="colorControlNormal">@android:color/white</item>
    </style>

    <style name="Widget.RS.Onboarding.Button" parent="Widget.AppCompat.Button.Colored">
        <item name="colorButtonNormal">@color/colorAccent</item>
        <item name="android:textColor">@android:color/white</item>
        <item name="android:layout_width">160dp</item>
        <item name="android:layout_height">wrap_content</item>
    </style>

    <style name="Widget.RS.EmptyView" parent="@style/Widget.Backbone.EmptyView">
        <item name="android:background">@android:color/white</item>
    </style>

    <style name="TextAppearance.Widget.RS.Toolbar.Title"
        parent="@style/TextAppearance.Widget.AppCompat.Toolbar.Title">
        <item name="android:textColor">@android:color/white</item>
        <item name="android:textSize">20sp</item>
    </style>

    <style name="TextAppearance.Widget.RS.Toolbar.Title.Transparent">
        <item name="android:textColor">@color/rsb_warm_gray</item>
    </style>

    <style name="PreferenceFragment.RS" parent="@style/PreferenceFragment.Material">
        <item name="android:divider">@null</item>
    </style>
```

#### 6b) Update `res/colors.xml` with the following: 
```angular2html
    <color name="dark_gray">#cccccc</color>
    <color name="gray">#EEEEEE</color>

    <color name="tab_text_color">#66FFFFFF</color>
    <color name="invalidColor">#2980b9</color>

    <color name="validColor">#2ecc71</color>

    <color name="darkBlue">#34495E</color>
    <color name="whiteColor">#ffffff</color>
```

#### 6c) Copy `main/res/color` folder into your `main/res`

#### 6d) Update your `res` folder to contain `themes.xml` (use the same themes.xml in this repo)

#### 6e) Copy `bg_splash.xml` and `ic_launcher_foreground.xml` into your `res/drawable` folder

### 7) Add code
- Import the 'rsrp' folder in this repo as a module into your project
- Copy `studyManagement` directory in `app/src/main` into the same directory as `MainActivity` (same as this repo example)
- Go to `studyManagement/RSApplication.java` and replace all `io.smalldata.newbeehivesurveys` with your package name
- Change MainActivity to extend `RSActivity`: 
```angular2html
public class MainActivity extends RSActivity {
           // other code here ...
 }
```
- Inside `MainActivity` after line `setContentView(R.layout.activity_main);` add `RSActivityManager.get().queueActivity(this, "notificationDate", true);`
### 8)  Update your manifest
- Add the following permission to `AndroidManifest.xml` before `<application></application>` tag: 
```angular2html
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```
- Add application name in `AndroidManifest.xml` as: 
```angular2html
        android:name=".studyManagement.RSApplication"
```
- Add MainActivity style in `AndroidManifest.xml` to:
```angular2html
            android:theme="@style/AppTheme">
```
- Add the following to `AndroidManifest.xml` in between `<application></application>` tag: 
```angular2html

        <activity
            android:name="org.researchstack.backbone.ui.ViewTaskActivity"
            android:label="@string/app_name"
            android:theme="@style/Theme.RS.Survey"
            android:windowSoftInputMode="adjustResize" />
```


### 9) Clean project and rebuild
- Clean, rebuild, and run app
- App should show two survey questions (from `assets/json/notificationDate.json`)
- Congratulations! All done!!

### 10) Enjoy - What's Next? 
- You can modify survey questions (from `assets/json/notificationDate.json`)
- You can add buttons in `MainActivity` to launch another survey besides `notificationDate.json`

