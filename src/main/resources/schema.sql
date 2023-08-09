CREATE TABLE IF NOT EXISTS VOTES (
     ID int not null,
     NAME varchar(100) not null,
     STATUS int,
     PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ELECTIONS (
     ELE_ID int not null,
     ELE_NAME varchar(100) not null,
     ELE_STATUS varchar(1),
     PRIMARY KEY (ELE_ID)
);

CREATE TABLE IF NOT EXISTS QUESTIONS (
     QUE_ID int not null,
     QUE_QUESTION varchar(250) not null,
     QUE_ELE_ID int,
     PRIMARY KEY (QUE_ID),
     FOREIGN KEY (QUE_ELE_ID) REFERENCES ELECTIONS(ELE_ID)
);

CREATE SEQUENCE IF NOT EXISTS elections_seq
    START WITH 50
    INCREMENT BY 50;
