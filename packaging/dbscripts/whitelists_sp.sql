

----------------------------------------------------------------
-- [whitelists] Table
--

------------------------------------
-- Inserts whitelist entity into whitelists table
------------------------------------
CREATE OR REPLACE FUNCTION InsertWhitelist (
    v_whitelist_id UUID,
    v_description TEXT,
    v_user_name TEXT,
    v_ip_address TEXT,
    v_registration_time TIMESTAMP WITH TIME ZONE
    )
RETURNS VOID AS $PROCEDURE$
BEGIN
    INSERT INTO whitelists (
        whitelist_id,
        description,
        user_name,
        ip_address,
        registration_time
        )
    VALUES (
        v_whitelist_id,
        v_description,
        v_user_name,
        v_ip_address,
        v_registration_time
        );
END;$PROCEDURE$
LANGUAGE plpgsql;

------------------------------------
-- Updates whitelist entity in whitelists table
------------------------------------
CREATE OR REPLACE FUNCTION UpdateWhitelist (
    v_whitelist_id UUID,
    v_description TEXT,
    v_user_name TEXT,
    v_ip_address TEXT,
    v_registration_time TIMESTAMP WITH TIME ZONE
    )
RETURNS VOID AS $PROCEDURE$
BEGIN
    UPDATE whitelists
    SET whitelist_id = v_whitelist_id,
        description = v_description,
        user_name = v_user_name,
        ip_address = v_ip_address,
        registration_time = v_registration_time
    WHERE whitelist_id = v_whitelist_id;
END;$PROCEDURE$
LANGUAGE plpgsql;

--------------------------------------------
-- Deletes whitelist entity by whitelist_id
--------------------------------------------
CREATE OR REPLACE FUNCTION DeleteWhitelist (v_whitelist_id UUID)
RETURNS VOID AS $PROCEDURE$
BEGIN
    DELETE
    FROM whitelists
    WHERE whitelist_id = v_whitelist_id;
END;$PROCEDURE$
LANGUAGE plpgsql;

----------------------------------------------------
-- Retrieves whitelist entity by its whitelist_id from whitelists table
----------------------------------------------------
CREATE OR REPLACE FUNCTION GetWhitelistByWhitelistId (v_whitelist_id UUID)
RETURNS SETOF whitelists STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT whitelists.*
    FROM whitelists
    WHERE whitelist_id = v_whitelist_id;
END;$PROCEDURE$
LANGUAGE plpgsql;

----------------------------------------------------
-- Retrieves whitelist entity by its whitelist_id from whitelists table
----------------------------------------------------
CREATE OR REPLACE FUNCTION GetWhitelistByIpAddress (v_ip_address TEXT)
RETURNS SETOF whitelists STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT whitelists.*
    FROM whitelists
    WHERE ip_address = v_ip_address;
END;$PROCEDURE$
LANGUAGE plpgsql;

--------------------------------------------
-- Retrieves all whitelist entitise from whitelists table
--------------------------------------------
CREATE OR REPLACE FUNCTION GetAllWhitelists ()
RETURNS SETOF whitelists STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT whitelists.*
    FROM whitelists
    WHERE status != 'UNKNOWN'
    ORDER BY registration_time DESC;
END;$PROCEDURE$
LANGUAGE plpgsql;

