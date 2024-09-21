package br.com.mgonzaga.orgs.ui.acivity

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.mgonzaga.orgs.R
import br.com.mgonzaga.orgs.dao.ProdutosDAO
import br.com.mgonzaga.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.mgonzaga.orgs.databinding.FormularioImagemBinding
import br.com.mgonzaga.orgs.extensions.TryLoadImage
import br.com.mgonzaga.orgs.models.Produto
import br.com.mgonzaga.orgs.ui.dialogs.FormularioImagemDialog
import coil.load
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    private val produtosDao = ProdutosDAO()
    private val fProdBinding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Cadastrar Produto"
        val botaoSalvar = fProdBinding.activityFormularioProdutoBotaoSalvar
        botaoSalvar.setOnClickListener {
            val produto = criarProduto()
            produtosDao.Add(produto)
            finish()
        }
        fProdBinding.formularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this).show(url) { uri ->
                url = uri
                fProdBinding.formularioProdutoImagem.TryLoadImage(url)
            }
        }
        setContentView(fProdBinding.root)
    }

    private fun criarProduto(): Produto {
        val campoNome = fProdBinding.activityFormularioProdutoNome
        val campoDescricao = fProdBinding.activityFormularioProdutoDescricao
        val campoValor = fProdBinding.activityFormularioProdutoValor

        val nome = campoNome.text.toString()
        val descricao = campoDescricao.text.toString()
        val valorEmTexto = campoValor.text.toString()

        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )

    }
}