#!/bin/bash
BASEDIR=$(dirname $0)
<<<<<<< HEAD
DATABASE=city-tour
=======
DATABASE=citytour
>>>>>>> 591ab6c101d40b28033efadfff438e3da9298a84
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql"
