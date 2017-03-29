-- Ce script permet d'accorder les droits aux utilisateurs définis de la base de données.

\echo [INFO] droits accordés
GRANT ALL PRIVILEGES ON SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT SELECT,INSERT,UPDATE,DELETE ON ALL TABLES IN SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO glaurent,fwassen,mmoreira,clukombo;