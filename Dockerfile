FROM clojure:openjdk-11-lein-2.9.7-buster

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY project.clj /usr/src/app/

RUN lein deps

COPY . /usr/src/app

RUN lein uberjar

ENV name=Nasir

EXPOSE 3000

ENTRYPOINT top -b

CMD java -jar target/app-standalone.jar
