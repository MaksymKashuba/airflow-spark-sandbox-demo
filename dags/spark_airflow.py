import airflow
from airflow import DAG
from airflow.operators.python import PythonOperator
from airflow.providers.apache.spark.operators.spark_submit import SparkSubmitOperator

dag = DAG (
    dag_id='spark_airflow_dag',
    default_args={
        'owner': 'Maksym Kashuba',
        'start_date': airflow.utils.dates.days_ago(1),
        'retries': 1,
        'retry_delay': 300,
    },
    schedule_interval='@daily',
)

start = PythonOperator(
    task_id='start',
    python_callable=lambda: print("Starting the DAG"),
    dag=dag,
)

python_job = SparkSubmitOperator(
    task_id='python_job',
    conn_id='spark_default',
    application='/path/to/your/wordcountjob.py',
    dag=dag
)

end = PythonOperator(
    task_id='end',
    python_callable=lambda: print("Completed the DAG"),
    dag=dag,
)

start >> python_job >> end