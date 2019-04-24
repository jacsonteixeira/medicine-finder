# medicine-finder
MedicineFinder is a search tool to find medicines which have been bought already and are on their way to be delivered.

This application is configured with H2 database and some data is entered at application startup through the file located in \src\main\resources\data.sql

Examples of call
Medicine Finder
http://localhost:8080/medicine-finder?origin=DEU&destination=BRA&departureDate=2019-04-04&estimatedArrival=2019-04-20&numberOfMedicine=9

Best Supplier
http://localhost:8080/best-supplier?origin=DEU&destination=BRA&departureDate=2019-04-04&estimatedArrival=2019-04-20&quantityCount=9

Worst Supplier
http://localhost:8080/worse-supplier?departFrom=DEU&arriveTo=BRA&outboundDate=2019-04-04&inboundDate=2019-04-20&numberOfMedicines=3
