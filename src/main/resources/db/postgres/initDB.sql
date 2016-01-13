--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.profile_detail DROP CONSTRAINT fkpdnxgcsuk290sgtk9bho1rcey;
ALTER TABLE ONLY public.function DROP CONSTRAINT fkmrqyi9ds1evem06bo0r3u1me4;
ALTER TABLE ONLY public.users_profile DROP CONSTRAINT fklmo26nq6l3ke2ahmsbkobxq1f;
ALTER TABLE ONLY public.component DROP CONSTRAINT fkk72rcp7q838x167pxlf6l651h;
ALTER TABLE ONLY public.profile_detail DROP CONSTRAINT fkcu4q73rl0b1vdk7egvm23cyqm;
ALTER TABLE ONLY public.users_profile DROP CONSTRAINT fk8dgr1j0hg9k5snenv256a7k6g;
ALTER TABLE ONLY public.users_profile DROP CONSTRAINT users_profile_pkey;
ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
ALTER TABLE ONLY public.profile DROP CONSTRAINT profile_pkey;
ALTER TABLE ONLY public.profile_detail DROP CONSTRAINT profile_detail_pkey;
ALTER TABLE ONLY public.module DROP CONSTRAINT module_pkey;
ALTER TABLE ONLY public.function DROP CONSTRAINT function_pkey;
ALTER TABLE ONLY public.component DROP CONSTRAINT component_pkey;
ALTER TABLE public.users ALTER COLUMN userid DROP DEFAULT;
ALTER TABLE public.profile ALTER COLUMN profileid DROP DEFAULT;
ALTER TABLE public.module ALTER COLUMN moduleid DROP DEFAULT;
ALTER TABLE public.function ALTER COLUMN functionid DROP DEFAULT;
ALTER TABLE public.component ALTER COLUMN componentid DROP DEFAULT;
DROP SEQUENCE public.users_userid_seq;
DROP TABLE public.users_profile;
DROP TABLE public.users;
DROP SEQUENCE public.profile_profileid_seq;
DROP TABLE public.profile_detail;
DROP TABLE public.profile;
DROP SEQUENCE public.module_moduleid_seq;
DROP TABLE public.module;
DROP SEQUENCE public.function_functionid_seq;
DROP TABLE public.function;
DROP SEQUENCE public.component_componentid_seq;
DROP TABLE public.component;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;
-- postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: component; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE component (
    componentid integer NOT NULL,
    classname character varying(80),
    description character varying(100),
    imagefilename character varying(200),
    name character varying(80),
    module_moduleid integer
);


ALTER TABLE component OWNER TO kamaq_user;

--
-- Name: component_componentid_seq; Type: SEQUENCE; Schema: public; Owner: kamaq_user
--

CREATE SEQUENCE component_componentid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE component_componentid_seq OWNER TO kamaq_user;

--
-- Name: component_componentid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamaq_user
--

ALTER SEQUENCE component_componentid_seq OWNED BY component.componentid;


--
-- Name: function; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE function (
    functionid integer NOT NULL,
    name character varying(80),
    component_componentid integer
);


ALTER TABLE function OWNER TO kamaq_user;

--
-- Name: function_functionid_seq; Type: SEQUENCE; Schema: public; Owner: kamaq_user
--

CREATE SEQUENCE function_functionid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE function_functionid_seq OWNER TO kamaq_user;

--
-- Name: function_functionid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamaq_user
--

ALTER SEQUENCE function_functionid_seq OWNED BY function.functionid;


--
-- Name: module; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE module (
    moduleid integer NOT NULL,
    description character varying(100),
    imagefilename character varying(200),
    name character varying(80)
);


ALTER TABLE module OWNER TO kamaq_user;

--
-- Name: module_moduleid_seq; Type: SEQUENCE; Schema: public; Owner: kamaq_user
--

CREATE SEQUENCE module_moduleid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE module_moduleid_seq OWNER TO kamaq_user;

--
-- Name: module_moduleid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamaq_user
--

ALTER SEQUENCE module_moduleid_seq OWNED BY module.moduleid;


--
-- Name: profile; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE profile (
    profileid integer NOT NULL,
    enabled boolean,
    name character varying(80)
);


ALTER TABLE profile OWNER TO kamaq_user;

--
-- Name: profile_detail; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE profile_detail (
    enabled boolean NOT NULL,
    inserted timestamp without time zone,
    updated timestamp without time zone,
    profile_profileid integer NOT NULL,
    function_functionid integer NOT NULL
);


ALTER TABLE profile_detail OWNER TO kamaq_user;

--
-- Name: profile_profileid_seq; Type: SEQUENCE; Schema: public; Owner: kamaq_user
--

CREATE SEQUENCE profile_profileid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE profile_profileid_seq OWNER TO kamaq_user;

--
-- Name: profile_profileid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamaq_user
--

ALTER SEQUENCE profile_profileid_seq OWNED BY profile.profileid;


--
-- Name: users; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE users (
    userid integer NOT NULL,
    email character varying(255),
    enabled boolean,
    name character varying(80),
    password character varying(20)
);


