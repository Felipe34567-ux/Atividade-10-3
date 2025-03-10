// Felipe Ferreira Melantonio RA: 10443843 , Guilherme Sampaio Silva RA:10443768
package com.seuprojeto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<>();

    @Override
    public List<String> obterNomes() {
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() <= MAX_CARACTERES_NOMES) {
            nomes.add(nome);
        } else {
            System.out.println("Erro: Nome excede o limite de caracteres!");
        }
    }
}
