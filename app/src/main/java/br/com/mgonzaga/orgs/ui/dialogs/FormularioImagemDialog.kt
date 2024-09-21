package br.com.mgonzaga.orgs.ui.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import br.com.mgonzaga.orgs.databinding.FormularioImagemBinding
import br.com.mgonzaga.orgs.extensions.TryLoadImage

class FormularioImagemDialog(private val context : Context) {
    fun show(defaultUrl: String? = null, whenImageChanged: (uri: String?) -> Unit) {
        FormularioImagemBinding.inflate(LayoutInflater.from((context))).apply {

            //Este Let Funciona como um IF
            defaultUrl?.let {
                formularioImagemUrl.setText(it)
                formularioImagemImageview.TryLoadImage(it)
            }

            formularioImagemBotaoCarregar.setOnClickListener {
                val url = formularioImagemUrl.text.toString()
                formularioImagemImageview.TryLoadImage(url);
            }
            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar")
                { _, _ ->
                    val url = formularioImagemUrl.text.toString()
                    whenImageChanged(url)
                }
                .setNegativeButton("Cancelar") {_ , _ ->

                }.show()
        }
    }
}

/* ESTA CLASSE ESTA SEM O APPPLY
O APLLY é uma funcao de Escopo que retorna os metodos a partir da classe intanciada.

class FormularioImagemDialog(private val context : Context) {
    fun show(defaultUrl: String? = null, whenImageChanged: (uri: String?) -> Unit) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from((context)))

        //Este Let Funciona como um IF
        defaultUrl?.let {
            binding.formularioImagemUrl.setText(it)
            binding.formularioImagemImageview.TryLoadImage(it)
        }

        binding.formularioImagemBotaoCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            binding.formularioImagemImageview.TryLoadImage(url);
        }
        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar")
            { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                whenImageChanged(url)
            }
            .setNegativeButton("Cancelar") {_ , _ ->

            }.show()
    }
}
 */