: Copy the result target to devops image folder
echo "..............................................."
echo "Copying jar to docker folder to deploy"
cp -a ./target/h3-0.0.1-SNAPSHOT.jar ./docker/h3-0.0.1-SNAPSHOT.jar
echo "."
echo "...........................................done!"