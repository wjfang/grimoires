@echo OFF

setlocal enabledelayedexpansion

set OMII_CLIENT_HOME=@OMIICLIENT_HOME@
set GRIMOIRES_CLIENT_HOME=%OMII_CLIENT_HOME%\grimoires

set ENDORSED=-Djava.endorsed.dirs=%OMII_CLIENT_HOME%\endorsed
set MY_CLASSPATH=.;%OMII_CLIENT_HOME%\lib;%OMII_CLIENT_HOME%\conf;

for %%j in ("%OMII_CLIENT_HOME%"\lib\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j

for %%j in ("%GRIMOIRES_CLIENT_HOME%"\lib\*.jar) do set MY_CLASSPATH=!MY_CLASSPATH!;%%j

java "%ENDORSED%" -classpath "%MY_CLASSPATH%" uk.ac.soton.ecs.grimoires.shell.Shell %1

endlocal enabledelayedexpansion


