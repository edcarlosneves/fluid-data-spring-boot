SHELL := /bin/bash # Use bash syntax
ARG := $(word 2, $(MAKECMDGOALS) )

database-up:
	docker-compose -f docker/docker-compose-database.yml up -d

database-stop:
	docker-compose -f docker/docker-compose-database.yml stop

run-api: 
	 ./mvnw spring-boot:run

build-package:
	./mvnw clean package

docker-build-image:
	docker build -f docker/Dockerfile -t edcarlosneves/fluid-data-spring-boot:$(shell cat VERSION) .

docker-run-image:
	docker run -it -p 8080:8080 edcarlosneves/fluid-data-spring-boot:$(shell cat VERSION)


