--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: khipuuser
--

INSERT INTO users(id,email,enabled,name,password) VALUES (1, 'wilmer.reyes@raw.com', false, 'wil', '123');
INSERT INTO users(id,email,enabled,name,password) VALUES (2, 'james.bradock@champion.com', false, 'jimmy', 'cenicienta');
INSERT INTO users(id,email,enabled,name,password) VALUES (3, 'chris.nielsen@dreams.com', false, 'chris', 'paradise');
INSERT INTO users(id,email,enabled,name,password) VALUES (4, 'joe.sassa@lafamilia.com', false, 'joe', 'joy');
INSERT INTO users(id,email,enabled,name,password) VALUES (5, 'vincent.corleone@lafamilia.com', false, 'vincent', 'vin');
INSERT INTO users(id,email,enabled,name,password) VALUES (6, 'vitto.corleone@genco.com', false, 'vitto', 'padri');
INSERT INTO users(id,email,enabled,name,password) VALUES (7, 'don.tomassini@genco.com', false, 'tomassini', 'don');
INSERT INTO users(id,email,enabled,name,password) VALUES (8, 'luca.brassi@genco.com', false, 'luca', 'brassi');
INSERT INTO users(id,email,enabled,name,password) VALUES (9, 'santino.corleone@genco.com', false, 'sonny', 'soni');
INSERT INTO users(id,email,enabled,name,password) VALUES (10, 'peter.clemenza@genco.com', false, 'clemenza', 'pete');
INSERT INTO users(id,email,enabled,name,password) VALUES (11, 'salvatore.tessio@genco.com', false, 'tessio', 'chava');
INSERT INTO users(id,email,enabled,name,password) VALUES (12, 'julio.bonacera@panino.com', false, 'bonacera', 'julio');
INSERT INTO users(id,email,enabled,name,password) VALUES (13, 'tom.hagen@genco.com', false, 'tom', 'hagen');
INSERT INTO users(id,email,enabled,name,password) VALUES (14, 'constanza.corleone@genco.com', false, 'connie', 'connie');
INSERT INTO users(id,email,enabled,name,password) VALUES (15, 'frank.pentangelli@lafamilia.com', false, 'frank', '5angeles');
INSERT INTO users(id,email,enabled,name,password) VALUES (16, 'anakin.skywalker@starwars.com', false, 'anakin', 'ani');
INSERT INTO users(id,email,enabled,name,password) VALUES (17, 'darth.vader@starwars.com', false, 'dart', 'vader');
INSERT INTO users(id,email,enabled,name,password) VALUES (18, 'luke.skywalker@starwars.com', false, 'luke', 'luk');
INSERT INTO users(id,email,enabled,name,password) VALUES (19, 'leia.skywalker@starwars.com', false, 'leia', 'princess');
INSERT INTO users(id,email,enabled,name,password) VALUES (20, 'obiwan.kenobi@starwars.com', false, 'obiwan', 'obi');
INSERT INTO users(id,email,enabled,name,password) VALUES (21, 'r2.d2@starwars.com', false, 'r2d2', 'arturito');
INSERT INTO users(id,email,enabled,name,password) VALUES (22, 'c3.po@starwars.com', false, 'c3po', 'tripio');
INSERT INTO users(id,email,enabled,name,password) VALUES (23, 'hans.solo@starwars.com', false, 'hans', 'solo');
INSERT INTO users(id,email,enabled,name,password) VALUES (24, 'chewbacca.solo@starwars.com', false, 'chewbacca', 'chewy');
INSERT INTO users(id,email,enabled,name,password) VALUES (25, 'yoda.master@starwars.com', false, 'yoda', 'master');
INSERT INTO users(id,email,enabled,name,password) VALUES (26, 'johnny.fontane@hollywood.com', false, 'johnny', 'yoni');
INSERT INTO users(id,email,enabled,name,password) VALUES (27, 'moe.greene@lasvegas.com', false, 'moe', 'poker');
INSERT INTO users(id,email,enabled,name,password) VALUES (28, 'william.ciccio@lafamilia.com', false, 'ciccio', 'chichio');
INSERT INTO users(id,email,enabled,name,password) VALUES (29, 'bruno.tataglia@rossato.com', false, 'bruno', 'tataglia');
INSERT INTO users(id,email,enabled,name,password) VALUES (30, 'emilio.barzini@cosanostra.com', false, 'barzini', 'emi');
INSERT INTO users(id,email,enabled,name,password) VALUES (31, 'virgil.solozzo@cosanostra.com', false, 'solozzo', 'chaveta');
INSERT INTO users(id,email,enabled,name,password) VALUES (32, 'jack.waltz@waltzinternational.com', false, 'waltz', 'jack');



INSERT INTO module(moduleid,description,imagefilename,name) VALUES (1,'Tools for manager application','','Manager Application');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (2,'Tools for manager application','','Commerce');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (3,'Tools for manager application','','Financial');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (4,'Tools for manager application','','People');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (5,'Tools for manager application','','Manufacture');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (6,'Tools for manager application','','Human Resource');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (7,'Tools for manager application','','Management');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (8,'Tools for manager application','','Quality');

INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (1,'users/','User management','/kamaq/resources/images/menu/User.png','userForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (2,'main/form','Module management','/kamaq/resources/images/menu/Module.png','moduleForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (3,'main/form','component management','/kamaq/resources/images/menu/Component.png','componentForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (4,'main/form','function management','/kamaq/resources/images/menu/Function.png','functionForm',1);
