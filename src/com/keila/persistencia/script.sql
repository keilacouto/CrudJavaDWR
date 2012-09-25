CREATE DATABASE SISDEMONSTRACAO;

USE SISDEMONSTRACAO

CREATE TABLE Cliente(
    codigo int primary key identity,
    nome varchar(50) not null,
    telefone varchar(15) not null,
    email varchar(50) not null,
    site varchar(50) not null
)

CREATE TABLE Marca(
    codigo int primary key identity,
    descricao varchar(100) not null
)

CREATE TABLE Produto(
    codigo int primary key identity,
    descricao varchar(50) not null,
    quantidade int(10) not null,
    valor double not null,
    marcaId int(10) not null,
    foreign key (marcaId) references Marca (codigo)
)
