insert into user (id,User_Name,password) values (1,'ammar','1234');

insert into GE_CATEGORY (id,name,from_year,to_year,scale_unit) values (1,'Hadeean',1,10000,'1 million Years');
insert into GE_CATEGORY (id,name,from_year,to_year,scale_unit) values (2,'Archean',20000,30000,'10 million Years');

insert into GE_SUBCATEGORY (id,name,from_year,to_year,ge_category_id) values (1,'eo headean',1,9000,1);
insert into GE_SUBCATEGORY  (id,name,from_year,to_year,ge_category_id) values (2,'lo headean',9001,10000,1);
insert into GE_SUBCATEGORY  (id,name,from_year,to_year,ge_category_id) values (3,'eo archean',20001,25000,2);
insert into GE_SUBCATEGORY  (id,name,from_year,to_year,ge_category_id) values (4,'lo archean',25000,30000,2);

insert into GE_SUBCATEGORY_POST (id,post_description,post_image_url,post_year,ge_subcategory_id) values (1,'Monalisa Image','https://tineye.com/images/widgets/mona.jpg',90,1);
insert into GE_SUBCATEGORY_POST (id,post_description,post_image_url,post_year,ge_subcategory_id) values (2,'Mona','https://tineye.com/images/widgets/mona.jpg',900,1);