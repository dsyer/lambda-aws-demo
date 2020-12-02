#!/usr/bin/env bash

ARTIFACT=native-config-server
TARGET=${1:-native-config-server}
MAINCLASS=${2:-com.vmware.nativeconfigserver.NativeConfigServerApplication}
VERSION=1.0.0

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

JAR="$ARTIFACT-$VERSION.jar"
rm -rf target/native-image
mkdir -p target/native-image

echo "Packaging $ARTIFACT with Maven"
mvn package > target/native-image/output.txt

rm -f target/$TARGET
echo "Unpacking $JAR"
cd target/native-image
jar -xvf ../$JAR >/dev/null 2>&1
cp -R META-INF BOOT-INF/classes

LIBPATH=`find BOOT-INF/lib | tr '\n' ':'`
CP=../classes:$LIBPATH

GRAALVM_VERSION=`native-image --version`
echo "Compiling $ARTIFACT with $GRAALVM_VERSION"
{ time native-image \
  -Dapp.name=${TARGET} \
  -H:Name=$TARGET \
  -H:+ReportExceptionStackTraces \
  --verbose --allow-incomplete-classpath --report-unsupported-elements-at-runtime --no-fallback --no-server --install-exit-handlers \
  -cp $CP $MAINCLASS >> output.txt ; } 2>> output.txt

if [[ -f $ARTIFACT ]]
then
  printf "${GREEN}SUCCESS${NC}\n"
  mv ./$TARGET ..
  exit 0
else
  cat output.txt
  printf "${RED}FAILURE${NC}: an error occurred when compiling the native-image.\n"
  exit 1
fi

