--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: khipuuser
--

INSERT INTO users VALUES (1, 'wilmer.reyes@outlook.com', false, 'wil', '123');
INSERT INTO users VALUES (2, 'james.bradock@champion.com', false, 'jimmy', 'cenicienta');
INSERT INTO users VALUES (3, 'chris.nielsen@dreams.com', false, 'chris', 'paradise');

INSERT INTO module VALUES (1,'Tools for manager application','','Manager Application');
INSERT INTO module VALUES (2,'Tools for manager application','','Commerce');
INSERT INTO module VALUES (3,'Tools for manager application','','Financial');
INSERT INTO module VALUES (4,'Tools for manager application','','People');
INSERT INTO module VALUES (5,'Tools for manager application','','Manufacture');
INSERT INTO module VALUES (6,'Tools for manager application','','Human Resource');
INSERT INTO module VALUES (7,'Tools for manager application','','Management');
INSERT INTO module VALUES (8,'Tools for manager application','','Quality');

INSERT INTO component VALUES (1,'main/userForm','User Management','/kamaq/resources/images/menu/User.png','User Editor',1);
INSERT INTO component VALUES (2,'main/moduleForm','Module Management','/kamaq/resources/images/menu/Module.png','Module Editor',1);
INSERT INTO component VALUES (3,'main/componentForm','Component Management','/kamaq/resources/images/menu/Component.png','Component Editor',1);
INSERT INTO component VALUES (4,'main/functionForm','Function Management','/kamaq/resources/images/menu/Function.png','Function Editor',1);
