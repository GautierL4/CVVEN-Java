-- Ce script contient l'ensemble des procédures du schéma de la base de données "gestioncolloques".


/*
 * Ce trigger permet de contrôler le nombre de participant en fonction de la salle.
 * Si le nombre de participant excéde la capacité de la salle, on léve une exception.
 */

\echo [INFO] Création de la fonction controler_nombre_participants

CREATE OR REPLACE FUNCTION controler_nombre_participants() RETURNS TRIGGER AS $$
 DECLARE 
 	un_evenement RECORD;
BEGIN
 	SELECT INTO un_evenement * FROM gestioncolloques.evenement e INNER JOIN gestioncolloques.salle s ON e.num_salle = s.num_salle;
 	IF((un_evenement.nb_participant_max + NEW.nb_participant_max) > un_evenement.capacite) THEN -- Si le nombre de participants n'est pas conforme
 		RAISE EXCEPTION 'Erreur le nombre de participants excéde la capacité de la salle.';		 -- On lève une exception.
 	END IF;
 	RETURN NEW;
 END;
 $$ LANGUAGE PLPGSQL;

\echo [INFO] Création du trigger controler_nombre_participants

CREATE TRIGGER controler_nombre_participants 
BEFORE INSERT OR UPDATE
ON gestioncolloques.evenement
FOR EACH ROW
EXECUTE PROCEDURE controler_nombre_participants();


/*
 *Ce trigger permet d'insérer un participant dans la table utilisateur en lui attribuant un login et mot de passe par défaut.
 */

\echo [INFO] Création de la fonction creation_utilisateur

CREATE OR REPLACE FUNCTION creation_utilisateur() RETURNS TRIGGER AS $$
DECLARE 
	un_identifiant VARCHAR;
BEGIN
	PERFORM * FROM gestioncolloques.participants WHERE num_pers = NEW.num_pers;
	IF(FOUND) THEN -- On insére un nouveau participant.
		un_identifiant := LOWER(SUBSTR(NEW.prenom,0,2)) || LOWER(NEW.nom);
		INSERT INTO gestionColloques.utilisateur(id,identifiant,pass,rang) VALUES(DEFAULT,un_identifiant,md5('bienvenue!'),1);
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE PLPGSQL;

\echo [INFO] Création du trigger creation_utilisateur

CREATE TRIGGER creation_utilisateur
AFTER INSERT
ON gestioncolloques.participants
FOR EACH ROW EXECUTE PROCEDURE creation_utilisateur();

 /*
 * Ce trigger permet de contrôler que des événements ne peuvent avoir lieu dans la même salle et en même temps.
 */

\echo [INFO] Création de la fonction controler_conformite

CREATE OR REPLACE FUNCTION controler_conformite() RETURNS TRIGGER AS $$
BEGIN
	PERFORM * FROM gestioncolloques.evenement WHERE (date_debut >= NEW.date_debut AND date_fin <= NEW.date_fin) AND num_salle = NEW.num_salle;
	IF (FOUND) THEN 
		RAISE EXCEPTION 'L''insertion de l''événement ne peut se faire, car un évenement est déjà attribué à la salle.';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE PLPGSQL;

\echo [INFO] Création du trigger controler_conformite

CREATE TRIGGER controler_conformite
BEFORE INSERT
ON gestioncolloques.evenement
FOR EACH ROW EXECUTE PROCEDURE controler_conformite();
