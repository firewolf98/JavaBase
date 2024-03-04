create table tutor(
id int auto_increment primary key,
nome varchar(30) not null,
cognome varchar(30) not null,
email varchar(50) unique,
telefono varchar(20)
);

create table studente(
id int auto_increment primary key,
nome varchar(30) not null,
cognome varchar(30) not null
);

create table corso(
id int auto_increment primary key,
nome varchar(30) not null,
tutor int not null,
durata int not null,
stato varchar(20) default '',
foreign key(tutor) references tutor(id)
on update cascade
on delete cascade
);

create table corsostudente(
corso int not null,
studente int not null,
foreign key(corso) references corso(id)
on update cascade
on delete cascade,
foreign key(studente) references studente(id)
on update cascade
on delete cascade,
primary key(corso, studente)
);