INSERT INTO `user` (`id`, `address`, `birth_date`, `country`, `email`, `facebook_id`, `full_name`, `gender`, `google_id`, `language`, `linkedid_id`, `password`, `photo`, `signup_on`, `state`, `twitter_id`, `zipcode`)
VALUES
	(1,'deneme','2010-01-01 00:00:00','US','ealparslan@gmail.com',NULL,'Erhan Alparslan','M','ealparslan','Turkish',NULL,'deneme',NULL,'2017-01-01 00:00:00','CA',NULL,95117),
	(2,'dkdekdj','2010-01-01 00:00:00','US','ouuuz@gmail.com',NULL,'Oguzhan Topgul','F','oguzzz','English',NULL,'deneme',NULL,'2017-05-01 00:00:00','CA',NULL,94432),
	(3,'371 Aloe Vera Ave','2010-01-01 00:00:00','US','johnwick@gmail.com','johnwick','John Wick','M','jwick','English',NULL,'deneme',NULL,'2017-06-01 00:00:00','NJ',NULL,70041);


INSERT INTO `speciality` (`id`, `description`, `title`)
VALUES
	(1,'regular','Basic Diet');


INSERT INTO `dietician` (`id`, `intro`, `is_approved`, `rate`, `user_id`)
VALUES
	(1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor i',b'1',4.2,2),
	(2,'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt molliti',b'1',3.8,3);

INSERT INTO `bank_account` (`id`, `account_number`, `added_on`, `bank`, `routing_number`, `dietician_id`)
VALUES
	(1,'1237453','2017-01-01 00:00:00','Bank of America','4829',1),
	(2,'2876344','2017-01-01 00:00:00','Bank of America','2344',2);

INSERT INTO `dieter` (`id`, `user_id`)
VALUES
	(1,1);


INSERT INTO `aggreement` (`offer_date`, `approved_date`, `pay_amount`, `pay_period`, `status`, `dietician_id`, `dieter_id`)
VALUES
	('2010-01-01 00:00:00','2010-01-03 00:00:00',121,'month',2,1,1);


INSERT INTO `dietician_speciality` (`submit_date`, `approve_date`, `fee`, `is_approved`, `proof`, `dietician_id`, `speciality_id`)
VALUES
	('2017-07-10 00:00:00','2017-07-13 00:00:00',20,b'1',X'70726F6F66',1,1),
	('2017-07-11 00:00:00','2017-07-14 00:00:00',14,b'1',NULL,2,1);





