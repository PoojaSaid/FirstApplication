package com.example.firstparlourproject.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.firstparlourproject.R
import com.example.firstparlourproject.model.user
import com.example.firstparlourproject.viewModel.UserViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var  mUserViewModel: UserViewModel

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
//        auth = Firebase.auth
         auth = FirebaseAuth.getInstance()
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var lodingBar = ProgressDialog(requireContext())
        view.loginUserBtn.setOnClickListener {

//            login(view)
            doLogin()

        }

        view.signupTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }

        return view
    }

    private fun doLogin() {

        var userEmail = loginEmailEd.text.toString()
        val userPassword = loginPasswordEd.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            loginEmailEd.error = "Please enter valid email"
            loginEmailEd.requestFocus()
        }

        if (userPassword.isEmpty()) {
            loginPasswordEd.error = "Please enter email"
            loginPasswordEd.requestFocus()
        }


//        val userObj: user = user(,userEmail,userPassword)
        //Get data from database, if customer exist
        val userExist = mUserViewModel.getCustomerDetails(userEmail, userPassword)
        Log.d("CustomerObject",userExist.toString())

        /*auth.signInWithEmailAndPassword(
            loginEmailEd.text.toString(),
            loginPasswordEd.text.toString()
        )
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("LoginFragment", "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.

                    updateUI(null)
                    // ...
                }

                // ...
           }*/


//        navigate after successful login
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

    }

    override fun onStart() {
        super.onStart()
       /* var currentUser = auth.currentUser
        updateUI(currentUser)*/
    }

/*    fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
//            if(currentUser.isEmailVerified) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            *//*}else{
                Toast.makeText(requireContext(), "EMail is not verified", Toast.LENGTH_SHORT).show()

            }*//*
        } else {
            Toast.makeText(requireContext(), "Login failed.", Toast.LENGTH_SHORT).show()
        }

    }*/



}