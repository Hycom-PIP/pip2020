package com.pip.chatbot.repository.joke;


import com.pip.chatbot.jooq.jokes.tables.records.CategoryRecord;
import com.pip.chatbot.jooq.jokes.tables.records.JokeRecord;
import com.pip.chatbot.model.joke.Category;
import com.pip.chatbot.model.joke.Joke;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.Optional;

import static com.pip.chatbot.jooq.jokes.tables.Category.CATEGORY;
import static com.pip.chatbot.jooq.jokes.tables.Joke.JOKE;


public class NoAuthJokeRepository {

    private DSLContext dsl;
    private static final boolean CONFIRMED = true;

    public NoAuthJokeRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public Optional<Joke> getRandomJoke() {
        JokeRecord result = dsl
                .selectFrom(JOKE)
                .where(JOKE.IS_CONFIRMED.eq(CONFIRMED))
                .orderBy(DSL.rand())
                .limit(1)
                .fetchOne();

        return Optional.ofNullable(result.into(Joke.class));
    }

    public Optional<Joke> getRandomJokeByCategory(String category) {
        JokeRecord result = dsl
                .selectFrom(JOKE)
                .where(JOKE.CATEGORY.eq(category).and(JOKE.IS_CONFIRMED.eq(CONFIRMED)))
                .orderBy(DSL.rand())
                .limit(1)
                .fetchOne();

        return Optional.ofNullable(result.into(Joke.class));
    }

    public List<Category> getAllCategory() {
        return dsl.selectFrom(CATEGORY)
                .fetch()
                .into(Category.class);
    }

    public List<Category> getAllConfirmedCategory() {
        return dsl.selectFrom(CATEGORY)
                .where(CATEGORY.IS_CONFIRMED.eq(CONFIRMED))
                .fetch()
                .into(Category.class);

    }

    public Optional<Joke> addTemporaryJoke(Joke joke) {
        JokeRecord result = dsl.insertInto(JOKE)
                .set(JOKE.CATEGORY, joke.getCategory())
                .set(JOKE.IS_CONFIRMED, !CONFIRMED)
                .set(JOKE.JOKE_, joke.getJoke())
                .returning()
                .fetchOne();

        return Optional.ofNullable(result.into(Joke.class));
    }

    public Optional<Category> addTemporaryCategory(String category) {
        CategoryRecord result = dsl.insertInto(CATEGORY)
                .set(JOKE.CATEGORY, category)
                .set(JOKE.IS_CONFIRMED, !CONFIRMED)
                .returning()
                .fetchOne();

        return Optional.ofNullable(result.into(Category.class));
    }
}
