#!/bin/bash

CONTAINER=vox-keycloak
REALM=vox-realm
OUTPUT="./keycloak/import"

mkdir -p $OUTPUT

docker exec $CONTAINER \
  /opt/keycloak/bin/kc.sh export \
  --dir /tmp/export \
  --realm $REALM

docker cp \
  $CONTAINER:/tmp/export/$REALM-realm.json \
  $OUTPUT/

echo "Keycloak realm exported"
