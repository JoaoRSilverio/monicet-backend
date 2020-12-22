# monicet-backend
Monicet Backend

# Description
The Monicet Backend is responsible for handling the collaborative research and public facing info part of the Monicet System it comprises of two independent projects
the SpringBoot monicetApplication(`./src/main/`) and the React Front End(`./ui/`)


#How to build
- clone the repository
- make sure your JAVA_HOME is set properly
- run ./mvnw install
- run ./mvnw spring-boot:run or press play on your IDE

#Development 
- Start the React development server in port 3000 by using the following commands
`cd ui/`
`npm start`
the development version is proxying to 8080 so it should work while the server is running locally
