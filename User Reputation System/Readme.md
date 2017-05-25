# User Reputation System for Cloud Service Providers

This stage consists of several parts.

![Stages in Classification](img.JPG?raw=true "Stages in Classification")

## Data Generation

Data is generated on 30 virtual machines on which load generation is done using the web application built as SaaS.

The parameters used are cpu usage and memory usage. This is collected over a period of 50s and replicated into 5 different users. This results in a total of 5 files each with 50 lines of data corresponding to cpu usage and memory usage.
This code is run on client virtual machines.

>The code for the same can be found in data_generation.sh 

## Data Collection

Data files are generated on client machines. These files are pulled by the server into it's memory space. 

>The code for the same can be found in data_collection.sh

## Data Preprocessing

The main reason why data preprocessing is necessary is because data generated at the client end is skewed andcontains outliers. 

For eg. when an application is launched or closed, cpu usage percentage increases and falls if the application is not being used or the application cpu usage is low. To avoid such cases, data preprocessing is done.

A simple technique is used to preprocess data: average of cpu usage and memory usage is taken for each client machine.

Thus, by calculating the average of 50 values of cpu usage and memory usage results in a total of 150 rows representing data extracted form 150 client machines ( 30 machines impersonating 5 each)

>The code for the same can be found in DataPreprocess.java
