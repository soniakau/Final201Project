DROP DATABASE IF EXISTS TICTACTOE;
CREATE DATABASE TICTACTOE;

USE TICTACTOE;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Games; 

CREATE TABLE Users (
	userID int NOT NULL AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    userpass varchar(50) NOT NULL,
    wins int NOT NULL,
    losses int NOT NULL,
    draws int NOT NULL,
    PRIMARY KEY(userID),
    UNIQUE (username)
);

CREATE TABLE Games (
	gameID int NOT NULL AUTO_INCREMENT,
    firstUsername varchar(50) NOT NULL, 
    secondUsername varchar(50) NOT NULL,
    PRIMARY KEY(gameID),
    FOREIGN KEY (firstUsername) REFERENCES Users(username),
    FOREIGN KEY (secondUsername) REFERENCES Users(username)
);