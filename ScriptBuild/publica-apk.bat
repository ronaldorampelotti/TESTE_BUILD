SET android_store_password=01062011
SET android_alias_password=01062011
SET DIR_RAIZ=%cd%
set VERSAO=%BUILD_NUMBER%
set DESTINO=%DIR_RAIZ%\ScriptBuild\BuildDist\%VERSAO%

call C:\Users\appveyor\AppData\Local\Android\android-sdk\tools\android update sdk --no-ui --filter 6,tool,platform-tool,doc

cd %DIR_RAIZ%\TesteTTS 
IF exist bin ( rmdir /S /Q bin )
call C:\tools\apache-ant-1.9.4\bin\ant release -Dkey.alias.password=%android_alias_password% -Dkey.store.password=%android_store_password% -Dkey.alias=hbmdmpuxada -Dkey.store=..\\hbmdm-android.keystore
cd ..

mkdir %DESTINO%\Android
copy /Y %DIR_RAIZ_ANDROID%\TesteTTS\bin\TesteTTS-release.apk %DESTINO%\Android\TesteTTS.apk

cd %DIR_RAIZ%
