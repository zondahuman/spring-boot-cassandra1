march action

# Cassandra-API :



# spring-boot-cassandra:

create keyspace boot_keyspace with replication = {'class':'SimpleStrategy', 'replication_factor':1};
use boot_keyspace;
select * from  library ;

CREATE TABLE library (
       id bigint PRIMARY KEY,
       question text,
       createTime timestamp,
       updateTime timestamp
    );


use lee_keyspace;

select * from  products ;


apache-cassandra-3.11.1

# Table Data Type :
* http://docs.datastax.com/en/archived/cql/3.0/cql/cql_reference/create_table_r.html

* http://blog.csdn.net/codeforjesus/article/details/53337317


# Apache Cassandra

* wget http://archive.apache.org/dist/cassandra/3.0.9/apache-cassandra-3.0.9-bin.tar.gz

* wget http://archive.apache.org/dist/cassandra/3.11.1/apache-cassandra-3.11.1-bin.tar.gz





# Start Boot

* java  -jar  *.jar   --spring.profiles.active=dev

* https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

# debezium binlog subscribe :

* debezium


# Zookeeper Install :

* wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.6/zookeeper-3.4.6.tar.gz
* wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.5/zookeeper-3.4.5.tar.gz


# Check Cluster Status :

./nodetool status




















