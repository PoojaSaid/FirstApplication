package com.example.firstparlourproject.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.firstparlourproject.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.view.*


class RegisterFragment : Fragment() {
    private lateinit var mAuth:FirebaseAuth
    private lateinit var lodingBar:ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        lodingBar = ProgressDialog(requireContext())
        mAuth = FirebaseAuth.getInstance()

        view.registerUserBtn.setOnClickListener{
            registerUser(view)

        }

        view.alreadyHavAccountBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return view
    }

    private fun registerUser(view:View) {
        val userName = view.inputUserNameEd.text.toString()
        val email = view.inputEmailEd.text.toString()
        val userPassword = view.inputPasswordEd.text.toString()
        val userConfirmPassword = view.inputConfirmPasswordEd.text.toString()

        if(userName.isEmpty() || userName.length<7){

            Toast.makeText(requireContext(),"Your username is not valid",Toast.LENGTH_SHORT).show()
        }else if(email.isEmpty() ){
            Toast.makeText(requireContext(),"Email is not valid",Toast.LENGTH_SHORT).show()
        }else if(userPassword.isEmpty() || userPassword.length<7){
            Toast.makeText(requireContext(),"Password must be 7 character",Toast.LENGTH_SHORT).show()
        }else if(userConfirmPassword.isEmpty() || userConfirmPassword.equals(userPassword).not()){
            Toast.makeText(requireContext(),"Password not match",Toast.LENGTH_SHORT).show()
        }else {
            lodingBar.setTitle("Registration")
            lodingBar.setMessage("Please wait,while checking your credentials")
            lodingBar.setCanceledOnTouchOutside(false)
            lodingBar.show()


           /* mAuth.createUserWithEmailAndPassword(email,userPassword).addOnCompleteListener(
                OnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(requireContext(), "Successfully Registered",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }else{
                        Toast.makeText(requireContext(), "Exception: " + it.exception,Toast.LENGTH_SHORT).show()

                    }
                })*/

            mAuth.createUserWithEmailAndPassword(email, userPassword)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("RegisterFragment", "createUserWithEmail:success")
                        val user = mAuth.currentUser
                        user!!.sendEmailVerification()
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                                    lodingBar.dismiss()
                                }
                            }



                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("RegisterFragment", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(requireContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show()


                    }

                    // ...
                }

        }

    }

}