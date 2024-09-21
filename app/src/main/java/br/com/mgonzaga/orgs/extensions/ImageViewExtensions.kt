package br.com.mgonzaga.orgs.extensions

import android.widget.ImageView
import br.com.mgonzaga.orgs.R
import coil.load

fun ImageView.TryLoadImage(url: String? = null)
{
    load(url){
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}
