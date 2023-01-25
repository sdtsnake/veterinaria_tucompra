-- Table: public.usuarios

-- DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9999 CACHE 1 ),
    nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    apellido character varying(255) COLLATE pg_catalog."default" NOT NULL,
    tipo_documento character varying(255) COLLATE pg_catalog."default",
    documento_identificacion integer NOT NULL,
    estado character varying(255) COLLATE pg_catalog."default",
    sexo integer,
    CONSTRAINT pk_usuario_id PRIMARY KEY (id),
    CONSTRAINT documento_usuario UNIQUE (documento_identificacion)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to root;



-- Table: public.mascotas

-- DROP TABLE IF EXISTS public.mascotas;

CREATE TABLE IF NOT EXISTS public.mascotas
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9999 CACHE 1 ),
    nombre character varying(255) COLLATE pg_catalog."default",
    raza character varying(255) COLLATE pg_catalog."default",
    usuario_id integer,
    sexo character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT pk_mascota_id PRIMARY KEY (id),
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id)
    REFERENCES public.usuarios (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.mascotas
    OWNER to root;

-- Table: public.historias_clinicas

-- DROP TABLE IF EXISTS public.historias_clinicas;

CREATE TABLE IF NOT EXISTS public.historias_clinicas
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9999 CACHE 1 ),
    mascota_id integer,
    fecha_creacion date,
    CONSTRAINT pk_historias_clinica_id PRIMARY KEY (id),
    CONSTRAINT fk_mascota_id FOREIGN KEY (mascota_id)
    REFERENCES public.mascotas (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.historias_clinicas
    OWNER to root;



-- Table: public.colaboradores

-- DROP TABLE IF EXISTS public.colaboradores;

CREATE TABLE IF NOT EXISTS public.colaboradores
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9999 CACHE 1 ),
    nombre character varying(255) COLLATE pg_catalog."default",
    apellido character varying(255) COLLATE pg_catalog."default",
    cargo character varying(255) COLLATE pg_catalog."default",
    especialidad character varying(255) COLLATE pg_catalog."default",
    tipo_documento character varying(3) COLLATE pg_catalog."default",
    documento_identificacion integer,
    CONSTRAINT pk_colaborador_id PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.colaboradores
    OWNER to root;



-- Table: public.detalles_historias_clinicas

-- DROP TABLE IF EXISTS public.detalles_historias_clinicas;

-- Table: public.detalles_historias_clinicas

-- DROP TABLE IF EXISTS public.detalles_historias_clinicas;

CREATE TABLE IF NOT EXISTS public.detalles_historias_clinicas
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9999 CACHE 1 ),
    temperatura character varying(255) COLLATE pg_catalog."default",
    peso real,
    frecuencia_cardiaca real,
    frecuencia_respiratoria real,
    fecha_hora timestamp without time zone,
    alimentacion character varying(255) COLLATE pg_catalog."default",
    habitad character varying(255) COLLATE pg_catalog."default",
    observacion character varying(255) COLLATE pg_catalog."default",
    colaborador_id integer,
    historia_clinica_id integer,
    CONSTRAINT pk_detalles_historias_clinicas_id PRIMARY KEY (id),
    CONSTRAINT fk_colaborador_id FOREIGN KEY (colaborador_id)
    REFERENCES public.colaboradores (id) MATCH SIMPLE
                         ON UPDATE NO ACTION
                         ON DELETE NO ACTION
    NOT VALID,
    CONSTRAINT fk_detalle_historia_clinica_id FOREIGN KEY (historia_clinica_id)
    REFERENCES public.historias_clinicas (id) MATCH SIMPLE
                         ON UPDATE NO ACTION
                         ON DELETE NO ACTION
    NOT VALID
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detalles_historias_clinicas
    OWNER to root;
