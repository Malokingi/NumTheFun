-- DDL --
INSERT INTO words
    (id, word)
values
    ( 1, 'Natural Number' );

INSERT INTO defs
    (id, def)
values
    ( 1, 'an Integer that is larger than 0' );

INSERT INTO examples
    (id, example, anti_example)
values
    ( 1, '1, 2, 5, 100, 6023', '0, -5, 2.3, 1.00001');

INSERT INTO term_entry
    (word_id, def_id, example_id, added_by, date_added)
values
    ( 1, 1, 1, 'MWGarvey', '1990/11/23' );


INSERT INTO words
    (id, word)
values
    ( 2, 'Integer' );
    
INSERT INTO defs
    (id, def)
values
    ( 2, 'a number that can be accurately expressed without any fractional or decimal component' );

INSERT INTO examples
    (id, example, anti_example)
values
    ( 2, '3, 0, -5000', '1.5, 3/4, 0.00001');

INSERT INTO term_entry
    (word_id, def_id, example_id, added_by, date_added)
values
    ( 2, 2, 2, 'MWGarvey', '1990/11/23' );