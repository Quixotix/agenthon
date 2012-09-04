Fighters of Agenthon
====================


* Development Status: **Early Development - Planning**
* License: [Apache 2.0][1]
* Copyright: © 2012 - Quixotix, LLC

[1]: http://www.apache.org/licenses/LICENSE-2.0.txt

Build Instructions
------------------

Clone the git repository and navigate to the `agenthon-android` directory.

        git clone git://github.com/Quixotix/agenthon.git
        cd agenthon/agenthon-android

Create `local.properties` in for the android project.

        android update project --path .

Build a debug APK.

        ant debug

Install the APK onto a connected Android device or emulator.
    
        adb install -r build/agenthon-debug.apk
    

        
        
