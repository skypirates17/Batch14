CREATE TABLE USERS
(
  USERID CHARACTER VARYING (100) PRIMARY KEY,
  USERNAME character varying (100),
  PASSWORD character varying (100)
);

CREATE TABLE MESSAGE
(
  MESSAGEID SERIAL PRIMARY KEY,
  SENDER character varying (100),
  RECEIVER character varying (100),
  MESSAGE character varying (100),
  TIME character varying (100)
);

CREATE TABLE ONLINEUSER
(
  ONLINEUSERID character varying (100),
  USERID character varying (100),
  LIVESTATUS character varying (100)
);

CREATE TABLE CONTACT
(
  CONTACTID SERIAL PRIMARY KEY,
  FIRSTNAME character varying (100),
  LASTNAME character varying (100),
  EMAIL character varying (100),
  TELEPHONE character varying (100)
);
