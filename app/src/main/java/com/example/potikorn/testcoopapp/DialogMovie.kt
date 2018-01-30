package com.example.potikorn.testcoopapp
import android.app.ProgressDialog
import android.content.Context

class DialogMovie(var context: Context) {
    fun showDialog(){
        val progressdialog = ProgressDialog(context)
        progressdialog.setMessage("Please Wait....")
        progressdialog.show() }
    fun dismissDialog(){
        val progressdialog = ProgressDialog(context)
        progressdialog.setMessage("Please Wait....")
        progressdialog.dismiss() }
}