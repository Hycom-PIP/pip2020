/*
 * This file is generated by jOOQ.
 */
package com.pip.chatbot.jooq.jokes;


import com.pip.chatbot.jooq.jokes.tables.Joke;
import com.pip.chatbot.jooq.jokes.tables.records.JokeRecord;

import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>jokes</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<JokeRecord, Integer> IDENTITY_JOKE = Identities0.IDENTITY_JOKE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<JokeRecord> JOKE_PKEY = UniqueKeys0.JOKE_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<JokeRecord, Integer> IDENTITY_JOKE = Internal.createIdentity(Joke.JOKE, Joke.JOKE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<JokeRecord> JOKE_PKEY = Internal.createUniqueKey(Joke.JOKE, "joke_pkey", new TableField[] { Joke.JOKE.ID }, true);
    }
}
