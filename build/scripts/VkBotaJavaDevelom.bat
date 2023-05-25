@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  VkBotaJavaDevelom startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and VK_BOTA_JAVA_DEVELOM_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\VkBotaJavaDevelom.jar;%APP_HOME%\lib\sdk-1.0.6.jar;%APP_HOME%\lib\gson-2.8.5.jar;%APP_HOME%\lib\async-http-client-2.8.1.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.11.2.jar;%APP_HOME%\lib\async-http-client-netty-utils-2.8.1.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\log4j-core-2.11.2.jar;%APP_HOME%\lib\commons-text-1.6.jar;%APP_HOME%\lib\commons-collections4-4.3.jar;%APP_HOME%\lib\commons-lang3-3.8.1.jar;%APP_HOME%\lib\commons-io-2.6.jar;%APP_HOME%\lib\httpmime-4.5.8.jar;%APP_HOME%\lib\httpclient-4.5.8.jar;%APP_HOME%\lib\log4j-api-2.11.2.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.33.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.33.Final.jar;%APP_HOME%\lib\netty-reactive-streams-2.0.0.jar;%APP_HOME%\lib\netty-handler-4.1.33.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.33.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.33.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.33.Final.jar;%APP_HOME%\lib\reactive-streams-1.0.2.jar;%APP_HOME%\lib\javax.activation-1.2.0.jar;%APP_HOME%\lib\httpcore-4.4.11.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.11.jar;%APP_HOME%\lib\netty-codec-dns-4.1.33.Final.jar;%APP_HOME%\lib\netty-codec-4.1.33.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.33.Final.jar;%APP_HOME%\lib\netty-transport-4.1.33.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.33.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.33.Final.jar;%APP_HOME%\lib\netty-common-4.1.33.Final.jar

@rem Execute VkBotaJavaDevelom
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %VK_BOTA_JAVA_DEVELOM_OPTS%  -classpath "%CLASSPATH%" ru.vkbot.Bot %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable VK_BOTA_JAVA_DEVELOM_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%VK_BOTA_JAVA_DEVELOM_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
