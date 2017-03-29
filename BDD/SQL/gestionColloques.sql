-- Ce fichier contient le script destiné à créer la base de données le schéma "gestionColloques".

\echo [INFO] Début du script

-- Suppression du schéma gestionColloques
\echo Suppression du schéma 
DROP SCHEMA IF EXISTS gestionColloques CASCADE;

-- Création du schéma gestionColloques
\echo Création du Schéma
CREATE SCHEMA gestionColloques;

-- Suppression du domaine email
\echo [INFO] Suppression du domaine email
DROP DOMAIN IF EXISTS email;

-- Création du domaine email
\echo [INFO] Création du domaine email avec des regex
CREATE DOMAIN email AS VARCHAR(50) CHECK (value ~* E'^[a-z][a-z0-9_-]+\.?[a-z0-9_-]+@[a-z0-9_-]+\.[a-z]{2,4}$');

-- Création de la table gestionColloques.participants
\echo Creation de la table participants;
CREATE TABLE gestionColloques.participants(
	num_pers SERIAL,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	email email UNIQUE NOT NULL,
	date_naiss DATE NOT NULL CONSTRAINT ck_gestionColloques_date_naissance CHECK (date_part('year', CURRENT_DATE) - date_part('year', date_naiss) >= 18),
	organisation VARCHAR(50) NOT NULL,
	observation VARCHAR(300) DEFAULT 'non défini',
	PRIMARY KEY(num_pers)
);

-- Création de la table gestionColloques.salle
\echo Création de la table gestionColloques.salle
CREATE TABLE gestionColloques.salle(
	num_salle SERIAL,
	nom VARCHAR(50) NOT NULL,
	capacite INTEGER NOT NULL DEFAULT 0 CONSTRAINT ck_gestionColloques_capacite CHECK(capacite>=0),
	description TEXT,
	PRIMARY KEY (num_salle)
);

-- Création de la table gestionColloques.evenement
\echo Création de la table gestionColloques.evenement
CREATE TABLE gestionColloques.evenement(
	num_event SERIAL,
	libelle VARCHAR(50) NOT NULL,
	theme VARCHAR(50) NOT NULL,
	date_debut DATE CONSTRAINT ck_gestionColloques_date_debut CHECK(date_debut > CURRENT_DATE) NOT NULL,
	date_fin DATE CONSTRAINT ck_gestionColloques_date_fin CHECK(date_fin > CURRENT_DATE) NOT NULL,
	duree SMALLINT CONSTRAINT ck_gestionColloques_duree CHECK(duree BETWEEN 0 AND 10) NOT NULL,
	nb_participant_max INTEGER DEFAULT 0 CONSTRAINT ck_gestionColloques_nb_participant_max CHECK(nb_participant_max >= 0),
	description TEXT,
	organisateur VARCHAR(50) DEFAULT 'inconnu',
	type_event VARCHAR(50),
	etat VARCHAR(10) NOT NULL DEFAULT 'À venir' CONSTRAINT ck_gestionColloques_etat CHECK(etat IN ('À venir', 'En cours','Terminé')),
	num_salle INTEGER,
	CONSTRAINT ck_gestionColloques_date_fin_2 CHECK(date_fin >= date_debut),
	PRIMARY KEY(num_event)
);

-- Création de la table gestionColloques.evenement
\echo Création de la table participe_a_evenement;
CREATE TABLE gestionColloques.participe_a_evenement(
	num_event INTEGER,
	num_pers INTEGER,
	hebergement BOOLEAN NOT NULL,
	restauration BOOLEAN NOT NULL,
	PRIMARY KEY(num_event,num_pers)
);

-- Création de la table gestionColloques.utilisateur
\echo Création de la table gestionColloques.utilisateur
CREATE TABLE gestionColloques.utilisateur(
	id SERIAL,
	identifiant VARCHAR(50) NOT NULL UNIQUE,
	pass VARCHAR(50) NOT NULL,
	rang SMALLINT CONSTRAINT ck_gestionColloques_rang CHECK (rang BETWEEN 1 AND 2) DEFAULT 1,
	PRIMARY KEY(id)
);

-- Modification de la table gestionColloques.evenement
\echo [INFO] Ajout des contraintes sur la table gestionColloques.evenement
ALTER TABLE gestionColloques.evenement
	ADD CONSTRAINT fk_num_salle FOREIGN KEY(num_salle) REFERENCES gestionColloques.salle(num_salle) ON UPDATE CASCADE ON DELETE CASCADE;

-- Modification de la table gestionColloques.participe_a_evenement
\echo [INFO] Ajout des contraintes sur la table gestionColloques.participe_a_evenement
ALTER TABLE gestionColloques.participe_a_evenement
	ADD CONSTRAINT fk_num_event FOREIGN KEY(num_event) REFERENCES gestionColloques.evenement(num_event) ON UPDATE CASCADE ON DELETE CASCADE,
	ADD CONSTRAINT fk_num_pers FOREIGN KEY(num_pers) REFERENCES gestionColloques.participants(num_pers) ON UPDATE CASCADE ON DELETE CASCADE;

\echo Fin du script
