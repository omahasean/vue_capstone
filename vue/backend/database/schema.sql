BEGIN TRANSACTION;

DROP TABLE IF EXISTS itinerary_user;
DROP TABLE IF EXISTS itinerary_landmarks;
DROP TABLE IF EXISTS itinerary;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;



CREATE TABLE users (
  user_id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user')
);

CREATE TABLE landmarks (
  landmark_id serial PRIMARY KEY,
  landmark_name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  zipcode integer NOT NULL,
  city varchar(255) NOT NULL,
  state varchar(255) NOt NULL,
  Latitude decimal(15,5)  NOT NULL,
  Longitude decimal(15,5) NOT NULL,
  Description varchar(1000) NOT NULL
);

CREATE TABLE itinerary (
 itinerary_id serial PRIMARY KEY,
 user_id integer,
 CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
 itinerary_name varchar(255)
);

 
 CREATE TABLE itinerary_landmarks(
 itinerary_id integer,
 CONSTRAINT itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary(itinerary_id),
 landmark_id integer,
 CONSTRAINT landmark_id FOREIGN KEY (landmark_id) REFERENCES landmarks(landmark_id)
 );

COMMIT TRANSACTION;
