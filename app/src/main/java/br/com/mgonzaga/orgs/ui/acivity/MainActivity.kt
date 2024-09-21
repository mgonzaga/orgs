package br.com.mgonzaga.orgs.ui.acivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.mgonzaga.orgs.dao.ProdutosDAO
import br.com.mgonzaga.orgs.databinding.ActivityMainBinding
import br.com.mgonzaga.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class MainActivity : AppCompatActivity() {
    private val produtosDao = ProdutosDAO()
    private val produtosAdapter = ListaProdutosAdapter(produtosDao.getAll(), this)
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Welcome to Orgs", Toast.LENGTH_SHORT).show()
        configureRecycleView()
        configureFab()
        binding.activityMainRefreshLayout.setOnRefreshListener {
            LoadProductsList();
        }
        setContentView(binding.root)
    }

    private fun configureFab() {
        val fabAddProduto = binding.activityMainFbAdicionarProduto
        fabAddProduto.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    fun configureRecycleView() {
        val recyclerViewProdutos = binding.activityMainRecyclerViewProdutos
        recyclerViewProdutos.adapter = produtosAdapter
    }

    override fun onResume() {
        super.onResume()
        LoadProductsList()
    }
    private fun LoadProductsList(){
        produtosAdapter.UpdateList(produtosDao.getAll())
        binding.activityMainRefreshLayout.isRefreshing = false;
    }
}