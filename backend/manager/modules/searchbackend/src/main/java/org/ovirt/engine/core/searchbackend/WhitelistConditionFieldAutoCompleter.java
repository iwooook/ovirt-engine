package org.ovirt.engine.core.searchbackend;

import java.util.UUID;

public class WhitelistConditionFieldAutoCompleter extends BaseConditionFieldAutoCompleter {

    public static final String WHITELIST_ID = "ID";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String USER_NAME = "USER_NAME";
    public static final String IP_ADDRESS = "IP_ADDRESS";

    public WhitelistConditionFieldAutoCompleter() {
        // Building the basic verbs dict.
        verbs.add(WHITELIST_ID);
        verbs.add(DESCRIPTION);
        verbs.add(USER_NAME);
        verbs.add(IP_ADDRESS);        

        // Building the autoCompletion dict.
        buildCompletions();

        // Building the types dict.
        getTypeDictionary().put(WHITELIST_ID, Integer.class);
        getTypeDictionary().put(DESCRIPTION, String.class);
        getTypeDictionary().put(USER_NAME, String.class);
        getTypeDictionary().put(IP_ADDRESS, String.class);

        // building the ColumnName dict.
        columnNameDict.put(WHITELIST_ID, "whitelist_id");
        columnNameDict.put(DESCRIPTION, "description");
        columnNameDict.put(USER_NAME, "user_name");
        columnNameDict.put(IP_ADDRESS, "ip_address");

        // Building the validation dict.
        buildBasicValidationTable();
    }

    @Override
    public IAutoCompleter getFieldRelationshipAutoCompleter(final String fieldName) {
        return StringConditionRelationAutoCompleter.INSTANCE;
    }
}
