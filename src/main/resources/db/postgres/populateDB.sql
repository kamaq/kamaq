--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: khipuuser
--

INSERT INTO users(id,email,enabled,name,password) VALUES (1, 'wilmer.reyes@outlook.com', false, 'wil', '123');
INSERT INTO users(id,email,enabled,name,password) VALUES (2, 'james.bradock@champion.com', false, 'jimmy', 'cenicienta');
INSERT INTO users(id,email,enabled,name,password) VALUES (3, 'chris.nielsen@dreams.com', false, 'chris', 'paradise');

INSERT INTO module(moduleid,description,imagefilename,name) VALUES (1,'Tools for manager application','','Manager Application');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (2,'Tools for manager application','','Commerce');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (3,'Tools for manager application','','Financial');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (4,'Tools for manager application','','People');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (5,'Tools for manager application','','Manufacture');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (6,'Tools for manager application','','Human Resource');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (7,'Tools for manager application','','Management');
INSERT INTO module(moduleid,description,imagefilename,name) VALUES (8,'Tools for manager application','','Quality');

INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (1,'users/find','User management','/kamaq/resources/images/menu/User.png','userForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (2,'main/form','Module management','/kamaq/resources/images/menu/Module.png','moduleForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (3,'main/form','component management','/kamaq/resources/images/menu/Component.png','componentForm',1);
INSERT INTO component(componentid,classname,description,imagefilename,name,module_moduleid) VALUES (4,'main/form','function management','/kamaq/resources/images/menu/Function.png','functionForm',1);
