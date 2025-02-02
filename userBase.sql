-- Creates the overall Database
CREATE DATABASE users;
\c users;


CREATE TYPE Event AS (
    event_name Text,
    event_date DATE
);

CREATE TABLE userCreds(
    Email Text PRIMARY KEY,
    Passkey varchar(4) NOT NULL
    userCalender Event[]
);

CREATE OR REPLACE FUNCTION addUser(username Text, passkey varChar(4))
RETURNS VOID
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO userCreds(Email, Passkey)
    VALUES (username, passkey)
END
$$;

CREATE OR REPLACE FUNCTION retrieveUser(username Text, passkey varChar(4))
RETURNS Event[]
LANGUAGE plpgsql
AS $$
BEGIN
    SELECT userCalender INTO events
    FROM userCreds
    WHERE Email = username AND Passkey = passkey;

    RETURN events;
END
$$;