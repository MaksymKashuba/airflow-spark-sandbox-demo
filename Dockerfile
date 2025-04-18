FROM apache/airflow:2.9.0-python3.12

USER root

RUN apt-get update -y && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
    gcc \
    python3-dev \
    default-jdk \
    procps && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME /usr/lib/jvm/default-java

USER airflow

RUN pip install --no-cache-dir apache-airflow-providers-openlineage==1.12.1

RUN pip install --no-cache-dir apache-airflow apache-airflow-providers-apache-spark pyspark