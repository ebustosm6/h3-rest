# H3-REST microservice
En este repositorio se desarrolla el proyecto de H3-REST.
El servicio REST se basa en la idea de disponer como API REST con docker las funcionalidades del proyecto de [Uber H3](https://uber.github.io/h3/#/).


## Idea
La idea es implementar las funcionalidades de la librería H3 de C, mediante el wrapper de java. Para ello se utiliza el framework de desarrollo web Springboot.


## How to contribute
Para colaborar en el proyecto, se recomienda seguir el siguiente esquema:

-  New issue (gitlab)

- Create Branch from issue (gitlab)

- Download branch to local (local git console)

>git fetch origin {branch-name}

- Change to branch (local git console)

>git checkout {branch-name}

- Make some changes!

- Add changes to stage (local git console)

>git add . or files

- Commit the changes (local git console)

>git commit -m "{message}"

- Publish your changes in repo (local git console)

>git push origin {branch-name}

- Download last version of development and merge to your branch (local git console)

>git checkout develop

>git pull origin develop

>git checkout {branch-name}

>git merge --no-ff develop

>git push origin {branch-name}

- Someone will review and merge your changes (gitlab)!
