# REPOSITORY_NAME = sia-2019-1c-X
mkdir $REPOSITORY_NAME
mkdir output
cd $REPOSITORY_NAME && mvn package | tee ../output/student_package_result.txt
cd ..
mvn install:install-file -Dfile=./$REPOSITORY_NAME/target/gps-1.0.jar | tee output/student_package_installing_result.txt
mvn package | tee output/test_result.txt