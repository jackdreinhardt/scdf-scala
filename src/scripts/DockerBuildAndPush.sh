# run from the base data-pipeline/ direectory

echo "Building jar"
gradle assemble

IMAGE_NAME=pass-through-log
VERSION=0.0.2.SNAPSHOT
JAR=scdf-scala-$VERSION.jar

echo "Building docker image"
docker build -t $IMAGE_NAME:$VERSION --build-arg JAR=$JAR .
docker tag $IMAGE_NAME:$VERSION $CONTAINER_REGISTRY/$IMAGE_NAME:$VERSION

echo "Pushing docker image"
docker push $CONTAINER_REGISTRY/$IMAGE_NAME:$VERSION
