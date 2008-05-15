@echo OFF

setlocal enabledelayedexpansion

set AXIS_LIB=..\lib\axis1.2rc3
set MY_CLASSPATH=.;..\lib;
for %%j in (.\lib\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j
for %%j in (%AXIS_LIB%\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j
for %%j in (..\lib\misc\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j

REM do you need feta support?
REM set FETA_LIB=..\Feta\lib
REM for %%j in (%FETA_LIB%\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j
REM for %%j in (%FETA_LIB%\jwsdp-jaxb\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j
REM for %%j in (%FETA_LIB%\jwsdp-shared\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j

set MY_CLASSPATH=!MY_CLASSPATH!;..\lib\jena2.2\jena.jar

java %ENDORSED% -classpath %MY_CLASSPATH% uk.ac.soton.ecs.grimoires.shell.Shell %1

endlocal enabledelayedexpansion
