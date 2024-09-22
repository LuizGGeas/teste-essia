CREATE TABLE IF NOT EXISTS folder (
id bigint not null primary key AUTO_INCREMENT,
name varchar(100) not null,
parent_folder_id bigint,
foreign KEY (parent_folder_id) references folder(id)
);