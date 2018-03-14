package com.example.q.myapplication

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL
import java.net.URLEncoder

/**
 * Created by Q on 11/03/18.
 */

class backgroundWorker internal constructor(internal var context: Context) : AsyncTask<String, Void, String>() {
    internal lateinit var alertDialog: AlertDialog

    override fun doInBackground(vararg params: String): String? {


        val type=params[0]
        val login_url="http://192.168.1.12/Lab/application1.php"
        val sigin_url="http://192.168.1.12/Lab/application2.php"
        val url_new="http://192.168.1.12/Lab/application3.php"
       val url_lo="http://databases.000webhost.com/tbl_row_action.php";
        val url1="http://databases.000webhost.com/tbl_row_action.php";

        if (type == "login") {
            try {
                val user_name=params[1]
                val password=params[2]
                val url=URL(login_url)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doOutput=true
                httpURLConnection.doInput=true
                val outputStream=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data=(URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8"))
                bufferedWriter.write(post_data)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream=httpURLConnection.inputStream
                val bufferedReader=BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var result2=""
                var line=""
                line=bufferedReader.readLine();
                while ((line) != null) {
                    result2+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                return result2
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else if (type == "sigin in") {
            try {
                val id_1=params[1]
                val password1=params[2]
                val url=URL(sigin_url)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doOutput=true
                httpURLConnection.doInput=true
                val outputStream=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val post_data=(URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_1, "UTF-8") + "&"
                        + URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(password1, "UTF-8"))
                bufferedWriter.write(post_data)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream=httpURLConnection.inputStream
                val bufferedReader=BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var result1=""
                var line1=""
                line1=bufferedReader.readLine();
                while ((line1) != null) {
                    result1+=line1
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                return result1
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else if (type == "register1") {
            val id_i=params[1]
            val email=params[2]
            try {
                val url=URL(url_new)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doInput=true
                val os=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data=URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_i, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")
                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                os.close()
                val IS=httpURLConnection.inputStream
                IS.close()
                return "register success...."
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: ProtocolException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }


        } else if (type == "register") {
            val name=params[1]
            val id=params[2]
            val email=params[3]
            val phone=params[4]
            val code=params[5]
            val dateOfbirth=params[6]


            try {
                val url=URL(url_lo)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doInput=true
                val os=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data=URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8") + "&" +
                        URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(dateOfbirth, "UTF-8")

                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                os.close()
                val IS=httpURLConnection.inputStream
                IS.close()
                return "personal information ...."
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: ProtocolException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }


        }
        return null
    }

    override fun onPreExecute() {
        alertDialog=AlertDialog.Builder(context).create()
        alertDialog.setTitle("Status")


    }

    override fun onPostExecute(result: String) {
        if (result === "register success....") {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show()

        } else if(result=="personal information ....") {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show()
        } else{
            alertDialog.setMessage(result)
            alertDialog.show()


        }


    }

    override fun onProgressUpdate(vararg values: Void) {
        super.onProgressUpdate(*values)
    }
}



