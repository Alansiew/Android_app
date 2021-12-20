package com.example.aplikacja7

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import androidx.core.content.FileProvider
import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfWriter
import java.text.SimpleDateFormat
import java.util.*
import android.os.Build
import com.itextpdf.text.Paragraph
import java.nio.file.Files


private val STORAGE_CODE = 100;



class FifthActivity : AppCompatActivity() {

    private val listaDoWyslania = mutableListOf<String>()
    private var checkBoxes = listOf<CheckBox>()
    val mFileName = SimpleDateFormat("dd_MM_yyyy",Locale.getDefault()).format(System.currentTimeMillis())
    val mFilePath = Environment.getExternalStorageDirectory().toString()+"/"+mFileName+"_Check_Lista.pdf"
    val file = File(Environment.getExternalStorageDirectory(),mFileName+"_Check_Lista.pdf")

    ////////////////////// Zamienia plik na URI, dzieki ktoremu mozna dodac zalacznik do gmaila//////////
    val uri = FileProvider.getUriForFile(this,"com.example.aplikacja7.fileprovider",file)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        var clearBtn = findViewById<Button>(R.id.buttonWyczysc)


        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
            //////// Usuwa plik Check_Lista.pdf jesli juz istnieje///////
            if (file.exists()) {
                file.delete()
                listaDoWyslania.clear()
        }

            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    ==PackageManager.PERMISSION_DENIED){

                    val permission = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permission, STORAGE_CODE)
                }
                else {
                    savePdf()
                }
            }
            else{

                savePdf()
            }
            fun getIntent(intent: Intent, isNewTask: Boolean): Intent? {
                return if (isNewTask) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                else intent
            }
            //// funkcja która automatycznie dodaje mail, temat, test i zaałacznik//////////
            fun getEmailIntent(
                email: String,
                subject: String?,
                content: String?,
                attachmentUri: Uri
            ): Intent? {
                val intent = Intent(Intent.ACTION_SEND)

                intent.type = "message/rfc822"
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, content)
                intent.putExtra(Intent.EXTRA_STREAM, attachmentUri)

                return getIntent(intent, true)
            }
            //////////// Otwiera aplikacje Gmail ////////
            val data: String = "Zaznaczono : ".plus("\n"+listaDoWyslania + "\n")
            startActivity(
                Intent.createChooser(
                    getEmailIntent("siewieraa@GMAIL.COM", "Check Lista", "W załączniku Check Lista", uri), "Send mail"
                )
            )
        }


////////////////////  Grupuje wszystkie checkBoxy w jednym miejscu /////

checkBoxes = listOf(findViewById(R.id.checkBox_1),
    findViewById(R.id.checkBox_2),
    findViewById(R.id.checkBox_3),
    findViewById(R.id.checkBox_4),
    findViewById(R.id.checkBox_5),
    findViewById(R.id.checkBox_6),
    findViewById(R.id.checkBox_7),
    findViewById(R.id.checkBox_8),
    findViewById(R.id.checkBox_9),
    findViewById(R.id.checkBox_10),
    findViewById(R.id.checkBox_11),
    findViewById(R.id.checkBox_12),
    findViewById(R.id.checkBox_13),
    findViewById(R.id.checkBox_14),
    findViewById(R.id.checkBox_15),
    findViewById(R.id.checkBox_16),
    findViewById(R.id.checkBox_17),
    findViewById(R.id.checkBox_18),
    findViewById(R.id.checkBox_19),
    findViewById(R.id.checkBox_20),
    findViewById(R.id.checkBox_21),
    findViewById(R.id.checkBox_22),
    findViewById(R.id.checkBox_23),
    findViewById(R.id.checkBox_24),
    findViewById(R.id.checkBox_25),
    findViewById(R.id.checkBox_26),
    findViewById(R.id.checkBox_27),
    findViewById(R.id.checkBox_28),
    findViewById(R.id.checkBox_29),
    findViewById(R.id.checkBox_30),
    findViewById(R.id.checkBox_31),
    findViewById(R.id.checkBox_32),
    findViewById(R.id.checkBox_33),
    findViewById(R.id.checkBox_34),
    findViewById(R.id.checkBox_35),
    findViewById(R.id.checkBox_36),
    findViewById(R.id.checkBox_37),
    findViewById(R.id.checkBox_38),
    findViewById(R.id.checkBox_39),
    findViewById(R.id.checkBox_40))



// Odznacza zaznaczone checkBoxy
        clearBtn.setOnClickListener {
            checkBoxes.forEach {
                it.isChecked = false

            }
        }

        }
//////////////// Funkcja tworzy plik pdf z zaznaczonych check Boxów///////////////
    private fun savePdf() {

        val mDoc = Document()

        try{
            PdfWriter.getInstance(mDoc,FileOutputStream(mFilePath))
            mDoc.open()

            checkBoxes.forEach {
                if (it.isChecked) /////////////////////// dodaje zaznaczone okna do listy
                {
                    val a = it.text.toString()
                    listaDoWyslania.add(a + "\n")
                }
                else{
                    val a = it.text.toString()
                    listaDoWyslania.add(a+" Nie Zaznaczone!\n")
                }
            }
            val mText = listaDoWyslania.toString()
            mDoc.addAuthor("Alan Siewiera")
            mDoc.add(Paragraph(mText))
            mDoc.close()
            Toast.makeText(this,"$mFileName.pdf\nzapisany w \n$mFilePath",Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

        }

    }
/////////////// Przy pierwszym uruchomieniu funkcja zapyta o pozwolenie dla aplikacji na zapisywanie plikow //////////
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            STORAGE_CODE -> {
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    savePdf()
                }
                else{
                    Toast.makeText(this,"Odmowa dostępu...!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
