alter table if exists monicet_address drop constraint if exists fk_monicet_address_zip_code_id;
drop index if exists ix_monicet_address_zip_code_id;

alter table if exists monicet_boat drop constraint if exists fk_monicet_boat_company_id;
drop index if exists ix_monicet_boat_company_id;

alter table if exists monicet_district drop constraint if exists fk_monicet_district_country_id;
drop index if exists ix_monicet_district_country_id;

alter table if exists issuer_token drop constraint if exists fk_issuer_token_application_user_id;
drop index if exists ix_issuer_token_application_user_id;

alter table if exists monicet_locality drop constraint if exists fk_monicet_locality_municipality_id;
drop index if exists ix_monicet_locality_municipality_id;

alter table if exists monicet_municipality drop constraint if exists fk_monicet_municipality_district_id;
drop index if exists ix_monicet_municipality_district_id;

alter table if exists monicet_parish drop constraint if exists fk_monicet_parish_municipality_id;
drop index if exists ix_monicet_parish_municipality_id;

alter table if exists monicet_person drop constraint if exists fk_monicet_person_company_id;
drop index if exists ix_monicet_person_company_id;

alter table if exists monicet_person drop constraint if exists fk_monicet_person_user_id;

alter table if exists skippercompany drop constraint if exists fk_skippercompany_monicet_person;
drop index if exists ix_skippercompany_monicet_person;

alter table if exists skippercompany drop constraint if exists fk_skippercompany_monicet_company;
drop index if exists ix_skippercompany_monicet_company;

alter table if exists watchmancompany drop constraint if exists fk_watchmancompany_monicet_person;
drop index if exists ix_watchmancompany_monicet_person;

alter table if exists watchmancompany drop constraint if exists fk_watchmancompany_monicet_company;
drop index if exists ix_watchmancompany_monicet_company;

alter table if exists guidecompany drop constraint if exists fk_guidecompany_monicet_person;
drop index if exists ix_guidecompany_monicet_person;

alter table if exists guidecompany drop constraint if exists fk_guidecompany_monicet_company;
drop index if exists ix_guidecompany_monicet_company;

alter table if exists roles drop constraint if exists fk_roles_application_user_id;
drop index if exists ix_roles_application_user_id;

alter table if exists monicet_zip_code drop constraint if exists fk_monicet_zip_code_locality_id;
drop index if exists ix_monicet_zip_code_locality_id;

drop table if exists monicet_address cascade;

drop table if exists monicet_user cascade;

drop table if exists monicet_boat cascade;

drop table if exists monicet_company cascade;

drop table if exists monicet_country cascade;

drop table if exists monicet_district cascade;

drop table if exists issuer_token cascade;

drop table if exists monicet_locality cascade;

drop table if exists monicet_municipality cascade;

drop table if exists monicet_parish cascade;

drop table if exists monicet_person cascade;

drop table if exists skippercompany cascade;

drop table if exists watchmancompany cascade;

drop table if exists guidecompany cascade;

drop table if exists roles cascade;

drop table if exists monicet_zip_code cascade;

drop index if exists ix_monicet_user_email;
drop index if exists ix_monicet_company_name;
drop index if exists ix_monicet_company_email;
drop index if exists ix_monicet_country_acronym3;
