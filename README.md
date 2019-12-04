# Ferrys

Ferrys app provides schedule of the ferries sailing between Surat Thani and 3 islands in the Gulf of Thailand: 
Koh Samui, Koh Phangan and Koh Tao.

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
