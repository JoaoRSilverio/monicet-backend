package pt.geniusgrow.monicet.models.common;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LocalizedString {

    private Map<Locale, String> locValues;

    public LocalizedString() {
        locValues = new HashMap<>();
    }

    public LocalizedString(Map<Locale, String> locValues) {
        this.locValues = locValues;
    }

    public String getValue(Locale locale) {
        return locValues.get(locale);
    }

    @JsonIgnore
    public String getValue() {
        return locValues.get(Locale.getDefault());
    }

    public Map<Locale, String> getLocValues() {
        return locValues;
    }

    public void setLocValues(Map<Locale, String> locValues) {
        this.locValues = locValues;
    }

    public LocalizedString with(Locale locale, String value) {
        Map<Locale, String> newValues = new HashMap<>();
        newValues.putAll(locValues);
        newValues.put(locale, value);
        return new LocalizedString(newValues);
    }
}