ALTER TABLE users OWNER TO kamaq_user;

--
-- Name: users_profile; Type: TABLE; Schema: public; Owner: kamaq_user; Tablespace: 
--

CREATE TABLE users_profile (
    user_userid integer NOT NULL,
    profiles_profileid integer NOT NULL
);


ALTER TABLE users_profile OWNER TO kamaq_user;

--
-- Name: users_userid_seq; Type: SEQUENCE; Schema: public; Owner: kamaq_user
--

CREATE SEQUENCE users_userid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_userid_seq OWNER TO kamaq_user;

--
-- Name: users_userid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamaq_user
--

ALTER SEQUENCE users_userid_seq OWNED BY users.userid;


--
-- Name: componentid; Type: DEFAULT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY component ALTER COLUMN componentid SET DEFAULT nextval('component_componentid_seq'::regclass);


--
-- Name: functionid; Type: DEFAULT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY function ALTER COLUMN functionid SET DEFAULT nextval('function_functionid_seq'::regclass);


--
-- Name: moduleid; Type: DEFAULT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY module ALTER COLUMN moduleid SET DEFAULT nextval('module_moduleid_seq'::regclass);


--
-- Name: profileid; Type: DEFAULT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY profile ALTER COLUMN profileid SET DEFAULT nextval('profile_profileid_seq'::regclass);


--
-- Name: userid; Type: DEFAULT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY users ALTER COLUMN userid SET DEFAULT nextval('users_userid_seq'::regclass);


--
-- Data for Name: component; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Name: component_componentid_seq; Type: SEQUENCE SET; Schema: public; Owner: kamaq_user
--

SELECT pg_catalog.setval('component_componentid_seq', 1, false);


--
-- Data for Name: function; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Name: function_functionid_seq; Type: SEQUENCE SET; Schema: public; Owner: kamaq_user
--

SELECT pg_catalog.setval('function_functionid_seq', 1, false);


--
-- Data for Name: module; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Name: module_moduleid_seq; Type: SEQUENCE SET; Schema: public; Owner: kamaq_user
--

SELECT pg_catalog.setval('module_moduleid_seq', 1, false);


--
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Data for Name: profile_detail; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Name: profile_profileid_seq; Type: SEQUENCE SET; Schema: public; Owner: kamaq_user
--

SELECT pg_catalog.setval('profile_profileid_seq', 1, false);




--
-- Data for Name: users_profile; Type: TABLE DATA; Schema: public; Owner: kamaq_user
--



--
-- Name: users_userid_seq; Type: SEQUENCE SET; Schema: public; Owner: kamaq_user
--

SELECT pg_catalog.setval('users_userid_seq', 1, true);


--
-- Name: component_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY component
    ADD CONSTRAINT component_pkey PRIMARY KEY (componentid);


--
-- Name: function_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY function
    ADD CONSTRAINT function_pkey PRIMARY KEY (functionid);


--
-- Name: module_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY module
    ADD CONSTRAINT module_pkey PRIMARY KEY (moduleid);


--
-- Name: profile_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY profile_detail
    ADD CONSTRAINT profile_detail_pkey PRIMARY KEY (profile_profileid, function_functionid);


--
-- Name: profile_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (profileid);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);


--
-- Name: users_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: kamaq_user; Tablespace: 
--

ALTER TABLE ONLY users_profile
    ADD CONSTRAINT users_profile_pkey PRIMARY KEY (user_userid, profiles_profileid);


--
-- Name: fk8dgr1j0hg9k5snenv256a7k6g; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY users_profile
    ADD CONSTRAINT fk8dgr1j0hg9k5snenv256a7k6g FOREIGN KEY (user_userid) REFERENCES users(userid);


--
-- Name: fkcu4q73rl0b1vdk7egvm23cyqm; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY profile_detail
    ADD CONSTRAINT fkcu4q73rl0b1vdk7egvm23cyqm FOREIGN KEY (function_functionid) REFERENCES function(functionid);


--
-- Name: fkk72rcp7q838x167pxlf6l651h; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY component
    ADD CONSTRAINT fkk72rcp7q838x167pxlf6l651h FOREIGN KEY (module_moduleid) REFERENCES module(moduleid);


--
-- Name: fklmo26nq6l3ke2ahmsbkobxq1f; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY users_profile
    ADD CONSTRAINT fklmo26nq6l3ke2ahmsbkobxq1f FOREIGN KEY (profiles_profileid) REFERENCES profile(profileid);


--
-- Name: fkmrqyi9ds1evem06bo0r3u1me4; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY function
    ADD CONSTRAINT fkmrqyi9ds1evem06bo0r3u1me4 FOREIGN KEY (component_componentid) REFERENCES component(componentid);


--
-- Name: fkpdnxgcsuk290sgtk9bho1rcey; Type: FK CONSTRAINT; Schema: public; Owner: kamaq_user
--

ALTER TABLE ONLY profile_detail
    ADD CONSTRAINT fkpdnxgcsuk290sgtk9bho1rcey FOREIGN KEY (profile_profileid) REFERENCES profile(profileid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
