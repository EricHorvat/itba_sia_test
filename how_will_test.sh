# `pwd` = ~/itba_sia_test
# `ls -d */` = src/ $REPOSITORY_NAME/
mkdir output
cd $REPOSITORY_NAME && mvn install | tee ../output/student_installing_result.txt
cd ..
mvn package | tee output/test_result.txt