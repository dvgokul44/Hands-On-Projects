# QUICK START


To deploy MEAN you can execute below commands provided you have below files.

	Files:
		- MEAN_app.tar
		- MEAN_mongo.tar
		- docker-compose.yml
		- .env
	
	Commands:
		- docker load -i MEAN_app.tar		(To load application image)
		- docker load -i MEAN_mongo.tar	(To load database image)
		- docker-compose up -d 				(To start services)
		- docker-compose down				(To stop services)

**************************************************************************************************
--------------------------------------------------------------------------------------------------
										DOCKER DETAILS
--------------------------------------------------------------------------------------------------
**************************************************************************************************

--------------------------------------------------------------------------------------------------
										FOLDER HIERARCHY
--------------------------------------------------------------------------------------------------

	* MEAN_Base
		- DockerFile
		* Python_Source
			- nltk_data.tar.gz
			- tf-tensorboard.html
			
												* FOLDER
												- FILE
								
**************************************************************************************************

	* MEAN_App
		- DockerFile
		* codebase
		* app_sourcefiles
			- batch_node_modules.tar.gz
			- web_node_modules.tar.gz
			* shells
				- start_webserver.bat 
				- start_batchserver.bat
				- start_tensorboardserver.bat 
				
												* FOLDER
												- FILE

**************************************************************************************************

	* MEAN_Mongo
		- DockerFile
		- mongoinit.js

												* FOLDER
												- FILE
												
**************************************************************************************************

	* MEAN_Compose
		- docker-compose.yml
		- .env
		
												* FOLDER
												- FILE

--------------------------------------------------------------------------------------------------
										MEAN_Base DockerFile
--------------------------------------------------------------------------------------------------

To build base image for MEAN with necessary software.

Steps:
	- Install OS, Ubuntu
	- Install Anaconda3-4.2.0
	- Update PATH variable with python
	- Install NodeJS v10.19.0
	- Update PATH variable with node
	- Install required python libraries
	- Copy nltk_data and tf-tensorboard.html to Anaconda 

Commands:
	- cd MEAN_Base
	- docker build -t MEAN_base:0.1 . 
	- docker save -o MEAN_base.tar MEAN_base:0.1    (This is for backup)
	- docker load -i MEAN_base.tar					(This is to load from backup)

--------------------------------------------------------------------------------------------------
										MEAN_App DockerFile
--------------------------------------------------------------------------------------------------

To build MEAN application.

Steps: 
	- Use MEAN_base:0.1 image
	- Copy codebase 
	- Copy app_sourcefiles
	- Untar web_node_modules.tar.gz
	- Untar batch_node_modules.tar.gz
	
Commands:
	- cd MEAN_App
	- docker build -t MEAN_app:0.1 .
	- docker save -o MEAN_app.tar MEAN_app:0.1	(This is for backup)
	- docker load -i MEAN_app.tar					(This is to load from backup)

--------------------------------------------------------------------------------------------------
										MEAN_Mongo DockerFile
--------------------------------------------------------------------------------------------------

To build MongoDB v3.2 and initialize DB 'mean-dev' with credentials and save default documents in 'projects' and 'users' collection.

Steps:
	- Use mongo:3.2 image
	- Copy mongoinit.js to docker-entrypoint-initdb.d folder 
		(All .js and .sh files in 'docker-entrypoint-initdb.d' folder will be executed on startup in DB initialised using variable MONGO_INITDB_DATABASE)

Commands:
	- cd MEAN_Mongo
	- docker build -e MONGO_INITDB_DATABASE=mean-dev -t MEAN_mongo:0.1 .
	- docker save -o MEAN_mongo.tar MEAN_mongo:0.1	(This is for backup)
	- docker load -i MEAN_mongo.tar 
	
--------------------------------------------------------------------------------------------------
										MEAN docker-compose
--------------------------------------------------------------------------------------------------

To start MEAN services and MongoDB service in synch.

Steps:
	- For each service defined:
		* Refer appropriate image (MEAN_app:0.1, MEAN_mongo:0.1)
		* Define container name (MEAN_web, MEAN_batch, MEAN_mongo)
		* Refer appropriate environment file
		* Set environment variables
		* Expose requried ports
		* Set network to help containers communicate with each other
		* Define volumes to enable persistent storage (mongo data, MEAN logs)
		* Create container start command by defining entrypoint, working directory and command

Commands:
	- docker-compose up -d	(To start services)
	- docker-compose down	(To stop services)
	

		
