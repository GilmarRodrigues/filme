package com.br.teste.cubosfilme.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.teste.cubosfilme.R
import com.br.teste.cubosfilme.extensions.loadUrl
import com.br.teste.cubosfilme.model.Resultado
import kotlinx.android.synthetic.main.adapter_filmes.view.*

private const val URL_BASE_IMG = "https://image.tmdb.org/t/p/w500/"

class FilmesAdapter(private val resultados: MutableList<Resultado>,
                    private val onClick: (Resultado) -> Unit)
    : RecyclerView.Adapter<FilmesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_filmes, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = resultados.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultado = resultados[position]
        val view = holder.itemView
        with(view) {

            tv_titulo.text = resultado.title
            iv_foto.loadUrl(URL_BASE_IMG + resultado.poster_path)

            setOnClickListener {onClick(resultado)}
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}