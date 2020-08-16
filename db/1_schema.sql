CREATE TABLE words
(
    id integer primary key,
    word TEXT not null
);

CREATE TABLE defs
(
    id integer primary key,
    def TEXT not null
);

CREATE TABLE examples
(
    id integer primary key,
    example TEXT not null,
    anti_example TEXT
);

CREATE TABLE term_entry
(
    id serial primary key,
    word_id INTEGER not null unique REFERENCES words(id),
    def_id INTEGER not null REFERENCES defs(id),
    example_id INTEGER not null REFERENCES examples(id),
    added_by TEXT not null,
    date_added TEXT not null
);