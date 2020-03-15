package seedu.volant.journal.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;

/**
 * Wraps all data at the Journal level
 * Duplicates are not allowed (by .isSameEntry comparison)
 */
public class EntryList implements ReadOnlyEntryList {

    private final UniqueEntryList entries;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        entries = new UniqueEntryList();
    }

    public EntryList() {

    }


    /**
     * Creates an EntryList using the entries in the {@code toBeCopied}
     */
    public EntryList(ReadOnlyEntryList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the entry list with {@code entries}.
     * {@code entries} must not contain duplicate entries.
     */

    public void setActivities(List<Entry> entries) {
        this.entries.setEntries(entries);
    }

    /**
     * Resets the existing data of this {@code EntryList} with {@code newData}.
     */

    public void resetData(ReadOnlyEntryList newData) {
        requireNonNull(newData);

        setActivities(newData.getEntryList());
    }

    /**
     * TODO: Complete all these methods after full implementation of Itinerary as the methods here are reliant on
     *  UniqueEntryList which can only be fully implemented after full implementation of Itinerary.
     */

    //// entry-level operations

    /*
     * Returns true if a entry with the same identity as {@code entry} exists in the address book.

    public boolean hasEntry(Entry entry) {
        requireNonNull(entry);
        return entries.hasAc;
    }


     * Adds a entry to the address book.
     * The entry must not already exist in the address book.

    public void addEntry(Entry p) {

    }

    public void setEntry(Entry target, Entry editedEntry) {

    }


     * Removes {@code key} from this {@code EntryList}.
     * {@code key} must exist in the address book.

    public void removeEntry(Entry key) {
        entries.remove(key);
    }


    //// util methods


    @Override
    public String toString() {
        return entries.asUnmodifiableObservableList().size() + " asscheeks";
    }


    */

    public UniqueEntryList getUniqueEntryList() {
        return entries;
    }

    @Override
    public ObservableList<Entry> getEntryList() {
        return entries.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EntryList // instanceof handles nulls
                && entries.equals(((EntryList) other).entries));
    }

    @Override
    public int hashCode() {
        return entries.hashCode();
    }

}
