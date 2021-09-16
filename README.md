# Context
This project aims to validate some initial authentication scenarios for the Ton solution (Stone Co.).
The project created was based on an automation stack directed to the Java language, making use of the following technologies:
- [Serenity BDD](https://serenity-bdd.info/)
- [Cucumber 6](https://cucumber.io/)
- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- Others: Lombok, JUnit and Appium Java Client 

## Pre-requirements
- [JDK 1.8+](https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html)
- [Maven 3.6.x+](https://maven.apache.org/download.cgi)
- [Android SDK](https://developer.android.com/studio?gclid=Cj0KCQjw1ouKBhC5ARIsAHXNMI_fZut2oHtjqUHPzgvy0JAr8cRi2LwMTUSVfjRrbaijQYQAE2woNvoaApX0EALw_wcB&gclsrc=aw.ds#downloads)
- [Appium](https://appium.io/) - Node.js and NPM latest stable version

## Environment Variables and PATH configuration required

```shell
export ANDROID_HOME=/Users/ton.sample/Library/Android/sdk 
export PATH="${ANDROID_HOME}/tools:${PATH}" 
export PATH="${ANDROID_HOME}/emulator:${PATH}" 
export PATH="${ANDROID_HOME}/platform-tools:${PATH}
```

## Serenity settings
1. The following settings need to be changed depending on the Android Virtual Device or Physical Device used to run the tests - File **serenity.conf**

```json
appium {
    platformVersion = 10
    deviceName = emulator-5554
    ...
}
```

    1. platformVersion - Android version installed in device (AVD or Physical)
    2. deviceName - Can be obtained through the following command

```shell
adb devices -l
```

## Steps to execute the automation project
1. Setting the ANDROID_HOME environment variable and add to the PATH the commands folders


2. After to install Appium via NPM, start it. How to install and start up Appium access this [link](https://appium.io/docs/en/about-appium/getting-started/)


3. Execute the following command replacing **username** and **password** for your Ton credentials and the **path_apk_debug_mode** for the APK path built in DEBUG mode.
If necessary use the path of APK storage in **resources/app** folder.
   
`mvn clean verify -Dton.username=<username> -Dton.pwd=<password> -Dapk.path="<path_apk_debug_mode>"`
   
4. Access the HTML report generated in **target/site** folder through of **index.html** file 