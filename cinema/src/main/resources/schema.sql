
create table projection(
	id bigint not null AUTO_INCREMENT,
	start_time Timestamp,
	end_time Timestamp,
	PRIMARY KEY (id), 
);
create table User(
	id bigint not null AUTO_INCREMENT,
	name varchar(200),
	login varchar(400),
	projection_id bigint,
	PRIMARY KEY (id),
	CONSTRAINT fk_user_projection_id  FOREIGN KEY (projection_id) REFERENCES projection(id) ON DELETE SET NULL
);
create table room(
	id bigint not null AUTO_INCREMENT,
	number Integer,
	projection_id bigint,
	PRIMARY KEY (id),
	CONSTRAINT fk_room_projection_id  FOREIGN KEY (projection_id) REFERENCES projection(id) ON DELETE SET NULL
);

create table Movie(
	id bigint not null AUTO_INCREMENT,
	name varchar(200),
	projection_id BIGINT ,
	PRIMARY KEY (id),
    CONSTRAINT fk_movie_projection_id FOREIGN KEY (projection_id) REFERENCES Projection(id) ON DELETE SET NULL
);
create table matrix(
	id BIGINT not null AUTO_INCREMENT,
	room_id BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_matrix_room_id FOREIGN KEY (room_id) REFERENCES room(id) ON DELETE SET NULL
);

create table element(
	id BIGINT not null AUTO_INCREMENT,
	matrix_id BIGINT,
	row int,
	columns int,
	state varchar(30),
	PRIMARY KEY (id),
  	CONSTRAINT fk_element_matrix_id FOREIGN KEY (matrix_id) REFERENCES matrix(id) ON DELETE SET NULL
);