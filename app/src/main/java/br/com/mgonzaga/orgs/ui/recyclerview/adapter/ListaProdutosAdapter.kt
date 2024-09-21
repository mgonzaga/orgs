package br.com.mgonzaga.orgs.ui.recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.GLES31
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mgonzaga.orgs.R
import br.com.mgonzaga.orgs.databinding.ActivityMainBinding
import br.com.mgonzaga.orgs.databinding.ProdutoItemBinding
import br.com.mgonzaga.orgs.extensions.TryLoadImage
import br.com.mgonzaga.orgs.models.Produto
import br.com.mgonzaga.orgs.util.Util
import coil.load


class ListaProdutosAdapter(
    produtos: List<Produto>,
    private val context: Context
) : RecyclerView.Adapter<ListaProdutosAdapter.ProdutoViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ProdutoViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvNome = binding.produtoItemNome
        val tvDescricao = binding.produtoItemDescricao
        val tvValor = binding.produtoItemValor
        val imagem = binding.imageView

        fun vincularProduto(produto: Produto) {
            tvNome.text = produto.nome
            tvDescricao.text = produto.descricao
            tvValor.text = Util().getCurrencyValue(produto.valor)

            val visibilidade = if (produto.imagem != null)
            {
                View.VISIBLE
            }else{
                View.GONE
            }
            imagem.visibility = visibilidade
            imagem.TryLoadImage(produto.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoViewHolder(binding)
    }

    override fun getItemCount(): Int = produtos.size
    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.vincularProduto(produtos[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun UpdateList(produtos: List<Produto>) {
        this.produtos.clear();
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }


}
