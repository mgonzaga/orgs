package br.com.mgonzaga.orgs.dao

import br.com.mgonzaga.orgs.models.Produto
import java.math.BigDecimal

class ProdutosDAO {
    fun Add(produto: Produto) {
        produtos.add(produto)
    }

    fun getAll(): List<Produto> {
        return produtos
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto( nome = "Frutas diversas",
                    descricao = "Cesta de frutas variadas de acordo com o período de colheita",
                    valor = BigDecimal("39.83"))
        )
    }
}