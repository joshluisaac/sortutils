package com.sortutils.parser;


import com.google.gson.JsonSyntaxException;
import com.sortutils.entity.Distance;
import com.sortutils.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A utility providing command line/terminal input validation helper methods.
 *
 * @author Joshua Nwankwo
 * @version 1.0
 * @since April 2019
 */
public class InputValidationParser {

    private static final Logger LOG = LoggerFactory.getLogger(InputValidationParser.class);

    /**
     * Parses a JSON string and checks if it is really a valid JSON formatted string.
     *
     * @param maybeJson input string which was passed in from terminal
     * @return true if it is valid or false if otherwise
     */
    public static boolean isValidJson(final String maybeJson) {
        boolean isValid = false;
        try {
            new JsonUtils().fromJson(maybeJson, Distance.class);
            isValid = true;
        } catch (JsonSyntaxException ex) {
            LOG.error("{} is not a valid JSON formatted string.", maybeJson);
            throw new JsonSyntaxException("Not a valid JSON");
        }
        return isValid;
    }




}
