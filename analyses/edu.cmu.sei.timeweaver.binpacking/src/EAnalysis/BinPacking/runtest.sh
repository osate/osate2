i=0;
while [ "$i" -le "30" ]
do
echo "###########################"
echo       RUN $i 
echo "###########################"
java -Xms850M -Xmx850M -classpath "c:\twcvs\timeweaver\bin\classes" EAnalysis.BinPacking.BinPackerTester $i
i=`expr $i + 1`
done