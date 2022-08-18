alter table vaysmanDB.user
add column locale varchar(10) after name,
    add column email_verified boolean after locale;