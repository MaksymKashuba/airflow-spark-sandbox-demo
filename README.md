# Airflow Spark Demo

This project serves as a study sandbox for learning and experimenting with Apache Spark and Apache Airflow. It allows you to create Spark jobs in Python, Scala, and Java, and run them using Airflow.

## Prerequisites

- Docker
- Java 17
- Scala 2.12
- Apache Maven
- SBT (Scala Build Tool)

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/MaksymKashuba/airflow-spark-sandbox-demo.git
   cd airflow-spark-sandbox-demo
   ```

2. **Build the Scala and Java Jobs**:
   - For Scala:
     ```bash
     cd jobs/scala
     sbt package
     ```
   - For Java:
     ```bash
     cd jobs/java/spark-job
     mvn clean package
     ```

3. **Start the Docker Containers**:
   ```bash
   docker-compose up -d
   ```

4. **Access the Airflow Web UI**:
   - Open your browser and navigate to [http://localhost:8080].
   - Use the credentials:
     - Username: `admin`
     - Password: `admin`

5. **Trigger the DAG**:
   - In the Airflow UI, enable and trigger the `sparking_flow` DAG.
