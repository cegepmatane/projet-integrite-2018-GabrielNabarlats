--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: studiodev; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE studiodev WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE studiodev OWNER TO postgres;

\connect studiodev

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: jeu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jeu (
    id integer NOT NULL,
    annee integer,
    titre text,
    idstudio integer
);


ALTER TABLE public.jeu OWNER TO postgres;

--
-- Name: jeu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jeu_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jeu_id_seq OWNER TO postgres;

--
-- Name: jeu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jeu_id_seq OWNED BY public.jeu.id;


--
-- Name: studiodev; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.studiodev (
    id integer NOT NULL,
    nom text,
    siegesocial text,
    anneecreation text,
    effectif text
);


ALTER TABLE public.studiodev OWNER TO postgres;

--
-- Name: studiodev_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.studiodev_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.studiodev_id_seq OWNER TO postgres;

--
-- Name: studiodev_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.studiodev_id_seq OWNED BY public.studiodev.id;


--
-- Name: jeu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jeu ALTER COLUMN id SET DEFAULT nextval('public.jeu_id_seq'::regclass);


--
-- Name: studiodev id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studiodev ALTER COLUMN id SET DEFAULT nextval('public.studiodev_id_seq'::regclass);


--
-- Data for Name: jeu; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: studiodev; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.studiodev VALUES (3, 'LeStudio', 'paris', '2000', '100');
INSERT INTO public.studiodev VALUES (9, 'AutreStudio', 'Moscou', '2005', '50');
INSERT INTO public.studiodev VALUES (7, 'Un studio', 'Chicago', '1995', '100');


--
-- Name: jeu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jeu_id_seq', 1, false);


--
-- Name: studiodev_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.studiodev_id_seq', 10, true);


--
-- PostgreSQL database dump complete
--

