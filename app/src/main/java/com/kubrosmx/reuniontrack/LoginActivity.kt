package com.kubrosmx.reuniontrack

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import java.util.*

class LoginActivity : AppCompatActivity() {

    companion object {
        lateinit var instance: LoginActivity
            private set
    }

    var callbackManager : CallbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        instance = this

        val loginFacebook = LoginButton(this)
        loginFacebook.setReadPermissions("email")

        validarLogin();

        loginFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onCancel() {
                instance.toast("Login Cancelado")
            }

            override fun onSuccess(result: LoginResult?) {
                instance.toast("Login Exitoso")
                escribirPreferencia("face_logueado", "1")
                var intent = Intent(instance, PrincipalActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onError(error: FacebookException?) {
                instance.toast("Error en el login "  + error?.message)
            }
        })

    }

    fun toast(message: CharSequence) =
            Toast.makeText(instance, message, Toast.LENGTH_SHORT).show()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    fun escribirPreferencia(clave: String, valor: String) {
        var pref = getSharedPreferences("pref1", Context.MODE_PRIVATE)
        var editor = pref.edit();
        editor.putString(clave, valor);
        editor.commit()
    }

    fun obtenerPreferencia(clave: String): String? {
        return getSharedPreferences("pref1", Context.MODE_PRIVATE).getString(clave, "0")
    }

    fun validarLogin(){
        if (obtenerPreferencia("face_logueado").equals("1")) {
            LoginManager.getInstance().logInWithReadPermissions(
                    this,
                    Arrays.asList("public_profile")
            );
        }
    }
}

