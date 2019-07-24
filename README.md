# H3-REST microservice
En este repositorio se desarrolla el proyecto de H3-REST.
El servicio REST se basa en la idea de disponer como API REST con docker las funcionalidades del proyecto de [Uber H3](https://uber.github.io/h3/#/).

## Idea


## How to contribute
Para colaborar en el proyecto, se recomienda seguir el siguiente esquema:

1. New issue (gitlab)
2. Create Branch from issue (gitlab)
3. Download branch to local (local git console)

>>git fetch origin {branch-name}

4. Change to branch (local git console)

>>git checkout {branch-name}

5. Make some changes!
6. Add changes to stage (local git console)

>>git add . or files

6. Commit the changes (local git console)

>>git commit -m "{message}"

7. Publish your changes in repo (local git console)

>>git push origin {branch-name}

8. Download last version of development and merge to your branch (local git console)

>>git checkout develop

>>git pull origin develop

>>git checkout {branch-name}

>>git merge --no-ff develop

>>git push origin {branch-name}

9. Someone will review and merge your changes (gitlab)!
