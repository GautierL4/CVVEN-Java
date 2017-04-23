-- Ce script permet d'accorder les droits aux utilisateurs définis de la base de données.
DO
$body$
BEGIN
	IF NOT EXISTS (SELECT * FROM pg_user WHERE usename = 'glaurent') THEN
    	CREATE USER glaurent WITH password'infinity';
    END IF;
    IF NOT EXISTS (SELECT * FROM pg_user WHERE usename = 'fwassen') THEN
    	CREATE USER fwassen WITH password'infinity';
    END IF;
    IF NOT EXISTS (SELECT * FROM pg_user WHERE usename = 'mmoreira') THEN
    	CREATE USER mmoreira WITH password'infinity';
    END IF;
   	IF NOT EXISTS (SELECT * FROM pg_user WHERE usename = 'clukombo') THEN
    	CREATE USER clukombo WITH password'infinity';	
    END IF;
END
$body$;

\echo [INFO] droits accordés
GRANT ALL PRIVILEGES ON SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT SELECT,INSERT,UPDATE,DELETE ON ALL TABLES IN SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA gestionColloques TO glaurent,fwassen,mmoreira,clukombo;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO glaurent,fwassen,mmoreira,clukombo;