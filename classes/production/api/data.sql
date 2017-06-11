INSERT INTO seller (name, permit_no) VALUES ('xxxx', 123);
INSERT INTO seller (name, permit_no) VALUES ('yyy', 4444564);

INSERT INTO buyer (age, is_active, name) VALUES (20, true, 'aaa');
INSERT INTO buyer (age, is_active, name) VALUES (30, false, 'bbb');

INSERT INTO sale (sell_date, amount, buyer_id, seller_id) VALUES ('2017-06-10 01:38:05', 3, 1, 1);
INSERT INTO sale (sell_date, amount, buyer_id, seller_id) VALUES ('2017-06-10 04:38:12', 4, 1, 2);
INSERT INTO sale (sell_date, amount, buyer_id, seller_id) VALUES ('2017-06-10 01:38:52', 5, 2, 1);
INSERT INTO sale (sell_date, amount, buyer_id, seller_id) VALUES ('2017-06-10 01:39:52', 6, 2, 2);