insert into roles(name) value("admin");
insert into roles(name) value("user");

insert into instruments(name) value("drums");
insert into instruments(name) value("guitar");
insert into instruments(name) value("bass");

insert into cities(name) value("Warszawa");
insert into cities(name) value("Wrocław");
insert into cities(name) value("Kraków");
insert into cities(name) value("Łódź");
insert into cities(name) value("Gdańsk");
insert into cities(name) value("Katowice");

insert into cities(name) value("Berlin");
insert into cities(name) value("Hamburg");
insert into cities(name) value("Bremen");
insert into cities(name) value("Dresden");
insert into cities(name) value("Leipzig");
insert into cities(name) value("Frankfurt");
insert into cities(name) value("Wuppertal");
insert into cities(name) value("Köln");
insert into cities(name) value("Düsseldorf");

insert into cities(name) value("Praha");

insert into users(email, password, username) value("mail@mail.com", "password", "admin");
insert into users(email, password, username, city_id) value("user1@mail.com", "password", "user1", 2);
insert into users(email, password, username, city_id) value("user2@mail.com", "password", "user2", 2);

insert into users_roles(user_id, role_id) value(1, 1);
insert into users_roles(user_id, role_id) value(2, 2);
insert into users_roles(user_id, role_id) value(3, 2);

insert into jams(date, description, place, city_id, founder_id) value("2018-04-15", "sample description", "wzgórze partyzantów", 2, 2);
insert into jams(date, description, place, city_id, founder_id) value("2018-05-11", "sample description", "pafawak", 2, 2);
insert into jams(date, description, place, city_id, founder_id) value("2018-03-30", "sample description", "zwinger", 10, 3);
insert into jams(date, description, place, city_id, founder_id) value("2018-04-05", "sample description", "dom", 10, 2);



