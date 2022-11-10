CREATE SCHEMA IF NOT EXISTS oblig4;
SET SEARCH_PATH TO oblig4;

CREATE TABLE Deltaker
(
    mobilnummer CHAR (8) PRIMARY KEY,
    fornavn VARCHAR,
    etternavn VARCHAR,
    passord VARCHAR,
    salt VARCHAR,
    kjonn VARCHAR CHECK (kjonn = 'mann' OR kjonn = 'dame')
)