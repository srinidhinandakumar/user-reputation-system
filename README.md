# Cloud Computing- IaaS, SaaS and User Reputation System for Cloud Service Providers
This is my final year thesis work based on the use of a decision tree algorithm for accurate user classification ( users here are clients to cloud service providers).

Team members include @Lucky94 and @jiya-singh

## Problem Statement
Cloud has moved beyond the promise of cost savings. As a result, we need to consider the perspective of cloud service providers and not just what the end user or client needs. 
>When a cloud service provider recieves similar resuource requests from multiple clients, on what basis will resource scheduling take place? 

>How will the service provider decide which user deserves to be allocated those requested resources?

## Proposed Solution
The cloud service provider must accurately classify his client database into priority classes where in each client is classified based on the efficiency of use of previosuly allocated resources.
For eg.

User A has 120Gb RAM, and 1Tb Memory allocated.

User B has 150Gb RAM, and 1Tb Memory allocated.


User A has used 500Gb memory and performs computation that consume 20% CPU load.

User B has used 800Gb memory and performs computation that consumes 85% CPU load.

Under such circumstances, if User A and B, both make requests for additional 100Gb memory, User B will be granted the request first, and User A may be granted later, or never (as per administrato review). This is done because User A has not yet used all resources and allocating additional resources to User A will be wasteful.

This classification example is a very simple problem where easy parameters were observed with marginable difference in the user resource usages. To deal with more real time scenarios, a classification algorithm needs to be developed to classify these users.

>Our proposed solution uses the C4.5 decision tree algorithm to classify users with CPU usage mean percentage and Memory usage mean percentage as parameters of classification.

## Stages

This project is divided into three stages namely, IaaS, SaaS and User Reputation System.

The initial function is to implement the Infrastructutre as a Service functionality. It is followed by developing a software to serve the Software as a Service functionality. Finally, the infrastructure created is used along with the software to develop a user reputation system.

### Infrastructure as a Service
Cloud model used was based on the esXi server in vCloud. Deployment of 60 Virtual Machines of Ubuntu and Mac Os were done and used as clients to the cloud model. Details of the same can be found in the IaaS repository.

### Software as a Service
A basic web application was developed to serve the purpose of load generation. Client portal allowed clients to run two kinds of stress funtions, infinite loop and launch and closing of various applications like firefox, logisim, sublimetext, xcode(in Mac Os), etc.

### User Reputation System
C4.5 decision tree algorithm was used to train the model on collected client data. The training code geenrated a ruleset against which the testing data was tested for its accuracy. Further a simple java code was written to correctly classify the incorrect classifications to improve the training model set. Details of the same can be found in the User_Reputation_System repository.

