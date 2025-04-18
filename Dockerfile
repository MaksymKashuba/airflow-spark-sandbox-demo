FROM apache/airflow:latest-python3.11

USER root
RUN apt-get update && \
    apt-get install -y gcc python3-dev default-jdk && \
    apt-get clean

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-arm64

USER airflow

RUN pip install apache-airflow apache-airflow-providers-apache-spark pyspark