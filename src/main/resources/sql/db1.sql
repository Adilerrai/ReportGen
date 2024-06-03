create table databasechangelog
(
    id            varchar(255) not null,
    author        varchar(255) not null,
    filename      varchar(255) not null,
    dateexecuted  timestamp    not null,
    orderexecuted integer      not null,
    exectype      varchar(10)  not null,
    md5sum        varchar(35),
    description   varchar(255),
    comments      varchar(255),
    tag           varchar(255),
    liquibase     varchar(20),
    contexts      varchar(255),
    labels        varchar(255),
    deployment_id varchar(10)
);

alter table databasechangelog
    owner to postgres;

create table databasechangeloglock
(
    id          integer not null  primary key,
    locked      boolean not null,
    lockgranted timestamp,
    lockedby    varchar(255)
);

alter table databasechangeloglock
    owner to postgres;

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

alter table batch_job_instance
    owner to postgres;

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

alter table batch_job_execution
    owner to postgres;

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

alter table batch_job_execution_params
    owner to postgres;

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

alter table batch_step_execution
    owner to postgres;

create table batch_step_execution_context
(
    step_execution_id  bigint        not null
        primary key
        constraint step_exec_ctx_fk
            references batch_step_execution,
    short_context      varchar(2500) not null,
    serialized_context text
);

alter table batch_step_execution_context
    owner to postgres;

create table batch_job_execution_context
(
    job_execution_id   bigint        not null
        primary key
        constraint job_exec_ctx_fk
            references batch_job_execution,
    short_context      varchar(2500) not null,
    serialized_context text
);

alter table batch_job_execution_context
    owner to postgres;

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

alter table _user
    owner to postgres;

create table arrete_de_caisse
(
    id             bigserial
        primary key,
    total_achat    numeric(38, 2),
    total_benefice numeric(38, 2),
    total_depense  numeric(38, 2),
    total_vente    numeric(38, 2)
);

alter table arrete_de_caisse
    owner to postgres;

create table caisse
(
    id              bigserial
        primary key,
    difference      numeric(38, 2),
    solde_de_caisse numeric(38, 2),
    total_achats    numeric(38, 2),
    total_depenses  numeric(38, 2),
    total_ventes    numeric(38, 2)
);

alter table caisse
    owner to postgres;

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

alter table client
    owner to postgres;

create table entete_fact
(
    id             bigserial
        primary key,
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
    client_id      bigint
        constraint fkjb85juksg867j934jdr270rd4
            references client
);

alter table entete_fact
    owner to postgres;

create table client_entete_facts
(
    client_id       bigint not null
        constraint fk4m6r1isygtmnc9t247pdh4kta
            references client,
    entete_facts_id bigint not null
        constraint uk_lwnv0efiv09gir2rld1ly86fq
            unique
        constraint fklarok3cb5j3tg9ioo92e40vao
            references entete_fact
);

alter table client_entete_facts
    owner to postgres;

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

alter table fournisseur
    owner to postgres;

create table achat
(
    id             bigserial
        primary key,
    date_achat     date,
    status_achat   smallint
        constraint achat_status_achat_check
            check ((status_achat >= 0) AND (status_achat <= 2)),
    total_achat    numeric(38, 2),
    fournisseur_id bigint
        constraint fkqd7fqvaymdyjlcnmm24qtc70o
            references fournisseur
);

alter table achat
    owner to postgres;

create table produit
(
    id            bigserial
        primary key,
    description   varchar(255),
    designation   varchar(255),
    prix_unitaire numeric(38, 2),
    quantite      integer not null
);

alter table produit
    owner to postgres;

create table det_facture
(
    id                        bigserial
        primary key,
    montant_total_par_produit numeric(38, 2),
    prix_unitaire             numeric(38, 2),
    quantite                  bigint,
    facture_id                bigint
        constraint fkh3qsk1yh48wb9e6yheofa3t7b
            references entete_fact,
    produit_id                bigint
        constraint fk67m3g8tgnsau0mkfcoc7r4ujb
            references produit
);

alter table det_facture
    owner to postgres;

create table det_achat
(
    id              bigserial
        primary key,
    prix_unitaire   double precision not null,
    quantite_achete integer          not null,
    achat_id        bigint
        constraint fke2vab0g5weyva4fnv6k33bugc
            references achat,
    produit_id      bigint
        constraint fkkg8og6ieqrhcki1mt6uq23tyy
            references produit
);

alter table det_achat
    owner to postgres;

create table entete_fact_det_factures
(
    entete_fact_id  bigint not null
        constraint fk19g57uht1lb5b2wr5q9kuyiwv
            references entete_fact,
    det_factures_id bigint not null
        constraint uk_fqdgnfws481838v5cwdy7f3hj
            unique
        constraint fk6ag1bmlqsau3gdur6ybag18xu
            references det_facture
);

alter table entete_fact_det_factures
    owner to postgres;

create table refresh_token
(
    id          bigint                      not null
        primary key,
    expiry_date timestamp(6) with time zone not null,
    revoked     boolean                     not null,
    token       varchar(255)                not null
        constraint uk_r4k4edos30bx9neoq81mdvwph
            unique,
    user_id     bigint
        constraint fkbws85up72jgwebb6ttkjiytg3
            references _user
);

alter table refresh_token
    owner to postgres;

create table statistique
(
    id bigserial
        primary key
);

alter table statistique
    owner to postgres;

create table vente
(
    id bigserial
        primary key
);

alter table vente
    owner to postgres;

