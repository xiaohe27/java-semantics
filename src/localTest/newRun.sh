#export PATH="/home/xiaohe/UIUC-WorkSpace/k/k-distribution/target/release/k/bin:$PATH"
#!/bin/bash
# Absolute path to this script, e.g. /home/user/bin/foo.sh
SCRIPT=/home/xiaohe/Unit-Projects/java-semantics/tools/kjrun-simple.sh
# Absolute path this script is in, thus /home/user/bin
SCRIPTPATH=$(dirname "$SCRIPT")

CurDir=$(pwd)

TMP="$CurDir/tmp.txt"

Input=$(basename $1)
OUT="$CurDir/$Input"

sed 's/\s*\([[:graph:]].*[[:graph:]]\)\s*/\1/g' < $OUT | tr -d '\n' > $TMP

sed -r 's/.*<program>//g' < $TMP > $OUT
sed -r 's/<\/program>.*//g' < $OUT > $TMP

sed "s/\`'KListWrap/\`'ListWrap/g" < $TMP > $OUT

rm $TMP

ClsName=$(echo $OUT | sed -r 's/\.java.pkast$//g')
krun $OUT --directory "$SCRIPTPATH/../src/exec" -cMainClass="ListItem(\"$ClsName\")" -cDissolveAllExceptOut="true" --parser "cat" > "$ClsName.actualOut"
