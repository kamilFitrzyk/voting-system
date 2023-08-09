CREATE SCHEMA IF NOT EXISTS functions;

CREATE OR REPLACE FUNCTION table_exists(tableName text)
    RETURNS boolean AS $$
DECLARE
    table_count integer;
BEGIN
    SELECT COUNT(*)
    INTO table_count
    FROM information_schema.tables
    WHERE table_name = tableName;

    IF table_count > 0 THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION column_exists(tableName text, columnName text)
    RETURNS boolean AS $$
DECLARE
    column_count integer;
BEGIN
    SELECT COUNT(*)
    INTO column_count
    FROM information_schema.columns
    WHERE table_name = tableName AND column_name = columnName;

    IF column_count > 0 THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$ LANGUAGE plpgsql;