


create table batch_job_instance
(
    job_instance_id bigint       not null
        primary key,
    version         bigint,
    job_name        varchar(100) not null,
    job_key         varchar(32)  not null,
    constraint job_inst_un
        unique (job_name, job_key)
);


create table batch_job_execution
(
    job_execution_id bigint    not null
        primary key,
    version          bigint,
    job_instance_id  bigint    not null
        constraint job_inst_exec_fk
            references batch_job_instance,
    create_time      timestamp not null,
    start_time       timestamp,
    end_time         timestamp,
    status           varchar(10),
    exit_code        varchar(2500),
    exit_message     varchar(2500),
    last_updated     timestamp
);


create table batch_job_execution_params
(
    job_execution_id bigint       not null
        constraint job_exec_params_fk
            references batch_job_execution,
    parameter_name   varchar(100) not null,
    parameter_type   varchar(100) not null,
    parameter_value  varchar(2500),
    identifying      char         not null
);


create table batch_step_execution
(
    step_execution_id  bigint       not null
        primary key,
    version            bigint       not null,
    step_name          varchar(100) not null,
    job_execution_id   bigint       not null
        constraint job_exec_step_fk
            references batch_job_execution,
    create_time        timestamp    not null,
    start_time         timestamp,
    end_time           timestamp,
    status             varchar(10),
    commit_count       bigint,
    read_count         bigint,
    filter_count       bigint,
    write_count        bigint,
    read_skip_count    bigint,
    write_skip_count   bigint,
    process_skip_count bigint,
    rollback_count     bigint,
    exit_code          varchar(2500),
    exit_message       varchar(2500),
    last_updated       timestamp
);


create table batch_step_execution_context
(
    step_execution_id  bigint        not null
        primary key
        constraint step_exec_ctx_fk
            references batch_step_execution,
    short_context      varchar(2500) not null,
    serialized_context text
);


create table batch_job_execution_context
(
    job_execution_id   bigint        not null
        primary key
        constraint job_exec_ctx_fk
            references batch_job_execution,
    short_context      varchar(2500) not null,
    serialized_context text
);


create table _user
(
    id        bigint not null
        primary key,
    email     varchar(255)
        constraint uk_k11y3pdtsrjgy8w9b6q4bjwrx
            unique,
    firstname varchar(255),
    lastname  varchar(255),
    password  varchar(255),
    role      varchar(255)
        constraint _user_role_check
            check ((role)::text = ANY ((ARRAY ['ADMIN'::character varying, 'USER'::character varying])::text[]))
);


create table arrete_de_caisse
(
    id             bigserial
        primary key,
    total_EnteteAchat    numeric(38, 2),
    total_benefice numeric(38, 2),
    total_depense  numeric(38, 2),
    total_vente    numeric(38, 2)
);


create table caisse
(
    id              bigserial
        primary key,
    difference      numeric(38, 2),
    solde_de_caisse numeric(38, 2),
    total_EnteteAchats    numeric(38, 2),
    total_depenses  numeric(38, 2),
    total_ventes    numeric(38, 2)
);



create table client
(
    id        bigint not null
        primary key,
    adresse   varchar(255),
    email     varchar(255),
    nom       varchar(255),
    prenom    varchar(255),
    telephone varchar(255)
);



create table entete_fact
(
    id             bigserial primary key,
    created_date   timestamp(6),
    date_facture   timestamp(6),
    mode_paiement  smallint
        constraint entete_fact_mode_paiement_check
            check ((mode_paiement >= 0) AND (mode_paiement <= 3)),
    numero_facture bigint,
    statut         smallint
        constraint entete_fact_statut_check
            check ((statut >= 0) AND (statut <= 2)),
    total_facture  numeric(38, 2),
    client_id      bigint REFERENCES client
);


CREATE TABLE client_entete_facts
(
    client_id       BIGINT NOT NULL REFERENCES client,
    entete_facts_id BIGINT NOT NULL UNIQUE REFERENCES entete_fact
);



create table fournisseur
(
    id                  bigserial
        primary key,
    adresse             varchar(255),
    email               varchar(255),
    info_supplementaire varchar(255),
    nom                 varchar(255),
    telephone           varchar(255)
);



CREATE TABLE EnteteAchat
(
    id             BIGSERIAL PRIMARY KEY,
    date_EnteteAchat     DATE,
    status_EnteteAchat   SMALLINT CHECK (status_EnteteAchat >= 0 AND status_EnteteAchat <= 2),
    total_EnteteAchat    NUMERIC(38, 2),
    fournisseur_id BIGINT REFERENCES fournisseur
);


create table produit
(
    id            bigserial
        primary key,
    description   varchar(255),
    designation   varchar(255),
    prix_unitaire numeric(38, 2),
    quantite      integer not null
);



CREATE TABLE det_facture
(
    id                        BIGSERIAL PRIMARY KEY,
    montant_total_par_produit NUMERIC(38, 2),
    prix_unitaire             NUMERIC(38, 2),
    quantite                  BIGINT,
    facture_id                BIGINT REFERENCES entete_fact,
    produit_id                BIGINT REFERENCES produit
);


CREATE TABLE det_EnteteAchat
(
    id              BIGSERIAL PRIMARY KEY,
    prix_unitaire   DOUBLE PRECISION NOT NULL,
    quantite_achete INTEGER NOT NULL,
    EnteteAchat_id        BIGINT REFERENCES EnteteAchat,
    produit_id      BIGINT REFERENCES produit
);

CREATE TABLE entete_fact_det_factures
(
    entete_fact_id  BIGINT NOT NULL REFERENCES entete_fact,
    det_factures_id BIGINT NOT NULL UNIQUE REFERENCES det_facture
);

CREATE TABLE refresh_token
(
    id          BIGINT PRIMARY KEY,
    expiry_date TIMESTAMP WITH TIME ZONE NOT NULL,
    revoked     BOOLEAN NOT NULL,
    token       VARCHAR(255) NOT NULL UNIQUE,
    user_id     BIGINT REFERENCES _user
);

create table statistique
(
    id bigserial
        primary key
);


create table vente
(
    id bigserial
        primary key
);



