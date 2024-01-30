region = "us-east-1"

#vpc

cidr_block = "10.0.0.0/16"

#subnets

pub_sub_cidr_block = "10.0.1.0/24"

pub_sub_name = "pub_sub"

map_ip = true

#ec2

instance_type = "t2.micro"

#s3

bucket_name = "ivolve-s3-test-for-amr"

bucket_key = "terraform.tfstate"

bucket_region = "us-east-1"

bucket_encrypt = true

#sns topic subscription email
email = "nader.mohamedh@gmail.com"

