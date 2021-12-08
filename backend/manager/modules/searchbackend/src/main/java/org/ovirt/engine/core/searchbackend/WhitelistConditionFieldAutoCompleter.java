package org.ovirt.engine.core.searchbackend;

import java.util.UUID;

public class WhitelistConditionFieldAutoCompleter extends BaseConditionFieldAutoCompleter {

    public static final String WHITELIST_DB_ID = "ID";
    public static final String IP_ADDRESS = "IP_ADDRESS";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_ID = "USER_ID";

    public WhitelistConditionFieldAutoCompleter() {
        // Building the basic verbs dict.
        verbs.add(WHITELIST_DB_ID);
        verbs.add(IP_ADDRESS);
        verbs.add(USER_NAME);
        verbs.add(USER_ID);

        // Building the autoCompletion dict.
        buildCompletions();

        // Building the types dict.
        getTypeDictionary().put(WHITELIST_DB_ID, Integer.class);
        getTypeDictionary().put(IP_ADDRESS, String.class);
        getTypeDictionary().put(USER_NAME, String.class);
        getTypeDictionary().put(USER_ID, UUID.class);

        // building the ColumnName dict.
        columnNameDict.put(WHITELIST_DB_ID, WHITELIST_DB_ID);
        columnNameDict.put(IP_ADDRESS, IP_ADDRESS);
        columnNameDict.put(USER_NAME, USER_NAME);
        columnNameDict.put(USER_ID, USER_ID);

        // Building the validation dict.
        buildBasicValidationTable();
    }

    @Override
    public IAutoCompleter getFieldRelationshipAutoCompleter(final String fieldName) {
        return StringConditionRelationAutoCompleter.INSTANCE;
    }
}
