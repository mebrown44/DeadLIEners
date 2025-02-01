CREATE TABLE userCreds(
    Email Text,
    Passkey varchar(4)
    userCalender Event[]
);

CREATE TYPE Event AS (
    event_name Text,
    event_date DATE
);

CREATE FUNCTION addUser(username Text, passkey varChar(4))
RETURNS VOID
BEGIN
    INSERT INTO userCreds(Email, Passkey)
    VALUES (username, passkey)
END

CREATE FUNCTION retrieveUser(username Text, passkey varChar(4))
RETURNS 
BEGIN
