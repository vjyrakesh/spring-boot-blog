
insert into posts(id, title, content, created_on, updated_on) values(1, "Post1", "Post content 1", '2019-04-23', null);

insert into comments(id, post_id, name, email, content, created_on, updated_on) values(1,1,"Dan","dan@example.com","Comment for post 1",'2019-04-23',null);