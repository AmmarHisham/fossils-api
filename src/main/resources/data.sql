insert into user (id,User_Name,password) values (1,'ammar','1234');

insert into ge_page (id,name,from_age,to_age,scale_unit) values (1,'PRECAMBRIAN',700,4500,'50');


insert into GE_CATEGORY (id,name,from_age,to_age,ge_page_id,bg_img_url) values (1,'PROTEROZOIC ',700,2500,1,'http://google.com');
insert into GE_CATEGORY (id,name,from_age,to_age,ge_page_id,bg_img_url) values (2,'ARCHEAN ',2500,4000,1,'http://google.com');
insert into GE_CATEGORY (id,name,from_age,to_age,ge_page_id,bg_img_url) values (3,'HADEAN ',4000,4500,1,'http://google.com');

insert into GE_SUBCATEGORY (id,name,from_age,to_age,ge_category_id) values (1,'NEOPROTEROZOIC',700,1000,1);
insert into GE_SUBCATEGORY (id,name,from_age,to_age,ge_category_id) values (2,'MESOPROTEROZOIC',1000,1600,1);
insert into GE_SUBCATEGORY (id,name,from_age,to_age,ge_category_id) values (3,'PALEOPROTEROZOIC',1600,2500,1);

insert into GE_SUBCATEGORY_DIV (id,name,from_age,to_age,ge_subcategory_id) values (1,'EDIACARAN',700,720,1);
insert into GE_SUBCATEGORY_DIV (id,name,from_age,to_age,ge_subcategory_id) values (2,'CRYOGENIAN',720,740,1);
insert into GE_SUBCATEGORY_DIV (id,name,from_age,to_age,ge_subcategory_id) values (3,'TONIAN',740,1000,1);


insert into GE_SUBCATEGORY_DIV_ITEM (id,item_description,item_image_url,item_age,ge_subcategory_div_id) values (1,'Monalisa Image','https://tineye.com/images/widgets/mona.jpg',90,1);
insert into GE_SUBCATEGORY_DIV_ITEM (id,item_description,item_image_url,item_age,ge_subcategory_div_id) values (2,'Mona','https://tineye.com/images/widgets/mona.jpg',900,1);