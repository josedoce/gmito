package github.josedoce.gmito

import android.util.Log
import github.josedoce.gmito.models.GMonth


import android.widget.TextView
import github.josedoce.gmito.models.Consumable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * @since 2023
 * @author josedoce
 *
 */
//https://www.youtube.com/watch?v=ZnU21u1_fBE
class Fakegem {
    private companion object {

        val MONTHS_LIST: MutableList<GMonth> = emptyList<GMonth>().toMutableList()


        val CONSUMABLE_LIST: List<Consumable> = listOf(
            Consumable("Arroz"),
            Consumable("Feijão"),
            Consumable("Macarrão"),
            Consumable("Pão"),
            Consumable("Leite"),
            Consumable("Ovos"),
            Consumable("Frango"),
            Consumable("Carne bovina"),
            Consumable("Peixe"),
            Consumable("Azeite de oliva"),
            Consumable("Sal"),
            Consumable("Açúcar"),
            Consumable("Farinha de trigo"),
            Consumable("Café"),
            Consumable("Chá"),
            Consumable("Bananas"),
            Consumable("Maçãs"),
            Consumable("Laranjas"),
            Consumable("Cenouras"),
            Consumable("Batatas"),
            Consumable("Cebolas"),
            Consumable("Alface"),
            Consumable("Tomates"),
            Consumable("Brócolis"),
            Consumable("Abacate"),
            Consumable("Melão"),
            Consumable("Melancia"),
            Consumable("Morangos"),
            Consumable("Uvas"),
            Consumable("Abacaxi"),
            Consumable("Manga"),
            Consumable("Kiwi"),
            Consumable("Mel"),
            Consumable("Iogurte"),
            Consumable("Queijo"),
            Consumable("Presunto"),
            Consumable("Manteiga"),
            Consumable("Leite condensado"),
            Consumable("Requeijão"),
            Consumable("Chocolate"),
            Consumable("Cereais"),
            Consumable("Granola"),
            Consumable("Amendoim"),
            Consumable("Castanhas"),
            Consumable("Aveia"),
            Consumable("Geléia"),
            Consumable("Massa de pizza"),
            Consumable("Molho de tomate"),
            Consumable("Maionese"),
            Consumable("Mostarda"),
            Consumable("Ketchup"),
            Consumable("Vinagre"),
            Consumable("Salgadinhos"),
            Consumable("Biscoitos"),
            Consumable("Pipoca"),
            Consumable("Cerejas"),
            Consumable("Pêssegos"),
            Consumable("Ameixas"),
            Consumable("Peras"),
            Consumable("Amoras"),
            Consumable("Rúcula"),
            Consumable("Espinafre"),
            Consumable("Salmão"),
            Consumable("Atum"),
            Consumable("Sardinha"),
            Consumable("Arroz integral"),
            Consumable("Feijão preto"),
            Consumable("Chocolate amargo"),
            Consumable("Azeite de coco"),
            Consumable("Vinagre balsâmico")
        )

        init {
            val isTodosMeses = false
            val isAbreviado = false

            val nomeMes = SimpleDateFormat(if(isAbreviado) "MMM" else "MMMM", Locale.getDefault())
            val mesAtual = Calendar.getInstance().get(Calendar.MONTH)

            for (i in 0..if(isTodosMeses) 12 else mesAtual) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.MONTH, i)
                val diasNoMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                MONTHS_LIST.add(
                    GMonth(
                        name = nomeMes.format(calendar.time).removeSuffix(".").replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                        code = i,
                        days = diasNoMes
                ))

            }
        }
    }

    fun euVi(tv: TextView) {
        CoroutineScope(Dispatchers.IO).launch {
            val tx = StringBuilder()
            MONTHS_LIST.forEach {
                //tx.append("Mês: ${it.name} -- Dias: ${it.days}\n")
            }
            generateTitle(tx)
            withContext(Dispatchers.Main){
                tv.text = tx.toString()
            }
        }
    }


    fun generateTitle(tx: StringBuilder) {
        val embaralhado = CONSUMABLE_LIST.toTypedArray()
        embaralhado.shuffle()

        val elementosEmbaralhados = embaralhado.toMutableList()
        val limit = minOf(10, CONSUMABLE_LIST.size)
        for (i in 0 until limit) {
            tx.append("${elementosEmbaralhados[i].name}\n")
        }
    }
}

