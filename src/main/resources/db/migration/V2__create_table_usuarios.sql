create table usuarios (
    id int primary key auto_increment,
    usuarioname varchar(100) not null unique ,
    clave varchar(300) not null
)