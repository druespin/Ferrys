# Ferrys

Ferrys app provides schedule for the ferries sailing between Surat Thani and 3 islands in the Gulf of Thailand: 
Koh Samui, Koh Phangan and Koh Tao.

![screen-1](https://github.com/druespin/Ferrys/app/src/main/res/drawable/screen_1.png)
![screen-2](https://github.com/druespin/Ferrys/app/src/main/res/drawable/screen_2.png)


## Dependency

Add this in your root `build.gradle` file
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Then, add the library to your project `build.gradle`
```gradle
dependencies {
    implementation 'com.github.druespin:Ferrys
}
```
