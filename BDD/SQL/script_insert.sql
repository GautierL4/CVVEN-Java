-- Ce script permet d'insérer les données dans la base de données du schéma gestionColloques.

\echo [INFO] Insertion dans la table gestionColloques.participants
-- Insertion dans la table gestionColloques.participants

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Dupond','Daniel','dupond.daniel@gmail.com','1998-11-12','tortutle','bien');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation) 
VALUES(DEFAULT,'Delacrue','Jean','delacrue.jean@hotmail.fr','1950-01-03','ldlc','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Bosc','Denis','bdenis@yahoo.fr','1983-04-25','microsoft','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Vadeleux','Bertrand','adeleux.bertrand@sfr.fr','1974-09-16','facebook','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Arrouas','Henry','arrouas.henry@gmail.com','1971-06-05','facebook','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Leroux','Germain','leroux.germain@hotmail.com','1960-05-05','twitter','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Meynier','Ghislaine','meynier.ghislaine@wanadoo.com','1962-08-02','twitter','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Holtz','Jean-Jacques','holtz.jean@hotmail.com','1960-02-02','twitter','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Lorenz','Bernhard','lorenz.bernhard@yahoo.de','1955-09-05','orange','aucune');

INSERT INTO gestionColloques.participants(num_pers,nom,prenom,email,date_naiss,organisation,observation)
VALUES(DEFAULT,'Calquier','Laurence','calquier.laurence@hotmail.fr','1980-03-31','auchan','aucune');

\echo [INFO] Insertion dans la table gestionColloques.salle
-- Insertion dans la table gestionColloques.salle
INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description)
VALUES(DEFAULT,'301',200,'Belle salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description)
VALUES(DEFAULT,'md4',800,'Vaste salle avec chauffage');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description)
VALUES(DEFAULT,'303',650,'Salle confortable');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'212',100,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'322',40,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'129',200,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'122',150,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'127',460,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'121',100,'Bonne salle');

INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) 
VALUES(DEFAULT,'102',700,'Bonne salle');


\echo [INFO] Insertion dans la table gestionColloques.evenement
 -- Insertion dans la table gestionColloques.evenement

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'fete mania','danse','2018-10-10','2018-10-10',1,5,'Tess','mus','normal','À venir',1);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Cyber The','danse','2017-08-16','2017-08-17',1,6,'Maria','fête','pleine','À venir',2);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Confere chirurgie','chirurgie','2017-12-16','2017-12-17',1,2,'David','conference','pleine','À venir',3);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Ballon d''or','Football','2017-09-01','2017-09-01',1,5,'John','annonce pour le nouveau titre','presque plein','À venir',4);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Fête','Musique','2017-09-01','2017-09-01',1,5,'Patrick','','presque plein','À venir',5);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Meetting','Politique','2017-09-01','2017-09-01',1,5,'Ghilas','annonce pour le nouveau titre','presque plein','À venir',6);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Reunion','annonce','2017-09-01','2017-09-03',1,5,'Victor','annonce pour le nouveau titre','presque plein','À venir',7);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Cérémonie','Football','2017-09-01','2017-09-06',1,5,'Jonathan','annonce pour le nouveau titre','presque plein','À venir',8);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Oscar','Musique','2017-09-01','2017-09-06',1,5,'Eddy','annonce pour le nouveau titre','presque plein','À venir',9);

INSERT INTO gestionColloques.evenement(num_event,libelle,theme,date_debut,date_fin,duree,nb_participant_max,organisateur,description,type_event,etat,num_salle) 
VALUES(DEFAULT,'Star Academie','Seminaire','2017-12-01','2017-12-02',1,5,'Arthur','annonce pour le nouveau titre','presque plein','À venir',10);

\echo [INFO] Insertion dans la table gestionColloques.participe_a_evenement
 -- Insertion dans la table gestionColloques.participe_a_evenement

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(1,1,TRUE,TRUE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(2,3,TRUE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(4,2,FALSE,TRUE);
--
INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(1,4,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(2,4,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(8,4,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(3,5,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(6,4,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(7,4,FALSE,FALSE);

INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) 
VALUES(3,4,FALSE,FALSE);

\echo [INFO] Insertion dans la table gestionColloques.utilisateur
 -- Insertion dans la table gestionColloques.utilisateur

INSERT INTO gestionColloques.utilisateur(id,identifiant,pass,rang) 
VALUES(DEFAULT,'daniel5',md5('toto123'),1);

INSERT INTO gestionColloques.utilisateur(id,identifiant,pass,rang) 
VALUES(DEFAULT,'marie7',md5('marie?Z7'),1);
