DELETE FROM Child;
DELETE FROM Parent;


INSERT INTO Parent (id, name) VALUES (1, 'Matthews');
INSERT INTO Parent (id, name) VALUES (2, 'Beauford');

INSERT INTO Child (id, parent_id, name, random) VALUES (1, 1, 'Dave', 'foo');
INSERT INTO Child (id, parent_id, name, random) VALUES (2, 2, 'Carter', 'bar');
INSERT INTO Child (id, name, random) VALUES (3, 'Stephan', 'foobar');

INSERT INTO Parent (id, name) VALUES (4, 'Charly');
INSERT INTO Parent (id, name) VALUES (5, 'Chris');
INSERT INTO Parent (id, name) VALUES (6, 'Paula');