# 1PF_ExchangeRates

ExchangeRatesBE
- Spring Boot 3.2.2
- Java 17
- run unit tests: mvn test
- run application mvn spring-boot:run

Database: H2
- BD is ailable after running the ExchangeRatesBE application
- H2 BD concole thru Web browser: http://localhost:8080/h2-consoles
- H2 DB credentials: see ExchangeRatesBE\src\main\resources\application.properties



ExchangeRatesFE
- Angular CLI: 17.2.0
- Node: 20.11.1
- Package Manager: npm 10.4.0
- OS: win32 x64

- The application was created without app.module.ts file. 
	ng new my-app 
	instead of 
	ng new my-app --no-standalone
- CORS solved by setting a proxy in src/app/proxy/proxy.conf.json
- run ExchangeRatesFE by CLI: ng serve -o --poll=2000 / ng serve --poll=2000 / ng serve
- install node.js and npm, runs the application



GIT branches
- main
- develop
- angular_initial_app (created after the new Angular pllilcation was created)