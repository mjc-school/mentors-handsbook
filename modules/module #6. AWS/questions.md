# QUESTIONS

1. What is IAM? Please describe shortly what you can go using IAM?
2. What is an IAM User? What is User Group in IAM? What is an IAM Role? What are Policies?
3. What is S3 service in AWS? What is S3 bucket?
4. What is Region? What is Availability Zone?
5. What is EC2 service?
6. What is EC2 instance? What types of EC2 instances do you know?
7. What is Private and Public Key during instance creation?
8. What is EC2 instance lifecycle? If we stop and start the server what will happen? What will happen during reboot operation?
9. What is instance user data? How can you make sure that your bootstrapping script completed without errors?
10. What is AWS RDS? What engines does it support?
11. What is AWS VPC? What are the main components of AWS VPC?
12. How do instances in a VPC access the Internet? What IP types do you know? What will happen with IP during reboot, stop, start?
13. What is the range of IP addresses in VPC? What is CIDR block?
14. What is IaaS, SaaS, PaaS? What are other similar abbreviations?

## Quiz
### Cloud

1. What is the cloud  model that gives you access to virtual machines on the OS level
      * PaaS
      * SaaS
      * IaaS :heavy_check_mark:
      * FaaS
2.	What are the main advantages of the cloud? (multi)
      * Productivity :heavy_check_mark:
      * Cost :heavy_check_mark:
      * Global Scale :heavy_check_mark:
      * Reliability :heavy_check_mark:
3.	Google Docs is which type of cloud computing service
      * IaaS
      * SaaS :heavy_check_mark:
      * PaaS
4.	Which of the following is Cloud Platform by Amazon?
      * Azure
      * Alibaba
      * AWS :heavy_check_mark:
      * CloudFoundry
5. Which of the following is true about cloud computing?
      * It's always going to be less expensive and more secure than  local computing
      * Only a few small companies are investing  in the technology, making it a ricky venture
      * You can access your data from any computer in the world, as long as you have an Internet connection :heavy_check_mark:
 
### AWS

1. What cloud computing models are supported by AWS? (multi)
      * IaaS :heavy_check_mark:
      * SaaS
      * PaaS :heavy_check_mark:
      * FaaS :heavy_check_mark:
2. Amazon Elastic Compute Cloud (EC2) is primarily considered which type of cloud computing model?
      * SaaS
      * PaaS
      * IaaS :heavy_check_mark:
      * FaaS
3. Amazon Elastic Compute Cloud (Amazon EC2) does which of the following? (multi)
      * Provides customers with an isolated section of the AWS cloud where they can launch AWS resources in a virtual network :heavy_check_mark:
      * Provides resizable computing capacity in the cloud :heavy_check_mark:
      * Pay only for the resources that you actually consume, like instance-hours or data transfer :heavy_check_mark:
      * Determine whether you want to run in multiple locations, utilize static IP endpoints, or attach persistent block storage to your instances :heavy_check_mark:
4. What is a virtual server platform that allows users to create and run virtual machines on Amazon’s server farm?
      * EC2 :heavy_check_mark: 
      * S3
      * VPC
      * RDS
5. Which of the following instance has an hourly rate with no long-term commitment?
      * On-Demand :heavy_check_mark: 
      * Reserved
      * Spot
      * Scheduled
6. Amazon S3 is which type of storage service?
      * File
      * Object :heavy_check_mark: 
      * Stream
7. Object storage systems store files in a flat organization of containers called what?
      * Cluster
      * Bucket :heavy_check_mark: 
      * Basket
      * Cart
8. Why is a bucket policy necessary?
      * To allow bucket access to multiple users
      * To grant or deny accounts to read and upload files in your bucket :heavy_check_mark: 
9. Which statements are true? (multi)
      * Availability Zones form a collection of Regions
      * Each Region has only one Availability Zone
      * Clients can load balance between multiple Availability Zones :heavy_check_mark:
      * Regions are global and Availability Zones are local within each region :heavy_check_mark:
10.	An AWS VPC is a component of which group of AWS services?
      * Compute infrastructure
      * Compute Services
      * Database Services
      * Network Services :heavy_check_mark:
11. If you want to run your relational database in the AWS cloud, which service would you choose?
      * Amazon DynamoDB
      * Amazon RDS :heavy_check_mark:
      * Amazon S3
      * Amazon Redshift
12. Databases supported by RDS:
      * MySQL :heavy_check_mark:
      * Oracle :heavy_check_mark:
      * MongoDB
      * PostgreSQL :heavy_check_mark:
      * Aurora :heavy_check_mark:
13. Which statements are true about AWS Regions? (multi)
      * Each region consists of 2 or more availability zones :heavy_check_mark:
      * Regions have direct, low-latency, high throughput and redundant network connections between each other
      * Each region consists of a collection of VPCs
      * Each region is designed to be completely isolated from the other Amazon Regions :heavy_check_mark:
14. Which of the following is the most secure way of giving access to AWS services to applications running on EC2 instances?
      * Creating Service users
      * Creating service groups
      * Roles :heavy_check_mark:
      * Attaching policies to applications
15. It's not possible to define the Availability Zone into which you deploy your RDS instance. True or false?
      * True
      * False :heavy_check_mark:
