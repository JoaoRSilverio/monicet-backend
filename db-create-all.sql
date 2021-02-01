create table monicet_address (
  id                            bigserial not null,
  street                        varchar(255),
  number                        varchar(255),
  zip_code_id                   bigint,
  constraint pk_monicet_address primary key (id)
);

create table monicet_user (
  id                            bigserial not null,
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_monicet_user primary key (id)
);

create table monicet_company (
  id                            bigserial not null,
  name                          varchar(255),
  email                         varchar(255),
  constraint pk_monicet_company primary key (id)
);

create table monicet_country (
  id                            bigserial not null,
  acronym3                      varchar(255),
  acronym2                      varchar(255),
  name                          json,
  nationality                   json,
  constraint pk_monicet_country primary key (id)
);

create table monicet_district (
  id                            bigserial not null,
  code                          varchar(255),
  name                          varchar(255),
  country_id                    bigint not null,
  constraint pk_monicet_district primary key (id)
);

create table issuer_token (
  id                            bigserial not null,
  application_user_id           bigint,
  issuer                        varchar(255),
  constraint pk_issuer_token primary key (id)
);

create table monicet_locality (
  id                            bigserial not null,
  code                          varchar(255),
  name                          varchar(255),
  municipality_id               bigint not null,
  constraint pk_monicet_locality primary key (id)
);

create table monicet_municipality (
  id                            bigserial not null,
  code                          varchar(255),
  name                          varchar(255),
  district_id                   bigint not null,
  constraint pk_monicet_municipality primary key (id)
);

create table monicet_parish (
  id                            bigserial not null,
  code                          varchar(255),
  name                          varchar(255),
  municipality_id               bigint not null,
  constraint pk_monicet_parish primary key (id)
);

create table monicet_person (
  id                            bigserial not null,
  name                          varchar(255),
  first_name                    varchar(255),
  last_name                     varchar(255),
  occupation                    varchar(255),
  company_id                    bigint,
  user_id                       bigint,
  constraint uq_monicet_person_user_id unique (user_id),
  constraint pk_monicet_person primary key (id)
);

create table roles (
  id                            bigserial not null,
  application_user_id           bigint not null,
  name                          varchar(20),
  constraint ck_roles_name check ( name in ('USER','COLLABORATOR','WATCHTOWER','MANAGER','ADMIN','SUPER_ADMIN')),
  constraint pk_roles primary key (id)
);

create table monicet_zip_code (
  id                            bigserial not null,
  code                          varchar(255),
  locality_id                   bigint not null,
  constraint pk_monicet_zip_code primary key (id)
);

create index ix_monicet_user_email on monicet_user (email);
create index ix_monicet_company_name on monicet_company (name);
create index ix_monicet_company_email on monicet_company (email);
create index ix_monicet_country_acronym3 on monicet_country (acronym3);
alter table monicet_address add constraint fk_monicet_address_zip_code_id foreign key (zip_code_id) references monicet_zip_code (id) on delete restrict on update restrict;
create index ix_monicet_address_zip_code_id on monicet_address (zip_code_id);

alter table monicet_district add constraint fk_monicet_district_country_id foreign key (country_id) references monicet_country (id) on delete restrict on update restrict;
create index ix_monicet_district_country_id on monicet_district (country_id);

alter table issuer_token add constraint fk_issuer_token_application_user_id foreign key (application_user_id) references monicet_user (id) on delete restrict on update restrict;
create index ix_issuer_token_application_user_id on issuer_token (application_user_id);

alter table monicet_locality add constraint fk_monicet_locality_municipality_id foreign key (municipality_id) references monicet_municipality (id) on delete restrict on update restrict;
create index ix_monicet_locality_municipality_id on monicet_locality (municipality_id);

alter table monicet_municipality add constraint fk_monicet_municipality_district_id foreign key (district_id) references monicet_district (id) on delete restrict on update restrict;
create index ix_monicet_municipality_district_id on monicet_municipality (district_id);

alter table monicet_parish add constraint fk_monicet_parish_municipality_id foreign key (municipality_id) references monicet_municipality (id) on delete restrict on update restrict;
create index ix_monicet_parish_municipality_id on monicet_parish (municipality_id);

alter table monicet_person add constraint fk_monicet_person_company_id foreign key (company_id) references monicet_company (id) on delete restrict on update restrict;
create index ix_monicet_person_company_id on monicet_person (company_id);

alter table monicet_person add constraint fk_monicet_person_user_id foreign key (user_id) references monicet_user (id) on delete restrict on update restrict;

alter table roles add constraint fk_roles_application_user_id foreign key (application_user_id) references monicet_user (id) on delete restrict on update restrict;
create index ix_roles_application_user_id on roles (application_user_id);

alter table monicet_zip_code add constraint fk_monicet_zip_code_locality_id foreign key (locality_id) references monicet_locality (id) on delete restrict on update restrict;
create index ix_monicet_zip_code_locality_id on monicet_zip_code (locality_id);

