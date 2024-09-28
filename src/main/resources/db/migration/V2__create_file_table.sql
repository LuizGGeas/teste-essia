create table file(
    id bigint not null primary key AUTO_INCREMENT,
    name varchar(100) not null,
    parent_folder_id bigint not null,
    file_content text,
    foreign KEY (parent_folder_id) references folder(id)
);