create table users (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	username character varying(55) NOT NULL,
	password character varying(155) NOT NULL,
	uuid character varying(155),
	date_created bigint default 0,
	stripe_user_id text,
	location_id bigint
);

create table roles (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name character varying(155) NOT NULL UNIQUE
);

create table user_permissions(
	id bigint PRIMARY KEY AUTO_INCREMENT,
	user_id bigint REFERENCES users(id),
	permission character varying(55)
);

create table user_roles(
	id bigint PRIMARY KEY AUTO_INCREMENT,
	role_id bigint NOT NULL REFERENCES roles(id),
	user_id bigint NOT NULL REFERENCES users(id)
);

create table designs (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name character varying (154),
	design text,
	css text,
	javascript text
);

create table categories (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	uri character varying (154),
	name character varying (154),
	description text,
	image_uri character varying (254),
	design_id bigint NOT NULL REFERENCES designs(id)
);


