package com.example.programa_megasena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conexao com o botao e com a tela de saida
        Button botao = (Button) findViewById(R.id.botaoGerar);
        TextView saida = (TextView) findViewById(R.id.textoSaida);

        //Acao que sera executada com o clique do botao
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                String captura;
                //Intancia o objeto Random para a geracao de valores aleatorios
                Random aleatorio = new Random();
                //Uso do ArrayList de numeros inteiros para armazenar os valores
                ArrayList<Integer> numeros = new ArrayList();
                //Uso do ArrayList de String para armazenar os valores como texto
                ArrayList<String> jogo = new ArrayList();
                //Laco para o que o ArrayList armazene 6 valores
                while (numeros.size() < 6) {
                    //Gera um valor inteiro aleatorio entre 1 e 60
                    int valor = aleatorio.nextInt(60) + 1;
                    //Se o valor inteiro aleatorio gerado nao existir na lista, ele eh adicionado. Evita valores repetidos.
                    if (!numeros.contains(valor))
                        numeros.add(valor);

                }
                //Guarda os valores como texto e adiciona ao Arraylist 'Jogo'
                for (i = 0; i < numeros.size(); i++) {
                    captura = numeros.get(i).toString();
                    jogo.add(captura);
                }
                //Junta todos os valores armazenados no Arraylist 'Jogo' em uma unica variavel do tipo String
                String juntar = String.join("    ", jogo);

                //Exibe na tela os valores
                saida.setText(juntar);
            }
        });


    }
}