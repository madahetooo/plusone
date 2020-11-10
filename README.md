# PlusOne APP
---
### Intended User

We target everyone who want to learn and chat with others by using our chatting service and studying mobile development using our material .

## Describtion :
With this app, you can log in with google or create a new account, and enjoy with two sections, one for the entertainment and the other for the tools: 

**Entertainment section :**
1. Chat App: you can chat with others in real-time and upload photos.
2. Connect 3 Game: you can play the connect 3 game with your friends.
3. Media Player: you can play and run some music and enjoy watching videos.
4. Dog or Cat Quiz: you can run a quiz to detect if you are acting like Dog or cat.

<img width="200" heigth="400" alt="Login Screen" src="https://user-images.githubusercontent.com/28203059/98726170-cf05c980-239e-11eb-8b39-f575d6f616a0.png"> <img width="200" width="400" alt="Chat Screen" src="https://user-images.githubusercontent.com/28203059/98726247-e6dd4d80-239e-11eb-9cba-0197ecac39b7.png"> <img width="200" height="420" alt="Connect3 Screen" src="https://user-images.githubusercontent.com/28203059/98726356-10967480-239f-11eb-907c-542b43e8f51a.png"> <img width="200" height="420" alt="Media Screen" src="https://user-images.githubusercontent.com/28203059/98726539-518e8900-239f-11eb-8d92-1dd2b74e7301.png"> <img width="200" height="420" alt="Dog Or Cat Quiz Screen" src="https://user-images.githubusercontent.com/28203059/98726641-7551cf00-239f-11eb-9103-4ca6a67b7b66.png">

---
**Tools Section:**
1. Calculator: you can do simple operations like Sum, sub, multiplication, and division.
2. Temperature Converter: you can convert degrees from or to celsius and Fahrenheit.
3. Java T Point website: you surf the java point website and study programming language through it. 
4. Google Maps: you can get your current location through google map.
5. Mobile Track PDF : you can learn the mobile development fundementals.

<img width="200"  heigth="420" alt="Calculator Screen" src="https://user-images.githubusercontent.com/28203059/98727117-19d41100-23a0-11eb-8726-4e2a33f75d99.png"> <img width="200" height="420" alt="Temperature Converter Screen" src="https://user-images.githubusercontent.com/28203059/98727055-01fc8d00-23a0-11eb-827a-403f99397c4d.png"> <img width="200" height="420" alt="Java T Point Screen" src="https://user-images.githubusercontent.com/28203059/98727225-4ab44600-23a0-11eb-88c8-1415e29b1d4c.png"> <img width="200"  height="420" alt="Google Maps Screen" src="https://user-images.githubusercontent.com/28203059/98727335-6ddef580-23a0-11eb-82e4-7f2864396d7b.png"> <img width="200" height="420" alt="Mobile track Screen" src="https://user-images.githubusercontent.com/28203059/98727513-aed70a00-23a0-11eb-9014-3ef9adc066af.png">
---
# Features
- App is written solely in the Java programming language.
- Android Studio version 4.1.0
- Gradle version 6.5
- Current Location with Google Maps API.
- Firebase Authentication
- Firebase Database
- Firebase Storage
- Adding UI Widget
- Java language will be used for development in all this designs
- All versions of gradle and android studio are stable.

---
# Dependencies i used : 

```
dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    
    // sdp lib
    implementation 'com.intuit.sdp:sdp-android:1.0.6'

    //butterknife
    implementation 'com.jakewharton:butterknife:10.2.3'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.3'

    //Material
    implementation 'com.google.android.material:material:1.2.1'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.media:media:1.2.0'
    
    //MultiDex
    implementation 'com.android.support:multidex:1.0.3'

    //Exo Player
    implementation 'com.google.android.exoplayer:exoplayer:2.12.0'
    implementation 'com.google.android.exoplayer:exoplayer-core:2.12.0'
    implementation 'com.google.android.exoplayer:exoplayer-ui:2.12.0'
    
    //GoogleMaps
    implementation 'com.google.android.gms:play-services-maps:17.0.0'
    implementation 'com.google.android.gms:play-services-location:17.1.0'
    implementation 'com.google.android.gms:play-services-maps:17.0.0'

    //PDF Viewer
    implementation 'com.github.barteksc:android-pdf-viewer:2.8.2'

    //Firebase
    implementation 'com.google.firebase:firebase-database:19.5.1'  //Firebase database
    implementation 'com.google.firebase:firebase-auth:20.0.0' //Firebase authentication
    implementation 'com.firebaseui:firebase-ui-database:6.4.0' //Firebase ui database
    implementation 'com.google.firebase:firebase-storage'    //Firebase Storage

    // Import the BoM for the Firebase platform
    implementation platform('com.google.firebase:firebase-bom:26.0.0')

    // Declare the dependency for the Cloud Storage library
    // When using the BoM, you don't specify versions in Firebase library dependencies

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.11.0'

    //Rounded Image
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.makeramen:roundedimageview:2.3.0'
    
    //Picasso
    implementation 'com.squareup.picasso:picasso:2.5.2'

    //Google Authentication
    implementation 'com.google.android.gms:play-services-auth:18.1.0'

    //Design
    //noinspection GradleCompatible
    implementation 'com.android.support:support-core-ui:28.0.0'
    implementation 'com.google.android.material:material:1.2.1'
    
    testImplementation 'junit:junit:4.13.1'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

}
```
