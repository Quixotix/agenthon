#!/usr/bin/env bash

LIBGDX_ZIP="libgdx-nightly-latest.zip"

message(){
    echo -e "\E[1;36m"
    echo $1
    echo -e "\E[0;37m"
}

cd libgdx

message "Downloading $LIBGDX_ZIP ..."

wget http://libgdx.badlogicgames.com/nightlies/$LIBGDX_ZIP

message "Extracting $LIBGDX_ZIP ..."

unzip -o $LIBGDX_ZIP
rm libgdx-nightly-latest.zip

message "Copying JAR files into source tree ..."

cp -v gdx.jar sources/gdx-sources.jar ../main/libs/
cp -v gdx-natives.jar gdx-backend-lwjgl.jar gdx-backend-lwjgl-natives.jar sources/gdx-backend-lwjgl-sources.jar ../desktop/libs/
cp -v gdx-backend-android.jar sources/gdx-backend-android-sources.jar ../android/libs/
cp -rv armeabi-v7a armeabi ../android/libs/

