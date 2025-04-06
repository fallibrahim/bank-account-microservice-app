# Étape 1 : build de l'app Angular
FROM node:latest AS build

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# Étape 2 : image finale avec nginx
FROM nginx:latest

# Copie du build Angular vers Nginx
COPY --from=build /usr/src/app/dist/angular-front-end/browser /usr/share/nginx/html

# Suppression de l'avertissement sur la casse
EXPOSE 80
