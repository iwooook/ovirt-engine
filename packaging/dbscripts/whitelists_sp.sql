

----------------------------------------------------------------
-- [whitelists] Table
--
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
        ip_address = v_ip_address
        registration_time = v_registration_time
    WHERE whitelist_id = v_whitelist_id;
END;$PROCEDURE$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION DeleteWhitelist (v_whitelist_id UUID)
RETURNS VOID AS $PROCEDURE$
BEGIN
    DELETE
    FROM whitelists
    WHERE whitelist_id = v_whitelist_id;
END;$PROCEDURE$
LANGUAGE plpgsql;

/*
CREATE OR REPLACE FUNCTION GetAllFromWhitelists ()
RETURNS SETOF user_profiles_view STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT user_profiles_view.*
    FROM user_profiles_view;
END;$PROCEDURE$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION GetAllFromWhitelists (v_user_id UUID)
RETURNS SETOF user_profiles_view STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT *
    FROM user_profiles_view
    WHERE user_id = v_user_id;
END;$PROCEDURE$
LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION GetUserProfileByProfileId (v_profile_id UUID)
RETURNS SETOF user_profiles_view STABLE AS $PROCEDURE$
BEGIN
    RETURN QUERY

    SELECT *
    FROM user_profiles_view
    WHERE profile_id = v_profile_id;
END;$PROCEDURE$
LANGUAGE plpgsql;
*/


