# run from the base data-pipeline/ direectory

echo "Building jar"
gradle assemble

VERSION=0.0.1.SNAPSHOT
JAR=scdf-scala-$VERSION.jar
CONTAINER_REGISTRY=

function build_and_push()
  echo "Building $1 docker image"
  docker build -t $1:$VERSION --build-arg JAR=$JAR --build-arg CLASSPATH=$2 .
  docker tag $1:$VERSION $CONTAINER_REGISTRY/$1:$VERSION

  echo "Pushing $IMAGE_NAME docker image"
  docker push $CONTAINER_REGISTRY/$1:$VERSION

build_and_push pass-through-log com.example.scdfscala.processor.PassThroughLog
build_and_push helloworld com.example.scdfscala.source.HelloWorld
build_and_push log com.example.scdfscala.sink.Log
