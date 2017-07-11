package org.jabref.model.entry.event;

import java.util.Objects;

import org.jabref.model.database.event.BibDatabaseContextChangedEvent;
import org.jabref.model.entry.BibEntry;
import radar.ad.annotations.YStatementJustification;

/**
 * This abstract class pretends a minimal set of attributes and methods
 * which an entry event should have.
 */
@YStatementJustification (
        id = "JabRef-Solutions/logic/Events",
        context = "improving the code quality",
        chosen = "JabRef-Solutions/logic/Google%20Guava%20Event%20Bus",
        neglected = "JabRef-Solutions/logic/Event%20Listeners",
        achieving = "better code quality"
)
public abstract class EntryEvent extends BibDatabaseContextChangedEvent {

    private final BibEntry bibEntry;
    private final EntryEventSource location;


    /**
     * @param bibEntry BibEntry object which is involved in this event
     */
    public EntryEvent(BibEntry bibEntry) {
        this(bibEntry, EntryEventSource.LOCAL);
    }

    /**
     * @param bibEntry BibEntry object which is involved in this event
     * @param location Location affected by this event
     */
    public EntryEvent(BibEntry bibEntry, EntryEventSource location) {
        this.bibEntry = Objects.requireNonNull(bibEntry);
        this.location = Objects.requireNonNull(location);
    }

    public BibEntry getBibEntry() {
        return this.bibEntry;
    }

    public EntryEventSource getEntryEventSource() {
        return this.location;
    }
}
