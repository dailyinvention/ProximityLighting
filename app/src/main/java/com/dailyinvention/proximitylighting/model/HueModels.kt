package com.dailyinvention.proximitylighting.model

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class GetHueGroups : AsyncTask<String, String, String>() {
    val CONNECTON_TIMEOUT_MILLISECONDS = 60000

    override fun onPreExecute() {
        // Before doInBackground
    }

    override fun doInBackground(vararg urls: String?): String {

        var urlConnection: HttpURLConnection? = null

        try {
            val url = URL(urls[0])

            Log.d("GetHueGroups","doInBackground")

            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connectTimeout = CONNECTON_TIMEOUT_MILLISECONDS
            urlConnection.readTimeout = CONNECTON_TIMEOUT_MILLISECONDS

            val inString = streamToString(urlConnection.inputStream)

            publishProgress(inString)
        } catch (ex: Exception) {
            Log.e("GetHueGroups", ex.toString())
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect()
            }
        }

        return " "
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }

    fun streamToString(inputStream: InputStream): String {
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        var line: String
        var result = ""

        try {
            while ((bufferReader.readLine()) != null) {
                line = bufferReader.readLine()
                result += line
            }
            inputStream.close()
        } catch (ex: Exception) {
            Log.e("streamToString", ex.toString())
        }

        return result
    }
}