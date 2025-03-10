// Felipe Ferreira Melantonio RA: 10443843 , Guilherme Sampaio Silva RA:10443768
package com.seuprojeto;
import java.util.List;

public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;
    List<String> obterNomes();
    void adicionarNome(String nome);
 }
