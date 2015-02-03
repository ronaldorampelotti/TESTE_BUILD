SET android_store_password=01062011
SET android_alias_password=01062011
SET DIR_RAIZ=%cd%
SET VERSAO=%BUILD_NUMBER%
SET DESTINO=%DIR_RAIZ%\ScriptBuild\BuildDist\%VERSAO%
SET "JAVA_HOME=C:\Program Files\Java\jdk1.8.0"

echo y|call C:\Users\appveyor\AppData\Local\Android\android-sdk\tools\android update sdk --no-ui --all --filter 1,2,3,android-19


cd %DIR_RAIZ%\TesteTTS 
IF exist bin ( rmdir /S /Q bin )
call C:\tools\apache-ant-1.9.4\bin\ant release -Dkey.alias.password=%android_alias_password% -Dkey.store.password=%android_store_password% -Dkey.alias=hbmdmpuxada -Dkey.store=..\\hbmdm-android.keystore
cd ..

copy /Y %DIR_RAIZ%\TesteTTS\bin\Principal-release.apk %DIR_RAIZ%\ScriptBuild\BuildDist\TesteTTS.apk

cd %DIR_RAIZ%
