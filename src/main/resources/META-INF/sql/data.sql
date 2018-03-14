insert into roles(name) values ("admin");
insert into roles(name) values ("user");

insert into instruments(name) values ("drums");
insert into instruments(name) values ("guitar");
insert into instruments(name) values ("bass");
insert into instruments(name) values ("saxo");

insert into cities(name) values ("Warszawa");
insert into cities(name) values ("Wrocław");
insert into cities(name) values ("Kraków");
insert into cities(name) values ("Łódź");
insert into cities(name) values ("Gdańsk");
insert into cities(name) values ("Katowice");

insert into cities(name) values ("Berlin");
insert into cities(name) values ("Hamburg");
insert into cities(name) values ("Bremen");
insert into cities(name) values ("Dresden");
insert into cities(name) values ("Leipzig");
insert into cities(name) values ("Frankfurt");
insert into cities(name) values ("Wuppertal");
insert into cities(name) values ("Köln");
insert into cities(name) values ("Düsseldorf");

insert into cities(name) values ("Praha");

insert into users(email, password, username) values ("mail@mail.com", "$2a$10$3MwtgSz7jyfi/wswE.2SVulISTVigAwzcW1DRsB3OCvY6H8qi9/Yi", "admin");
insert into users(email, password, username, city_id) values ("user1@mail.com", "$2a$10$3MwtgSz7jyfi/wswE.2SVulISTVigAwzcW1DRsB3OCvY6H8qi9/Yi", "bad_influence", 2);
insert into users(email, password, username, city_id) values ("user2@mail.com", "password", "satan", 2);
insert into users(email, password, username, city_id) values ("user3@mail.com", "$2a$10$3MwtgSz7jyfi/wswE.2SVulISTVigAwzcW1DRsB3OCvY6H8qi9/Yi", "metal4eva", 4);
insert into users(email, password, username, city_id) values ("user4@mail.com", "$2a$10$3MwtgSz7jyfi/wswE.2SVulISTVigAwzcW1DRsB3OCvY6H8qi9/Yi", "bestbeat", 4);

insert into users_roles(user_id, role_id) values (1, 1);
insert into users_roles(user_id, role_id) values (1, 2);
insert into users_roles(user_id, role_id) values (2, 2);
insert into users_roles(user_id, role_id) values (3, 2);
insert into users_roles(user_id, role_id) values (4, 2);
insert into users_roles(user_id, role_id) values (5, 2);

insert into jams(date, description, place, city_id, founder_id) values ("2018-04-15", "sample description", "Wzgórze Partyzantów", 2, 2);
insert into jams(date, description, place, city_id, founder_id) values ("2018-05-11", "sample description", "Pafawak", 2, 2);
insert into jams(date, description, place, city_id, founder_id) values ("2018-03-30", "sample description", "Zwinger", 10, 3);
insert into jams(date, description, place, city_id, founder_id) values ("2018-04-05", "sample description", "Schloss", 10, 2);



