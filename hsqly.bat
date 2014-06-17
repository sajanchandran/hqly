call mvn dependency:build-classpath -Dmdep.outputFile=test.txt
for /f %%i in (test.txt) do set HSQLY_CLASSPATH=%%i
echo Classpath is "%HSQLY_CLASSPATH%;.\target\classes\"
java -cp %HSQLY_CLASSPATH%;.\target\classes;.\src\test\resources;.\target\test-classes; com.hqly.main.Hqly "from Country"