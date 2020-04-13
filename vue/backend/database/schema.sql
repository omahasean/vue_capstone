BEGIN TRANSACTION;

DROP TABLE IF EXISTS itinerary_users;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;
DROP TABLE IF EXISTS itinerary;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user'),
  itineraryId int NOT NULL

 );

CREATE TABLE landmarks (
  id serial PRIMARY KEY,
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  zipcode integer NOT NULL,
  city varchar(255) NOT NULL,
  state varchar(255) NOt NULL,
  Latitude decimal(15,5)  NOT NULL,
  Longitude decimal(15,5) NOT NULL,
  Description varchar(1000) NOT NULL
);

CREATE TABLE intinerary (
  id serial PRIMARY KEY,
  name varchar(255)
);


ALTER TABLE itinerary 
    ADD FOREIGN KEY (id) REFERENCES users (id)
        DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE users 
    ADD FOREIGN KEY (id) REFERENCES itinerary (id)
        DEFERRABLE INITIALLY DEFERRED;

COMMIT TRANSACTION;
