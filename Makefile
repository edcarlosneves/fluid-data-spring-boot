SHELL := /bin/bash # Use bash syntax
ARG := $(word 2, $(MAKECMDGOALS) )

database-up:
	cd docker && docker-compose up -d

run-api: 
	 ./mvnw spring-boot:run

build-package:
	./mvnw clean package

docker-build-image:
	docker build -f docker/Dockerfile -t edcarlosneves/fluid-data-spring-boot .

docker-run-image:
	docker run -it -p 8080:8080 edcarlosneves/fluid-data-spring-boot


