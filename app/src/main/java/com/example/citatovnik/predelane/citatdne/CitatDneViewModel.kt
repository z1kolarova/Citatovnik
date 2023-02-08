package com.example.citatovnik.predelane.citatdne

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.example.citatovnik.predelane.db.CitatDneDBItem
import com.example.citatovnik.predelane.db.CitatRepository
import com.example.citatovnik.puvodni.data.db.entity.CitatDneResponseItem
import org.json.JSONObject

class CitatDneViewModel( private val repository: CitatRepository) : ViewModel() {

    private val _citat = MutableLiveData<CitatDneDBItem>()
    val citatDne: LiveData<CitatDneDBItem>
        get() = _citat

    private val _dotazenyCitatDne = MutableLiveData<CitatDneResponseItem>()

    init {
        _citat.value = repository.citatDne

    }
/*
    private val _ipAddressAsString = MutableLiveData<String>()
    val ipAddressAsString: LiveData<String>
        get() = _ipAddressAsString

    private val _location = MutableLiveData<Location>()
    val location: LiveData<Location>
        get() = _location

    private val _localized = MutableLiveData<Boolean>()
    val localized: LiveData<Boolean>
        get() = _localized
*/
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error


    fun dotahniCitatDne(context: Context, view: View){
        val queue = Volley.newRequestQueue(context)

        val url = "https://zenquotes.io?today"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                naparsujCitatDne(response)
            },
            Response.ErrorListener { showMessage("Zkontrolujte připojení k internetu") })

        queue.add(stringRequest)
    }

    private fun naparsujCitatDne(response: String ) {
        var jObject = JSONObject(response)
        try {
            //val ip = jObject.getString("ip")
            //onIpChanged(ip)
        }
        catch (e: java.lang.Exception) {
            showMessage("Chyba při čtení citátu dne")
        }
    }


    fun onIpChanged(value: CitatDneDBItem){
        _citat.value = value
        Log.v("testapi","změna: $value")
    }
/*
    fun onLocateClicked(context: Context, view: View){
        val sourceIP = _ipAddressAsString.value?.split(".")
        if( sourceIP == null || sourceIP.count() != 4 ) {
            showMessage("Nebyla zadána IP adresa")
            return
        }
        var ip = arrayOf<Int>()
        for( stringIP in sourceIP ){
            val convert = stringIP.toIntOrNull()
            if( convert!= null )
                ip += convert
            else{
                showMessage("IP není ve správném formátu")
                return
            }
        }
        if( ip[0] == 0 )
            showMessage("IP adresa nemůže začínat nulou")

        if( ip[0] == 127 )
            showMessage("Toto je adresa localhost")

        for( i in ip ){
            if( i < 0 || i > 255) {
                showMessage("Toto není platná IP adresa")
                return
            }
        }

        if( ip[0] == 10 || (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) || ( ip[0] == 192 && ip[1] == 168 )) {
            showMessage("Toto není veřejná IPv4 adresa")
            return
        }

        locateIP(context)
    }
*/
    private fun showMessage( msg: String ){
        _error.value = msg
    }


    fun errorReaded(){
        _error.value = ""
    }
/*
    fun locateIP(context: Context){
        val queue = Volley.newRequestQueue(context)

        val url = "https://api.geoiplookup.net/?query=${_ipAddressAsString.value}&json=true"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                locationReceived(response)
            },
            Response.ErrorListener { showMessage("Zkontrolujte připojení k internetu") })

        queue.add(stringRequest)
    }
    private fun locationReceived(response: String)
    {
        Log.v("testapi", response)
        var jObject = JSONObject(response)
        try {
            _location.value = Location(
                jObject.getString("ip"),
                jObject.getString("isp"),
                jObject.getString("city"),
                jObject.getString("countryname"),
                jObject.getDouble("latitude"),
                jObject.getDouble("longitude")
            )
            _localized.value = true
            val locDB = LocationDb(0, _location.value?.ip?:"0.0.0.0", _location.value?.isp?:"ISP",
                _location.value?.city?:"CITY", _location.value?.country?:"COUNTRY",
                _location.value?.latitude?:0.0, _location.value?.longitude?:0.0)
            viewModelScope.launch {  repository.insert(locDB) }
        }
        catch (e: java.lang.Exception){
            showMessage("Toto není platná veřejná IP")
        }
        //{"error":"not found"}
        //{"ip":"86.49.254.107","host":"86.49.254.107","isp":"Vodafone Czech Republic",
        // "city":"Prague","countrycode":"CZ","countryname":"Czechia",
        // "latitude":50.0804, "longitude":14.5045}
    }

    fun  resetLocation(){
        _localized.value = false
    }*/
}