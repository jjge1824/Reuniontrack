# Reunion track

Introducción
-------
Reunion track es una aplicación que facilita a sus usuarios reunirse de manera más comoda y sin preocuparse de sus otras actividades **escaneando calendarios de terceros** junto con el de la misma Reunion track, mandando invitaciones y haciendo el match tanto en el lugar como en el espacio de tiempo pata que así amigos, familiares, excompañeros inclusive parejas puedan reunirse más comodamente.

Reglas de Commits
-------

 1. La rama master siempre tendra la ultima versión estable, por ningun motivo se debe hacer un commit sobre esta a menos que sea un merge de una rama ya validada.
 2. Para que una rama pueda hacer merge con master, esta debe tener la nueva activity, clase o issue totalmente concluidos y debe su funcionamiento debe ser validado por el otro compañero dando un ***commit --allow-empty*** con la aprobación.
 3. Las ramas para desarrollar nueva funcionalidad se tomaran desde master, y de esta nueva rama creada, puede haber N ramas a responsabilidad del desarrollador.
 4. En caso de que master llegase a presentar las suficientes irregularidades o errores para considerarse intestable, se hara una rama de esta versión de master y despues se procedera a regresar esta rama a la versión estable anterior.
 5. Cuando se llegue a la versión BETA,  se creará un tag empezando desde el 0.1 y este tag, al momento de su creación debe tener exactamente lo mismo que master.
 6. Si un desarrollador tiene una rama individual y diferente a la del otro, esta prohibido realizar commits sobre la rama de desarrollador hasta que se haga la integración atendiendo lo estipulado en las reglas anteriores.
 
Iniciar un proyecto 
-------
Para empezar un proyecto es necesario crear un repositorio en la plataforma de su preferencia, ya sea Bitbucket, Github, Gitlab, etc.

Basta con seguir la siguiente lista de comandos en e orden establecido.

    touch README.md
    git init
    git add README.md
    git commit -m "[COMENTARIO]"
    git remote add origin [LINK HTTPS O SSH DEL REPO]
    git push -u origin master

Clonado del proyecto
-----

En dado caso de que el proyecto ya exista en un repositorio y se desee trabajar sobre el mismo seguir los siguientes pasos:

    git clone [LINK HTTPS O SSH DEL REPO]
    git checkout -b [NOMBRE DE LA RAMA]
    git pull origin [NOMBRE DE LA RAMA]


> **Kubrosmx**
	> Jose Jesus Guzman Eusebio
	> Victor Uriel Pacheco Garcia
