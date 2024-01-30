variable "region" {
    type = string
}

#vpc

variable "cidr_block" {
    description = "main vpc cider block"
    type = string
}

#subnets

variable "pub_sub_cidr_block" {
    type = string
}

variable "pub_sub_name" {
    type = string
}

variable "map_ip" {
    type = bool
}

#sgs

#ec2

variable "instance_type" {
    type = string
}

#s3

variable "bucket_name" {
    type = string
}

variable "bucket_key" {
    type = string
}

variable "bucket_region" {
    type = string
}

variable "bucket_encrypt" {
    type = bool
}

variable "email" {
    type = string
}
