-- Password for this user is 'greatwall'
INSERT INTO users ("username", "password", "salt", "role") VALUES
('user',
'FjZDm+sndmsdEDwNtfr6NA==',
'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=',
'user');


INSERT INTO landmarks("name", "address", "zipcode", "city", "state", "latitude", "longitude", "description")
VALUES ('Easton Town Center', '160 Easton Town Ctr', 43219, 'Columbus', 'Ohio', 40.0508, 82.9145, 'Easton Town Center is an indoor and outdoor shopping complex in northeast Columbus, Ohio. The core buildings and streets that comprise Easton are intended to look like a self-contained town, reminiscent of American towns and cities in the early-to-mid 20th century. Included in the design are fountains, streets laid out in a grid pattern surrounded by a continuous loop, and metered storefront parking.'),
       ('Ohio Statehouse', '1 Capitol Sq', 43215, 'Columbus', 'Ohio', 39.9614, 82.9991, 'The Ohio Statehouse is the state capitol building and seat of government for the U.S. state of Ohio. The Greek Revival building is located on Capitol Square in downtown Columbus. The capitol houses the Ohio General Assembly, consisting of the House of Representatives and the Senate.[2] It also contains the ceremonial offices of the governor,[2] lieutenant governor, state treasurer,[3] and state auditor.[4] Built between 1839 and 1861, it is one of the oldest working statehouses in the United States.' ),
       ('Nationwide Arena', '200 W Nationwide Blvd', 43215, 'Columbus', 'Ohio', 39.969010, 83.004740, 'Nationwide Arena is a multipurpose arena in Columbus, Ohio, United States. Since completion in 2000, the arena has served as the home of the Columbus Blue Jackets of the National Hockey League. It is one of two facilities in Columbus, along with Greater Columbus Convention Center, that hosts events during the annual Arnold Classic, a sports and fitness event hosted by actor, bodybuilder, and former Governor of California Arnold Schwarzenegger.'),
       ('Lucas Oil Stadium', '500 South Capitol Avenue', 46225, 'Indianapolis', 'Indiana', 39.7601, 86.1639, 'Lucas Oil Stadium is a multi-purpose stadium in Downtown Indianapolis, Indiana, United States. It replaced the RCA Dome as the home field of the NFLs Indianapolis Colts and opened on August 16, 2008.[11] The stadium was constructed to allow the removal of the RCA Dome and expansion of the Indiana Convention Center on its site.'),
       ('Rock and Roll Hall of Fame', '1100 Rock and Roll Boulevard', 44114, 'Cleveland', 'Ohio', 41.5085, 81.6954, 'The Rock and Roll Hall of Fame is a museum and hall of fame located in downtown Cleveland, Ohio, on the shore of Lake Erie. The museum documents the history of rock music and the artists, producers, engineers, and other notable figures who have influenced its development.');

