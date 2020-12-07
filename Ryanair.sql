CREATE TABLE Airline(flightNo VARCHAR(5) NOT NULL, passengerNo VARCHAR(8), PRIMARY KEY(flightNo));
CREATE TABLE Airport(depature VARCHAR(4) NOT NULL, passengerNO VARCHAR(8) NOT NULL, flightNo VARCHAR(5), PRIMARY KEY(passengerNo));
CREATE TABLE Bookings(bookingId VARCHAR(5) NOT NULL, flightNo VARCHAR(5) NOT NULL, paymentConfirmed VARCHAR(1) NOT NULL, airportId VARCHAR(3), PRIMARY KEY(bookingId));
CREATE TABLE Customers(passengerName VARCHAR(10) NOT NULL, address VARCHAR(10), passportNo VARCHAR(10) NOT NULL, bookingId VARCHAR(5), PRIMARY KEY(bookingId));
CREATE TABLE Flights(bookingId VARCHAR(5) NOT NULL, flightNo VARCHAR(5), depature VARCHAR(4), destination VARCHAR(4), aircraftType VARCHAR(5), passengerNo VARCHAR(8), PRIMARY KEY (passengerNo));
CREATE TABLE Payments(bookingId VARCHAR(5) NOT NULL, paymentConfirmed VARCHAR(1), PRIMARY KEY(bookingId));