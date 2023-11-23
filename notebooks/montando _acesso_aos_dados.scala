// Databricks notebook source
dbutils.fs.mkdirs("/mnt/dados")

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt")

// COMMAND ----------

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "fdf3f976-983d-4aa2-a298-a41f9cb97bc4",
  "fs.azure.account.oauth2.client.secret" -> "A2h8Q~67I5360-pSF-PfI038V9.CCXHuyNQiMb9v",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/8e672a06-4986-40f8-b64e-f3708aa35fbb/oauth2/token")
// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://imoveis@datalakealura3.dfs.core.windows.net/",
  mountPoint = "/mnt/dados",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados")
// MAGIC
