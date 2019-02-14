#!/bin/bash
set -eux

echo Running pipeline...
mvn clean install
mvn dependency:copy-dependencies -DoutputDirectory=target/lib/

echo Done.
